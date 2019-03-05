
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;


public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>(); // complete constructor
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource(filename);
         for (String line : fr.lines()){
             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);
         }// complete method
         
     }
     public int countUniqueIPs(){
         ArrayList <String> uniqueIPs = new ArrayList <String>();
         for (LogEntry le : records){
             String ipAddress = le.getIpAddress();
             
             if (! uniqueIPs.contains(ipAddress)){
                uniqueIPs.add(ipAddress);
            }
            }
         return uniqueIPs.size();   
        }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     public int uniqueIPVisitsOnDay (String someday){
        ArrayList <String> visitsDay = new ArrayList();
        //ArrayList <String> unique = new ArrayList();
        for (LogEntry le : records){
            String date = le.getAccessTime().toString();
            if (date.contains(someday)){
                String ipAddress = le.getIpAddress();
             
                 if (! visitsDay.contains(ipAddress)){
                    visitsDay.add(ipAddress);
                }
                
            }

            
        }
        return visitsDay.size();
        }
     public ArrayList <Integer> printAllHigherThanNum(int num){
        
        ArrayList <Integer> greater = new ArrayList();
        for (LogEntry le : records){
            int status = le.getStatusCode();
            if (status > num){
                if (!greater.contains(status)){
                greater.add(status);
            }
                
            }
        }
        return greater;
    }
     public int countUniqueIPsInRange(int low, int high){
        ArrayList <String> inrange = new ArrayList();
        for (LogEntry le : records){
            int status = le.getStatusCode();
            if (status >= low && status <= high){
                String ipAddress = le.getIpAddress();
                if (!inrange.contains(ipAddress)){
                    inrange.add(ipAddress);
                }   
            }
        }
        return inrange.size();
        
    }
    public HashMap <String, Integer> countVisitsPerIP(){
        HashMap <String, Integer> counts = new HashMap <String, Integer>();
        for (LogEntry le : records){
            String ip = le.getIpAddress();
            if (! counts.containsKey(ip)){
                counts.put(ip, 1);
            }
            else{
                counts.put(ip, counts.get(ip) + 1);
            }
        }
        return counts;
    }
    public int mostNumberVisitsByIP(HashMap<String, Integer> counts){
        int max = 0;
        for (Integer v : counts.values()){
            if (v > max){
                max = v;
            }
        }
        return max;
    }
    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
        
        int max = mostNumberVisitsByIP(counts);
        ArrayList<String> ips = new ArrayList();
        for (String s : counts.keySet()){
            if (counts.get(s) == max){
                ips.add(s);
            }
        }
        return ips;
        
    } 
    public HashMap <String, ArrayList <String>> IPsForDays(){
        HashMap <String, ArrayList <String>> daily = new HashMap();
        
        //ArrayList <String> unique = new ArrayList();
        for (LogEntry le : records){
            String date = le.getAccessTime().toString();
            String day = date.substring(4,10);
            ArrayList <String> visitsDay = new ArrayList();
            
            if (!daily.containsKey(day)){

                visitsDay.add(le.getIpAddress().toString());
                daily.put(day, visitsDay);
            }
            else{
                //ArrayList <String> temp = new ArrayList();
                visitsDay = daily.get(day);
                visitsDay.add(le.getIpAddress().toString());
            }
                
            }
            return daily;
        }
    public String dayWithMostIPVisits(HashMap <String, ArrayList <String>> days){
        String neededDay = null;
        int max = 0;
        for (String day: days.keySet()){
            if (days.get(day).size() > max){
                max = days.get(day).size();
                neededDay = day;
            }
                
        }
        return neededDay;
    }
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> days, String date){
        // create a hashmap IPsForDays
        ArrayList<String> mostvisits = new ArrayList();
    
        // find a day in a map
        //for (String day : days.keySet()){
            //if (days.containsKey(date)){
                
                HashMap <String, Integer> map = new HashMap();
                ArrayList <String> ips = days.get(date);
                // iterate over values - IPs, map IPs with number of visits
                for (String ip : ips){
                    //get an IP address, create a map with ips and counts
                    if (!map.containsKey(ip)){
                        map.put(ip, 1);
                    }
                    else{
                        map.put(ip, map.get(ip) +1);
                        }
                    
            }
            System.out.println(map); 
            // create a list with iPsMostVisits
                    mostvisits = iPsMostVisits(map);
                
                //}
        
    
        //}
        return mostvisits;
    }
    }
    

