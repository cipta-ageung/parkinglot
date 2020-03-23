package com.cipta.ageung.parkinglot.shell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.cipta.ageung.parkinglot.service.CarParkingLotService;

@ShellComponent
public class ParkCommand {
	
	private final Logger log = LoggerFactory.getLogger(ParkCommand.class);
	
	private final CarParkingLotService carParkingLotService;
	
	public ParkCommand(CarParkingLotService carParkingLotService) {
		this.carParkingLotService = carParkingLotService;
	}
	
	@ShellMethod(value = "Create Parking Lot. Command : create SIZE_VALUE", group = "Parking Lot Commands")
    public void create(String size) {
        carParkingLotService.createParkingLot(size);
    }
	
	@ShellMethod(value = "Status Parking Lot. Command : status", group = "Parking Lot Commands")
    public void status() {
        carParkingLotService.statusParkingLot();
    }
	
	@ShellMethod(value = "Add Parking Lot. Command : add NUMBER_VALUE COLOUR_VALUE", group = "Parking Lot Commands")
    public void add(String number, String colour) {
        carParkingLotService.addCarParkingLot(number, colour);
    }
	
	@ShellMethod(value = "Remove Parking Lot. Command : remove NUM_SLOT_VALUE", group = "Parking Lot Commands")
    public void remove(String numSlot) {
        carParkingLotService.removeCarParkingLot(numSlot);
    }
	
	@ShellMethod(value = "check reg number with colour. Command : check-reg-number-with-colour COLOUR_VALUE", group = "Parking Lot Commands")
    public void checkRegNumberWithColour(String colour) {
        carParkingLotService.checkRegNumberWithColour(colour);
    }
	
	@ShellMethod(value = "check slot number with colour. Command : check-slot-number-with-colour COLOUR_VALUE", group = "Parking Lot Commands")
    public void checkSlotNumberWithColour(String colour) {
        carParkingLotService.checkSlotNumberWithColour(colour);
    }
	
	@ShellMethod(value = "Check Slot Number with Reg Number. Command : check-slot-number-with-reg-number REG_NUMBER_VALUE", group = "Parking Lot Commands")
    public void checkSlotNumberWithRegNumber(String regNumber) {
        carParkingLotService.checkSlotNumberWithRegNumber(regNumber);
    }
	
	@ShellMethod(value = "Check Parking Lot. Command : check-parking-lot", group = "Parking Lot Commands")
    public void checkParkingLot() {
        if(carParkingLotService.checkParkingLot()) {
        	log.info("Parking lot is ready");
        }
    }
}
