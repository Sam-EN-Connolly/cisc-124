package Assignment1;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 1 - Secret Messages
 *              July 8, 2020
 * 
 * Secret messages contains two functions to encode and decode
 * a string based on an encryption where each lowercase letter
 * is shifted down the alphabel by a given amount.
 */

public class SecretMessages {

    /**
     * encodes a strings by shifting the lowercase letters by a given amout
     * <p>
     * This function takes a string and shifts all the lowercase letters
     * by a given amount, key. 
     * The message may include spaces and punctuation characters, 
     * but only the lower case characters ‘a’ through ‘z’ are encoded.
     * <p>
     * Each of the letters of the alphabet will map to the letter key 
     * positions further along in the alphabet. 
     * For example, if the key value is 4, the letters of the alphabet will be mapped as follows:
     * 
     * A -> E
     * B -> F
     * C -> G
     * 
     * and so on...
     * 
     * @param message message to encode as String
     * @param key interger value by which to shift the message character
     * @return encoded message as String
     */
    public static String encode(String message, int key) {
        char[] charArr = message.toCharArray(); 
        int i = 0;
        if (key<0 || key>25) {
            System.out.println("Your key must be between 0 and 25");
            return "";
        }
        for (int ch : charArr) {
                if (ch >= 97 && ch <= 122-key) {
                    charArr[i] = (char) (ch + key);
                } else if (ch > 122-key && ch <= 122) {
                    charArr[i] = (char) (ch + key - 26);
                }
                i++;
            }
        String secretMessage = new String(charArr);
        return secretMessage;
    }


    /**
     * decodes a strings by shifting the lowercase letters by a given amout
     * <p>
     * This function takes an encoded string and shifts all the lowercase letters
     * by a given amount, key. 
     * The message may include spaces and punctuation characters, 
     * but only the lower case characters ‘a’ through ‘z’ are decoded.
     * <p>
     * Each of the letters of the alphabet will map to the letter key 
     * positions further along in the alphabet. 
     * For example, if the key value is 4, the letters of the alphabet will be mapped as follows:
     * 
     * E -> A
     * F -> B
     * G -> C
     * 
     * and so on...
     * 
     * @param codedText message to decode as String
     * @param key interger value by which to shift the message character
     * @return decoded message as String
     */
    public static String decode(String codedText, int key) {
        char[] charArr = codedText.toCharArray(); 
        int i = 0;
        if (key<0 || key>25) {
            System.out.println("Your key must be between 0 and 25");
            return "";
        }
        for (int ch : charArr) {
                if (ch >= 97+key && ch <= 122) {
                    charArr[i] = (char) (ch - key);
                } else if (ch >= 97 && ch < 97+key) {
                    charArr[i] = (char) (ch - key + 26);
                }
                i++;
            }
        String decodedMessage = new String(charArr);
        return decodedMessage;
    }

    public static void main(String[] args) {
        // example code demonstrating the encoding and decoding
        String myMessage = "Hello my name is Sam! I'm enrolled in CISC124; it's alright so far.";
        String encodedMessage = encode(myMessage, 7);
        String decodedMessage = decode(encodedMessage, 7);

        System.out.println("My message : " + myMessage);
        System.out.println("Encoded message : " + encodedMessage);
        System.out.println("Decoded message : " + decodedMessage);
    }
}