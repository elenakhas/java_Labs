
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.lang.*;
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
   
  public StorageResource getAllGenes(String dna){
  
  StorageResource geneList = new StorageResource();
  int startIndex = 0;
  while (true){
    String currentGene = findGene(dna,startIndex);
    if (currentGene.isEmpty()){
      break;
    }
    geneList.add(currentGene);
    //System.out.println(currentGene);
    startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    
    } 
  return geneList;
}
public void testAllGenes(){
    //            +       -   +    -     +             -
  String dna = "ATGCTATAATCAATGTAGGTCGTATGCATGCGTTTTGAGCTGCGT";
    StorageResource genes = getAllGenes(dna);
    for (String g : genes.data()){
    System.out.println(g);
  }
  }
  public double findC(String dna){
    int numberC = 0;
    int C = dna.indexOf("C");
    while (C >= 0){ 
           C = dna.indexOf("C", C+1);
           numberC = numberC + 1;
        }
        //System.out.println("Number of C: " + numberC);
        return numberC;
    }
  public double findG (String dna){
    int numberG = 0;
    int G = dna.indexOf("G");
    while (G >= 0){ 
           G = dna.indexOf("G", G+1);
           numberG = numberG + 1;
        }
        //System.out.println("Number of G: " + numberG);
        return numberG;
    }
    public double cgRatio (String dna){
        //System.out.println("DNA length: " + dna.length());
        double ratio = 0.0;
        ratio = ((findC(dna) + findG(dna)) / dna.length());
        //System.out.println ("ratio:" + ratio);
        return ratio;
  }
  public int countCTG(String dna){
    int numberCTG = 0;
    int findCTG = dna.indexOf("CTG");
    while (findCTG >= 0){ 
           findCTG = dna.indexOf("CTG", findCTG+1);
           numberCTG = numberCTG + 1;
        }
        System.out.println("Number of CTG: " + numberCTG);
        return numberCTG;
     }
  public void processGenes(StorageResource sr){   
    StorageResource longerthan60 = new StorageResource();
    StorageResource greaterthan35 = new StorageResource();
    int sizelongerthan60 = 0;
    int number60 = 0;
    int cgratio = 0;
    int longestgene = 0;
    for (String g : sr.data()){
          //process each gene g
         //print all strings longer than 9, print their number   
            if (g.length() > 60){
              number60 = number60+1;
              longerthan60.add(g);
          }
        // pring strings with C-G tatio > 0.35 and their number
            if (cgRatio(g) > 0.35){
              
              cgratio = cgratio+1;
              greaterthan35.add(g);
            }
            
        // print the length of the longest gene
            
            int currentgene = g.length();
           
            if (longestgene < currentgene){
                longestgene = currentgene;
            }
            
        }
         System.out.println("Total genes: " + sr.size());
         System.out.println("Number of genes longer than 60: " + longerthan60.size());
         System.out.println("Number of genes with C-G ratio more than 0.35: " + greaterthan35.size());
         System.out.println("The longest gene length is: " + longestgene);
         for (String s : longerthan60.data()){
         System.out.println("Genes longer than 60: " + s);
        }
         for (String m : greaterthan35.data()){
             System.out.println("Genes with C-G ratio more than 0.35: " + m);
            }
        }
  public void testProcessGenes(){
      //one DNA string that has some genes longer than 9 characters
       String dna = "BVCATGTAAGBCATGGCNNHUIKMTAABVCATGGFCBNHTGBTBCTGA";
       StorageResource sr = getAllGenes(dna);
       processGenes(sr);
      }   
    public void testProcessGenes2(){
    FileResource fr = new FileResource();
    String dna = fr.asString();
    String dnaUp = dna.toUpperCase();
    //StorageResource dnaStore = new StorageResource(); 
    StorageResource sr = getAllGenes(dnaUp);
    processGenes(sr);
    countCTG(dnaUp);
      }
  
}

 

