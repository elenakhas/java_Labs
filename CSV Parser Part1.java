
/**
 * Write a description of class Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class Part1 {
// import libraries

  public void tester (){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    
    //method 1
    countryinfo(parser, "Nauru");
   
    
    //method 2
    parser = fr.getCSVParser();
    listExportersTwoProducts(parser, "cotton", "flowers");
    //method 3
    parser = fr.getCSVParser();
    numberOfExporters(parser, "cocoa");
    //int number = numberOfExporters(parser, "gold");
    //System.out.println(number);
    //method 4
    parser = fr.getCSVParser();
    bigExporters(parser, "$999,999,999,999");
    //method 5
}
  public void  countryinfo(CSVParser parser, String countryOfInterest){
    for (CSVRecord record : parser){
      String country = record.get("Country");
      if (country.contains(countryOfInterest)){
          System.out.print(record.get("Country") + ":" + " ");
          System.out.print(record.get("Exports") + ":" + " ");
          System.out.println(record.get("Value (dollars)"));
        }
      else{
          System.out.println("COUNTRY NOT FOUND");
        }
        }
        }
  public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
    for (CSVRecord record : parser){
      String export = record.get("Exports");
      if(export.contains(exportItem1) && export.contains(exportItem2)){
        System.out.println(record.get("Country"));
        }
    } 
  } 
  public void numberOfExporters(CSVParser parser, String exportItem){
    int n = 0;
      for (CSVRecord record : parser){
       String export = record.get("Exports");
       if(export.contains(exportItem)){
           String country = record.get("Country");
           n = n+1;
        }
    }
    System.out.println(n);
    //return n;
    }
    public void bigExporters(CSVParser parser, String amount){
      for (CSVRecord record : parser){
        String value = record.get("Value (dollars)");
        if (value.length() > amount.length()){
            String country = record.get("Country");
            System.out.print(country + " ");
            System.out.println(value);
        }
    }
    }
}
