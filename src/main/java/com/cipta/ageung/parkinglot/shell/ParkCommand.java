package com.cipta.ageung.parkinglot.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.cipta.ageung.parkinglot.service.CarParkingLotService;

@ShellComponent
public class ParkCommand {
	
	private final CarParkingLotService carParkingLotService;
	
	public ParkCommand(CarParkingLotService carParkingLotService) {
		this.carParkingLotService = carParkingLotService;
	}
	
	@ShellMethod(value = "Add two integers together.", group = "Test Commands")
    public int add(int a, int b) {
        return a + b;
    }
	
	@ShellMethod(value = "Create Parking Lot.", group = "Parking Lot Commands")
    public void create(String size) {
        carParkingLotService.createParkingLot(size);
    }
	
	@ShellMethod(value = "Status Parking Lot.", group = "Parking Lot Commands")
    public void status() {
        carParkingLotService.statusParkingLot();
    }
}
