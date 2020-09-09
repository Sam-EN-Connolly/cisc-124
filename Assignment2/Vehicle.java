package Assignment2;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 2 - Vehicle class
 *              July 18, 2020
 * 
 * The Vehicle object represents different possible vehicles within the Department of Transportation Registry.
 * Each Vehicle has a registration number, an owner, an odometer reading, a make and model, a model year, 
 * a certain number of wheels, and a lisence plate number. The Vehicle class is the parent class of 
 * the Car, Truck, and Motorcycle classes.
 */

public class Vehicle {
    
    private int registrationNumber;
    private CarOwner owner;
    private double odometerReading;
    private String make;
    private String model;
    private int year;
    private int numWheels;
    private String plateNumber;

    /**
     * constructor for vehicle class
     * @param vehicleRegistration integer value for vehicle registration number
     * @param vehicleOwner CarOwner object containing information about the vehicle owner
     * @param vehicleOdometer current mileage on the vehicle, as double
     * @param vehicleMake make of vehivle, as String
     * @param vehicleModel model of vehivle, as String
     * @param vehicleYear model year of the vehicle, as int
     * @param vehicleWheels number of wheels on vehicle, as int
     * @param vehiclePlate licence plate number of vehicle, as String
     * @throws IllegalVehicleException if illegal parameter entered when contructing Vehicle instance
     */
    public Vehicle(int vehicleRegistration, CarOwner vehicleOwner, double vehicleOdometer, 
                   String vehicleMake, String vehicleModel, int vehicleYear, int vehicleWheels, String vehiclePlate) 
                   throws IllegalVehicleException {
        setRegistrationNumber(vehicleRegistration);
        setOwner(vehicleOwner);
        setMileage(vehicleOdometer);
        setMake(vehicleMake);
        setModel(vehicleModel);
        setYear(vehicleYear);
        setNumWheels(vehicleWheels);
        setPlateNumber(vehiclePlate);
    }

    /**
     * setter method for the vehicle registration number
     * @param vehicleRegistration integer value for vehicle registration number
     */
    public void setRegistrationNumber(int vehicleRegistration) {
        this.registrationNumber = vehicleRegistration;
    }
    
    /**
     * getter method for the vehicle registration number
     * @return integer value of vehicle registration number
     */
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * setter method for the vehicle owner
     * @param vehicleOwner CarOwner object containing information about the vehicle owner
     */
    public void setOwner(CarOwner vehicleOwner) {
        this.owner = vehicleOwner;
    }
    
    /**
     * getter method for the vehicle owner
     * @return CarOwner object containing information about the vehicle owner
     */
    public CarOwner getOwner() {
        return owner;
    }
    
    /**
     * setter method for vehicle odometer
     * @param vehicleOdometer current mileage on the vehicle, as double
     * @throws IllegalVehicleException if trying to decrease mileage
     */
    public void setMileage(double vehicleOdometer) throws IllegalVehicleException {
        if (vehicleOdometer < this.odometerReading)
            throw new IllegalVehicleException("Illegal mileage - nice try!");
        this.odometerReading = vehicleOdometer;
    }
    
    /**
     * getter method for vehicle odometer
     * @return current mileage on the vehicle, as double
     */
    public double getMileage() {
        return odometerReading;
    }

    /**
     * setter method for vehicle make
     * @param vehicleMake make of vehivle, as String
     */
    public void setMake(String vehicleMake) {
        this.make = vehicleMake;
    }
    
    /**
     * getter method for vehicle make
     * @return make of vehivle, as String
     */
    public String getMake() {
        return make;
    }

    /**
     * setter method for vehicle model
     * @param vehicleModel model of vehicle, as String
     */
    public void setModel(String vehicleModel) {
        this.model = vehicleModel;
    }
    
    /**
     * getter method for vehicle model
     * @return model of vehicle, as String
     */
    public String getModel() {
        return model;
    }

    /**
     * setter method for the model year of the vehicle
     * @param vehicleYear model year of the vehicle, as int
     * @throws IllegalVehicleException if vehicle is too old, made prior to 1980
     */
    public void setYear(int vehicleYear) throws IllegalVehicleException {
        if (vehicleYear < 1980) 
            throw new IllegalVehicleException("Illegal year - you need to buy a newer vehicle!");
        this.year = vehicleYear;
    }
    
    /**
     * getter method for the model year of the vehicle
     * @return model year of the vehicle, as int
     */
    public int getYear() {
        return year;
    }

    /**
     * setter method for number of wheels on vehicle
     * @param vehicleWheels number of wheels on vehicle, as int
     * @throws IllegalVehicleException if trying to set fewer than 2 wheels to vehicle
     */
    public void setNumWheels(int vehicleWheels) throws IllegalVehicleException {
        if (vehicleWheels < 2)
            throw new IllegalVehicleException("Illegal number of wheels - buy a unicycle!");
        this.numWheels = vehicleWheels;
    }
    
    /**
     * getter method for number of wheels on vehicle
     * @return number of wheels on vehicle, as int
     */
    public int getNumWheels() {
        return numWheels;
    }

    /**
     * setter method for vehicle licence plate number
     * @param vehiclePlate licence plate number of vehicle, as String
     * @throws IllegalVehicleException if licence plate number does not follow Ontario standards
     */
    public void setPlateNumber(String vehiclePlate) throws IllegalVehicleException {
        if (!validPlateNum(vehiclePlate)) 
            throw new IllegalVehicleException("Illegal license plate!");
        this.plateNumber = vehiclePlate;
    }
    
    /**
     * getter method for vehicle licence plate number
     * @return licence plate number of vehicle, as String
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * checks to see if licence plate number follows ontario standard
     * @param vehiclePlate licence plate number of vehicle, as String
     * @return boolean indication if licence number follows ontario standard (true), or not (false)
     */
    private boolean validPlateNum (String vehiclePlate) {
        if (vehiclePlate.length() == 8) { // check plateNumber is the right length
            for (int i = 0; i < 7; i++) {
                if (i < 4) { // check if character is a letter
                    if (!Character.isLetter(vehiclePlate.charAt(i))) {
                        return false;
                    } 
                } else if (i == 4) {
                    if (vehiclePlate.charAt(i) != ' ') {
                        return false;
                    } 
                } else { // check is character is a number
                    if (!Character.isDigit(vehiclePlate.charAt(i))) {
                        return false;
                    } 
                }
            }
        } else {
            return false;
        }
        return true;
    } // end of validPlateNum

    public String toString() { 
        return "Vehicle information, general \n" 
                + "Registration number : " + Integer.toString(registrationNumber) + ", Owner : " + owner.getName() 
                + ", Miles driven : " + Double.toString(odometerReading) + ", Make : " + make 
                + ", Model : " + model + ", Model year : " + Integer.toString(year) 
                + ", Wheels : " + numWheels + ", License plate number : " + plateNumber + ".\n";
    } // end of toString

}