//a program to find out how many times each codon occurs in a strand of DNA based on reading frames
/**
 * Write a description of class CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CodonCount {
    private HashMap <String, Integer> codon_count;
    
    
    public CodonCount(){
        codon_count = new HashMap();
        
    }
    public void buildCodonMap (int start, String dna){
        codon_count.clear();
        String cod = null;
        while (start <= dna.length() -3){
            cod = dna.substring(start, start+3);
            start = start + 3;
    
            if (codon_count.keySet().contains(cod)){
                codon_count.put(cod, codon_count.get(cod) + 1);
            }
            else {
                codon_count.put(cod, 1);
            }
        }
        System.out.println("Number of unique codons: " + codon_count.size());
        for (String c : codon_count.keySet()){
           int occurrences = codon_count.get(c);
           System.out.println(c + " : " + occurrences);
        }
    }
    public String getMostCommonCodon(){
       int max_occur = 0;
       String common = null;
       for (String c : codon_count.keySet()){
           if (codon_count.get(c) > max_occur){
               max_occur = codon_count.get(c);
               common = c;
            }
        }
       System.out.println ("The most common codon is: " + common); 
       return common; 
    }
    public void printCodonCounts (int start, int end){
        for (String c : codon_count.keySet()){
            int occurrences = codon_count.get(c);
            if (occurrences >= start && occurrences <= end){
                System.out.println("Occurred between " + start + " and " + end + " times: " + c + " , " + occurrences);
            }
        }
    }
    public void tester (){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        dna = dna.trim();
        dna = dna.toUpperCase();
        System.out.println("Frame 0: /n");
        buildCodonMap(0, dna);
        getMostCommonCodon();
        printCodonCounts(7, 7);
        System.out.println("Frame 1: /n");
        buildCodonMap(1, dna);
        getMostCommonCodon();
        printCodonCounts(6, 6);
        System.out.println("Frame 2: /n");
        buildCodonMap(2, dna);
        getMostCommonCodon();
        printCodonCounts(4, 4);
    }
}
