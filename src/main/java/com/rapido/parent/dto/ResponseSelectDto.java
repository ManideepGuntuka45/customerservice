package com.rapido.parent.dto;

import java.util.Map;

import com.rapido.parent.entity.Coordinates;

public class ResponseSelectDto {
	
	private Coordinatesdto source;
	private Coordinatesdto destination;
	private double distance;
	private Map<String, Double> fare;

	public ResponseSelectDto() {
		super();
	}

	public ResponseSelectDto(Coordinatesdto source, Coordinatesdto destination, double distance, Map<String, Double> fare) {
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.fare = fare;
	}

	public Coordinatesdto getSource() {
		return source;
	}

	public void setSource(Coordinatesdto source) {
		this.source = source;
	}

	public Coordinatesdto getDestination() {
		return destination;
	}

	public void setDestination(Coordinatesdto destination) {
		this.destination = destination;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Map<String, Double> getFare() {
		return fare;
	}

	public void setFare(Map<String, Double> fare) {
		this.fare = fare;
	}

}
