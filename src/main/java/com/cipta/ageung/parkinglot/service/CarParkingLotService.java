package com.cipta.ageung.parkinglot.service;

public interface CarParkingLotService {

	void createParkingLot(String size);
	
	void addCarParkingLot(String number, String colour);
	
	void removeCarParkingLot(String numSlot);
	
	void statusParkingLot();
	
	void checkRegNumberWithColour(String colour);
	
	void checkSlotNumberWithColour(String colour);
	
	void checkSlotNumberWithRegNumber(String regNumber);
	
	boolean checkParkingLot();
}