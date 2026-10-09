package com.rapido.parent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String name; 
	@Column(unique = true)
	private long mobno;
	@Column(unique = true)
	private String email;
	private String gender;
	@Column(unique = true)
	private String otp;
	public Customer() {
		super();
	}
	public Customer(int cid, String name, long mobno, String email, String gender, String otp) {
		super();
		this.cid = cid;
		this.name = name;
		this.mobno = mobno;
		this.email = email;
		this.gender = gender;
		this.otp = otp;
	}
	public int getId() {
		return cid;
	}
	public void setId(int id) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobno() {
		return mobno;
	}
	public void setMobno(long mobno) {
		this.mobno = mobno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "Customer [id=" + cid + ", name=" + name + ", mobno=" + mobno + ", email=" + email + ", gender=" + gender
				+ ", otp=" + otp + "]";
	}
	

}
