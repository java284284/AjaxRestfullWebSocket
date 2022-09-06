package ch04._03.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ch00.util.GlobalService;
import ch04._03.dao.PublisherDao;
import ch04._03.model.PublisherBean;

public class PublisherDaoImpl implements PublisherDao {
	DataSource ds;

	public PublisherDaoImpl() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<PublisherBean> getAllPublisher() {
		List<PublisherBean> list = new ArrayList<>();
		String sql = "SELECT bc.* FROM BookCompanyAjax bc";
		try (
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String url = rs.getString("url");
				PublisherBean pb = new PublisherBean(id, name, address, url);
				list.add(pb);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
