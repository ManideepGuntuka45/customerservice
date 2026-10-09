package com.rapido.parent.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Coordinates {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private double latitude;
	private double longitude;
	@ManyToOne
	private Booking b;
	public Coordinates() {
		super();
	}
	public Coordinates(int cid, double latitude, double longitude, Booking b) {
		super();
		this.cid = cid;
		this.latitude = latitude;
		this.longitude = longitude;
		this.b = b;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Booking getB() {
		return b;
	}
	public void setB(Booking b) {
		this.b = b;
	}
	
	
	
	

}
