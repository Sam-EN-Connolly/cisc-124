package Assignment3;
import java.lang.Math;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 3 - Property class
 *              July 31, 2020
 * 
 * The Property class represents all properties for the real-estate firm.
 * It is an abstract class that provides structure of all the building types
 * Properties must have a listing price. The property class also contains a 
 * concrete method to compare two properties based on listing price, as well as an 
 * abstract method to calculate the property tax.
 */

public abstract class Property {
    
    private double listingPrice;

    /**
     * constructor for Property class
     * @param listingPrice proterty's listing price in thousands of dollars (double)
     * @throws BadPropertyException if listing price is set to less than zero
     */
    public Property(double listingPrice) throws BadPropertyException { 
        setPrice(listingPrice);
    }

    /**
     * setter method for listingPrice 
     * @param listingPrice proterty's listing price (double)
     */
    public void setPrice(double listingPrice) throws BadPropertyException {
        if (listingPrice < 0) 
            throw new BadPropertyException("The listing price cannot be negative");
        this.listingPrice = listingPrice;
    }

    /**
     * getter method for listingPrice 
     * @return proterty's listing price (double)
     */
    public double getPrice() {
        return listingPrice;
    }

    // abstract method to calculate property tax 
    public abstract double calculateTax();

    /**
     * compare proerties based on listing price, prints out comparison details
     * @param protertyCompare property object to compare
     * @return difference in listing price
     */
    public double compareTo(Property protertyCompare) {
        double priceDifference = protertyCompare.getPrice() - this.getPrice();
        if (priceDifference < 0) {
            System.out.printf("The %s is more expensive than the %s. The difference is $%.2f thousand.\n", 
                              this.getClass().getSimpleName(), protertyCompare.getClass().getSimpleName(), Math.abs(priceDifference));
        } else if (priceDifference > 0) {
            System.out.printf("The %s is more expensive than the %s. The difference is $%.2f thousand.\n", 
                              protertyCompare.getClass().getSimpleName(), this.getClass().getSimpleName(), priceDifference);
        } else {
            System.out.printf("The %s and the %s are the same price. The difference is $%.2f.\n", 
                              this.getClass().getSimpleName(), protertyCompare.getClass().getSimpleName(), priceDifference);
        }
        return priceDifference;
    }

}