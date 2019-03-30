package strings.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static strings.lecture.Letter.createDictionary;

/**
 * Created by jaynehsu on 3/11/19.
 */
//MatchExpression.java
//In recursion, we only had to query it once. What if we had to make multiple queries in the same dictionary? We should store as tries.
public class AllWordsThatMatchPattern {

    static final String[] EMPTY_STR_ARR = {};

    public static void main(String[] args) {
//        String[] words = {"caaaat", "doggy", "dot", "do", "dogy"};
        String[] words = {"cat", "doy", "dogy", "doby"};
        String pattern = "ca";
        String[] matchedWords = getAllWordsThatMatchPat(words, pattern);

        if(matchedWords.length==0){
            System.out.println("no matches found");
        }
        for (String word : matchedWords) {
            System.out.println(word);
        }

    }

    private static String[] getAllWordsThatMatchPat(String[] words, String pattern) {
        Letter dictionary = createDictionary(words);

        return matchWordsToPattern(dictionary, pattern, new ArrayList<Character>());

    }

    private static String[] matchWordsToPattern(Letter dictionary, String pattern, ArrayList<Character> word) {
        if(pattern.length()==0){
            if(dictionary.end == true){
                String str = word.stream().map(e->e.toString()).collect(Collectors.joining());
                String[] result = {str};
                return result;
            }else{

                return EMPTY_STR_ARR;
            }
        }


        char pat = pattern.charAt(0);
        if (pat == '*') {
            // match 0 characters
            String[] match0 = matchWordsToPattern(dictionary, pattern.substring(1), new ArrayList<Character>(word));

            // match 1 or more characters
            String[] result = match0;
            for(char c : dictionary.nextLetters.keySet()){
                ArrayList<Character> word2 =  new ArrayList<Character>(word);
                word2.add(c);
                String[] subResult = matchWordsToPattern(dictionary.nextLetters.get(c), pattern, word2 );
                result = combineArrays(result, subResult);
                word2.remove((Character)c);

            }

            return result;

        } else {
            if (dictionary.nextLetters.containsKey(pat)) {
                word.add(pat);
                return matchWordsToPattern(dictionary.nextLetters.get(pat), pattern.substring(1), new ArrayList<Character>(word));

            } else {
                return EMPTY_STR_ARR;
            }
        }

    }

    static String[] combineArrays(String[] a, String[] b){

        return (String[]) Stream.concat(Stream.of(a), Stream.of(b)).toArray(d -> new String[d]);
//        Stream<String> out = Stream.of(Stream.of(a), Stream.of(b), Stream.of(c)).flatMap(s -> s);
//        return out.toArray(s -> new String[s]);
    }


}
