﻿package ch04.ex01.model;

import java.io.*;

public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String userId;
	String password;
	String name;
	String email;
	String tel;
	int expericnce;

	public Member(String userId, String password, String name, String mail,
			String tel, int expericnce) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		email = mail;
		this.tel = tel;
		this.expericnce = expericnce;
	}

	public Member() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public int getExpericnce() {
		return expericnce;
	}

	public void setExpericnce(int expericnce) {
		this.expericnce = expericnce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
