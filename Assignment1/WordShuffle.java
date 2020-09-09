package Assignment1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author      Sam Connolly <s.connolly@queensu.ca> 
 *              Student Number : 20004364
 *              CISC 124 - Assignment 1 - Word shuffle game
 *              July 8, 2020
 * 
 * Wordshuffle runs a game where two players have to take turns 
 * guessing scrambled words. 
 */


public class WordShuffle {

    /** 
     * reads words from file and puts in a String array
     * 
     * @param fileName filepath and name where list of reference words are stored
     * @param words empty String array with length equal to number of reference words
     * @return String array containing the reference words
     */
    private static String[] readWords(String fileName, String[] words) { 

        String line = null;
        int count = 0;

        try {
            FileReader fileReader = 
                new FileReader(fileName);
    
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                words[count] = line.strip();
                count++;
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
        return words;
    }

    /** 
     * takes a word and reshuffles the letters
     * 
     * @param random random incetance from Random class
     * @param word a string containing a single word
     * @return String of the input word with the characters in a random order
     */
    private static String shuffle(Random random, String word){
    // convert string into char array
    char charArr[] = word.toCharArray();

    // scramble the word using by switching letters 
    for(int i=0; i<charArr.length; i++ ) {
        int j = random.nextInt(charArr.length);
        // swap letters
        char temp = charArr[i]; 
        charArr[i] = charArr[j];  
        charArr[j] = temp;
    }       
    return new String(charArr);
}
    /** 
     * changes value of currentPlayer from 1 to 2, or 2, to 1
     * 
     * @param currentPlayer player number of current player, int 1 or 2
     * @return other player number, int 1 or 2
     */
    private static int changePlayer(int currentPlayer) {
        if (currentPlayer == 1) {
            return 2;
        } else {
            return 1;
        }
    }

    /** 
     * prints the intro instructions for the word shuffle game
     * 
     */
    private static void printIntro() {
        System.out.println("\nHello you are playing word shuffle.");
        System.out.println("Each turn one of you will be presented with a shuffled word.");
        System.out.println("You must guess the unshullfed version of the word.");
        System.out.println("You have five attempts, and you get one fewer points with each attempt, stating with five.");
        System.out.println("If you with to forefit your turn, press enter without typing anything");
        System.out.println("Goodluck!\n");
    }

    /** 
     * runs word shuffle game
     * <p>
     * The Word Shuffle game is a puzzle that shuffles the letters of a word. 
     * A word is selected a word and jumbled or mixed up and displayed to the player.
     * The player of the game must then guess what the original word was before it had been shuffled.
     * Players take turns guessing words until one player reaches 40 points. 
     * <p>
     * 
     * @param args 
     */
    public static void main(String[] args) { 
        int i;
        int currentPlayer = 2;
        String currentWord;
        String shuffledWord;
        String inWord;
        boolean gotWord = false;
        boolean gameWon = false;

        HashMap<Integer, Integer> playerPoints = new HashMap<Integer, Integer>();
        playerPoints.put(1, 0);
        playerPoints.put(2, 0);

        String[] words = new String[5459];
        String fileName = "./Assignment1/englishWords.txt";

        Random random = new Random(); 
        int range = 5460;
        int randomNum;

        Scanner in = new Scanner(System.in);
        
        // read in english words from file
        words = readWords(fileName, words);

        // print insructions for game
        printIntro();

        while (!gameWon) {
            randomNum = random.nextInt(range);
            currentPlayer = changePlayer(currentPlayer);

            System.out.print("It's you're turn player");
            System.out.println(currentPlayer);

            // get randomized word
            currentWord = words[randomNum];
            shuffledWord = shuffle(random, currentWord);

            gotWord = false;
            // give player up to five guesses
            for (i=5; i>0; i--) {

                System.out.println("\nWhat word is " + shuffledWord.toUpperCase() + ", unscrammbled?");
                System.out.println("Type in word and press enter.");
                inWord = in.nextLine().toLowerCase();

                if (inWord.equals("")) { 
                    System.out.println("You have forefitted your turn.");
                    break;
                }

                if (inWord.equals(currentWord)) { 
                    playerPoints.put(currentPlayer, playerPoints.get(currentPlayer) + i);
                    if (playerPoints.get(currentPlayer) >= 40) {
                        gameWon = true;
                    }
                    gotWord = true;
                    break;
                }

            }
            // check if player got word and display appropriate responce
            if (!gotWord){
                System.out.print("\nSorry player ");
                System.out.print(currentPlayer);
                System.out.println(", the word was " + currentWord);
                System.out.println("Better luck next time\n");
            } else {
                System.out.print("\nGood job player ");
                System.out.print(currentPlayer);
                System.out.println(", the word was " + currentWord);
                System.out.print("You now have ");
                System.out.print(playerPoints.get(currentPlayer));
                System.out.println(" points!");
            }
        }
        
        // print winning message
        System.out.println("\nYou have reached more than 40 points!");
        System.out.print("You win the game player");
        System.out.println(currentPlayer);

        in.close();

    }
}