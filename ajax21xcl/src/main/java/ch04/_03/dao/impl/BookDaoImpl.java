package ch04._03.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ch00.util.GlobalService;
import ch04._03.dao.BookDao;
import ch04._03.model.BookBean;
 
public class BookDaoImpl implements BookDao{
	DataSource ds;
	Integer bookId;
	Integer recordsPerPage = GlobalService.RECORDS_PER_PAGE;
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Override
	public int getTotalPages() {
		// 注意下一列敘述的每一個型態轉換
		int totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));

		return totalPages;
	}
	
	public BookDaoImpl() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public List<BookBean> getAllBooksJSON()  {
		List<BookBean> list = new ArrayList<>();
		String sql = "SELECT b.*, bc.name FROM BookAjax b JOIN BookCompanyAjax bc ON b.companyId = bc.id";
		try(
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				Integer id = rs.getInt("bookID");
				String title = rs.getString("title");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				double discount = rs.getDouble("discount");
				Integer companyId = rs.getInt("companyId");
				String filename = rs.getString("filename");
				String companyName = rs.getString("name");
				String bookNo = rs.getString("bookNo");
				BookBean bb = new BookBean(id, title, author, price, discount,
										   companyId, companyName, filename, bookNo, null);
				list.add(bb);
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}
	public List<BookBean> getAllBooks() throws SQLException {
		List<BookBean> list = new ArrayList<>();
		String sql = "SELECT b.*, bc.name FROM BookAjax b JOIN BookCompanyAjax bc ON b.companyId = bc.id";
		try(
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				//
				int id = rs.getInt("bookID");
				String title = rs.getString("title");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				double discount = rs.getDouble("discount");
				int companyId = rs.getInt("companyId");
				String companyName = rs.getString("name");
				String filename = rs.getString("filename");
				String bookNo = rs.getString("bookNo");
				Blob blob = rs.getBlob("CoverImage");
				BookBean bb = new BookBean(id, title, author, price, discount,
											companyId, companyName, filename, bookNo, blob);
				list.add(bb);
			}
		} 
		return list;
	}

	public BookBean getBook() throws SQLException {
		BookBean bb = null;
		String sql = "SELECT b.*, bc.name FROM BookAjax b JOIN BookCompanyAjax bc ON b.companyId = bc.id WHERE bookId = ?";
		try(
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setInt(1, bookId);
			try(
				ResultSet rs = stmt.executeQuery();
			) {
				if (rs.next()) {
					Integer id = rs.getInt("bookID");
					String title = rs.getString("title");
					String author = rs.getString("author");
					Double price = rs.getDouble("price");
					Double discount = rs.getDouble("discount");
					Integer companyId = rs.getInt("companyId");
					String companyName = rs.getString("name");
					String filename = rs.getString("filename");
					String bookNo = rs.getString("bookNo");
					Blob blob = rs.getBlob("CoverImage");
					bb = new BookBean(id, title, author, price, discount,
										companyId, companyName, filename, bookNo, blob);
				}
			}
		} 
		return bb;
	}
	@Override
	public BookBean getBookTextOnly(Integer bookId)  {
		BookBean bean = null;
		try {
			setBookId(bookId);
			bean = getBookTextOnly();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return bean;
	}
	public BookBean getBookTextOnly() throws SQLException {
		BookBean bb = null;
		String sql = "SELECT b.*, bc.name FROM BookAjax b JOIN BookCompanyAjax bc ON b.companyId = bc.id  WHERE bookId = ?";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setInt(1, bookId);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					Integer id = rs.getInt("bookID");
					String title = rs.getString("title");
					String author = rs.getString("author");
					Double price = rs.getDouble("price");
					Double discount = rs.getDouble("discount");
					Integer companyId = rs.getInt("companyId");
					String companyName = rs.getString("name");
					String filename = rs.getString("filename");
					String bookNo = rs.getString("bookNo");
					bb = new BookBean(id, title, author, price, discount, 
							companyId, companyName, filename, bookNo, null);
					
				}
			}
			return bb;
		}
	}

	@Override
	public List<BookBean> getPageBooks(Integer pageNo) {
		int startRecordNo = 0;
		int endRecordNo = 0;
		
        List<BookBean> list = new ArrayList<BookBean>();
        String sql = ""; 
        String sql0 = "SELECT  * FROM (SELECT  ROW_NUMBER() OVER (ORDER BY BOOKID)"
				+ " AS RowNum, b.BookId, b.author, b.bookNo, b.TITLE, b.PRICE, "
				+ " b.discount, b.companyID, b.fileName, b.coverImage, bc.name "
				+ " FROM BookAjax b JOIN BookCompanyAjax bc ON  b.companyID = bc.id )"
				+ " AS NewTable WHERE RowNum >= ? AND RowNum <= ?";
        
		String sql1 = "SELECT b.BookId, b.author, b.bookNo, b.TITLE, "
		+ "b.PRICE, b.discount, b.companyID, b.fileName, b.coverImage, "
		+ "bc.name FROM BookAjax b JOIN BookCompanyAjax bc ON  b.companyID = bc.id "
				+ " LIMIT ?, ?";        
        if (GlobalService.DB_TYPE.equals(GlobalService.DB_TYPE_SQLSERVER)) {
        	sql = sql0;
        	// 由頁碼推算出該頁是由哪一筆紀錄開始(1 based)
        	startRecordNo = (pageNo - 1) * recordsPerPage + 1;
        	endRecordNo = (pageNo) * recordsPerPage;
        	
        } else if (GlobalService.DB_TYPE.equals(GlobalService.DB_TYPE_MYSQL)) {
        	sql = sql1;
        	// 由頁碼推算出該頁是由哪一筆紀錄開始(0 based)		
		    startRecordNo = (pageNo - 1) * recordsPerPage;
		    endRecordNo = recordsPerPage;
        }

		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, startRecordNo);
			ps.setInt(2, endRecordNo);
			try (
				ResultSet rs = ps.executeQuery();
			) {
				// 只要還有紀錄未取出，rs.next()會傳回true
				// 迴圈內將逐筆取出ResultSet內的紀錄
				while (rs.next()) {
					// 準備一個新的BookBean，將ResultSet內的一筆紀錄移植到BookBean內
					BookBean bean = new BookBean();    	
					bean.setBookId(rs.getInt("BookId"));		
					bean.setAuthor(rs.getString("author"));
					bean.setBookNo(rs.getString("bookNo"));
					bean.setTitle(rs.getString("title"));
					bean.setPrice(rs.getDouble("price"));
					bean.setDiscount(rs.getDouble("discount"));
					bean.setCompanyId(rs.getInt("companyID"));
					bean.setFileName(rs.getString("Filename"));
					bean.setCoverImage(rs.getBlob("CoverImage"));
					bean.setCompanyName(rs.getString("name"));
					// 最後將BookBean物件放入大的容器內
					list.add(bean);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("BookDaoImpl_Jdbc()#getPageBooks()發生例外: " 
										+ ex.getMessage());
		}
		return list;
	}
	public long getRecordCounts() {
		long count = 0; // 必須使用 long 型態
		String sql = "SELECT count(*) FROM BookAjax";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		) {
			if (rs.next()) {
				count = rs.getLong(1);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#getRecordCounts()發生例外: " 
										+ ex.getMessage());
		}
		return count;
	}

	@Override
	public List<BookBean> getBooksByPublisherId(int publisherId) {
		List<BookBean> list = new ArrayList<>();
		String sql = "SELECT b.*, bc.name FROM BookAjax b JOIN BookCompanyAjax bc ON b.companyId = bc.id WHERE b.companyId = ?";
		try(
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setInt(1, publisherId);
			try (
					ResultSet rs = stmt.executeQuery();
			) {
				while (rs.next()) {
					//
					int id = rs.getInt("bookID");
					String title = rs.getString("title");
					String author = rs.getString("author");
					double price = rs.getDouble("price");
					double discount = rs.getDouble("discount");
					int companyId = rs.getInt("companyId");
					String companyName = rs.getString("name");
					String filename = rs.getString("filename");
					String bookNo = rs.getString("bookNo");
					Blob blob = rs.getBlob("CoverImage");
					BookBean bb = new BookBean(id, title, author, price, discount,
								companyId, companyName, filename, bookNo, blob);
					list.add(bb);
				}
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Map<String, Object> getBooksAmountByPublisherId(int publisherId) {
		long count = 0;    	// 出版社出版的書籍種類
		String name = ""; 	// 出版社之公司名稱
		String sql  = "SELECT count(*) FROM BookAjax WHERE companyId = ?";
		String sql2 = "SELECT name FROM BookCompanyAjax WHERE id=?";
		Map<String, Object>  map = new HashMap<>();
		try (
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			PreparedStatement ps2 = connection.prepareStatement(sql2);
		) {
			ps.setInt(1, publisherId);
			ps2.setInt(1, publisherId);
			try (
				ResultSet rs = ps.executeQuery();
			) {
				if (rs.next()) {
					count = rs.getLong(1);
				}
			}
			try (
				ResultSet rs2 = ps2.executeQuery();
				) {
					if (rs2.next()) {
						name = rs2.getString(1);
					}
				}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#getRecordCounts()發生例外: " 
										+ ex.getMessage());
		}
		map.put("BookType", count);
		map.put("companyName", name);
		return map;
	}

	@Override
	public BookBean getBook(Integer bookId) {
		// TODO Auto-generated method stub
		return null;
	}
}
