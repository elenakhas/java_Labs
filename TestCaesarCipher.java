
/**
 * Write a description of class TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher {
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
    private int findAkey (String s){
        int freqs [] = frequency(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }
    public String breakCaesarCipher(String input){
        int[] freqs = frequency(input);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        CaesarCipher2 cc = new CaesarCipher2(26-dkey);
        System.out.println(dkey);
        return cc.encrypt(input);
    }
    public void simpleTests(String message){
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        CaesarCipher2 cc = new CaesarCipher2(15);
        String encrypted = cc.encrypt(message);
        String decrypted = cc.decrypt(encrypted);
        String breaker = breakCaesarCipher(encrypted);
        System.out.println(message);
        System.out.println(encrypted);
        System.out.println(decrypted);
        System.out.println(breaker);
    }
}
