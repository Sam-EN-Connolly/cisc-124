package Assignment3;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 3 - Land class
 *              July 31, 2020
 * 
 * The Land class represents the land property for the real-estate firm.
 * Land is the child class of the Property class and the parent class of the Farm class.
 * Land has a listing price and number of hectares. 
 */


public class Land extends Property {

    // tax rate constants
    private static final double PER_HECTARE_TAX = 100;

    private double numHectare;

    /**
     * constructor for Land class
     * @param listingPrice proterty's listing price in thousands of dollars (double)
     * @param numHectare number of hactares of property (double)
     * @throws BadPropertyException if illigal value for parameters are entered
     */
    public Land(double listingPrice, double numHectare) throws BadPropertyException {
        super(listingPrice);
        setHect(numHectare);
    }

    /**
     * setter method for numHectare 
     * @param numHectare the number of hectares (double)
     */
    public void setHect(double numHectare) throws BadPropertyException {
        if (numHectare <= 0) 
            throw new BadPropertyException("Illegal number of hectares! Number of hectares must be positive.");
        this.numHectare = numHectare;
    }

    /**
     * getter method for numHectare 
     * @return the number of hectares (double)
     */
    public double getHect() {
        return numHectare;
    }


    @Override
    /**
     * calculate tax on the Land
     * @return tax on land (double)
     */
    public double calculateTax() {
        double tax = PER_HECTARE_TAX * this.numHectare;
        return tax;
    }

    @Override
    public String toString() {
        String propertyType = this.getClass().getSimpleName() + ", ";
        String hectares = this.getHect() + " hectares, ";
        String askingPrice = "asking price $" + this.getPrice() + ". ";
        return (propertyType + hectares + askingPrice);
    }

}