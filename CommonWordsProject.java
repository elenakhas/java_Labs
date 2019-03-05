
/**
 * Write a description of class decryption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CommonWordsProject {
    // reads the file and returns each word in an array
    public String[] getCommon(){
        FileResource fr = new FileResource("data/common.txt");
        String [] common = new String [20];
        int index = 0;
        for (String s : fr.words()){
            common[index] = s;
            index +=1;
        }
        return common;
    }
    // returns an index of a word in a string "list" if it is a common word "word"
    public int indexOf(String [] list, String word){
        for (int k = 0; k < list.length; k++){
            if (list[k].equals(word)){
                return k;
            }
        }
        return -1;
    }
    // counts how many times a common word was used in a file
    public void countWords(FileResource fr, String [] common, int[] counts){
        for (String word : fr.words()){
            word = word.toLowerCase();
            int index = indexOf(common, word);
            if (index != -1){
                counts [index] += 1;
            }
        }
    }
    //counts how many times common words were used in a file
    void countShakespeare(){
        //String [] plays = {"caesar.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt"};
        String[] plays = {"small.txt"};
        String [] common = getCommon();
        int [] counts = new int [common.length];
        for (int k = 0; k < plays.length; k++){
            FileResource fr = new FileResource("data/" + plays[k]);
            countWords(fr, common, counts);

        }

        for (int k=0; k < common.length; k++){
            System.out.println(common[k] + "\t" + counts[k]);
        }
    }
    
}
