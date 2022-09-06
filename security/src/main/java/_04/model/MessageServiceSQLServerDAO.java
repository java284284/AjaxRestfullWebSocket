package _04.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_init.GlobalService;
import _04.MessageBean;

public class MessageServiceSQLServerDAO {
	private DataSource ds = null;
	String toid="pili";
	
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	public MessageServiceSQLServerDAO() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME_MS);
	}
	public int insert(MessageBean mb) {
        int updateCount = 0 ;
        String sql = "INSERT INTO Message values(?, ?, ?, ?, ?)";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
		) {
			pstmt.setString(1, mb.getFromId());
			pstmt.setString(2, mb.getToId());
			pstmt.setString(3, mb.getTitle());
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(4, ts);
			pstmt.setString(5, mb.getContent());
			updateCount = pstmt.executeUpdate();
			updateCount++;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return updateCount;
	}
	
	public List<MessageBean> getMessages() {
		List<MessageBean> list = new ArrayList<>();
        String sql = "Select * from Message where toid = ? order by posttime desc ";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
		) {
			pstmt.setString(1, toid);
			try (
			    ResultSet rs = pstmt.executeQuery();
			) {
				while (rs.next()) {
					MessageBean cb = new MessageBean(rs.getInt(1),
							rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getTimestamp(5), rs.getString(6));
					list.add(cb);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
}
