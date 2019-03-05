
/**
 * Write a description of class Names here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Names {
    //this method calculates the total bumber of births in a given year, 
    //plus the total number of boys and girls separately
    public void totalnames(int year){
        FileResource fr = new FileResource("yob" + year + ".csv");
        int totalnames = 0;
        int totalGirls = 0;
        int totalBoys = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            totalnames ++;
            if (rec.get(1).equals("F")){
                totalGirls = totalGirls + 1;
            }
            else{
                totalBoys = totalBoys + 1;
            }
        }
        System.out.println("Total names : " + totalnames);
        System.out.println("Boys born : " + totalBoys);
        System.out.println("Gilrs born : " + totalGirls);
    }

    public void test(){
        totalnames(1900);
        totalnames(1905);
        System.out.println("Name Susan rank : " + getRank(1972, "Susan", "F"));
    }
    public void testgetName(){
        int year = 1980;
        int rank = 350;
        String gender = "F";
        String name = getName(year, rank, gender);
        if (name == null){
            System.out.println ("No name with rank " + rank);
                }
        else if (gender == "F"){
            System.out.println ("Girl's name with rank " + rank + " " + name);
        }
        else{
            System.out.println ("Boy's name with rank " + rank + " " + name);
        }
    } 
    public void testWhatIsNameInYear(){
        String name = "Susan";
        int year = 1972;
        int newYear = 2014;
        String gender = "F";
        String newname = whatIsNameInYear(name, year, newYear, gender);
        if (newname == null){
            System.out.println("No name in the year found");
        }
        else{
            System.out.println( name +" " + "born in " + year + " " + "would be " + newname + " in " + newYear);
        }
    }
    // this method returns the rank in the file of the name with a given gender, if name is not in the file, returns -1
    public int getRank (int year, String name, String gender){
        int rank = -1;
        int currentrank = 0;
        FileResource fr = new FileResource("yob" + year + ".csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)){
                currentrank++;
                if (rec.get(0).equals(name)){ 
                    rank = currentrank;
                    }
            }
        }
        return rank;
    }
    //returns the name of the person in the file at this rank, for the given gender; if not in the file, returns "NO NAME"
    public String getName( int year, int rank, String gender){
        String name = null;
        int currentrank = 0;
        FileResource fr = new FileResource("yob" + year + ".csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)){
                currentrank++;
                if (currentrank == rank){
                    name = rec.get(0);
                    break;
                }
            }
        }
        return name;
    } 
    //determines what name would have been named if they were born in a different year, based on the same popularity
        public String whatIsNameInYear(String name, int year, int newYear, String gender){
        String newname = null;
        int currentrank = 0;
        int rank = -1;
        FileResource fr = new FileResource("yob" + year + ".csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)){
                currentrank++;
                if (rec.get(0).equals(name)){ 
                    rank = currentrank;
                } 
            }
            newname = getName(newYear, rank, gender);    
        }
        return newname;
    }
    //This method selects a range of files to process and returns an integer, the year with the highest rank 
    //for the name and gender. If the name and gender are not in any of the selected files, it should return -1. 
    public int yearofHighestRank (String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int highestrank = -1;
        int highestyear = 0;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            String filename = f.getName();
            int year = Integer.parseInt(filename.substring(3,7));
            int currentrank = getRank(year, name, gender);
            if (highestrank == -1){
                highestrank = currentrank;
                highestyear = year;
            }
            if (currentrank < highestrank && currentrank != -1){
                highestyear = year;
                highestrank = currentrank;
                }
        }
        return highestyear;
    }
    public void testHighestYear (String name, String gender){
        System.out.println (yearofHighestRank (name, gender));
    }
    //returns a double representing the average rank of the name and gender over the selected files
    public double getAverageRank (String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        double averagerank = 0.0;
        int count = 0;
        double sumrank = 0.0;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            String filename = f.getName();
            int year = Integer.parseInt(filename.substring(3,7));
            if(getRank(year, name, gender) == -1){
                continue;
            }
            else {
                int currentrank = getRank(year, name, gender);
                sumrank = sumrank + currentrank;
                count ++;
            }
        }
        return sumrank / count;    
    }
    public void testAverageRank(){
        System.out.println ("Average rank is " + getAverageRank ("Susan", "F"));
    }
    //returns the total number of births of those names with the same gender and same year who are ranked higher than name
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        int totalhigh = 0;
        FileResource fr = new FileResource("yob" + year + ".csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)){
                if (!rec.get(0).equals(name)){
                    totalhigh = totalhigh + Integer.parseInt(rec.get(2));
                }
                else{
                    break;
                }
            }
        }
        return totalhigh;
    }
    public void testTotalBirthsRankedHigher(){
        System.out.println("Children born ranked higher: " + getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }
}
// 1 - 2225
// 2 - 1421
// 3 - 251
//4 - 54
// 5 - Mia
// 6 - Forrest
// 7 - Addison
// 8 - Leonel
// 9 - 1914
// 10 - 1960
// 11 - 173.51
// 12 - 10.75
//13 - 323200
//14 - 1498074
