package Assignment3;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 3 - Exception class
 *              
 * 
 * BadPropertyException is the custom exception built for the real-estate management project.
 */


public class BadPropertyException extends Exception {

    /**
     * Cutsom exception for the real-estate management package, specified message.
     * @param message error message or description, String
     */
    public BadPropertyException(String message) { 
        super(message);
    }
    
}
