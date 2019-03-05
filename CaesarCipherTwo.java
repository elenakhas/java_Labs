
/**
 * Write a description of class CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {

    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainkey1;
    private int mainkey2;
    
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        mainkey1 = key1;
        mainkey2 = key2;
    }
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < encrypted.length(); i++){
            char ch = encrypted.charAt(i);
            char low = Character.toUpperCase(ch);
            int idx = alphabet.indexOf(low);
            if (idx != -1){
                if( i % 2 == 0){
                    char newChar = shiftedAlphabet1.charAt(idx);
                    if (Character.isLowerCase(ch)){
                        encrypted.setCharAt(i, Character.toLowerCase(newChar));
                    }
                    else{
                        encrypted.setCharAt(i, newChar);
                    }
                }
                else{
                    char newChar = shiftedAlphabet2.charAt(idx);
                    if (Character.isLowerCase(ch)){
                        encrypted.setCharAt(i, Character.toLowerCase(newChar));
                    }
                    else{
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
        }
        return encrypted.toString();
    }
    public String decrypt (String input){
        CaesarCipherTwo cc = new CaesarCipherTwo((26 - mainkey1), (26  -mainkey2));
        return cc.encrypt(input);
    }
}
