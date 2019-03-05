
/**
 * Write a description of class testCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class testCaesarCipherTwo {
    private String halfOfString(String message, int start){
        StringBuilder halfstring = new StringBuilder();
        for (int i = start; i < message.length(); i += 2){
            
            halfstring.append(message.charAt(i));
            
        } 
        return halfstring.toString();
    }
    private int[] frequency (String message){ //finding frequency of each letter in a message
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] counts = new int [26];
        for(int k=0; k < message.length(); k++){
            char ch = Character.toUpperCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if( dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    private int maxIndex(int[] vals){
        int maxDex = 0;
        for (int k=0; k < vals.length; k++){
            if(vals[k] > vals[maxDex]){
                maxDex = k;
            } 
        }
        return maxDex;
    }
    private int getKey(String s){
        int freqs [] = frequency(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }

        return dkey;
    }
    public String breakCaesarCipher(String input){
        String string1 = halfOfString(input, 0);
        String string2 = halfOfString(input, 1);
        int key1 = getKey(string1);
        int key2 = getKey(string2);
        CaesarCipherTwo cc = new CaesarCipherTwo(26-key1, 26-key2);
        System.out.println("Key 1 is " + key1 + "; " + "Key 2 is " + key2);
        return cc.encrypt(input);
    }
    public void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(26, 26-24);
        String encrypted = cc.encrypt(message);
        String decrypted = cc.decrypt(encrypted);
        String breaker = breakCaesarCipher(encrypted);
        System.out.println(message);
        System.out.println(encrypted);
        System.out.println(decrypted);
        System.out.println(breaker);
    }

    }

