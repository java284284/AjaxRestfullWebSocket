package _01.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import _00_init.GlobalService;

public class LoginServiceMySQLDAO {
	private DataSource ds = null;
	HttpSession session;

	public LoginServiceMySQLDAO(HttpSession session) throws NamingException,
		     SQLException {
		this.session = session;
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}
	public LoginServiceMySQLDAO() throws NamingException,
	         SQLException { 
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}
	public CustomerBean checkPassword_NG(String userId, String password) {
		String sql = "SELECT * FROM Customer WHERE custId='" + userId
				+ "' AND password='" + password + "'";
		session.setAttribute("sql", sql);
		try (Connection connection = ds.getConnection();
			 Statement stmt = connection.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);) {
			if (rs.next()) {
				int pKey = rs.getInt("id");
				String custId 	= rs.getString("custId").trim(); 
				String pswd 	= rs.getString("password").trim();
				String email 	= rs.getString("email");
				CustomerBean cb = new CustomerBean(pKey, custId, pswd, email);
				return cb;
			}
		} catch (SQLException ex) {
			String msg= ex.getMessage();
			System.out.println("發生例外(LoginServiceMySQLDAO.java):" + msg);
			if (msg.indexOf("Communications link failure") != -1) {
			   throw new RuntimeException("資料庫未開啟或網路異常");
			} else {
			   throw new RuntimeException("發生例外");
			}
		}
		return null;
	}

	public CustomerBean checkPassword_OK(String userId, String password) {
		String sql = "SELECT * FROM Customer WHERE custId = ? AND password = ? ";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
		) {
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			
			try (
				ResultSet rs = pstmt.executeQuery();
			) {
				if (rs.next()) {
					int pKey 		= rs.getInt("id");
					String custId 	= rs.getString("custId").trim(); 
					String pswd 	= rs.getString("password").trim();
					String email 	= rs.getString("email");
					CustomerBean cb = new CustomerBean(pKey, custId, pswd, email);
					return cb;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	public int update(CustomerBean mb) {
        int updateCount = 0 ;
        String sql = "UPDATE Customer set password = ?, email = ? where custId = ?";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
		) {
			pstmt.setString(1, mb.password);
			pstmt.setString(2, mb.email);
			pstmt.setString(3, mb.custId);
			updateCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return updateCount;
	}
	public List<CustomerBean> getMembers() throws SQLException{
		List<CustomerBean> list = new ArrayList<>();
        String sql = "Select * from Customer";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()){
				CustomerBean cb = new CustomerBean(
						rs.getInt(1), rs.getString(2),
						rs.getString(3),rs.getString(4)
						);
				list.add(cb);
			}
		} 
		return list;
	}
}
