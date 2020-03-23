# Parking Lot Shell Command

## Technology Using
This application using language:

* [JAVA]
* [Spring Boot]
* [Spring Shell]
* [maven]

## Clean Package / Clean install
./mvnw clean package

## Run Test Application
linux : ./mvnw test
windows : mvnw test

## Run Application
linux : ./mvnw
windows : mvnw

## Build Application via Docker
linux : ./mvnw package verify jib:dockerBuild -Dmaven.test.skip=true -Dimage=parkinglot:0.0.1
windows : mvnw package verify jib:dockerBuild -Dmaven.test.skip=true -Dimage=parkinglot:0.0.1

## Run Application via Docker
docker run -it --name parking_lot parkinglot:0.0.1

## Command Helper
You can show available command with syntax : help
parkinglot:>help
AVAILABLE COMMANDS

Built-In Commands
  clear: Clear the shell screen.
  exit, quit: Exit the shell.
  help: Display help about available commands.
  history: Display or save the history of previously run commands
  script: Read and execute commands from a file.
  stacktrace: Display the full stacktrace of the last error.

Parking Lot Commands
  add: Add Parking Lot. Command : add NUMBER_VALUE COLOUR_VALUE
  check-parking-lot: Check Parking Lot. Command : check-parking-lot
  check-reg-number-with-colour: check reg number with colour. Command : check-reg-number-with-colour COLOUR_VALUE
  check-slot-number-with-colour: check slot number with colour. Command : check-slot-number-with-colour COLOUR_VALUE
  check-slot-number-with-reg-number: Check Slot Number with Reg Number. Command : check-slot-number-with-reg-number REG_NUMBER_VALUE
  create: Create Parking Lot. Command : create SIZE_VALUE
  remove: Remove Parking Lot. Command : remove NUM_SLOT_VALUE
  status: Status Parking Lot. Command : status
  
## Command for input file
You can using command : script ./src/main/resources/input.txt 
