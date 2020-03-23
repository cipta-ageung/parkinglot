package com.cipta.ageung.parkinglot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.cipta.ageung.parkinglot.ParkinglotApplication;
import com.cipta.ageung.parkinglot.entity.CarParkingLot;
import com.cipta.ageung.parkinglot.entity.CarParkingSize;
import com.cipta.ageung.parkinglot.service.impl.CarParkingLotServiceImpl;

@SpringBootTest(classes = ParkinglotApplication.class)
public class CarParkingLotServiceTest {

	private CarParkingLotServiceImpl carParkingLotService = new CarParkingLotServiceImpl();

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	CarParkingSize carParkingSize = new CarParkingSize();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void createParkingLot() throws Exception {
		carParkingSize = carParkingLotService.createParkingLot("6");
		assertEquals(6, carParkingSize.getMaxSize());
		assertEquals(6, carParkingSize.getSlot().size());
		assertTrue("Createdaparkinglotwithslots:6".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
	}

	@Test
	public void addCarParkingLot() throws Exception {
		carParkingLotService.addCarParkingLot("KA-01-HH-1234", "White");
		assertEquals("Parkinglotsizemusttosetfirst", outContent.toString().trim().replace(" ", ""));
		carParkingSize = carParkingLotService.createParkingLot("6");
		carParkingLotService.addCarParkingLot("KA-01-HH-1234", "White");
		carParkingLotService.addCarParkingLot("KA-01-HH-9999", "White");
		List<CarParkingLot> listWithoutNulls = carParkingSize.getSlot().parallelStream().filter(Objects::nonNull)
				.collect(Collectors.toList());
		assertEquals(4, carParkingSize.getSlot().size() - listWithoutNulls.size());
	}

	@Test
	public void removeCarParkingLot() throws Exception {
		carParkingLotService.removeCarParkingLot("2");
		assertEquals("Parkinglotsizemusttosetfirst", outContent.toString().trim().replace(" ", ""));
		carParkingSize = carParkingLotService.createParkingLot("6");
		assertEquals("Parkinglotsizemusttosetfirst\nCreatedaparkinglotwithslots:6",
				outContent.toString().trim().replace(" ", ""));
		carParkingLotService.removeCarParkingLot("4");
		assertEquals("Parkinglotsizemusttosetfirst\nCreatedaparkinglotwithslots:6\nThereisnocarinslot4",
				outContent.toString().trim().replace(" ", ""));
		carParkingLotService.addCarParkingLot("KA-01-HH-1234", "White");
		carParkingLotService.addCarParkingLot("KA-01-HH-1232", "White");
		carParkingLotService.removeCarParkingLot("1");
		assertEquals(
				"Parkinglotsizemusttosetfirst\nCreatedaparkinglotwithslots:6\nThereisnocarinslot4\nAllocatedslotnumber:1\nAllocatedslotnumber:2\nSlotnumber1isfree",
				outContent.toString().trim().replace(" ", ""));
	}

	@Test
	public void statusParkingLot() throws Exception {
		carParkingLotService.statusParkingLot();
		assertEquals("Parkinglotsizemusttosetfirst", outContent.toString().trim().replace(" ", ""));
		carParkingLotService.createParkingLot("6");
		carParkingLotService.addCarParkingLot("KA-01-HH-1234", "White");
		carParkingLotService.addCarParkingLot("KA-01-HH-9999", "White");
		carParkingLotService.statusParkingLot();
		assertEquals(
				"Parkinglotsizemusttosetfirst\nCreatedaparkinglotwithslots:6\nAllocatedslotnumber:1\nAllocatedslotnumber:2\n"
						+ "SlotNo.\tRegNumber.\tColor.\n" + "1\tKA-01-HH-1234\tWhite\n" + "2\tKA-01-HH-9999\tWhite",
				outContent.toString().trim().replace(" ", ""));
	}

	@Test
	public void checkRegNumberWithColour() throws Exception {
		carParkingLotService.checkRegNumberWithColour("White");
		assertEquals("Parkinglotsizemusttosetfirst", outContent.toString().trim().replace(" ", ""));
		carParkingLotService.createParkingLot("6");
		carParkingLotService.addCarParkingLot("KA-01-HH-1234", "White");
		carParkingLotService.addCarParkingLot("KA-01-HH-9999", "White");
		carParkingLotService.checkRegNumberWithColour("White");
		assertEquals(
				"Parkinglotsizemusttosetfirst\nCreatedaparkinglotwithslots:6\n"
						+ "Allocatedslotnumber:1\nAllocatedslotnumber:2\n" + "KA-01-HH-1234,KA-01-HH-9999",
				outContent.toString().trim().replace(" ", ""));
		carParkingLotService.checkRegNumberWithColour("Red");
		assertEquals(
				"Parkinglotsizemusttosetfirst\nCreatedaparkinglotwithslots:6\n"
						+ "Allocatedslotnumber:1\nAllocatedslotnumber:2\n" + "KA-01-HH-1234,KA-01-HH-9999\nNotFound",
				outContent.toString().trim().replace(" ", ""));
	}

	@Test
	public void checkSlotNumberWithColour() throws Exception {
		carParkingLotService.checkSlotNumberWithColour("White");
		assertEquals("Parkinglotsizemusttosetfirst", outContent.toString().trim().replace(" ", ""));
		carParkingLotService.createParkingLot("6");
		carParkingLotService.addCarParkingLot("KA-01-HH-1234", "White");
		carParkingLotService.addCarParkingLot("KA-01-HH-9999", "White");
		carParkingLotService.checkSlotNumberWithColour("White");
		assertEquals(
				"Parkinglotsizemusttosetfirst\nCreatedaparkinglotwithslots:6\n"
						+ "Allocatedslotnumber:1\nAllocatedslotnumber:2\n1,2",
				outContent.toString().trim().replace(" ", ""));
		carParkingLotService.checkSlotNumberWithColour("Red");
		assertEquals(
				"Parkinglotsizemusttosetfirst\nCreatedaparkinglotwithslots:6\n"
						+ "Allocatedslotnumber:1\nAllocatedslotnumber:2\n1,2\nNotFound",
				outContent.toString().trim().replace(" ", ""));
	}

	@Test
	public void checkSlotNumberWithRegNumber() throws Exception {
		carParkingLotService.checkSlotNumberWithRegNumber("KA-01-HH-1234");
		assertEquals("Parkinglotsizemusttosetfirst", outContent.toString().trim().replace(" ", ""));
		carParkingLotService.createParkingLot("6");
		carParkingLotService.addCarParkingLot("KA-01-HH-1234", "White");
		carParkingLotService.addCarParkingLot("KA-01-HH-9999", "White");
		carParkingLotService.checkSlotNumberWithRegNumber("KA-01-HH-1234");
		assertEquals(
				"Parkinglotsizemusttosetfirst\nCreatedaparkinglotwithslots:6\n"
						+ "Allocatedslotnumber:1\nAllocatedslotnumber:2\n1",
				outContent.toString().trim().replace(" ", ""));
		carParkingLotService.checkSlotNumberWithRegNumber("KA-01-HH-9999");
		assertEquals(
				"Parkinglotsizemusttosetfirst\nCreatedaparkinglotwithslots:6\n"
						+ "Allocatedslotnumber:1\nAllocatedslotnumber:2\n1\n2",
				outContent.toString().trim().replace(" ", ""));
	}
}
