package strings.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static strings.lecture.Letter.createDictionary;

/**
 * Created by jaynehsu on 11/8/18.
 */
public class MostRepeatedSubstring {

    public static void main(String[] args) {
//        String str = "mississippi";
        String str = "jkljkljklabababjkl";

//        String[] resultLongestOfMostRepeated = longestRepeatedSubstring(str);
//        for (String s : resultLongestOfMostRepeated) {
//            System.out.println("longest of most repeated: " + s);
//        }

        String[] resultMostRepeated = mostRepeatedSubstring(str);
        for (String s : resultMostRepeated) {
            System.out.println("most repeated: " + s);
        }

    }

    private static String[] mostRepeatedSubstring(String str) {
        Letter dictionary = createDictionary(str);
        ArrayList<String> strs = findMostSubstring(dictionary);
        return strs.toArray(new String[strs.size()]);

    }


    private static String[] longestRepeatedSubstring(String str) {
        Letter dictionary = createDictionary(str);

        ArrayList<String> strs = findLongestSubstring(dictionary);
        return strs.toArray(new String[strs.size()]);
    }

    private static ArrayList<String> findLongestSubstring(Letter dictionary) {
        // get largest number of hits on the second degree. store in array of letters
        HashMap<Letter, String> highestHits = getHighestHitsOnSecondLayer(dictionary);

        // using array of letters. get lengthiest.
        return getLongestWithHighestHits(highestHits);

    }


    private static HashMap<Letter, String> getHighestHitsOnSecondLayer(Letter dictionary) {

        HashMap<Letter, String> result = new HashMap<>();
        int count = 1;
        for (Character c1 : dictionary.nextLetters.keySet()) { // check first level
            for (Character c2 : dictionary.nextLetters.get(c1).nextLetters.keySet()) {
                Letter l2 = dictionary.nextLetters.get(c1).nextLetters.get(c2);
                String thusfar = String.valueOf(c1) + String.valueOf(c2);
                if (l2.getHit() > count) {
                    result = new HashMap<>();
                    result.put(l2, thusfar);
                    count = l2.getHit();
                } else if (l2.getHit() == count) {
                    result.put(l2, thusfar);
                }

            }
        }

        return result;
    }


    private static ArrayList<String> getLongestWithHighestHits(HashMap<Letter, String> highestHits) {
        ArrayList<String> result = new ArrayList<>();
        int count = 2;

        for (Letter letter : highestHits.keySet()) {
            String thusfar = highestHits.get(letter);
            boolean onetrail = letter.nextLetters.keySet().size() == 1 ? true : false;
            Letter nextLetter = letter.nextLetters.get(letter.nextLetters.keySet().iterator().next());

            while (onetrail && nextLetter.getHit() == letter.getHit()) {
                thusfar = thusfar + nextLetter.c;
                letter = nextLetter;
                onetrail = letter.nextLetters.keySet().size() == 1 ? true : false;
                nextLetter = letter.nextLetters.get(letter.nextLetters.keySet().iterator().next());
            }

            if (thusfar.length() == count) {
                result.add(thusfar);
            } else if (thusfar.length() > count) {
                count = thusfar.length();
                result = new ArrayList<>();
                result.add(thusfar);
            }
        }
        return result;
    }

    private static ArrayList<String> findMostSubstring(Letter dictionary) {
        ArrayList<String> result = new ArrayList<>();

        // get largest number of hits on the second degree. store in array of letters
        HashMap<Letter, String> highestHits = getHighestHitsOnSecondLayer(dictionary);

        for (Letter letter : highestHits.keySet()) {
            String thusfar = highestHits.get(letter);
            result.add(thusfar);
            boolean onetrail = letter.nextLetters.keySet().size() == 1 ? true : false;
            Letter nextLetter = letter.nextLetters.get(letter.nextLetters.keySet().iterator().next());

            while (onetrail && nextLetter.getHit() == letter.getHit()) {
                thusfar = thusfar + nextLetter.c;
                result.add(thusfar);
                letter = nextLetter;
                onetrail = letter.nextLetters.keySet().size() == 1 ? true : false;
                nextLetter = letter.nextLetters.get(letter.nextLetters.keySet().iterator().next());
            }
        }

        return result;

    }


}
