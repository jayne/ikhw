package strings.lecture;

import java.util.ArrayList;
import java.util.HashMap;

import static strings.lecture.Letter.createDictionary;

/**
 * Created by jaynehsu on 11/8/18.
 */
public class LongestRepeatedSubstring {
    public static void main(String[] args) {
        String str = "mississippiss";
//        String str = "abcdefgefhefiefjabcd";

        String[] resultMostRepeated = longestRepeatedSubstring(str);
        for (String s : resultMostRepeated) {
            System.out.println("longest repeated: " + s);
        }

    }

    private static String[] longestRepeatedSubstring(String str) {
        Letter dictionary = createDictionary(str);
        ArrayList<String> strs = findLongestRepeated(dictionary, null);
        return strs.toArray(new String[strs.size()]);

    }


    private static ArrayList<String> findLongestRepeated(Letter dictionary, String ch) {

        String prefix = ch == null ? "" : String.valueOf(dictionary.c);
        ArrayList<String> result = new ArrayList<>();
        int count = result.size();

        for (Character c : dictionary.nextLetters.keySet()) {
            Letter nextLetter = dictionary.nextLetters.get(c);
            if (nextLetter.getHit() >= 2) {
                ArrayList<String> arr = findLongestRepeated(nextLetter, String.valueOf(nextLetter.c));
                int size = arr.size() == 0 ? 0 : arr.get(0).length();
                if (size >= count) {
                    if (size > count) {
                        result = new ArrayList<>();
                        count = size;
                    }
                    for (String s : arr) {
                        result.add(prefix + s);
                    }
                }
            }
        }
        if(result.size()==0){
            result.add(ch);
        }


        return result;
    }



}
