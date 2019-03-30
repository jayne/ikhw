package strings.lecture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static strings.lecture.Letter.createDictionary;

/**
 * Created by jaynehsu on 3/15/19.
 */
public class PalindromePairs {
    public static void main(String[] args) {
        String[] words = { // assumme unique words in this array
                "dog",
                "cat",
                "race",
                "ma",
                "dam",
                "car",
                "god",
                "pop",
                "b",
                "bb",
                "pope"
        };

        // answers : madam, racecar, doggod, goddog
        for(String s : getPalindromePairs(words)){
            System.out.println(s);
        }


    }

    private static Set<String> getPalindromePairs(String[] words) {
        Set<String> result = new HashSet<>();

        Letter dictionary = createDictionary(words);
        ArrayList<String> reverseListOfWords = new ArrayList<>();

        for (String word : words) {
            String reverse = reverse(word);
            reverseListOfWords.add(reverse);
            ArrayList<String> finalWords = checkPalindrome(dictionary, reverse, "");
            for (String str : finalWords) {
                String palindrome = reverse + reverse(str);
                if(!palindrome.equals(word+word)){
                    result.add(palindrome);
                }
            }
        }

        Letter dictionaryReversed = createDictionary(reverseListOfWords.toArray(new String[reverseListOfWords.size()]));
        for (String word : words) {
            ArrayList<String> finalWords = checkPalindrome(dictionaryReversed, word, "");
            for (String str : finalWords) {
                String palindrome = word + reverse(str);

                if(!palindrome.equals(word+word)){
                    result.add(palindrome);
                }
            }
        }

        return result;
    }

    private static ArrayList<String> checkPalindrome(Letter dictionary, String word, String wordThusFar) {

        ArrayList<String> result = new ArrayList<>();
        if (word.length() == 0) {
            if (dictionary.end == true) {
                result.add(wordThusFar);
            }

            for (Character n : dictionary.nextLetters.keySet()) {
                ArrayList<String> palindrome = getPalindromes(dictionary.nextLetters.get(n));
                if (palindrome.size() >= 1) {
                    for (String str : palindrome) {
                        result.add(wordThusFar + str);
                    }
                }
            }
            return result;
        }


        char c = word.charAt(0);
        if (dictionary.nextLetters.containsKey(c)) {
            return checkPalindrome(dictionary.nextLetters.get(c), word.substring(1), wordThusFar + c);
        } else {
            return result;
        }
    }

    private static ArrayList<String> getPalindromes(Letter dictionary) {
        ArrayList<String> words = getAllWords(dictionary);


        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            if (isPalindrome(word)) {
                result.add(word);
            }
        }
        return result;
    }

    private static ArrayList<String> getAllWords(Letter dictionary) {
        ArrayList<String> result = new ArrayList<>();
        if(dictionary.end==true){
            result.add(String.valueOf(dictionary.c));
        }

        for (Character n : dictionary.nextLetters.keySet()) {
            ArrayList<String> words = getAllWords(dictionary.nextLetters.get(n));
            for (String word : words) {
                result.add(dictionary.c + word);
            }
        }
        return result;
    }

    static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i<=j && str.charAt(i) == str.charAt(j)) {
            i++;
            j--;
        }
        if (i < j) {
            return false;
        }
        return true;
    }

    private static String reverse(String word) {
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        return sb.toString();
    }


}
