package com.rapido.parent.dto;

public class Customerdto {
	
	private String name;
	private String email;
	private long mobno;
	private String gender;
	public Customerdto() {
		super();
	}
	public Customerdto(String name, String email, long mobno, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.mobno = mobno;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobno() {
		return mobno;
	}
	public void setMobno(long mobno) {
		this.mobno = mobno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

}
