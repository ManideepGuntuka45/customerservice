package com.rapido.parent.dto;

public class BookingDetailsForAllRidersDto {
	private int id;
	private double fare;
	private double distance;
	private int bid;
	public BookingDetailsForAllRidersDto() {
		super();
	}
	public BookingDetailsForAllRidersDto(int id, double fare, double distance, int bid) {
		super();
		this.id = id;
		this.fare = fare;
		this.distance = distance;
		this.bid = bid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	

}
