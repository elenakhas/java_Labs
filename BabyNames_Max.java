
/**
 * Write a description of class Max here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class Max {

    //this method calculates the total bumber of births in a given year, 
    //plus the total number of boys and girls separately
    public void totalBirths(FileResource fr){
        int totalbirths = 0;
        int totalGirls = 0;
        int totalBoys = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBirths = Integer.parseInt(rec.get(2));
            totalbirths += numBirths;
            if (rec.get(1).equals("F")){
                totalGirls += numBirths;
            }
            else{
                totalBoys += numBirths;
            }
            }
        System.out.println("Total births : " + totalbirths);
        System.out.println("Boys born : " + totalBoys);
        System.out.println("Gilrs born : " + totalGirls);
    }

    public void test(){
        FileResource fr = new FileResource();
        totalBirths(fr);
        System.out.println("Name rank : " + getRank(2012, "Sophia", "F"));
        System.out.println("Name rank : " + getRank(2012, "Emma", "F"));
        System.out.println("Name rank : " + getRank(2012, "Isabella", "F"));
        System.out.println("Name rank : " + getRank(2012, "Olivia", "F"));
        System.out.println("Name rank : " + getRank(2012, "Ava", "F"));
        System.out.println("Name rank : " + getRank(2012, "Jacob", "M"));
        System.out.println("Name rank : " + getRank(2012, "Mason", "M"));
        System.out.println("Name rank : " + getRank(2012, "Ethan", "M"));
        System.out.println("Name rank : " + getRank(2012, "Noah", "M"));
        System.out.println("Name rank : " + getRank(2012, "William", "M"));
    }
    // this method returns the rank in the file of the name with a given gender
    public int getRank (int year, String name, String gender){
        int rank = 0;
        int last_frequency = -1;
        boolean found = false;
        FileResource fr = new FileResource("yob" + year + "short.csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)){
                int current_frequency = Integer.parseInt(rec.get(2));
                String current_name = rec.get(0);
                if (current_frequency != last_frequency){
                    rank = rank + 1;
                    last_frequency = current_frequency;
                }
                if (current_name == name){
                    found = true;
                    break;
                }
            }
        }
        if (found == false){
            return -1;
        }
        return rank;
    }
    public int getRank (int year, String name, String gender){
        int rank = -1;
        int currentrank = 0;
        //int temprank = 0;
        //int frequency = -1;
        //int current_freq = 0;
        FileResource fr = new FileResource("yob" + year + ".csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)){
                //current_freq = Integer.parseInt(rec.get(2));
                //String current_name = rec.get(0);
                //if (current_freq != frequency){
                    //frequency = current_freq;
                currentrank++;
            
                if (rec.get(0).equals(name)){ 
                    rank = currentrank;
                    }
                //else{
                    //temprank++;
                    //currentrank = temprank;
                //}
                //}
            }
        }
        return rank;
    }
}
