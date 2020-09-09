package Assignment2;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 2 - Truck class
 *              July 18, 2020
 * 
 * The Truck object represents different possible Truck within the Department of Transportation Registry.
 * The Truck class is a child class of the Vehicle class. 
 * Each Vehicle has a registration number, an owner, an odometer reading, a make and model, a model year, 
 * a certain number of wheels, and a lisence plate number. Additionally a Truck can be a transport truck, or semi,
 * and has a specified number load capacity. 
 */

public class Truck extends Vehicle {

    boolean isSemi;
    double loadCapacity;
    
    /**
     * constructor for Truck class, a child class of the vehicle class
     * @param vehicleRegistration integer value for vehicle registration number
     * @param vehicleOwner CarOwner object containing information about the vehicle owner
     * @param vehicleOdometer current mileage on the vehicle, as double
     * @param vehicleMake make of vehivle, as String
     * @param vehicleModel model of vehivle, as String
     * @param vehicleYear model year of the vehicle, as int
     * @param vehicleWheels number of wheels on vehicle, as int
     * @param vehiclePlate licence plate number of vehicle, as String
     * @param isSemi boolean stating if truck is a transport truck (true), or other type of truck (false)
     * @param loadCapcity the weight that the truck can hold, measured in pounds, as double
     * @throws IllegalVehicleException if illegal parameter entered when contructing Truck instance
     */
    public Truck(int vehicleRegistration, CarOwner vehicleOwner, double vehicleOdometer, 
                 String vehicleMake, String vehicleModel, int vehicleYear, int vehicleWheels, 
                 String vehiclePlate, boolean isSemi, double loadCapcity) 
                 throws IllegalVehicleException { 
        super(vehicleRegistration, vehicleOwner, vehicleOdometer, vehicleMake, vehicleModel, 
              vehicleYear, vehicleWheels, vehiclePlate);
        setIsSemi(isSemi);
        setloadCapacity(loadCapacity);
    }

    /**
     * setter method for truck type
     * @param isSemi boolean stating if truck is a transport truck (true), or other type fo truck (false)
     */
    public void setIsSemi(boolean isSemi) {
        this.isSemi = isSemi;
    }
    
    /**
     * getter method for truck type
     * @return boolean stating if truck is a transport truck (true), or other type fo truck (false)
     */
    public boolean getIsSemi() {
        return isSemi;
    }

    /**
     * setter method for truck load capacity
     * @param loadCapacity the weight that the truck can hold, measured in pounds, as double
     */
    public void setloadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    
    /**
     * getter method for truck load capacity
     * @return the weight that the truck can hold, measured in pounds, as double
     */
    public double getLoadCapacity() {
        return loadCapacity;
    }

    /**
     * get number of axles on truck
     * @return number of axles, or number of wheels divided by two, rounded down 
     */
    public int getNumberAxles() {
        int numAxles = Math.floorDiv(getNumWheels(), 2);
        return numAxles;
    }

    @Override
    public String toString() {
        return super.toString() + "Vehicle information, specific \n" 
                + "Vehicle type : truck, Transport truck : " + Boolean.toString(isSemi)
                + ", Load capacity : " + Double.toString(loadCapacity) + ".\n";
    }
        
}