package Assignment2;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 2 - Car class
 *              July 18, 2020
 * 
 * The Motorcycle object represents different possible Motorcycle within the Department of Transportation Registry.
 * The Motorcycle class is a child class of the Vehicle class. 
 * Each Vehicle has a registration number, an owner, an odometer reading, a make and model, a model year, 
 * a certain number of wheels, and a lisence plate number. The Motorcylce object has no additional fields.  
 */

public class Motorcycle extends Vehicle {

    /**
     * constructor for Motorycycle class, a child class of the vehicle class
     * @param vehicleRegistration integer value for vehicle registration number
     * @param vehicleOwner CarOwner object containing information about the vehicle owner
     * @param vehicleOdometer current mileage on the vehicle, as double
     * @param vehicleMake make of vehivle, as String
     * @param vehicleModel model of vehivle, as String
     * @param vehicleYear model year of the vehicle, as int
     * @param vehicleWheels number of wheels on vehicle, as int
     * @param vehiclePlate licence plate number of vehicle, as String
     * @throws IllegalVehicleException if illegal parameter entered when contructing Motorcycle instance
     */
    public Motorcycle(int vehicleRegistration, CarOwner vehicleOwner, double vehicleOdometer, 
                 String vehicleMake, String vehicleModel, int vehicleYear, int vehicleWheels, String vehiclePlate) 
                 throws IllegalVehicleException { 
        super(vehicleRegistration, vehicleOwner, vehicleOdometer, vehicleMake, vehicleModel, 
              vehicleYear, vehicleWheels, vehiclePlate);
    }

    @Override
    public String toString() {
        return super.toString() + "Vehicle information, specific \n" 
                + "Vehicle type : motorcycle.\n";
    }
    
}