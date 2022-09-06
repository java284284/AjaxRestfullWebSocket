package ch04._03.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch00.util.GlobalService;
import ch04._03.dao.BookDao;
import ch04._03.model.BookBean;
import ch04._03.model.PublisherBean;

@Repository
public class BookDaoImpl_Hibernate implements BookDao{
	
	@Autowired
	SessionFactory factory;

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
	
	public BookDaoImpl_Hibernate() {
	}
	
	@SuppressWarnings("unchecked")
	public List<BookBean> getAllBooksJSON()  {
		List<BookBean> list = new ArrayList<>();
		String hql = "FROM BookBean";

		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		System.out.println("list=" + list);
		return list;
	}

	public BookBean getBook() throws SQLException {
		BookBean bb = null;
		Session session = factory.getCurrentSession();
		bb = session.get(BookBean.class, bookId);
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
			return getBook();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookBean> getPageBooks(Integer pageNo) {
		int startRecordNo = (pageNo - 1) * recordsPerPage;

		Session session = factory.getCurrentSession();
        List<BookBean> list = new ArrayList<BookBean>();
        String hql = "FROM BookBean"; 
        
        list = session.createQuery(hql)
        			  .setFirstResult(startRecordNo)
        			  .setMaxResults(recordsPerPage)
        			  .getResultList();

		return list;
	}
	public long getRecordCounts() {
		Long count = 0L; // 必須使用 long 型態
		String hql = "SELECT count(*) FROM BookBean";
		Session session = factory.getCurrentSession();
		count = (Long) session.createQuery(hql).getSingleResult();
		return count;
	}

	@Override
	public List<BookBean> getBooksByPublisherId(int publisherId) {
		Session session = factory.getCurrentSession();
		PublisherBean bean = session.get(PublisherBean.class, publisherId);
		return new ArrayList<>(bean.getBooks());
	}

	@Override
	public Map<String, Object> getBooksAmountByPublisherId(int publisherId) {
		Map<String, Object> map = new HashMap<>();
		Session session = factory.getCurrentSession();
		PublisherBean bean = session.get(PublisherBean.class, publisherId);
		long count = bean.getBooks().size();  	// 出版社出版的書籍種類
		String name = bean.getName(); 			// 出版社之公司名稱
		
		map.put("BookType", count);
		map.put("companyName", name);
		return map;
	}

	@Override
	public BookBean getBook(Integer bookId) {
		BookBean bb = null;
		Session session = factory.getCurrentSession();
		bb = session.get(BookBean.class, bookId);
		return bb;
	}
}
