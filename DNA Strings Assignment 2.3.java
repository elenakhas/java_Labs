
/**
 * Write a description of class Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
  public int countGenes(String dna){
  //            +       -   +    -     +             -              +       
  //dna = "ATGCTATAATCAATGTAGGTCGTATGCATGCGTTTTGAGCTGCGTATGATAAATGCTATAGA";
  int numGenes = 0;
  int startIndex = 0;
  while (true){
    String currentGene = findGene(dna,startIndex);
    if (currentGene.isEmpty()){
      break;
    }

    startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
    numGenes = numGenes + 1;
    
  } 
  return numGenes;
 }
 public void testCountGenes(){
     String dna = "ATGTAAGATGCCCTAGT";
     System.out.println(countGenes(dna));
     
     dna = "ATGTAAGATGCCCTAGTATGTAAGATGCCCTAGT";
     System.out.println(countGenes(dna));
     
     dna = "ATGTAAGATGCCCTAGTATGTAGTAAATGTAATGCTAA";
     System.out.println(countGenes(dna));
    }
 }
