
/**
 * Write a description of class Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.lang.*;
import edu.duke.*;

public class Part4 {

    public String Findalink(String word){ 
        String mylink = "";
        String workingword = word.toLowerCase(); //convert a string into lowercase
        int first = workingword.indexOf("youtube.com"); //check if the word contains youtube
        if (first != -1){
          int end = word.indexOf("\"", first);
          int start = word.lastIndexOf("\"", first-1);
          mylink =  word.substring(start, end+1);
          return mylink;
          }
        return mylink;
    }
   
     
    public void testURL() {
        URLResource ur = new URLResource ("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
          for (String word : ur.words()){
          //System.out.println(word);
          System.out.println(Findalink(word));
        }
  }
  }




