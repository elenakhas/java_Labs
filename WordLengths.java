
/**
 * Write a description of class WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {
    //read in the words from resource and count the number of words of each length for all the words
    //in resource, storing these counts in the array counts
    public void countWordLengths (FileResource resource, int [] counts){
        
        //read in the words from resource
        // number of letters in a word
        for (String word : resource.words()){
            //word = word.toLowerCase();
            //access the characters in a word
            StringBuilder sb = new StringBuilder(word);
            int quant = 0; 
            int i = 0;  //index of a character
            int last = sb.length() - 1; //last character in a word
            // count the letter characters
            for (int h = 0; h < sb.length(); h++){ 
                if (Character.isLetter(sb.charAt(i)) || sb.charAt(i) == '-' || sb.charAt(i) == '\'' ){
                    quant++;
                }
                if (!Character.isLetter(sb.charAt(last)) || !Character.isLetter(sb.charAt(0))){
                    i++; 
                }
            }
                
            if (quant >= counts.length){
                    quant = counts.length -1;
            }
            if (quant > 0){
                    counts [quant] = counts [quant] + 1;
            }
        }
        
        for (int c = 0; c < counts.length; c++){
                if (counts [c] == 0){
                    continue;
                }
                else{
                    System.out.println(counts[c] + "words with " + c + " characters");
                }
        } 
    
    }
    //returns the most common word length
    public int indexOfMax (int[] values){
        int commonwl = 0;
        int biggestnumber = 0;

        for (int k = 0; k < values.length; k++){
            int currentNumber = 0;
            if (values[k] != 0){
                currentNumber = values[k];
                if (currentNumber > biggestnumber){
                    biggestnumber = currentNumber;
                    commonwl = k;
                }
            }
        }
        return commonwl;
    }
    public void testCountWordLength(){
        FileResource fr = new FileResource();
        int[] counter = new int[31];
        countWordLengths(fr, counter);
        System.out.println("Most common word length is " + indexOfMax(counter));
        
        }
        
    }

