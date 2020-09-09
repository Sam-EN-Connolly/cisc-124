package Assignment2;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 2 - CarOwner class
 *              July 18, 2020
 * 
 * The CarOwner object represents owners of vehicles for the Department of Transportation Registry.
 * CarOwners have a name, age, gender, lisence number, and years of diving experience.
 */

public class CarOwner {

    private String name;
    private int age;
    private String gender;
    private int licenseNumber;
    private int yearsDriving;

    /**
     * CarOwner class constructor
     * @param driverName name of driver, as String
     * @param driverAge age of driver, as int
     * @param driverGender gender of driver, as String
     * @param driverLicence driver's licence number, as int
     * @param driverExperience years of driving experience, as int
     * @throws IllegalVehicleException if illigal value for driverExperience is entered
     */
    public CarOwner(String driverName, int driverAge, String driverGender, int driverLicence, int driverExperience) 
                    throws IllegalVehicleException {
        setName(driverName);
        setAge(driverAge);
        setGender(driverGender);
        setLicenceNumber(driverLicence);
        setYearsDriving(driverExperience);
    }
    
    /**
     * setter method for driver name
     * @param driverName name of driver, as String
     */
    public void setName(String driverName) {
        this.name = driverName;
    }

    /**
     * getter method for driver name
     * @return name of driver, as String
     */
    public String getName() {
        return name;
    }

    /**
     * setter method for driver age
     * @param driverAge age of driver, as int
     */
    public void setAge(int driverAge) {
        this.age = driverAge;
    }

    /**
     * getter method for driver age
     * @return age of driver, as int
     */
    public int getAge() {
        return age;
    }

    /**
     * setter method for driver gender
     * @param driverGender gender of driver, as String
     */
    public void setGender(String driverGender) {
        this.gender = driverGender;
    }

    /**
     * getter method for driver gender
     * @return gender of driver, as String
     */
    public String getGender() {
        return gender;
    }

    /**
     * setter method for driver's licence number
     * @param driverLicence driver's licence number, as int
     */
    public void setLicenceNumber(int driverLicence) {
        this.licenseNumber = driverLicence;
    }

    /**
     * getter method for driver's licence number
     * @return driver's licence number, as int
     */
    public int getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * setter method for years of driving experience
     * @param driverExperience years of driving experience, as int
     * @throws IllegalVehicleException if driving experience is negative
     */
    public void setYearsDriving(int driverExperience) throws IllegalVehicleException {
        if (driverExperience < 0) 
            throw new IllegalVehicleException("Illegal value!");
        this.yearsDriving = driverExperience;
    }

    /**
     * getter method for years of driving experience
     * @return years of driving experience, as int
     */
    public int getYearsDriving() {
        return yearsDriving;
    }


    public String toString() { 
        return "Car owner : " + name + ", age : " + Integer.toString(age) + " years, gender : " + gender 
                + ", license number : " + Integer.toString(licenseNumber) + ", driving experience : " 
                + Integer.toString(yearsDriving) + " years.";
    }
}