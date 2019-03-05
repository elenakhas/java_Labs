
/**
 * Write a description of class Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa,String stringb){
    int number = 0;
    int curroccurrence = stringb.indexOf(stringa);
    while (curroccurrence >= 0){ 
           curroccurrence = stringb.indexOf(stringa, curroccurrence+stringa.length());
           number = number + 1;
        }
    return number;
}
    public void testHowMany(){
        int howmany = howMany("ATGTAA", "ABCATGTAAHTVATGTAAHNUATGTAAATGTAATGTAA");
        System.out.println(howmany);
    }
}
