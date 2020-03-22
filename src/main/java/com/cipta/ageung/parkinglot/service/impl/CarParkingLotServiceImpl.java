package com.cipta.ageung.parkinglot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cipta.ageung.parkinglot.entity.CarParkingLot;
import com.cipta.ageung.parkinglot.service.CarParkingLotService;

@Service
public class CarParkingLotServiceImpl implements CarParkingLotService {

	private final Logger log = LoggerFactory.getLogger(CarParkingLotServiceImpl.class);

	private ArrayList<CarParkingLot> slot = new ArrayList<>();

	private int maxSize = 0;

	public int getMaxSize() {
		return maxSize;
	}

	public List<CarParkingLot> getSlot() {
		return slot;
	}

	@Override
	public void createParkingLot(String size) {
		int temp = Integer.parseInt(size);
		if (temp > maxSize) {
			for (int i = maxSize; i < temp; i++) {
				slot.add(null);
			}
			maxSize = temp;
			log.info("Created a parking lot with slots : " + size);
		} else {
			log.info("number size must larger than maxSize");
		}

	}

	@Override
	public void addCarParkingLot(String number, String colour) {
		if (checkParkingLot()) {
			return;
		}

		int i = 0;
		boolean setSlot = false;
		while (i < maxSize && !setSlot) {
			if (slot.get(i) == null) {
				CarParkingLot car = new CarParkingLot(number, colour);
				slot.set(i, car);
				setSlot = true;
				log.info("Allocated slot number: " + (i + 1));
			} else if (i == maxSize - 1) {
				log.info("Sorry, parking lot is full");
			}
			i++;
		}

	}

	@Override
	public void removeCarParkingLot(String numSlot) {
		if(checkParkingLot()){
            return;
        }

        int num = Integer.parseInt(numSlot)-1;
        if(num >= 0 && num < maxSize){
            if(slot.get(num)==null){
            	log.info("There is no car in slot "+numSlot);
            }
            else{ 
                slot.set(num,null);
                log.info("Slot number "+numSlot+" is free");
            }
        }
        else{
        	log.info("There is no slot with number "+numSlot);
        }

	}

	@Override
	public void statusParkingLot() {
		if(checkParkingLot()){
            return;
        }

		log.info("Slot No.    Registration No    Colour");
        boolean empty = true;
        for(int i=0; i<maxSize; i++)
        {
            if(slot.get(i)!=null){
                empty = false;
                CarParkingLot carInfo = slot.get(i);
                log.info((i+1)+"           "+ carInfo.getRegNumber() +"      "+ carInfo.getColour());
            }
        }
        if(empty){ 
        	log.info("           All Slot is free");
        }
	}

	@Override
	public void checkRegNumberWithColour(String colour) {
		if(checkParkingLot()){
            return;
        }

        boolean firstString = true; 
        StringBuilder temp = new StringBuilder("");

        for(int i=0; i<maxSize; i++)
        {
            if(slot.get(i)!=null){
            	CarParkingLot carInfo = slot.get(i);
                if(carInfo.getColour().equals(colour)){
                    if(firstString){
                    	temp.append(carInfo.getRegNumber());
                        firstString = false;
                    }
                    else{
                    	temp.append(", "+carInfo.getRegNumber());
                    }   
                }
            }
        }

        if(temp.length()==0){
        	log.info("Not found");
        }
        else{
        	log.info(temp.toString());
        }

	}

	@Override
	public void checkSlotNumberWithColour(String colour) {
		if(checkParkingLot())
        {
            return;
        }
        
        boolean firstString = true;
        StringBuilder temp = new StringBuilder("");
        for(int i=0; i<maxSize; i++)
        {
            if(slot.get(i)!=null){
            	CarParkingLot carInfo = slot.get(i);
                if(carInfo.getColour().equals(colour)){
                    if(firstString){
                    	temp.append(i+1);
                        firstString = false;
                    }
                    else{
                    	temp.append(", " + (i+1));
                    }
                }
            }
        }
        if(temp.length()==0){
        	log.info("Not found");
        }
        else{
        	log.info(temp.toString());
        }

	}

	@Override
	public void checkSlotNumberWithRegNumber(String regNumber) {
		if(checkParkingLot()){
            return;
        }

        boolean firstString = true;
        StringBuilder temp = new StringBuilder("");
        for(int i=0; i<maxSize; i++)
        {
            if(slot.get(i) != null){
            	CarParkingLot carInfo = slot.get(i);
                if(carInfo.getRegNumber().equals(regNumber)){
                    if(firstString){
                    	temp.append(i+1);
                        firstString = false;
                    }
                    else{
                    	temp.append(", " + (i+1));
                    }
                }
            }
        }
        
        if(temp.length()==0){
        	log.info("Not found");
        }
        else{
        	log.info(temp.toString());
        }
	}

	@Override
	public boolean checkParkingLot() {
		
		boolean cek = false;
        if(maxSize == 0){
        	log.info("Parking lot size must to set first");
            return true;
        }
        
        return cek;
	}

}
