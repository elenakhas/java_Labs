
/**
 * Write a description of class Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2
 {
    public String findSimpleGene (String dna, String startCodon, String stopCodon){
        String result = "";
        
        String dna1 = dna.toUpperCase();
    
        int StartIndex = dna1.indexOf(startCodon);
        if (StartIndex == -1) {
          return "";
        }
    
        int EndIndex = dna1.indexOf(stopCodon,StartIndex + 3);
        if (EndIndex == -1) {
          return "";
        }
        
        result = dna1.substring (StartIndex, EndIndex + 3);
        int stringlength = result.length();
        if (stringlength % 3 != 0) {
          return "";
        }  
        return result;    
  } 
  
    public void testSimpleGene(){
      
      String startCodon = "ATG";
      String stopCodon = "TAA";
      String dna = "ATGTAA";
      System.out.println ("Working with:" + " " + dna);
      String gene = findSimpleGene(dna, startCodon, stopCodon);
      System.out.println ("Gene is" + " " + gene);
      
      dna = "TAAGATTAGATGATGGTATAGTACACTGTCATAAGCTACTTAAGCTACT"; 
      
      System.out.println ("Working with:" + " " + dna);
      gene = findSimpleGene(dna, startCodon, stopCodon);
      System.out.println ("Gene is" + " " + gene);
      
      dna = "GTAAGTATGAGCTAGTAAGTCGAT";
      
      System.out.println ("Working with:" + " " + dna);
      gene = findSimpleGene(dna, startCodon, stopCodon);
      System.out.println ("Gene is" + " " + gene);
      
      dna = "GTAATGTGCCTATAGGAT";
      
      System.out.println ("Working with:" + " " + dna);
      gene = findSimpleGene(dna, startCodon, stopCodon);
      System.out.println ("Gene is" + " " + gene);
      
      dna = "agctaaatgacttcagctcagtaagattcg";
      System.out.println ("Working with:" + " " + dna);
      gene = findSimpleGene(dna, startCodon, stopCodon);
      String gene1 = gene.toLowerCase();
      System.out.println ("Gene is" + " " + gene1);
        
  }  
  }
