package Assignment3;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 3 - Office class
 *              July 31, 2020
 * 
 * The Office class represents the office property for the real-estate firm.
 * Office is the child class of the MultiUnitBuilding class.
 * Offices have a listing price, floor space, number of unit, elevator indicator, and classification.
 * the classification is an enum, with three values.  
 */

public class Office extends MultiUnitBuilding {

    // tax rate constants
    private static final double PER_SQURE_METER_TAX = 10;
    private static final double PER_UNIT_TAX = 10;
    private static final double INDUSTRIAL_DISCOUNT_TAX = 0.85;
    private static final double SERVICE_DISCOUNT_TAX = 0.95;

    private OfficeType classification;

    /**
     * constructor for Office class
     * @param listingPrice proterty's listing price in thousands of dollars (double)
     * @param floorSpace the floor space in square-meters (double)
     * @param numUnits the number of units in the building (int) 
     * @param hasElevator whether the building has an elevator (boolean)
     * @param classification office classification type of service, sales, or industrial (enum)
     * @throws BadPropertyException if illigal value for parameters are entered
     */
    public Office(double listingPrice, double floorSpace, int numUnits, boolean hasElevator, OfficeType classification)
            throws BadPropertyException {
        super(listingPrice, floorSpace, numUnits, hasElevator);
        setClassification(classification);
    }

    /**
     * setter method for office classfication 
     * @param classification office classification type of service, sales, or industrial (enum)
     * @throws BadPropertyException if null pointer is given 
     */
    public void setClassification(OfficeType classification) throws BadPropertyException {
        if (classification == null) 
            throw new BadPropertyException("Illegal office classification! Classification cannot be null.");
        this.classification = classification;
    }

    /**
     * getter method for office classfication
     * @return office classification type of service, sales, or industrial (enum)
     */
    public OfficeType getClassification() {
        return classification;
    }

    @Override
    public double calculateTax() {
        double tax = PER_SQURE_METER_TAX * this.getFloorSpace() + PER_UNIT_TAX * this.getNumUnits();
        switch (this.classification) {
            case INDUSTRIAL : 
                tax = tax * INDUSTRIAL_DISCOUNT_TAX;
                break;
            case SERVICE : 
                tax = tax * SERVICE_DISCOUNT_TAX; 
                break;
            default :
                break;
        }
        return tax;
    }

    @Override
    public String toString() {
        String classString;
        switch (this.getClassification()) {
            case INDUSTRIAL : 
                classString = "This building is for industrial use. ";
                break;
            case SERVICE : 
                classString = "This building is for service use. ";
                break;
            default :
                classString = "This building is for sales use. ";
                break;
        }
        return super.toString() + classString;
    }
    
}