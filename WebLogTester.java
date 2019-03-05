
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
        // complete method
    }
    public void testUniqueIps(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println ("The number of unique IPs: " + la.countUniqueIPs());
    
    }
    public void test_unique_ip_day(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la. uniqueIPVisitsOnDay("Sep 24"));
        //System.out.println(la. uniqueIPVisitsOnDay("Sep 30"));
    }
    public void testcountinrange(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        //System.out.println(la.countUniqueIPsInRange(200,299));
        System.out.println(la.countUniqueIPsInRange(200,299));
    }
    public void testgreaterthannum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        System.out.println(la.printAllHigherThanNum(400));
    }
    public void testcountVisitsPerIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap <String, Integer> counts = new HashMap();
        System.out.println(la.countVisitsPerIP());
    }
    public void testMostNumberVisitsByIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap <String, Integer> counts = la.countVisitsPerIP();
        System.out.println(la.mostNumberVisitsByIP(counts));
        
    }
    public void tetsiPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap <String, Integer> counts = la.countVisitsPerIP();
        System.out.println(la.iPsMostVisits(counts));
    }
    public void testiPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        System.out.println(la.IPsForDays());
    }
    public void testdayWithMostIPVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap <String, ArrayList <String>> days = la.IPsForDays();
        System.out.println("Day with most IP visits: " + la.dayWithMostIPVisits(days));
       
    }
    public void testiPsWithMostVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap <String, ArrayList <String>> days = la.IPsForDays();
        System.out.println("IPs with most visits per day: " + la.iPsWithMostVisitsOnDay(days, "Sep 29"));
    }
}
