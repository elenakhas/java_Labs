import java.util.*;
import edu.duke.*;
import java.io.File;
public class VigenereBreaker {
    //HashMap <String, HashSet> languages;
    //public VigenereBreaker(){
      //  languages = new HashMap();
    
    //}
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slice = new StringBuilder();
        for (int k = whichSlice;  k < message.length(); k += totalSlices){
            char c = message.charAt(k);
            slice.append(c);
        } 
        //REPLACE WITH YOUR CODE
        
        return slice.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cc = new CaesarCracker();
        for (int i = 0; i < klength; i++){
            String part = sliceString(encrypted, i, klength);
            int mykey = cc.getKey(part);
            key[i] = mykey;
        }
        //WRITE YOUR CODE HERE
        return key;
    }

    public void breakVigenere () {
        FileResource fr = new FileResource("secretmessage3.txt");
        String encrypted = fr.asString();
        HashMap <String, HashSet> languages = new HashMap();
        DirectoryResource dr = new DirectoryResource();
         for (File f : dr.selectedFiles()) {
             String name = f.getName();
             FileResource dict = new FileResource(f);
             HashSet dictionary = readDictionary(dict);
             languages.put(name, dictionary);
            }
        //System.out.println("My hashmap: " + languages.size());
        HashSet language = breakForAllLangs(encrypted, languages);
        String decrypted = breakForLanguage(encrypted, language);
        System.out.println("The message is: " + decrypted);
        
        
        
        
        
       
        //WRITE YOUR CODE HERE
    }
    public HashSet<String> readDictionary(FileResource fr){
        HashSet <String> dictionary = new HashSet();
        for (String word : fr.words()){
            word = word.toLowerCase();
            dictionary.add(word);
        }
        return dictionary;
    }
    public int countWords(String message, HashSet <String> dictionary){
        int count = 0;
        String[] words = message.split("\\W+");
        for (String word : words){
            word = word.toLowerCase();
            if (dictionary.contains(word)){
                count ++;
            }
        }
        
        return count;
    }
    public  String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int[] keys  = new int [100];
        int keylength = 0;
        int max = 0;
        String original = null;
        for (int klength = 1; klength < keys.length; klength++){
            
            int[] key = tryKeyLength(encrypted, klength, mostCommonCharIn(dictionary));
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int quant = countWords(decrypted, dictionary);
            if (quant >= max){
                max = quant;
                original = decrypted;
                keylength = key.length;
            }
        }
        //System.out.println(keylength);
        //System.out.println("Valid words: " + max);
        return original;
    }
    public Character mostCommonCharIn(HashSet<String> dictionary){
        //iterate over the dictionary, create a hashmap
        
        //String alphabet = "abcdefghijklmnopqrstuvwxyz";
        HashMap <Character, Integer> charact_count = new HashMap();
                charact_count.clear();
            //for (int i = 0; i < alphabet.length(); i++){
                for (String s : dictionary){
                    for (int i = 0; i < s.length(); i++){
                if (Character.isLetter(s.charAt(i))){
                if (charact_count.containsKey(s.charAt(i))){
                    charact_count.put(s.charAt(i), charact_count.get(s.charAt(i)) + 1);
                }
                else{
                    charact_count.put(s.charAt(i), 1);
                }
            }
        }
            //String dict = dictionary.toString();    
        }
    
        //System.out.println(charact_count);
        int max_occur = 0;
        Character frequent = null;
        for (Character c : charact_count.keySet()){
            if (charact_count.get(c) > max_occur){
                max_occur = charact_count.get(c);
                frequent = c;
            }
        }
        return frequent; 
    }
    public HashSet breakForAllLangs(String encrypted, HashMap <String, HashSet> languages){
        
        int max = 0;
        String language = null;
        HashSet dict = null;
        for (String s : languages.keySet()){
            HashSet dictionary = languages.get(s);
            String decrypted = breakForLanguage(encrypted, dictionary);
            int number = countWords(decrypted, dictionary);
            if (number > max){
                max = number;
                language = s;
                dict = languages.get(s);
            }
            
        }
        System.out.println("The language of the message is: " + language + " words: " + max);
        return dict;
    
    }
    //La chambre à coucher de Juliette.
    //Drei Hexen treten auf.
}
