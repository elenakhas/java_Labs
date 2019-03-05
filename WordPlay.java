
/**
 * Write a description of class WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {

    public boolean isVowel (char ch){    
        //if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'){
        char ucchar = Character.toLowerCase(ch);
            if (ucchar == 'a'||ucchar == 'e' || ucchar == 'i' || ucchar == 'o' || ucchar == 'u'){
                return true;
        }
        return false;
    }
    public void testIsVowel (char ch){
        
        if (isVowel(ch)){
            System.out.println (ch + " is a vowel");
        }
        else{
            System.out.println (ch + " is not a vowel");
        }
    }
    public String replaceVowels (String phrase, char ch){
        StringBuilder input = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++){
            char letter = phrase.charAt(i);
            if (isVowel(letter)){
                input.setCharAt (i, ch);
            }
        }
        return input.toString();
    }
    public void testReplaceVowels(){
        String phrase = "HELLO WORLD";
        char ch = '*';
        System.out.println (replaceVowels(phrase, ch));
    }
    public String emphasize (String phrase, char ch){
        StringBuilder input = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++){
            char letter = phrase.charAt(i);
            char ucch = Character.toLowerCase(ch);
            char lcch = Character.toUpperCase(ch);
            if (letter == ucch || letter == lcch){
                if (i % 2 == 0){
                    input.setCharAt (i, '*');
                }
                else{
                    input.setCharAt (i, '+');
                }
            }
        }
        return input.toString();
        } 
    
    public void testemphasize(){
        System.out.println (emphasize("dna ctgaaactga", 'a'));
        System.out.println (emphasize("Mary Bella Abracadabra", 'a'));
    }
}
