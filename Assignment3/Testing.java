package Assignment3;

import java.util.ArrayList;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 3 - Testing class
 *              July 31, 2020
 * 
 * The Testing class tests tha code written for the real-estate firm project.
 * All property types are tested, with both good and illegal values.
 * This demonstrates the capabilities of the class, as well as the error handing.
 */

public class Testing {

    /**
     * tests to see if correct errors are thrown, when bad values are set for properties 
     * @param property a property object to test with
     */
    public static void testBadProperty (Property property) {
        System.out.println("\nTesting bad values in property setters.");

        System.out.println("Try setting illegal listing price.");
        try { 
            property.setPrice(-5);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 
    }

    /**
     * tests to see if correct errors are thrown, when bad values are set for houses 
     * @param hosue a house object to test with
     */
    public static void testBadHouse(House hosue) { 

        System.out.println("\nTesting bad values in house setters.");

        System.out.println("Try setting illegal floor space.");
        try { 
            hosue.setFloorSpace(-5);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 
        
        System.out.println("Try setting illegal number of bedrooms.");
        try { 
            hosue.setNumBed(0);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 

        System.out.println("Try setting illegal number of bathrooms.");
        try { 
            hosue.setNumBath(-1);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 

        System.out.println("Try setting illegal property width.");
        try { 
            hosue.setWidth(-1);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 

        System.out.println("Try setting illegal property depth.");
        try { 
            hosue.setDepth(-1);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 

        System.out.println("Try setting illegal house type of null.");
        try { 
            hosue.setHouseType(null);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 
    }

    /**
     * tests to see if correct errors are thrown, when bad values are set for cottages 
     * @param cottage cottage object
     */
    public static void testBadCottage(Cottage cottage) {

        System.out.println("\nTesting bad values in cottage setters.");

        System.out.println("Try setting illegal lake front.");
        try { 
            cottage.setLakeFront(-5);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 
    }

    /**
     * tests to see if correct errors are thrown, when bad values are set for land 
     * @param land  land object
     */
    public static void testBadLand(Land land) {

        System.out.println("\nTesting bad values in land setters.");

        System.out.println("Try setting illegal number of hectares.");
        try { 
            land.setHect(-5);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 
    }

    /**
     * tests to see if correct errors are thrown, when bad values are set for farms 
     * @param farm farm object
     */
    public static void testBadFarm(Farm farm) {

        System.out.println("\nTesting bad values in farm setters.");

        System.out.println("Try setting illegal crop: null and empty.");
        try { 
            farm.setCrop(null);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 
        try { 
            farm.setCrop("");
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 
        try { 
            farm.setCrop("5.7");
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 
    }

    /**
     * tests to see if correct errors are thrown, when bad values are set for multi-unit buildy 
     * @param building MultiUnitBuilding type object
     */
    public static void testBadMultiUnitBuilding (MultiUnitBuilding building) {

        System.out.println("\nTesting bad values in multi-unit building.");

        System.out.println("Try setting illegal floor space.");
        try { 
            building.setFloorSpace(-5);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 

        System.out.println("Try setting illegal number of units.");
        try { 
            building.setNumUnits(-5);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 

    }

    /**
     * tests to see if correct errors are thrown, when bad values are set for offices 
     * @param office office object
     */
    public static void testBadOffice(Office office) {
        System.out.println("\nTesting bad values in office building.");

        System.out.println("Try setting illegal classification.");
        try { 
            office.setClassification(null);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 
    }

    /**
     * tests to see if correct errors are thrown, when bad values are set for apartment buildings 
     * @param apartment ApartmentBuilding object
     */
    public static void testBadApartmentBuilding(ApartmentBuilding apartment) {
        
        System.out.println("\nTesting bad values in apartment building.");

        System.out.println("Try setting illegal floor space.");
        try { 
            apartment.setNumTenants(-5);
        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    /**
     * runs series of tests on all property types, first the with legal working properties,
     * then testing the error throwing for illegal property values
     * @param args None
     */
    public static void main(String[] args) {

        // create database in which to store properties 
        ArrayList<Property> propertyDB = new ArrayList<Property>();
        try { 
            System.out.println("\n---------- Testing Working Code ----------\n");
            // create test properties of each type
            System.out.println("Create instances of all types of objects, demonstrating that the constructors and setters are working.");
            Property houseDetached = new House(800, 2700, 2, 2, 50, 50, HouseType.DETACHED);
            Property houseDuplex = new House(800, 2700, 2, 2, 50, 50, HouseType.DUPLEX);
            Property houseTownhouse = new House(500, 2700, 2, 2, 50, 50, HouseType.TOWNHOUSE);
            Property cottage = new Cottage(400, 80, 2, 1, 100, 400, 80);
            Property land = new Land(500, 100);
            Property farm = new Farm(900, 300, "Strawberries");
            Property appartment = new ApartmentBuilding(300, 550, 17, 15);
            Property officeSales = new Office(1300, 5000, 150, true, OfficeType.SALES);
            Property officeService = new Office(1300, 5000, 150, true, OfficeType.SERVICE);
            Property officeIndustrial = new Office(1300, 5000, 150, false, OfficeType.INDUSTRIAL);

            // add properties to database 
            propertyDB.add(houseDetached);
            propertyDB.add(houseDuplex);
            propertyDB.add(houseTownhouse);
            propertyDB.add(cottage);
            propertyDB.add(land);
            propertyDB.add(farm);
            propertyDB.add(appartment);
            propertyDB.add(officeSales);
            propertyDB.add(officeService);
            propertyDB.add(officeIndustrial);

            // create last property holding vaiable 
            Property lastProperty = null;

            for (Property property : propertyDB) {
                // test methods for all properties : calculate tax, compareTo, toString 
                System.out.println("\nProperty print out : ");
                System.out.println(property);
                System.out.println("Property tax : $" + property.calculateTax());
                try {
                    System.out.println("Compare to last property : ");
                    double comparison = property.compareTo(lastProperty);
                } catch (NullPointerException e) {
                    System.out.println("First property, no comparison yet!");
                } finally {
                    lastProperty = property; 
                }

            }

        } catch (BadPropertyException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n---------- Testing Error Handling Code ----------\n");
        // setermine which type object is and do appropriate testing
        for (Property property : propertyDB) {
            testBadProperty(property);
            if (property instanceof House) {
                testBadHouse((House) property);
                if (property instanceof Cottage) {
                    testBadCottage((Cottage) property);
                }
            } else if (property instanceof Land) {
                testBadLand((Land) property);
                if (property instanceof Farm) {
                    testBadFarm((Farm) property);
                }
            } else if (property instanceof MultiUnitBuilding) {
                testBadMultiUnitBuilding((MultiUnitBuilding) property);
                if (property instanceof Office) {
                    testBadOffice((Office) property);
                } else if (property instanceof ApartmentBuilding) {
                    testBadApartmentBuilding((ApartmentBuilding) property);
                }

            }
        }
    }
}