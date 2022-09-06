package ch09.security.jaas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginService {
	static String key = "KittySnoopyMicky"; 
	public Collection<String> checkPassword(String name, String pswd) {
		Collection<String> roles = null;
		Context context;
		try {
			String password = CipherUtility.getMD5Encoding(
					          CipherUtility.encryptString(key, pswd));
			context = new InitialContext();
			DataSource ds = (DataSource) 
					context.lookup("java:comp/env/jdbc/securitydb");
			Connection con = ds.getConnection();
			String sqlUsers = "Select * from users WHERE username=? and password=?";
			String sqlRoles = "Select * from user_roles WHERE username=?";
			PreparedStatement psUser = con.prepareStatement(sqlUsers);
			psUser.setString(1, name);
			psUser.setString(2, password);
			ResultSet rsUser  = psUser.executeQuery();
			if (rsUser.next()){
				roles = new ArrayList<>();
				PreparedStatement psRole = con.prepareStatement(sqlRoles);
				psRole.setString(1, name);
				ResultSet rsRole  = psRole.executeQuery();
				while (rsRole.next()){
					roles.add(rsRole.getString("role_name"));
				}
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
        return roles;
	}
}
