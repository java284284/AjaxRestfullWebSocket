package ch04.ex03.model;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ch04.ex03.model.Member;

public class __MemberServiceSQLServer {
	static private List<String> memberIDList = new ArrayList<String>();
	Context ctx;

	public __MemberServiceSQLServer() throws IOException {
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			// TODO 自動產生 catch 區塊
			e.printStackTrace();
		}
		if (memberIDList.isEmpty()) {
			populateIDList();
		}
	}

	private void populateIDList() {
		Connection conn = null;
		try {
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MemberDataBase");
			conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT account  from memberExample");
			//int count = 0;
			while (rs.next()) {
				String id = rs.getString(1);
				//count++;
				memberIDList.add(id);
			}
		} catch (NamingException e) {
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自動產生 catch 區塊
				e.printStackTrace();
			}
		}

	}

	synchronized public boolean checkId(String id) {
		boolean exist = false;
		for (String s : memberIDList) {
			if (s.equals(id.trim())) {
				exist = true;
				break;
			}
		}
		return exist;
	}

	synchronized public int saveMember(Member mem)  {
		Connection conn = null;
		int n = 0;
		try {
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MemberDataBase");
			conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("Insert into memberExample values(?, ?, ?, ?, ?, ?)");
			stmt.setString(1, mem.getUserId());
			stmt.setString(2, mem.getPassword());
			stmt.setString(3, mem.getName());
			stmt.setString(4, mem.getEmail());
			stmt.setString(5, mem.getTel());
			stmt.setInt(6, mem.getExperience());
			n = stmt.executeUpdate();
			memberIDList.add(mem.getUserId());
		} catch (NamingException e) {
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動產生 catch 區塊
					e.printStackTrace();
				}
			}
		}
		return n;
	}

	public Collection<Member> getAllMembers()  {
		Connection conn = null;
		Collection<Member> allMembers = new ArrayList<Member>();
		try {
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MemberDataBase");
			conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * from  memberExample");
			ResultSet rs = stmt.executeQuery();
			Member mem = null;
			while (rs.next()) {
				mem = new Member(rs.getString(2), rs.getString(3), rs
						.getString(4), rs.getString(5), rs.getString(6), rs
						.getInt(7));
				allMembers.add(mem);
			}
			return allMembers;
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動產生 catch 區塊
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
