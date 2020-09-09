package Assignment3;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 3 - Office class
 *              July 31, 2020
 * 
 * The House class represents the office property for the real-estate firm.
 * House is the child class of the Property class and a parent class of the Cottage class.
 * Houses have a listing price, floor space, number bedrooms, number of bathrooms,
 * a property width and depth, and a house type.
 * The house type is an enum, with three values.  
 */


public class House extends Property {

    // tax rate constants
    private static final double BASE_TAX = 1000;
    private static final double PER_BED_TAX = 50;
    private static final double PER_SQUARE_METER_TAX = 10;


    private double floorSpace;
    private int numBed;
    private int numBath;
    private double propertyWidth;
    private double propertyDepth;
    private HouseType houseType;
    
    /**
     * constructor for House class
     * @param listingPrice proterty's listing price in thousands of dollars (double)
     * @param floorSpace the floor space in square-meters (double)
     * @param numBed number of bedrooms (int)
     * @param numBath number of bathrooms (int)
     * @param propertyWidth width of the property in meters (double) 
     * @param propertyDepth depth of the property in meters (double) 
     * @param houseType classification of the house
     * @throws BadPropertyException if illigal value for parameters are entered
     */
    public House(double listingPrice, double floorSpace, int numBed, int numBath, double propertyWidth, double propertyDepth, HouseType houseType) 
           throws BadPropertyException {
        super(listingPrice);
        setFloorSpace(floorSpace);
        setNumBed(numBed);
        setNumBath(numBath);
        setWidth(propertyWidth);
        setDepth(propertyDepth);
        setHouseType(houseType);
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
     * setter method for numBed
     * @param numBed number of bedrooms
     * @throws BadPropertyException if numBed is less than or equal to zero
     */
    public void setNumBed(int numBed) throws BadPropertyException {
        if (numBed <= 0) 
            throw new BadPropertyException("Illegal number of bedrooms! Must have at least one bedroom.");
        this.numBed = numBed;
    }

    /**
     * getter method for numBed
     * @return number of bedrooms
     */
    public int getNumBed() {
        return numBed;
    }

    /**
     * setter method for numBath
     * @param numBath number of bathrooms
     * @throws BadPropertyException if numBath is less than or equal to zero
     */
    public void setNumBath(int numBath) throws BadPropertyException {
        if (numBath <= 0) 
            throw new BadPropertyException("Illegal number of bathrooms! Must have at least one bathroom.");
        this.numBath = numBath;
    }

    /**
     * getter method for numBath
     * @return number of bathrooms
     */
    public int getNumBath() {
        return numBath;
    }

    /**
     * setter method for propertyWidth
     * @param propertyWidth width of the property in meters
     * @throws BadPropertyException if propertyWidth is less than or equal to zero
     */
    public void setWidth(double propertyWidth) throws BadPropertyException{
        if (propertyWidth <= 0) 
            throw new BadPropertyException("Illegal property width! Property width must be positive.");
        this.propertyWidth = propertyWidth;
    }

    /**
     * getter method for propertyWidth
     * @return width of the property in meters
     */
    public double getWidth() {
        return propertyWidth;
    }

    /**
     * setter method for propertyDepth
     * @param propertyDepth depth of the property in meters
     * @throws BadPropertyException if propertyDepth is less than or equal to zero
     */
    public void setDepth(double propertyDepth) throws BadPropertyException {
        if (propertyDepth <= 0) 
            throw new BadPropertyException("Illegal property depth! Property depth must be positive.");
        this.propertyDepth = propertyDepth;
    }

    /**
     * getter method for propertyDepth
     * @return depth of the property in meters
     */
    public double getDepth() {
        return propertyDepth;
    }

    /**
     * setter method for houseType
     * @param houseType classification of the house
     */
    public void setHouseType(HouseType houseType) throws BadPropertyException {
        if (houseType == null) 
            throw new BadPropertyException("Illegal house typw! House type cannot be null.");
        this.houseType = houseType;
    }

    /**
     * getter method for houseType
     * @return classification of the house
     */
    public HouseType getHouseType() {
        return houseType;
    }


    @Override
    /**
     * calculate the tax for the house
     * @return tax on the house (double)
     */
    public double calculateTax() {
        double tax = BASE_TAX + PER_BED_TAX * this.getNumBed() + PER_SQUARE_METER_TAX * this.getFloorSpace();
        return tax;
    }

    @Override
    public String toString() {
        String propertyType = this.getClass().getSimpleName() + ", ";
        String bedrooms = this.getNumBed() + " bedrooms, ";
        String bathrooms = this.getNumBath() + " bathrooms, ";
        String size = this.getFloorSpace() + " square meter building, ";
        String widthAndDepth = this.getWidth() + "m width by " + this.getDepth() + "m deep lot, ";
        String askingPrice = "asking price $" + this.getPrice() + ". ";
        String type;
        switch (houseType) {
            case TOWNHOUSE : 
                type = "townhouse, ";
                break;
            case DETACHED : 
                type = "detached home, ";
                break;
            case DUPLEX : 
                type = "duplex, ";
                break;
            case WATERFRONT_HOME : 
                type = "waterfront home, ";
                break;
            default :
                type = "not specified";
                break;
        }
        return (propertyType + type + bedrooms + bathrooms + size + widthAndDepth + askingPrice);
    }

    

}