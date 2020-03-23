package com.cipta.ageung.parkinglot.entity;

import java.util.ArrayList;
import java.util.List;

public class CarParkingSize {

	private List<CarParkingLot> slot = new ArrayList<>();
	
	private int maxSize = 0;

	public List<CarParkingLot> getSlot() {
		return slot;
	}

	public void setSlot(List<CarParkingLot> slot) {
		this.slot = slot;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	
	
}
