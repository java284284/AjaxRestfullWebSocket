package ch04.ex03.model;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

public class RegisterService {
	static private List<String> memberIDList = new ArrayList<String>();
	Context ctx;
	
	public RegisterService() throws IOException {
		
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
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
			int count = 0;
			while (rs.next()) {
				String id = rs.getString(1);
				count++;
				memberIDList.add(id);
			}
			System.out.println("count=" + count);
		} catch (NamingException e) {
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	public boolean idExists(String id) throws IOException {
		boolean exist = false;
		for (String s : memberIDList) {
			if (s.equals(id.trim())) {
				exist = true;
				break;
			}
		}
		return exist;
	}

	synchronized public int saveMember(Member mem) throws SQLException {
		Connection conn = null;
		int n = 0;
		try {
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MemberDataBase");
			conn = ds.getConnection();
			//MySQL
			//PreparedStatement stmt = conn.prepareStatement("Insert into memberExample values(null, ?, ?, ?, ?, ?, ?)");
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
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
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
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
