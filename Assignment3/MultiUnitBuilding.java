package Assignment3;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 3 - MultiUnitBuilding class
 *              July 31, 2020
 * 
 * The MultiUnitBuilding class represents all multi-unit building properties for the real-estate firm.
 * MultiUnitBuilding is the child class of the Property class and the parent class of the Office and ApartmentBuilding classes.
 * MultiUnitBuilding has a listing price, floor space, number of units, and boolean for having an elevator.
 * It is an abstract class, and contains the abstract method calculateTax. 
 */

public abstract class MultiUnitBuilding extends Property {

    private double floorSpace;
    private int numUnits;
    private boolean hasElevator;
    
    /**
     * constructor for MultiUnitBuilding class
     * @param listingPrice proterty's listing price in thousands of dollars (double)
     * @param floorSpace the floor space in square-meters (double)
     * @param numUnits the number of units in the building (int) 
     * @param hasElevator whether the building has an elevator (boolean)
     * @throws BadPropertyException if illigal value for parameters are entered
     */
    public MultiUnitBuilding(double listingPrice, double floorSpace, int numUnits, boolean hasElevator)
                            throws BadPropertyException {
            super(listingPrice);
            setFloorSpace(floorSpace);
            setHasElevator(hasElevator);
            setNumUnits(numUnits);
    }

    /**
     * setter method for floorSpace
     * @param floorSpace the floor space in square-meters
     * @throws BadPropertyException if floorSpace is less than or equal to zero
     */
    public void setFloorSpace(double floorSpace) throws BadPropertyException{
        if (floorSpace <= 0) 
            throw new BadPropertyException("Illegal floor space! Floor space must be greater than zero.");
        this.floorSpace = floorSpace;
    }

    /**
     * getter method for floorSpace
     * @return the floor space in square-meters
     */
    public double getFloorSpace() {
        return floorSpace;
    }

    /**
     * setter method for numUnits
     * @param numUnits number of units
     * @throws BadPropertyException if numUnits is less than or equal to zero
     */
    public void setNumUnits(int numUnits) throws BadPropertyException {
        if (numUnits <= 0) 
            throw new BadPropertyException("Illegal number of units! Must have at least one unit.");
        this.numUnits = numUnits;
    }

    /**
     * getter method for numUnits
     * @return number of Unitsrooms
     */
    public int getNumUnits() {
        return numUnits;
    }

    /**
     * setter method for hasElevator
     * @param hasElevator indicates if building has an elevator (boolean)
     */
    public void setHasElevator(boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    /**
     * getter method for hasElevator
     * @return indicates if building has an elevator (boolean)
     */
    public boolean getHasElevator() {
        return hasElevator;
    }

    // abstract method to calculate property tax 
    public abstract double calculateTax();

    @Override
    public String toString() {
        String propertyType = this.getClass().getSimpleName() + ", ";
        String size = this.getFloorSpace() + " square meter building, ";
        String units = this.getNumUnits() + " units, ";
        String askingPrice = "asking price $" + this.getPrice() + ". ";
        String elevator;
        if (this.getHasElevator()) {
            elevator = "has an elevator, ";
        } else {
            elevator = "does not have an elevator, ";
        }
        return (propertyType + size + units + elevator + askingPrice);
    }

}