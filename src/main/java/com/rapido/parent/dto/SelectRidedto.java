package com.rapido.parent.dto;



public class SelectRidedto {

	private Coordinatesdto sourceCoord;  
	private Coordinatesdto destinationCoord;
	public SelectRidedto() {
		super();
	}
	public SelectRidedto(Coordinatesdto sourceCoord, Coordinatesdto destinationCoord) {
		super();
		this.sourceCoord = sourceCoord;
		this.destinationCoord = destinationCoord;
	}
	public Coordinatesdto getSourceCoord() {
		return sourceCoord;
	}
	public void setSourceCoord(Coordinatesdto sourceCoord) {
		this.sourceCoord = sourceCoord;
	}
	public Coordinatesdto getDestinationCoord() {
		return destinationCoord;
	}
	public void setDestinationCoord(Coordinatesdto destinationCoord) {
		this.destinationCoord = destinationCoord;
	}
	
	
	
}
