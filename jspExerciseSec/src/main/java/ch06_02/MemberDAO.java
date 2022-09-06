package ch06_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Blob;

public class MemberDAO {
	
	DataSource ds = null;
	public MemberDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	

	private static final String SELECT_BY_ID = "Select memberId, password, name, address, phone, birthday, registerdate, picture, weight from member42 where memberId = ?";

	public MemberBean select(String id) {
		MemberBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_BY_ID);
			stmt.setString(1, id);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new MemberBean();
				result.setMemberId(rset.getString("memberid"));
				result.setPassword(rset.getString("password"));
				result.setName(rset.getString("name"));
				result.setAddress(rset.getString("address"));
				result.setPhone(rset.getString("phone"));
				result.setBirthday(rset.getDate("birthday"));
				result.setWeight(rset.getDouble("weight"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static final String SELECT_ALL = "Select memberId, password, name, address, phone, birthday,registerdate ,picture ,weight from member42";
	
	public List<MemberBean> select() {
		List<MemberBean> result = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(SELECT_ALL);

			rset = stmt.executeQuery();
			result = new Vector<>();
			while (rset.next()) {
				MemberBean temp = new MemberBean();
				temp.setMemberId(rset.getString("memberid"));
				temp.setPassword(rset.getString("password"));
				temp.setName(rset.getString("name"));
				temp.setAddress(rset.getString("address"));
				temp.setPhone(rset.getString("phone"));
				temp.setBirthday(rset.getDate("birthday"));
				temp.setWeight(rset.getDouble("weight"));
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
		return result;
	}

	private static final String INSERT = "Insert into member42 (memberId, password, name, address, phone, birthday, registerdate, picture, weight) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public MemberBean insertMember(MemberBean bean) throws SQLException {
		MemberBean result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(INSERT);

			stmt.setString(1, bean.getMemberId());
			stmt.setString(2, bean.getPassword());
			stmt.setString(3, bean.getName());
			stmt.setString(4, bean.getAddress());
			stmt.setString(5, bean.getPhone());

			java.util.Date temp = bean.getBirthday();
			if (temp != null) {
				java.sql.Date someTime = new java.sql.Date(temp.getTime());
				stmt.setDate(6, someTime);
			} else {
				stmt.setDate(6, null);
			}

			Timestamp ts = new Timestamp(System.currentTimeMillis());
			stmt.setTimestamp(7, ts);
			Blob b = null;
			stmt.setBlob(8, b);
			stmt.setDouble(9, bean.getWeight());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.select(bean.getMemberId());
			}

		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private static final String DELETE = "Delete from member42 where memberId=?";

	public int delete(int memberId) {
		int result = 0;

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(DELETE);

			stmt.setInt(1, memberId);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}