
/**
 * Write a description of class Part1 here.
 * 
 * @ElenaKhasanova (your name) 
 * @062218 (a version number or a date)
 */


public class Part1{ 
    
    public String findSimpleGene (String dna){
        String result = "";
    
        int StartIndex = dna.indexOf("ATG");
        if (StartIndex == -1) {
          return "";
        }
    
        int EndIndex = dna.indexOf("TAA",StartIndex + 3);
        if (EndIndex == -1) {
          return "";
        }
        
        result = dna.substring (StartIndex, EndIndex + 3);
        int stringlength = result.length();
        if (stringlength % 3 != 0) {
          return "";
        }  
        
        return result;    
  } 
  
    public void testSimpleGene(){
      String dna = "AAATGCCCTAACTAGATTAAGAAACC";
      System.out.println ("Working with:" + " " + dna);
      String gene = findSimpleGene(dna);
      System.out.println ("Gene is" + " " + gene);
      
      dna = "TAAGATTAGATGATGGTATAGTACACTGTCATAAGCTACTTAAGCTACT";
      System.out.println ("Working with:" + " " + dna);
      gene = findSimpleGene(dna);
      System.out.println ("Gene is" + " " + gene);
      
      dna = "GTAAGTATGAGCTAGTAAGTCGAT";
      System.out.println ("Working with:" + " " + dna);
      gene = findSimpleGene(dna);
      System.out.println ("Gene is" + " " + gene);
      
      dna = "GTAATGTGCCTATAGGAT";
      System.out.println ("Working with:" + " " + dna);
      gene = findSimpleGene(dna);
      System.out.println ("Gene is" + " " + gene);
        
  }  
}