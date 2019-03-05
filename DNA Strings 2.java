
/**
 * Write a description of class Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    boolean twoOccurrences (String stringa, String stringb){
        int FirstOccurrence =  stringb.indexOf(stringa); //find first occurrence of stringa in stringb
        //find second occurrence of stringa in stringb after the first
        //int SecondOccurrence = stringb.indexOf(stringa, FirstOccurrence + stringa.length());
        int SecondOccurrence = stringb.indexOf(stringa, FirstOccurrence + 1);
        //check if there is a second occurrence
        if (SecondOccurrence != -1){
            return true;
            }
        else{
            return false;

        }
    }
    String lastPart (String stringa, String stringb){
        int first = stringb.indexOf(stringa);
        if (first != -1){
            return stringb.substring(first, stringa.length());
        }
        else{
            return stringb;
        }
    }

    public void testing() {
        String stringa = "mama";
        String stringb = "mamapapamamarama";
        System.out.println (twoOccurrences(stringa, stringb));
            
        stringa = "kot";
        stringb = "kotobormot";
        System.out.println (twoOccurrences(stringa, stringb));
        
        stringa = "zoo";
        stringb = "forest";
        System.out.println (stringa + " " + stringb);
        System.out.println (lastPart(stringa, stringb));
        
        stringa = "meow";
        stringb = "meowmix";
        System.out.println (stringa + " " + stringb);
        System.out.println (lastPart(stringa, stringb));
    }
    }
        
    