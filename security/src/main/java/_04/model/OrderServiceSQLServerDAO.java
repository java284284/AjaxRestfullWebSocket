package _04.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_init.GlobalService;

public class OrderServiceSQLServerDAO implements IOrderDAO {
	private DataSource ds = null;
	private int key = 0;
	public OrderServiceSQLServerDAO() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME_MS);
	}
	/* (non-Javadoc)
	 * @see _04.model.IOrderDAO#insert(java.lang.String, double)
	 */
	@Override
	public int insert(String orderId, double amount) {
        int updateCount = 0 ;
        String sql = "INSERT INTO ProductOrders values(?, ?)";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
		) {
			pstmt.setString(1, orderId);
			pstmt.setDouble(2, amount);
			updateCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("OrderServiceSQLServerDAO#insert(): " + ex.getMessage());
		}
		return updateCount;
	}
	/* (non-Javadoc)
	 * @see _04.model.IOrderDAO#getAllBeans()
	 */
	@Override
	public List<OrderBean> getAllBeans() {
		List<OrderBean> list = new ArrayList<>() ;
        String sql = "SELECT * FROM ProductOrders";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()){
				OrderBean sb = new OrderBean(rs.getInt(1), 
						                           rs.getString(2), 
						                           rs.getDouble(3));
				list.add(sb);
			}
		} catch (Exception ex) {
			System.out.println("OrderServiceSQLServerDAO#getAllBeans(): " + ex.getMessage());
		}
		return list;
	}
	/* (non-Javadoc)
	 * @see _04.model.IOrderDAO#deleteBean()
	 */
	@Override
	public int deleteBean() {
		int updateCount = 0 ;
        String sql = "DELETE FROM ProductOrders WHERE id = ?";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
		) {
			pstmt.setInt(1, key);
			updateCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return updateCount;
	}
	/* (non-Javadoc)
	 * @see _04.model.IOrderDAO#getKey()
	 */
	@Override
	public int getKey() {
		return key;
	}
	/* (non-Javadoc)
	 * @see _04.model.IOrderDAO#setKey(int)
	 */
	@Override
	public void setKey(int key) {
		this.key = key;
	}
	/* (non-Javadoc)
	 * @see _04.model.IOrderDAO#delete(int)
	 */
	@Override
	public int delete(int key) {
		setKey(key);
		return deleteBean();
		
	}	
}