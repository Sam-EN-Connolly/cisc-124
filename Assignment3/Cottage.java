package Assignment3;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 3 - Office class
 *              July 31, 2020
 * 
 * The Cottage class represents the cottage property for the real-estate firm.
 * Cottage is the child class of the House class.
 * Cottages have a listing price, floor space, number of bedrooms and bathrooms, a property width and depth, 
 * and the amount of lake front.  
 */

public class Cottage extends House {

    // tax rate constants
    private static final double BASE_TAX = 2000;
    private static final double PER_LAKE_FRONT_TAX = 2;
    
    private double lakeFrontage;

    /**
     * constructor for Cottage class
     * @param listingPrice proterty's listing price in thousands of dollars (double)
     * @param floorSpace the floor space in square-meters (double)
     * @param numBed number of bedrooms (int)
     * @param numBath number of bathrooms (int)
     * @param propertyWidth width of the property in meters (double) 
     * @param propertyDepth depth of the property in meters (double) 
     * @param lakeFrontage amount of lake front in meters (double)
     * @throws BadPropertyException if illigal value for parameters are entered
     */
    public Cottage(double listingPrice, double floorSpace, int numBed, int numBath, double propertyWidth, double propertyDepth, double lakeFrontage) 
           throws BadPropertyException {
        super(listingPrice, floorSpace, numBed, numBath, propertyWidth, propertyDepth, HouseType.WATERFRONT_HOME);
        setLakeFront(lakeFrontage); 
    }

    /**
     * setter method for lakeFrontage
     * @param lakeFrontage the lakeFrontage in meters
     * @throws BadPropertyException if lakeFrontage is less than or equal to zero
     */
    public void setLakeFront(double lakeFrontage) throws BadPropertyException{
        if (lakeFrontage <= 0) 
            throw new BadPropertyException("Illegal lake front! Cottage must have more than zero lake front.");
        this.lakeFrontage = lakeFrontage;
    }

    /**
     * getter method for lakeFrontage
     * @return the floor space in square-meters
     */
    public double getLakeFront() {
        return lakeFrontage;
    }

    @Override
    /**
     * calculate the tax for the cottage
     * @return tax on the cottage (double)
     */
    public double calculateTax() {
        double tax = BASE_TAX + PER_LAKE_FRONT_TAX * this.lakeFrontage;
        return tax;
    }

    @Override
    public String toString() {
        return super.toString() + "This cottage has " + this.getLakeFront() + "m of lake front.";
    }

}