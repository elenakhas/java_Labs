
/**
 * Write a description of class CaesarCipher2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher2 {

    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher2(int key){
        
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < encrypted.length(); i++){
            char ch = encrypted.charAt(i);
            char low = Character.toUpperCase(ch);
            int idx = alphabet.indexOf(low);
            if (idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                if (Character.isLowerCase(ch)){
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
                else{
                    encrypted.setCharAt(i, newChar);
                    }
            }
        }
        return encrypted.toString();
    }
    public String decrypt(String input){
        CaesarCipher2 cc = new CaesarCipher2(26 - mainKey);
        return cc.encrypt(input);
    }
    
    }
