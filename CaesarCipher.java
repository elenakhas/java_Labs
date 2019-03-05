
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarCipher {

    public String encrypt (String input, int key){
        StringBuilder encryptedInput = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lcalphabet = alphabet.toLowerCase();
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        System.out.println(shiftedAlphabet);
        String lcShiftedAlphabet = shiftedAlphabet.toLowerCase();
        for ( int i = 0; i < encryptedInput.length(); i++){
            char currentChar = encryptedInput.charAt(i);
            int ind = 0;
            if (Character.isUpperCase(currentChar)) {
                ind = alphabet.indexOf(currentChar);
                if (ind != -1){
                    char newChar = shiftedAlphabet.charAt(ind);
                    encryptedInput.setCharAt(i, newChar);
                }
            }
            else{
                ind = lcalphabet.indexOf(currentChar);
                if (ind != -1){
                    char newChar = lcShiftedAlphabet.charAt(ind);
                    encryptedInput.setCharAt(i, newChar);
                }
            }      
        }
        return encryptedInput.toString();
    }
    public String encryptTwoKeys (String input, int key1, int key2){
        StringBuilder encryptedInput = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lcalphabet = alphabet.toLowerCase();
        String shiftedAlphabetkey1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphabetkey2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        String lcShiftedAlphabetkey1 = shiftedAlphabetkey1.toLowerCase();
        String lcShiftedAlphabetkey2 = shiftedAlphabetkey2.toLowerCase();
        for ( int i = 0; i < encryptedInput.length(); i++){
            if (i % 2 == 0){
                //working with key1
                char currentChar = encryptedInput.charAt(i);
                int ind = 0;
                if (Character.isUpperCase(currentChar)) {
                    ind = alphabet.indexOf(currentChar);
                    if (ind != -1){
                        char newChar = shiftedAlphabetkey1.charAt(ind);
                        encryptedInput.setCharAt(i, newChar);
                    }
                }
                else{
                    ind = lcalphabet.indexOf(currentChar);
                    if (ind != -1){
                        char newChar = lcShiftedAlphabetkey1.charAt(ind);
                        encryptedInput.setCharAt(i, newChar);
                    }
                }
                }
                else{
                // working with key2
                char currentChar = encryptedInput.charAt(i);
                int ind = 0;
                if (Character.isUpperCase(currentChar)) {
                    ind = alphabet.indexOf(currentChar);
                    if (ind != -1){
                        char newChar = shiftedAlphabetkey2.charAt(ind);
                        encryptedInput.setCharAt(i, newChar);
                    }
                }
                else{
                    ind = lcalphabet.indexOf(currentChar);
                    if (ind != -1){
                        char newChar = lcShiftedAlphabetkey2.charAt(ind);
                        encryptedInput.setCharAt(i, newChar);
                    }
            
                }
                }
        }
        return encryptedInput.toString();
    }
    
    public void testEncrypt(){
        System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", 15));
        
    }
    public void testCaesar(){
        //int key = 15;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        //String encrypted = encrypt (message, key);
        //System.out.println("key is " + key + "\n" + encrypted);
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        
    }
    
    public void testEncryptTwoKeys(){
        System.out.println(encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21, 8));
    }
}
//Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!
//Io iwjv jz dv bcm kjvammmikz mwju edbc twpz pvb wi awm v ncmxmqnm xvzog. TMGT TJCY!
