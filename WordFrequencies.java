
/**
 * Write a description of class WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class WordFrequencies {

    private ArrayList <String> myWords;
    private ArrayList <Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList <String>();
        myFreqs = new ArrayList <Integer>();
    }
    public void findUnique(){
         myWords.clear();
         myFreqs.clear();
         FileResource resource = new FileResource();
         for (String s : resource.words()){
             s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }
    public void tester(){
        findUnique();
        System.out.println("# of unique words: " + myWords.size());
        for (int k=0; k < myWords.size(); k++){
            System.out.println ("The word "+ myWords.get(k) + " " + "appeared " + myFreqs.get(k) + " times");
        }
        int k = findIndexOfMax();
        System.out.println ("The word that occurs most often and its count are: " + myWords.get(k) + " \\ " + myFreqs.get(k));
        }
        
    
    public int findIndexOfMax(){
        int maxIndex = 0;
        int maxFreq = 0;
        for (int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > maxFreq){
                maxFreq = myFreqs.get(k);
                maxIndex = k;
                String word = myWords.get(maxIndex);
            }
        }
        return maxIndex;
    }
}
