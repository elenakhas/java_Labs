
/**
 * Write a description of class CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarBreaker {

    public int[] frequency (String message){ //finding frequency of each letter in a message
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int [26];
        for(int k=0; k < message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if( dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for (int k=0; k < vals.length; k++){
            if(vals[k] > vals[maxDex]){
                maxDex = k;
            } 
        }
        return maxDex;
    }
    public String decrypt (String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = frequency(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        
        return cc.encrypt(encrypted, 26-dkey);
        
    }
    public void testDecrypt() {
        System.out.println(decrypt("Grpq x qbpq pqofkd tfqe ilqp lc bbbbbbbbbbbbbbbbbp"));
        System.out.println("The key is " + getKey("Grpq x qbpq pqofkd tfqe ilqp lc bbbbbbbbbbbbbbbbbp"));
    }
    public String halfOfString(String message, int start){
        StringBuilder halfstring = new StringBuilder();
        for (int i = start; i < message.length(); i += 2){
            
            halfstring.append(message.charAt(i));
            
        } 
        return halfstring.toString();
    }
    public void testhalfOfString(){
        String message = "Qbkm Zgis";
        System.out.println(halfOfString(message, 0));
        System.out.println(halfOfString(message, 1));
    }
    public int getKey(String s){
        int freqs [] = frequency(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }

        return dkey;
    }
    public String decryptTwoKeys (String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String string1 = halfOfString(encrypted, 0);
        String string2 = halfOfString(encrypted, 1);
        int key1 = getKey(string1);
        int key2 = getKey(string2);
        System.out.println("Key 1 is " + key1 + "; " + "Key 2 is " + key2);
        return cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
    }
    public void testDecryptTwoKeys(){
        FileResource fr = new FileResource();
        String line = fr.asString();
        String message = (decryptTwoKeys(line));
        System.out.println(message);
        }
    
    }

