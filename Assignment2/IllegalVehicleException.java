package Assignment2;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 2 - Exception class
 *              July 18, 2020
 * 
 * IllegalVehicleException is the custom exception built for the Department of Transportation Registry project.
 * It has a default message or custom message option. 
 */

public class IllegalVehicleException extends Exception {

    /**
     * Cutsom exception for the Department of Transportation Registry package, default message.
     */
    public IllegalVehicleException() {
        super("Illegal vehicle parameter supplied.");
    }

    /**
     * Cutsom exception for the Department of Transportation Registry package, specified message.
     * @param message error message or description, String
     */
    public IllegalVehicleException(String message) { 
        super(message);
    }
    
}