package Assignment3;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 3 - Farm class
 *              July 31, 2020
 * 
 * The Farm class represents the farm property for the real-estate firm.
 * Farm is the child class of the Land class.
 * Farms have a listing price, number of hectares, and a crop type. 
 */

public class Farm extends Land {

    // tax rate constants
    private static final double PER_HECTARE_TAX = 50;

    private String crop;

    /**
     * constructor for Farm class
     * @param listingPrice proterty's listing price in thousands of dollars (double)
     * @param numHectare number of hactares of property (double)
     * @param crop he crop type (String)
     * @throws BadPropertyException if illigal value for parameters are entered
     */
    public Farm(double listingPrice, double numHectare, String crop) throws BadPropertyException {
        super(listingPrice, numHectare);
        setCrop(crop);
    }

    /**
     * setter method for crop 
     * @param crop the crop type (String)
     * @throws BadPropertyException if crop is emty or null or a number
     */
    public void setCrop(String crop) throws BadPropertyException {
        if (crop == null || !(crop instanceof String) || crop.isEmpty())  
            throw new BadPropertyException("Illegal crop type! You must enter a crop type");

        // check is crop type is a number 
        boolean isNum = true;
        try {
            Double num = Double.parseDouble(crop);
        } catch (NumberFormatException e) {
            isNum = false;
        }

        if (isNum) {
            throw new BadPropertyException("Illegal crop type! Crop type cannot be a number");
        } else {
            this.crop = crop;
        }
    }

    /**
     * getter method for crop  
     * @return the crop type (String)
     */
    public String getCrop() {
        return crop;
    }
 
    @Override
    /**
     * calculate tax on the Farm
     * @return tax on farm (double)
     */
    public double calculateTax() {
        double tax = PER_HECTARE_TAX * this.getHect();
        return tax;
    }

    @Override
    public String toString() {
        return (super.toString() + "This farm grows " + this.getCrop() + ".");
    }


}