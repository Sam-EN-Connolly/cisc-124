package Assignment2;

import java.util.ArrayList;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 2 - Registry class
 *              July 18, 2020
 * 
 * The Registry object represents a database of all the cars in the Department of Transportation Registry.
 * The Registry object contains a collection of vehicles, and the number of vehicles in that collection.
 */

public class Registry {

    private ArrayList<Vehicle> vehicleCollection;
    private int numVehicles;
    
    /**
     * Registry class constructor
     * @param vehicles database of registered vehicles, as ArrayList of Vehicle types
     * @param numVehicles number of vehicles in the registry
     */
    public Registry (ArrayList<Vehicle> vehicles, int numVehicles) {
        setVehicleCollection(vehicles);
        setNumVehicles(numVehicles);
        if (vehicleCollection.size() != numVehicles) {
            System.out.println("Number of vehicles does not match size of registry");
        }
    } 

    /**
     * setter method for vehicleCollection
     * @param vehicles database of registered vehicles, as ArrayList of Vehicle types
     */
    public void setVehicleCollection(ArrayList<Vehicle> vehicles) {
        this.vehicleCollection = vehicles;
        vehicleCollection.trimToSize();
    }

    /**
     * getter method for vehicleCollection
     * @return database of registered vehicles, as ArrayList of Vehicle types
     */
    public ArrayList<Vehicle> getVehicleCollection() {
        return this.vehicleCollection;
    }

    /**
     * setter method for numVehicles
     * @param numVehicles number of vehicles in the registry
     */
    public void setNumVehicles(int numVehicles) {
        this.numVehicles = numVehicles;
    }

    /**
     * getter method for numVehicles
     * @return number of vehicles in the registry
     */
    public int getNumVehicles() {
        return this.numVehicles;
    }

    /**
     * adds a vehicle to the registry
     * @param vehicle vehicle object to add to registry
     */
    public void addVehicle(Vehicle vehicle) {
        vehicleCollection.add(vehicle);
        numVehicles++;
    }

    /**
     * prints entire registry
     */
    public void printRegistry() {
        System.out.println("Current registry of " + numVehicles + " vehicles : ");
        for(Vehicle vehicle : vehicleCollection) {
    		System.out.println(vehicle);
    	}
    }

    /**
     * calculates average mileage of all the vehicles in the registry
     * @return average mileage of all the vehicles in the registry
     */
    public double averageMileage() {
        
        double averageMileage;
        double totalMileage = 0;

        for(Vehicle vehicle : vehicleCollection) {
    		totalMileage += vehicle.getMileage();
    	}

        averageMileage = totalMileage / (double)vehicleCollection.size();

        return averageMileage;
    }

    public String toString() {
        return "Vehicle registry with " + numVehicles + " vehicles.";
    }

    /**
     * This function is an example of the capbilities of this package. A small vehicle registry is created
     * and the methods of each class are demonstrated, asside from the getter and mutator methods. 
     * Examples of all possible error message situation are also included.
     * @param args no aruments needed 
     */
    public static void main (String[] args) {
        // Registry example 
        try {
            System.out.println("\n\nTest CarOwner constructor\n");
            CarOwner carOwner1 = new CarOwner("Inez", 22, "woman", 10003345, 9);
            CarOwner carOwner2 = new CarOwner("Sam", 20, "non-binary", 10004364, 5);
            CarOwner carOwner3 = new CarOwner("Jill", 27, "woman", 10009887, 3);
            CarOwner carOwner4 = new CarOwner("Katja", 23, "woman", 10009889, 2);

            // print out example owner
            System.out.println(carOwner1);
            
            // example vehicles
            System.out.println("\n\nTest Vehicle and child class constructors\n");
            Vehicle vehicle1 = new Vehicle(305676, carOwner1, 7663.7, "Honda", "Civic", 1990, 4, "ADCE 890");
            Truck truck1 = new Truck(305676, carOwner2, 300, "Honda", "Civic", 1990, 4, "BGFT 100", false, 9000.5);
            Car car1 = new Car(305676, carOwner3, 100435, "Honda", "Civic", 1990, 4, "aeft 567", true, 6);
            Motorcycle motorcycle1 = new Motorcycle(305676, carOwner4, 34543, "Honda", "Civic", 1990, 4, "DGrG 832");

            // print out example of each vehicle
            System.out.println(vehicle1);
            System.out.println(truck1);
            // truck getAxles
            System.out.println(truck1.getOwner().getName() + "\'s truck has " + truck1.getNumberAxles() + " axles.");
            System.out.println(car1);
            System.out.println(motorcycle1);

            // create initial registry to hold vehicles
            System.out.println("\n\nTest Registry class constructor\n");
            ArrayList<Vehicle> vehicles = new ArrayList<Vehicle> ();
            Registry ottawaVehicles = new Registry(vehicles, 0);
            System.out.println(ottawaVehicles);
            
            // add vehicles to registry 
            System.out.println("\n\nTest add vehicles to registry and registry display\n");
            ottawaVehicles.addVehicle(vehicle1);
            ottawaVehicles.addVehicle(truck1);
            ottawaVehicles.addVehicle(car1);
            ottawaVehicles.addVehicle(motorcycle1);
            
            // display registry object and vehicles in registry
            ottawaVehicles.printRegistry();
            
            // display average mileage of vehicles
            System.out.println("The vehicles in ottawa have an average mileage of : " + ottawaVehicles.averageMileage());

            

        } catch (IllegalVehicleException e) {
            System.out.println(e.getMessage());
        }

        try { // illegal CarOwner - years driving
            System.out.println("\n\nCarOwner constructor with bad yearsDriving\n");
            CarOwner carOwnerBad = new CarOwner("Inez", 22, "woman", 10003345, -5);
        } catch (IllegalVehicleException e) {
            System.out.println(e.getMessage());
        }

        try { // illegal Vehicle methods
            System.out.println("\n\nTesting vehicle methods with illegal parameters\n");
            CarOwner testCarOwner = new CarOwner("Test person", 50, "n/a", 1000000, 50);
            Vehicle testVehicle = new Vehicle(10000, testCarOwner, 500, "n/a", "n/a", 2020, 4, "AAAA 000");

            try { // illegal mileage
                System.out.println("\nSet illegal mileage");
                testVehicle.setMileage(0);
            } catch (IllegalVehicleException e) {
                System.out.println(e.getMessage());
            }

            try { // illegal year
                System.out.println("\nSet illegal year");
                testVehicle.setYear(0);
            } catch (IllegalVehicleException e) {
                System.out.println(e.getMessage());
            }

            try { // illegal wheels
                System.out.println("\nSet illegal wheels");
                testVehicle.setNumWheels(0);
            } catch (IllegalVehicleException e) {
                System.out.println(e.getMessage());
            }

            try { // illegal license plate
                System.out.println("\nSet illegal license plate");
                testVehicle.setPlateNumber("notValPlate");
            } catch (IllegalVehicleException e) {
                System.out.println(e.getMessage());
            }

        } catch (IllegalVehicleException e) {
            System.out.println(e.getMessage());
        }

    }
}