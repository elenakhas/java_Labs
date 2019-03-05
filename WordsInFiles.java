
/**
 * Write a description of class WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import java.io.File;
public class WordsInFiles {

    public HashMap <String, ArrayList <String>> map;
    public WordsInFiles() {
        map = new HashMap ();

    }
    private void addWordsFromFile (File f){
        
        FileResource fl = new FileResource(f);
        String filename = f.getName();
        
        for (String w : fl.words()){

            if (!(map.containsKey(w))){
                ArrayList <String> files = new ArrayList <String>();
                files.add(filename);
                map.put(w, files);
                //System.out.println (w + ": Files: " + files);
            }
            else{
                ArrayList <String> temp = new ArrayList<String>();
                temp = map.get(w);
                if(!(temp.contains(filename))){
                    temp.add(filename);
                }
                //System.out.println (w + " : Temp: " + temp);
            }

        }

    }
    public void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for ( File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
        //System.out.println("My map: " + map);
    }
    public int maxNumber(){
        int max = 0;
        for (String w : map.keySet()){
            if (map.get(w).size() > max){
                max = map.get(w).size();
            }
            }
        return max;
    }
    public ArrayList wordsInNumFiles (int number){
        ArrayList <String> neededWords = new ArrayList();
        for (String w : map.keySet()){
            if (map.get(w).size() == number){
                neededWords.add(w);
            }
            }
        System.out.println ("Num of words that appear in a set num of files: " + neededWords.size());
        return neededWords;
    }
    public void printFilesIn (String word){
        map.keySet();
             ArrayList temp = map.get(word);
             
             for (int k = 0; k < temp.size(); k++){
                 System.out.println("The word " + word + " appears in file: " + temp.get(k));
                 
                

        }
        
        
    }
    
    public void tester(){
        buildWordFileMap();
        System.out.println("The greatest number of files for a word: " + maxNumber());
        System.out.println("The words that appear in 7 files are: " + wordsInNumFiles(7));
        System.out.println("The words that appear in 4 files are: " + wordsInNumFiles(4));
        
        printFilesIn ("laid");
        printFilesIn ("tree");
        //printFilesIn ("dogs");
    }
}

