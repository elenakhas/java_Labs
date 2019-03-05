
/**
 * Write a description of class GladLibMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//This program creates a story by replacing placeholder words such as <noun> by looking for a random word of that type. 
import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private HashMap <String, ArrayList <String>> myMap;
    //private HashMap <String, ArrayList <String>> categories;
    private ArrayList<String> usedCategories;
    private ArrayList<String> usedList;
    private ArrayList<String> replacedList;
    private Random myRandom;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
	
    public GladLibMap(){

        myMap = new HashMap <String, ArrayList <String>> ();
        //categories = new HashMap <String, ArrayList <String>> ();
        initializeFromSource(dataSourceDirectory);
	myRandom = new Random();
	usedCategories = new ArrayList <String> ();

    }
	
    public GladLibMap(String source){
	
        myMap = new HashMap <String, ArrayList <String>> ();
        //categories = new HashMap <String, ArrayList <String>> ();
        initializeFromSource(source);
	myRandom = new Random();
	usedCategories = new ArrayList <String> ();

    }
	
    private void initializeFromSource(String source) {
        myMap.clear();
        String [] myLabels = {"country", "color", "noun", "adjective", "name", "animal", "timeframe", "verb", "fruit"};
	   
        for (String s : myLabels){
	   ArrayList <String> list = readIt(source + "/" + s + ".txt");
	   myMap.put(s, list);
	}
	usedList = new ArrayList<String>();
	replacedList = new ArrayList<String>();
    }
	
	private String randomFrom(ArrayList<String> source){
		int index = myRandom.nextInt(source.size());
		String word = source.get(index);
		return word;
	}
	
	private String getSubstitute(String label) {
	   
	    if (!usedCategories.contains(label)){
	    usedCategories.add(label);
	   }
	   
	   //System.out.println(usedCategories);
	    if (label.equals("number")) {

	        return "" + myRandom.nextInt(50)+5;
	    }
	    else{

	        return randomFrom(myMap.get(label));
	    }
	}
	
	private String processWord(String w){
		
	        int first = w.indexOf("<");
		int last = w.indexOf(">",first);
		if (first == -1 || last == -1){
		    replacedList.add(w);	
		    return w;
		}
		String prefix = w.substring(0,first);
		String suffix = w.substring(last+1);
		String sub = getSubstitute(w.substring(first+1,last));
	    	while (usedList.contains(sub)){
		    sub = getSubstitute(w.substring(first+1,last));
		}
		usedList.add(sub);
		
                return prefix+sub+suffix;
                
	}
	
	private void printOut(String s, int lineWidth){
		int charsWritten = 0;
		for(String w : s.split("\\s+")){
			if (charsWritten + w.length() > lineWidth){
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w+" ");
			charsWritten += w.length() + 1;
		}
	}
	
	private String fromTemplate(String source){
	    //usedCategories.clear();	
	    String story = "";
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String word : resource.words()){
				story = story + processWord(word) + " ";
			}
		}
		return story;
	}
	
	private ArrayList<String> readIt(String source){
		ArrayList<String> list = new ArrayList<String>();
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		else {
			FileResource resource = new FileResource(source);
			for(String line : resource.lines()){
				list.add(line);
			}
		}
		return list;
	}
	
	public int totalWordsInMap(){
	    int totalnum = 0;
	    for (String label : myMap.keySet()){
	        myMap.get(label);
	        totalnum += myMap.get(label).size();

	        //System.out.println("Possible words to replace from " + label + ": " + totalnum);
	       }

	    return totalnum;   
	}
	public int totalWordsConsidered(){
	   
	    int totalnum = 0;
	   for (String label : usedCategories){
	       int num = myMap.get(label).size();
	       totalnum = totalnum + num;
	   }
	   return totalnum;
	   }
	
	public void makeStory(){
	    usedList.clear();
	    replacedList.clear();
	    System.out.println("\n");
	    String story = fromTemplate("data/madtemplate3.txt");
	    printOut(story, 60);
	    System.out.println("\n");
	    System.out.println("Replaced words: " + replacedList.size());
	    System.out.println("Total number of words is: " + totalWordsInMap());
	    System.out.println("Total words considered: " + totalWordsConsidered());
	}
	


}

    

