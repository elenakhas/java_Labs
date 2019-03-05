
/**
 * Write a description of class CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CharactersInPlay {

    private ArrayList <String> characters;
    private ArrayList <Integer> counts;
    
    public CharactersInPlay() {
        characters = new ArrayList <String>();
        counts = new ArrayList <Integer>();
    }
    public void update(String person){
        int index = characters.indexOf(person);
        if (index == -1){
                characters.add(person);
                counts.add(1);
        }
        else{
                int value = counts.get(index);
                counts.set(index, value+1);
        }
        }
    public void findAllCharacters(){
        characters.clear();
        counts.clear();
        FileResource fr = new FileResource();
        for (String s : fr.lines()){
            int ind = s.indexOf(".");
            if (ind != -1){
                String name = s.substring(0, ind);
                update(name);
            }
        }
    }
    public void charactersWithNumParts (int num1, int num2){
        for (int k = 0; k < counts.size(); k++){
            if (counts.get(k) >= num1 && counts.get(k) <= num2){
                System.out.println ("Characters with num.parts: " + characters.get(k) + " : " + counts.get(k));
            }
        }
    }
    public void tester(){
        findAllCharacters();
        for (int k = 0; k < characters.size(); k++){
            if (counts.get(k) >= 10){
                System.out.println (characters.get(k) + " : " + counts.get(k));
            }
        }
        charactersWithNumParts (10, 15);
    }
}
//4932 // the //692 //ROSALIND //200