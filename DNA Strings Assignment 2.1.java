
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.lang.*;
import edu.duke.*;
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        
        int stopIndex = dna.indexOf(stopCodon, startIndex +3);
      
        while (stopIndex != -1) {
          int  diff = stopIndex - startIndex;
          if (diff % 3 == 0){
            return stopIndex;
          }
          else{
            stopIndex = dna.indexOf(stopCodon, stopIndex+1);
          }
        
          }
        return -1;
        }

     public void testFindStopCodon(){
         //            012345678901234567890123456789 
         String dna = "AGACTGATCATGGTATGAATATAAGTATA";
         int stop = findStopCodon(dna, 9, "TGA");
         System.out.println("Stop codon is" + stop);
         //     012345678901234567890123456789
         dna = "AGBCGHITAATGTGATAGTAGTGDGTATAG"; 
         stop = findStopCodon(dna, 0, "TAA");
         System.out.println("Stop codon is" + stop);
         
     }
    public String findGene (String dna, int where){
      int startIndex = dna.indexOf("ATG", where);
      
        if (startIndex == -1){
        return "";
      }
      
      int taaIndex = findStopCodon(dna, startIndex, "TAA");
      int tgaIndex = findStopCodon(dna, startIndex, "TGA");
      int tagIndex = findStopCodon(dna, startIndex, "TAG");
      int minIndex = 0;
      if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
        minIndex = tgaIndex;
        }
        else{
        minIndex = taaIndex;
      }
      if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        
        if (minIndex == -1){
         return "";
      }
      return dna.substring(startIndex, minIndex + 3);
    }
    public void testFindGene (){
    // a valid gene
    String dna = "CATATGGTCCTATGATAACTAGTA";
    System.out.println("DNA strand is" + dna);
    String gene = findGene(dna,0);
    System.out.println("Gene is" + gene);
    //no start codon - empty string
    dna = "CATAGGTCCTACGATAACTAGTA";
    System.out.println("DNA strand is" + dna);
    gene = findGene(dna, 0);
    System.out.println("Gene is" + gene);
    // no stop codon - empty string
    dna = "ATCCGTATGCGTATG";
    System.out.println("DNA strand is" + dna);
    gene = findGene(dna,0);
    System.out.println("Gene is" + gene);
    
    //no stop codon divisible by 3
    dna = "CATATGGTCCTTGATAACTAGTA";
    System.out.println("DNA strand is" + dna);
    gene = findGene(dna,0);
    System.out.println("Gene is" + gene);
    
    //multiple stop codons
    dna = "CATATGGTCCTTTAGTAATAGGATAACTAGTA";
    System.out.println("DNA strand is" + dna);
    gene = findGene(dna,0);
    System.out.println("Gene is" + gene);
  }
  public void printAllGenes(){
  //            +       -   +    -     +             -
  String dna = "ATGCTATAATCAATGTAGGTCGTATGCATGCGTTTTGAGCTGCGT";
  int startIndex = 0;
  while (true){
    String currentGene = findGene(dna,startIndex);
    if (currentGene.isEmpty()){
      break;
    }
    System.out.println(currentGene);
    startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    } 
  }
}
