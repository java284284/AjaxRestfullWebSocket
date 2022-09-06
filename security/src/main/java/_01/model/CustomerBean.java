package _01.model;
// _01.model.CustomerBean
import java.io.*;

public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	int pKey;
	String custId;
	String password;
	String email;

	public CustomerBean(int pKey, String custId, String password, String email) {
		super();
		this.pKey = pKey;
		this.custId = custId;
		this.password = password;
		this.email = email;
	}

	public CustomerBean() {
		super();
	}

	public CustomerBean(String custId, String password, String email) {
		super();
		this.custId = custId;
		this.password = password;
		this.email = email;
	}

	public int getpKey() {
		return pKey;
	}

	public void setpKey(int pKey) {
		this.pKey = pKey;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
