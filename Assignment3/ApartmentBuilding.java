package Assignment3;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 3 - ApartmentBuilding class
 *              July 31, 2020
 * 
 * The AppartmentBuilding object represents appartment buildings for the real-estate firm.
 * ApartmentBuildings have a listing price, floor space per unit, number of units, and number of tenants.
 */

public class ApartmentBuilding extends MultiUnitBuilding {

    // tax rate constants
    private static final double PER_SQURE_METER_TAX = 35;

    private int numTenants;

    /**
     * constructor for AppartmentBuilding class
     * @param listingPrice proterty's listing price in thousands of dollars (double)
     * @param floorSpace the floor space in square-meters (double)
     * @param numUnits the number of units in the building (int) 
     * @param numTenants number of tenants in the appartment building (int)
     * @throws BadPropertyException
     */
    public ApartmentBuilding (double listingPrice, double floorSpace, int numUnits, int numTenants) 
                             throws BadPropertyException {
        super(listingPrice, floorSpace, numUnits, true);
        setNumTenants(numTenants);
    }

    /**
     * setter method for numTenants
     * @param numTenants number of tenants in the appartment building 
     * @throws BadPropertyException if numTenants is less than or equal to zero 
     */
    public void setNumTenants(int numTenants) throws BadPropertyException { 
        if (numTenants < 0)
            throw new BadPropertyException("Illegal number of tenants! Must have at least one tenant.");
        this.numTenants = numTenants;
    }

    /**
     * getter method for numTenants
     * @return number of tenants in the appartment building 
     */
    public int getNumTenants() {
        return numTenants;
    }

    @Override
    /**
     * calculate tax on the ApartmentBuilding
     * @return tax on apartment (double)
     */
    public double calculateTax() {
        double tax = PER_SQURE_METER_TAX * this.getNumUnits();
        return tax;
    }

    @Override
    public String toString() {
        return super.toString() + " There are " + this.getNumTenants() + " tenants in the building.";
    }
    
}