
/**
 * Write a description of class Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Part2 {
    public CSVRecord lowestOfTwo(CSVRecord currentrow, CSVRecord lowestsofar){
    //lowestsofar = null;
        if(lowestsofar == null){
            lowestsofar = currentrow;
    }
    else{
        double currentTemp = Double.parseDouble(currentrow.get("TemperatureF"));
        double lowestTemp = Double.parseDouble(lowestsofar.get("TemperatureF"));
        // check if currentrow's temp < lowestsofar
        if (currentTemp < lowestTemp && currentTemp != -9999){
        //update lowestsofar to currentrow
        lowestsofar = currentrow;
        }
    }
    return lowestsofar;
}
public CSVRecord ColdestHourInFile(CSVParser parser){
    CSVRecord lowestsofar = null;
    for (CSVRecord currentrow : parser){
        lowestsofar = lowestOfTwo(currentrow, lowestsofar);
    }

    return lowestsofar;
}

public void testcoldestday(){
FileResource fr = new FileResource();
CSVRecord coldest = ColdestHourInFile(fr.getCSVParser());
System.out.println("Coldest temperature was " + coldest.get("TemperatureF") + " at " + coldest.get("DateUTC"));
}

public String fileWithColdestTemperature(){
    String Filename = null;
    CSVRecord lowestsofar = null;
    CSVRecord currentrow = null;
    DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        currentrow = ColdestHourInFile(fr.getCSVParser());
        lowestsofar = lowestOfTwo(currentrow, lowestsofar);
        if (lowestsofar == currentrow){
        Filename = f.getName();
    }
}
    return Filename;
}
public void testFileWithColdestTemperature(){
  //DirectoryResource dr = new DirectoryResource();
  String coldestfile = fileWithColdestTemperature();
  System.out.println("Coldest temperature is in file " + coldestfile);
  FileResource fr = new FileResource();
  CSVRecord coldest = ColdestHourInFile(fr.getCSVParser());
  System.out.println("Coldest temperature was " + coldest.get("TemperatureF") + " at " + coldest.get("DateUTC"));
  CSVParser parser = fr.getCSVParser();
  System.out.println("All the temperatures on the coldest day were:");
    for (CSVRecord record : parser){
        System.out.println(record.get("DateUTC") + " " + record.get("TemperatureF"));
  }
}
public CSVRecord lowestHumidityOfTwo(CSVRecord currentrow, CSVRecord lowestsofar){
    //lowestsofar = null;
        if(lowestsofar == null){
            lowestsofar = currentrow;
    }
    else{
        double currentTemp = Double.parseDouble(currentrow.get("Humidity"));
        double lowestTemp = Double.parseDouble(lowestsofar.get("Humidity"));
        // check if currentrow's temp < lowestsofar
        if (currentTemp < lowestTemp){
        //update lowestsofar to currentrow
        lowestsofar = currentrow;
        }
    }

    return lowestsofar;
}
public CSVRecord lowestHumidityInFile (CSVParser parser){
CSVRecord lowestsofar = null;
    for (CSVRecord currentrow : parser){
        if(currentrow.get("Humidity").equals("N/A")){
        continue;
        //System.out.println("No temperature found");
        }
        else{
        lowestsofar = lowestHumidityOfTwo(currentrow, lowestsofar);  
    }
}
    return lowestsofar;
}
public void testLowestHumidity(){
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    CSVRecord csv = lowestHumidityInFile(parser);
    System.out.println("Lowest humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
}
public CSVRecord lowestHumidityInManyFiles(){
    CSVRecord lowestsofar = null;
    DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        CSVRecord currentrow = lowestHumidityInFile(fr.getCSVParser());
        lowestsofar = lowestHumidityOfTwo(currentrow, lowestsofar);
    }
    return lowestsofar;
}
public void testLowestHumidityInManyFiles(){
  //DirectoryResource dr = new DirectoryResource();
  CSVRecord lowesthumidity = lowestHumidityInManyFiles();
  System.out.println("Lowest humidity was " + lowesthumidity.get("Humidity") + " at " +  lowesthumidity.get("DateUTC"));
  }
public double averageTemperatureInFile(CSVParser parser){
int count = 0;
double sumtemp = 0.0;
// get the size of the record
for (CSVRecord currentrow : parser){
    if(currentrow.get("TemperatureF").equals("-9999")){
        continue;
        }
    else{
        double currenttemp = Double.parseDouble(currentrow.get("TemperatureF"));
        sumtemp = sumtemp + currenttemp;
        count++;
}
}
return sumtemp / count;
}
public void testaveragetemp(){
FileResource fr = new FileResource();
double average = averageTemperatureInFile(fr.getCSVParser());
System.out.println("Average temperature is " + average);

}
public double averageTemperatureWithHighHumidity(CSVParser parser, int value){ //calculates average temp. for high humidity days
    int count = 0;
    double sumtemp = 0.0;
    for (CSVRecord currentrow : parser){
        double currenthumidity = Double.parseDouble(currentrow.get("Humidity"));
        if(currenthumidity >= value){
            double currenttemp = Double.parseDouble(currentrow.get("TemperatureF"));
            sumtemp = sumtemp + currenttemp;
            count++;
    }
  }
    return sumtemp / count;
}
public void TestAverageTemperatureWithHighHumidity(){
  FileResource fr = new FileResource();
  double average = averageTemperatureWithHighHumidity(fr.getCSVParser(), 80);
    if (average > 0){
    System.out.println("Average temperature with high humidity is " + average);
    }
    else{
    System.out.println("No temperatures with that humidity");
  }
  }
  }




    


