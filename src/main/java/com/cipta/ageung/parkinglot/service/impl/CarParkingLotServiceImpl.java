package com.cipta.ageung.parkinglot.service.impl;

import org.springframework.stereotype.Service;

import com.cipta.ageung.parkinglot.entity.CarParkingLot;
import com.cipta.ageung.parkinglot.entity.CarParkingSize;
import com.cipta.ageung.parkinglot.service.CarParkingLotService;

@Service
public class CarParkingLotServiceImpl implements CarParkingLotService {
	
	CarParkingSize carParkingSize = new CarParkingSize();
	
	@Override
	public CarParkingSize createParkingLot(String size) {
		int temp = Integer.parseInt(size);
		if (temp > carParkingSize.getMaxSize()) {
			for (int i = carParkingSize.getMaxSize(); i < temp; i++) {
				carParkingSize.getSlot().add(null);
			}
			carParkingSize.setMaxSize(temp);
			System.out.println("Created a parking lot with slots : " + carParkingSize.getSlot().size());
		} else {
			System.out.println("number size must larger than maxSize");
		}
		return carParkingSize;

	}

	@Override
	public void addCarParkingLot(String number, String colour) {
		if (checkParkingLot()) {
			return;
		}

		int i = 0;
		boolean setSlot = false;
		while (i < carParkingSize.getMaxSize() && !setSlot) {
			if (carParkingSize.getSlot().get(i) == null) {
				CarParkingLot car = new CarParkingLot(number, colour);
				carParkingSize.getSlot().set(i, car);
				setSlot = true;
				System.out.println("Allocated slot number: " + (i + 1));
			} else if (i == carParkingSize.getMaxSize() - 1) {
				System.out.println("Sorry, parking lot is full");
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
        if(num >= 0 && num < carParkingSize.getMaxSize()){
            if(carParkingSize.getSlot().get(num)==null){
            	System.out.println("There is no car in slot "+numSlot);
            }
            else{ 
            	carParkingSize.getSlot().set(num,null);
                System.out.println("Slot number "+numSlot+" is free");
            }
        }
        else{
        	System.out.println("There is no slot with number "+numSlot);
        }

	}

	@Override
	public void statusParkingLot() {
		if(checkParkingLot()){
            return;
        }

		System.out.println("SlotNo.\tRegNumber.\tColor.");
        boolean empty = true;
        for(int i=0; i<carParkingSize.getMaxSize(); i++)
        {
            if(carParkingSize.getSlot().get(i)!=null){
                empty = false;
                CarParkingLot carInfo = carParkingSize.getSlot().get(i);
                System.out.println((i+1)+"\t"+ carInfo.getRegNumber()+"\t"+ carInfo.getColour());
            }
        }
        if(empty){ 
        	System.out.println("           All Slot is free");
        }
	}

	@Override
	public void checkRegNumberWithColour(String colour) {
		if(checkParkingLot()){
            return;
        }

        boolean firstString = true; 
        StringBuilder temp = new StringBuilder("");

        for(int i=0; i<carParkingSize.getMaxSize(); i++)
        {
            if(carParkingSize.getSlot().get(i)!=null){
            	CarParkingLot carInfo = carParkingSize.getSlot().get(i);
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
        	System.out.println("Not Found");
        }
        else{
        	System.out.println(temp.toString());
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
        for(int i=0; i<carParkingSize.getMaxSize(); i++)
        {
            if(carParkingSize.getSlot().get(i)!=null){
            	CarParkingLot carInfo = carParkingSize.getSlot().get(i);
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
        	System.out.println("Not Found");
        }
        else{
        	System.out.println(temp.toString());
        }

	}

	@Override
	public void checkSlotNumberWithRegNumber(String regNumber) {
		if(checkParkingLot()){
            return;
        }

        boolean firstString = true;
        StringBuilder temp = new StringBuilder("");
        for(int i=0; i<carParkingSize.getMaxSize(); i++)
        {
            if(carParkingSize.getSlot().get(i) != null){
            	CarParkingLot carInfo = carParkingSize.getSlot().get(i);
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
        	System.out.println("Not Found");
        }
        else{
        	System.out.println(temp.toString());
        }
	}

	@Override
	public boolean checkParkingLot() {
		
		boolean cek = false;
        if(carParkingSize.getMaxSize() == 0){
        	System.out.println("Parking lot size must to set first");
            return true;
        }
        
        return cek;
	}

}
