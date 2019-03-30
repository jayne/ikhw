package strings.lecture;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static strings.lecture.Letter.createDictionary;

/**
 * Created by jaynehsu on 3/11/19.
 */
//MatchExpression.java
//In recursion, we only had to query it once. What if we had to make multiple queries in the same dictionary? We should store as tries.
public class AllWordsThatMatchPattern2 {

    public static void main(String[] args) {
        String[] words = {"cat", "cane", "cut", "bat"};

//        String pat = ".at";
        String pat = "c..ef";

        String[] matchPatterns = getWords(words, pat);

        for (String s : matchPatterns) {
            System.out.println(s);
        }
    }

    private static String[] getWords(String[] words, String pat) {
        Letter dictionary = Letter.createDictionary(words);

        return getWords(dictionary, pat, 0, "");
    }

    private static String[] getWords(Letter dictionary, String pat, int i, String thusfar) {
        if(i==pat.length()){
            if(dictionary.end) {
                String[] result = {thusfar};
                return result;
            }else{
                String[] result = {};
                return result;
            }
        }
        if(dictionary.nextLetters.size()==0){
            String[] result = {};
            return result;
        }


        char c = pat.charAt(i);


        if (c == '.') {
            String[] allwords = {};
            for (Character nextC : dictionary.nextLetters.keySet()) {
                Letter l = dictionary.nextLetters.get(nextC);
                String[] words = getWords(l, pat, i + 1, thusfar + l.c);
                allwords = (String[]) Stream.concat(Stream.of(words), Stream.of(allwords)).toArray(b -> new String[b]);
            }
            return allwords;

        } else {
            Letter l = dictionary.nextLetters.get(c);
            return getWords(l, pat, i + 1, thusfar + l.c);
        }
    }


}
