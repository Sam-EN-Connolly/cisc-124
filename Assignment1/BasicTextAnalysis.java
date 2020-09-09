package Assignment1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter; 
import java.util.*;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca>
 *              Student Number : 20004364
 *              CISC 124 - Assignment 1 - Basic text analysis
 *              July 8, 2020
 * 
 * Basic text analys contains several finctions to analyse text including, 
 * counting the words, counting sentances, finding if a word is contained in 
 * the text, and output the top ten most common words.
 */

public class BasicTextAnalysis {

    /** 
     * converts string to string array containing words with only letters 
     * 
     * @param textString string to convert to array
     * @return string array containing words from input string
     */
    private static String[] stringArray(String textString) {
        String[] textArray = textString.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        return textArray;
    }
    
    /**
     * counts number of entries in an array. if the array doesn't exist, 0 is returned
     * 
     * @param textArray string array
     * @return length of string array, or zero
     */
    private static int countWords (String[] textArray) {
        if (textArray == null) {
            return 0;
        } else {
            int numWords = textArray.length;
            return numWords;
        }
        
    }

    /**
     * counts number of sentances in a string
     * 
     * @param textString string containing text to analyse
     * @return number of sentances as int
     */
    private static int countSentances (String textString) {
        // split string at punctuation to make array of sentances
        String[] sentances = textString.split("[.!?]+");
        // find number of sentances from length of array
        int numSentances = sentances.length;
        return numSentances;
    }

    /**
     * finds the top occuring words in a string array and saves them to a file
     * 
     * @param textArray string array of words
     */
    private static void findTopWords (String[] textArray) {
        String[] topTen = new String[10];
        int[] timesAppeared = new int[10];
        // create hashmap to hold and count words that are in textArray
        HashMap<String, Integer> topWords = new HashMap<String, Integer>();
        for (String word : textArray) { 
            if (topWords.containsKey(word)) {
                topWords.put(word, topWords.get(word) + 1);
            } else {
                topWords.put(word, 1);
            }
        }
        // go through the hasmap 10 times and find and remove the top 
        // word each time and store in an array
        for (int i = 0; i < 10; i++) {
            int max = -1;
            String maxKey = "";
            for (String key : topWords.keySet()) {
                if (topWords.get(key) > max) {
                    max = topWords.get(key);
                    maxKey = key;
                }
            }
            topTen[i] = maxKey;
            timesAppeared[i] = max;
            //System.out.println(i + ": " + maxKey + " " + max );  //print out top ten words
            topWords.remove(maxKey);
        }
        // save array into text file
        // create new file, if file arlready exists, write to current file
        try {
            File myObj = new File("topTenWords.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
        } catch (IOException ex) {
            System.out.println("An error occurred.");
        }

        try {
            FileWriter myWriter = new FileWriter("topTenWords.txt");
            myWriter.write("Top words,number of incetances\n");
            for (int i = 0; i < 10; i++) {
                myWriter.write(topTen[i]+","+timesAppeared[i]+"\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException ex) {
            System.out.println("An error occurred.");
        }
    }

    /**
     * determines if substring is in string to analyse
     * 
     * @param subString substring to find
     * @param textString string in which to find substring
     * @return boolean saying weather of not the substring is contained in the string
     */
    private static boolean findInText(String subString, String textString) {
        // find substring in string
        boolean inString = false;
        int checkLength = textString.length()-subString.length();

        for (int i=0; i<checkLength; i++) {
            // if string has been found, break from loop
            if (inString) break;
            for (int j=0; j<subString.length(); j++) {
                // compare current character in textString and subString
                // if they are not the same, break out of inner loop
                if (textString.charAt(i+j) != subString.charAt(j)) {
                    break;
                // if end of word is reached, end sequence
                } else if (j==subString.length()-1){
                    inString = true;
                    break;
                }
            }
        }
        return inString;
    }

    /**
     * this program demonstrates some basic text analysis on a text file.
     * <p>
     * The program opens the text file using code from CISC124-Summer2020
     * The program finds the number of words and sentances in a text. 
     * It also determines if two words are in the text, one is, one is not. 
     * Finally, it determins the ten words that occur most frequently in the text,
     * and saves them to another text file.
     * <p>
     * @param args
     */
    public static void main (String[] args) { 

        String fileName = "./Assignment1/PoliticalSpeech.txt";
        String line = null;
        String textString = "";
    
        try {
            FileReader fileReader = 
                new FileReader(fileName);
    
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                textString = textString + line;
                }   
    
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }

        // example code
        String[] textArray = stringArray(textString);
        int numWords = countWords(textArray);
        int numSentances = countSentances (textString);

        String wordToFind1 = "The";
        String wordToFind2 = "silly";

        System.out.println("This is an analysis of a section of an Obama's acceptance speach.");
        System.out.print("Number of words : ");
        System.out.println(numWords);
        System.out.print("Number of sentances : ");
        System.out.println(numSentances);
        System.out.print(wordToFind1 + " in text : ");
        System.out.println(findInText(wordToFind1, textString));
        System.out.print(wordToFind2 + " in text : ");
        System.out.println(findInText(wordToFind2, textString));
        findTopWords(textArray);

    }
}