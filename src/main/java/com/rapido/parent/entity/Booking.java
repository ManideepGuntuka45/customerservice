package com.rapido.parent.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bid;
	@OneToOne
	private Customer cust;
	private String paymenttype;
	private String vehicletype;
	private double distance;
	private String paymentstatus;
	private int riderrid;
	private double fare;
	private String pickuptime;
	private String droptime;
	private String bookingdate;
	private String bookingtime;
	@OneToMany
	private List<Coordinates> sourcelist;
	@OneToMany
	private List<Coordinates> destinationlist;
	public Booking() {
		super();
	}
	public Booking(int bid, Customer cust, String paymenttype, String vehicletype, double distance,
			String paymentstatus, int riderrid, double fare, String pickuptime, String droptime, String bookingdate,
			String bookingtime, List<Coordinates> sourcelist, List<Coordinates> destinationlist) {
		super();
		this.bid = bid;
		this.cust = cust;
		this.paymenttype = paymenttype;
		this.vehicletype = vehicletype;
		this.distance = distance;
		this.paymentstatus = paymentstatus;
		this.riderrid = riderrid;
		this.fare = fare;
		this.pickuptime = pickuptime;
		this.droptime = droptime;
		this.bookingdate = bookingdate;
		this.bookingtime = bookingtime;
		this.sourcelist = sourcelist;
		this.destinationlist = destinationlist;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public String getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	public int getRiderrid() {
		return riderrid;
	}
	public void setRiderrid(int riderrid) {
		this.riderrid = riderrid;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getPickuptime() {
		return pickuptime;
	}
	public void setPickuptime(String pickuptime) {
		this.pickuptime = pickuptime;
	}
	public String getDroptime() {
		return droptime;
	}
	public void setDroptime(String droptime) {
		this.droptime = droptime;
	}
	public String getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
	public String getBookingtime() {
		return bookingtime;
	}
	public void setBookingtime(String bookingtime) {
		this.bookingtime = bookingtime;
	}
	public List<Coordinates> getSourcelist() {
		return sourcelist;
	}
	public void setSourcelist(List<Coordinates> sourcelist) {
		this.sourcelist = sourcelist;
	}
	public List<Coordinates> getDestinationlist() {
		return destinationlist;
	}
	public void setDestinationlist(List<Coordinates> destinationlist) {
		this.destinationlist = destinationlist;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
    
    
	

}
	
	