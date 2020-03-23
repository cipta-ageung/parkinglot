package com.cipta.ageung.parkinglot.shell;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.shell.ConfigurableCommandRegistry;
import org.springframework.shell.MethodTarget;
import org.springframework.shell.standard.StandardMethodTargetRegistrar;
import org.springframework.util.ReflectionUtils;

import com.cipta.ageung.parkinglot.ParkinglotApplication;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@SpringBootTest(classes = ParkinglotApplication.class)
public class ParkCommandTest {

	private StandardMethodTargetRegistrar registrar = new StandardMethodTargetRegistrar();
	private ConfigurableCommandRegistry registry = new ConfigurableCommandRegistry();

	@Before
	public void setUp() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ParkinglotApplication.class);
		registrar.setApplicationContext(context);
		registrar.register(registry);
	}

	@Test
	public void create() {
		Map<String, MethodTarget> commands = registry.listCommands();

		MethodTarget methodTarget = commands.get("create");
		assertThat(methodTarget, notNullValue());
		Assertions.assertThat(methodTarget.getGroup()).isEqualTo("Parking Lot Commands");
		assertThat(methodTarget.getHelp(), is("Create Parking Lot. Command : create SIZE_VALUE"));
		assertThat(methodTarget.getMethod(), is(ReflectionUtils.findMethod(ParkCommand.class, "create", String.class)));
		assertThat(methodTarget.getAvailability().isAvailable(), is(true));
	}

	@Test
	public void add() {
		Map<String, MethodTarget> commands = registry.listCommands();

		MethodTarget methodTarget = commands.get("add");
		assertThat(methodTarget, notNullValue());
		Assertions.assertThat(methodTarget.getGroup()).isEqualTo("Parking Lot Commands");
		assertThat(methodTarget.getHelp(), is("Add Parking Lot. Command : add NUMBER_VALUE COLOUR_VALUE"));
		assertThat(methodTarget.getMethod(),
				is(ReflectionUtils.findMethod(ParkCommand.class, "add", String.class, String.class)));
		assertThat(methodTarget.getAvailability().isAvailable(), is(true));
	}

	@Test
	public void status() {
		Map<String, MethodTarget> commands = registry.listCommands();

		MethodTarget methodTarget = commands.get("status");
		assertThat(methodTarget, notNullValue());
		Assertions.assertThat(methodTarget.getGroup()).isEqualTo("Parking Lot Commands");
		assertThat(methodTarget.getHelp(), is("Status Parking Lot. Command : status"));
		assertThat(methodTarget.getMethod(), is(ReflectionUtils.findMethod(ParkCommand.class, "status")));
		assertThat(methodTarget.getAvailability().isAvailable(), is(true));
	}

	@Test
	public void remove() {
		Map<String, MethodTarget> commands = registry.listCommands();

		MethodTarget methodTarget = commands.get("remove");
		assertThat(methodTarget, notNullValue());
		Assertions.assertThat(methodTarget.getGroup()).isEqualTo("Parking Lot Commands");
		assertThat(methodTarget.getHelp(), is("Remove Parking Lot. Command : remove NUM_SLOT_VALUE"));
		assertThat(methodTarget.getMethod(), is(ReflectionUtils.findMethod(ParkCommand.class, "remove", String.class)));
		assertThat(methodTarget.getAvailability().isAvailable(), is(true));
	}

	@Test
	public void checkRegNumberWithColour() {
		Map<String, MethodTarget> commands = registry.listCommands();

		MethodTarget methodTarget = commands.get("check-reg-number-with-colour");
		assertThat(methodTarget, notNullValue());
		Assertions.assertThat(methodTarget.getGroup()).isEqualTo("Parking Lot Commands");
		assertThat(methodTarget.getHelp(),
				is("check reg number with colour. Command : check-reg-number-with-colour COLOUR_VALUE"));
		assertThat(methodTarget.getMethod(),
				is(ReflectionUtils.findMethod(ParkCommand.class, "checkRegNumberWithColour", String.class)));
		assertThat(methodTarget.getAvailability().isAvailable(), is(true));
	}

	@Test
	public void checkSlotNumberWithColour() {
		Map<String, MethodTarget> commands = registry.listCommands();

		MethodTarget methodTarget = commands.get("check-slot-number-with-colour");
		assertThat(methodTarget, notNullValue());
		Assertions.assertThat(methodTarget.getGroup()).isEqualTo("Parking Lot Commands");
		assertThat(methodTarget.getHelp(),
				is("check slot number with colour. Command : check-slot-number-with-colour COLOUR_VALUE"));
		assertThat(methodTarget.getMethod(),
				is(ReflectionUtils.findMethod(ParkCommand.class, "checkSlotNumberWithColour", String.class)));
		assertThat(methodTarget.getAvailability().isAvailable(), is(true));
	}

	@Test
	public void checkSlotNumberWithRegNumber() {
		Map<String, MethodTarget> commands = registry.listCommands();

		MethodTarget methodTarget = commands.get("check-slot-number-with-reg-number");
		assertThat(methodTarget, notNullValue());
		Assertions.assertThat(methodTarget.getGroup()).isEqualTo("Parking Lot Commands");
		assertThat(methodTarget.getHelp(),
				is("Check Slot Number with Reg Number. Command : check-slot-number-with-reg-number REG_NUMBER_VALUE"));
		assertThat(methodTarget.getMethod(),
				is(ReflectionUtils.findMethod(ParkCommand.class, "checkSlotNumberWithRegNumber", String.class)));
		assertThat(methodTarget.getAvailability().isAvailable(), is(true));
	}

	@Test
	public void checkParkingLot() {
		Map<String, MethodTarget> commands = registry.listCommands();

		MethodTarget methodTarget = commands.get("check-parking-lot");
		assertThat(methodTarget, notNullValue());
		Assertions.assertThat(methodTarget.getGroup()).isEqualTo("Parking Lot Commands");
		assertThat(methodTarget.getHelp(), is("Check Parking Lot. Command : check-parking-lot"));
		assertThat(methodTarget.getMethod(), is(ReflectionUtils.findMethod(ParkCommand.class, "checkParkingLot")));
		assertThat(methodTarget.getAvailability().isAvailable(), is(true));
	}
}
