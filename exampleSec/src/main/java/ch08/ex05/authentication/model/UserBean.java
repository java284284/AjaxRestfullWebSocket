package ch08.ex05.authentication.model;

import java.sql.Timestamp;
import java.util.Collection;

public class UserBean {
    private String user;
    private Collection roles; 
    private Timestamp loginTime;
	public UserBean(Timestamp loginTime, Collection roles, String user) {
		this.loginTime = loginTime;
		this.roles = roles;
		this.user = user;
	}	
	public UserBean() {
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Collection getRoles() {
		return roles;
	}
	public void setRoles(Collection roles) {
		this.roles = roles;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
}
