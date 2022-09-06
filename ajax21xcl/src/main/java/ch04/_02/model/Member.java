package ch04._02.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Component;

@Entity
@Table(name="MemberAjax")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer pk;
	String id;
	String name;
	Double balance;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8" )
	Date birthday;
	
	public Member() {
	}
	
	public Member(String id, String name, Double balance, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.birthday = birthday;
	}
	
	public Member(Integer pk, String id, String name, Double balance, Date birthday) {
		super();
		this.pk = pk;
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.birthday = birthday;
	}

	public Member(Integer ipk) {
		this.pk = ipk;
	}

	public Integer getPk() {
		return pk;
	}

	public void setPk(Integer pk) {
		this.pk = pk;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [pk=");
		builder.append(pk);
		builder.append(", id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append("]");
		return builder.toString();
	}
	
}
