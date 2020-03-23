package com.cipta.ageung.parkinglot.entity;

/*
* @author Cipta Ageung Mahdiar
*/

public class CarParkingLot {

	public CarParkingLot() {
		super();
	}
	
	public CarParkingLot(String regNumber, String colour) {
		super();
		this.regNumber = regNumber;
		this.colour = colour;
	}

	private String regNumber;
	
    private String colour;
    
	public String getRegNumber() {
		return regNumber;
	}
	
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
    
}