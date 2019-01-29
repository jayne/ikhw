package sorting.homework;

/**
 * Created by jaynehsu on 1/19/19.
 */
public class SortAllCharInString {
    public static void main(String[] args) {
//        String test = "boss bitch";
        String test = "bbccdefbbaa";

        System.out.println(test);
        System.out.println(sortCharacters(test));

    }

    static String sortCharacters(String inString) {

        int[] asciiMap = new int[256];

        for(int i = 0; i<inString.length(); i++){
            int asciiValue = inString.charAt(i);
            asciiMap[asciiValue] += 1;
        }

        String result = "";
        for(int i = 0; i<256; i++){
            while(asciiMap[i]-- != 0){
                char c = (char)i;
                result += c;

            }
        }
        return result;
    }

}
