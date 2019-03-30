package strings.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by jaynehsu on 2/24/19.
 */
public class PrefixTrees {
    public static void main(String[] args) {
        String[] words = {"cat", "button", "butt", "cab", "dog", "dare"};

        String prefix = "d";
//        String prefix = "butt";
        Letter dictionary = makeDictionary(words);
        System.out.println(isWord(dictionary, "dog"));
        ArrayList<String> wordsWithPrefix = getWordsWithPrefix(dictionary, prefix);

        System.out.println("Finding words for this prefix " + prefix);
        for (String str : wordsWithPrefix) {
            System.out.println(str);
        }


    }

    private static ArrayList<String> getWordsWithPrefix(Letter dictionary, String prefix) {
        Letter matchedPrefix = isWord(dictionary, prefix.toCharArray(), 0, false);
        ArrayList<String> results = new ArrayList<>();

        if (matchedPrefix != null) {
            Stack<Character> word = new Stack<>();
            for (int i = 0; i < prefix.length(); i++) {
                word.push(prefix.charAt(i));
            }

            getWordsWithPrefixHelper(matchedPrefix, word, results);
        }
        return results;
    }

    private static void getWordsWithPrefixHelper(Letter matchedPrefix, Stack<Character> word, ArrayList<String> results) {
        if (matchedPrefix.end == true) {
            results.add(getWordFromStackRepresentation(word));
        }
        for (Character c : matchedPrefix.nextLetter.keySet()) {
            word.push(c);
            getWordsWithPrefixHelper(matchedPrefix.nextLetter.get(c), word, results);
            word.pop();
        }
    }

    private static String getWordFromStackRepresentation(Stack<Character> word) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < word.size(); i++) {
            str.append(word.get(i));
        }
        return str.toString();
    }


    private static boolean isWord(Letter dictionary, String word) {

        Letter lastLetter = isWord(dictionary, word.toCharArray(), 0, true);
        return lastLetter == null ? false : true;
    }

    private static Letter isWord(Letter dictionary, char[] word, int index, boolean checkEnd) {
        if (index == word.length) {
            return null;
        }
        if (dictionary.nextLetter.containsKey(word[index])) {
            Letter nextLetter = dictionary.nextLetter.get(word[index]);
            if (index == word.length - 1) {
                if (checkEnd == true && nextLetter.end != true) {
                    return null;
                }
                return nextLetter;
            }
            return isWord(nextLetter, word, index + 1, checkEnd);
        } else {
            return null;
        }
    }

    private static Letter makeDictionary(String[] words) {

        Letter dictionary = new Letter();
        dictionary.start = true;

        for (String word : words) {
            addToDictionary(dictionary, word.toCharArray(), 0);
        }
        return dictionary;
    }

    private static void addToDictionary(Letter root, char[] word, int index) {
        if (index == word.length) {
            return;
        }
        char letter = word[index];

        Letter nextLetter = root.nextLetter.get((Character) letter);
        if (nextLetter == null) {
            Letter newLetter = new Letter(letter);
            if (index == word.length - 1) {
                newLetter.end = true;
            }
            root.nextLetter.put(letter, newLetter);
            addToDictionary(newLetter, word, index + 1);
        } else {
            if (index == word.length - 1) {
                nextLetter.end = true;
            }
            addToDictionary(nextLetter, word, index + 1);
        }
    }

    static class Letter {
        boolean start = false;
        boolean end = false;
        char letter;
        HashMap<Character, Letter> nextLetter = new HashMap();


        Letter(char letter) {
            this.letter = letter;
        }

        Letter() {

        }

    }
}
