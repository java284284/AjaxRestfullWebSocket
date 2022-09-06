package ch04._02.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ch00.util.GlobalService;
import ch04._02.dao.MemberDao;
import ch04._02.model.Member;

public class MemberDaoImpl implements MemberDao {
	private DataSource ds = null;
	public MemberDaoImpl() throws NamingException, SQLException { 
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
	}
	@Override
	public String checkMemberId(String memberId) {
		String sql = "SELECT * FROM Members m WHERE m.id = ?";
		String id = ""; 
		try (
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
		) {
			pstmt.setString(1, memberId);
			try (
				ResultSet rs = pstmt.executeQuery();
			) {
				if (rs.next()) {
					id 	= rs.getString("id").trim(); 
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			id = "Error: 資料庫異常，請檢查資料庫";
		}
		return id;
	}
	@Override
	public int saveMember(Member member) {
		String sql0 = "SELECT * FROM Members m WHERE m.id = ?";
		try (
				Connection connection = ds.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql0);
			) {
				pstmt.setString(1, member.getId());
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()){             // custId 已經存在
					return -1;
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return -2;
			}
		String sql = "INSERT INTO Members(id, name, balance, birthday) "
				+ " VALUES(?, ?, ?, ?)";
		int n = 0 ;
		try (
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
		) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setDouble(3, member.getBalance());
			pstmt.setDate(4, member.getBirthday());
			n = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return n;
	}
}
