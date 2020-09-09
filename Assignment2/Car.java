package Assignment2;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 2 - Car class
 *              July 18, 2020
 * 
 * The Car object represents different possible Car within the Department of Transportation Registry.
 * The Car class is a child class of the Vehicle class. 
 * Each Vehicle has a registration number, an owner, an odometer reading, a make and model, a model year, 
 * a certain number of wheels, and a lisence plate number. Additionally a car can be an SUV, and has a 
 * specified number of seats. 
 */

public class Car extends Vehicle {

    boolean isSUV;
    int numSeats;
    
    /**
     * constructor for Car class, a child class of the vehicle class
     * @param vehicleRegistration integer value for vehicle registration number
     * @param vehicleOwner CarOwner object containing information about the vehicle owner
     * @param vehicleOdometer current mileage on the vehicle, as double
     * @param vehicleMake make of vehivle, as String
     * @param vehicleModel model of vehivle, as String
     * @param vehicleYear model year of the vehicle, as int
     * @param vehicleWheels number of wheels on vehicle, as int
     * @param vehiclePlate licence plate number of vehicle, as String
     * @param isSUV boolean stating if truck is a sports utility vehicle (true), or other type of car (false)
     * @param numSeats the number of seats in the car, as int
     * @throws IllegalVehicleException if illegal parameter entered when contructing Car instance
     */
    public Car(int vehicleRegistration, CarOwner vehicleOwner, double vehicleOdometer, 
                 String vehicleMake, String vehicleModel, int vehicleYear, int vehicleWheels, 
                 String vehiclePlate, boolean isSUV, int numSeats) 
                 throws IllegalVehicleException { 
        super(vehicleRegistration, vehicleOwner, vehicleOdometer, vehicleMake, vehicleModel, 
              vehicleYear, vehicleWheels, vehiclePlate);
        setIsSUV(isSUV);
        setNumSeats(numSeats);
    }

    /**
     * setter methof for car type
     * @param isSUV boolean stating if truck is a sports utility vehicle (true), or other type of car (false)
     */
    public void setIsSUV(boolean isSUV) {
        this.isSUV = isSUV;
    }
    
    /**
     * getter method for car type
     * @return boolean stating if truck is a sports utility vehicle (true), or other type of car (false)
     */
    public boolean getIsSUV() {
        return isSUV;
    }

    /**
     * setter method for number of seats in car
     * @param numSeats the number of seats in the car, as int
     */
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
    
    /**
     * getter method for number of seats in car
     * @return the number of seats in the car, as int
     */
    public int getNumSeats() {
        return numSeats;
    }

    @Override
    public String toString() {
        return super.toString() + "Vehicle information, specific \n" 
                + "Vehicle type : car, SUV : " + Boolean.toString(isSUV)
                + ", Number of seats : " + Integer.toString(numSeats) + ".\n";
    }
    
}