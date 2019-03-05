
/**
 * Write a description of class Decryption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Decryption {
    public int[] frequency (String message){
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
        return cc.encrypt(encrypted, 26-key);
        
    }
}
