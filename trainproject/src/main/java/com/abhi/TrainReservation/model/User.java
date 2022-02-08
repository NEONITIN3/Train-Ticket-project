package com.abhi.TrainReservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sNo;

	private String fullName;
	private String userName;
	private String email;
	private String number;
	private String password;

	public User() {
		super();
	}

	public User(int sNo, String fullName, String userName, String email, String number, String password) {
		super();
		this.sNo = sNo;
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.number = number;
		this.password = password;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "User [sNo=" + sNo + ", fullName=" + fullName + ", userName=" + userName + ", email=" + email
				+ ", number=" + number + ", password=" + password + "]";
	}
}