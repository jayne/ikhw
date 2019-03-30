package strings.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by jaynehsu on 2/24/19.
 */
// runtime of creating the tree
    // O(n*m)
    // n = number of words
    // m = length of longest word

// runtime of searching the tree
    // O(p + n(m-p)
    // p = prefix length
public class PrefixTrees2 {
    public static void main(String[] args) {
        String[] words = {
                "pizza hut",
                "dominos",
                "pizza my heart",
                "olive garden",
                "olivers",
                "olive"
        };

        String prefix = "olive";

        Letter dictionary = createDictionary2(words);

        String[] matchingPrefix = getMatches(dictionary, prefix);

        for (String s : matchingPrefix) {
            System.out.println(s);
        }


    }

    private static Letter createDictionary2(String[] words) {
        Letter dictionary = new Letter();

        for(String s : words){
            Letter map = dictionary;
            for(int i = 0; i<s.length(); i++){
                if(!map.nextLetters.containsKey(s.charAt(i))){
                    map.nextLetters.put(s.charAt(i), new Letter(s.charAt(i)));
                }
                map = map.nextLetters.get(s.charAt(i));
            }
            map.end = true;
        }

        return dictionary;
    }

    private static String[] getMatches(Letter letter, String prefix) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < prefix.length(); i++) {
            if (!letter.nextLetters.containsKey(prefix.charAt(i))) {
                return result.toArray(new String[result.size()]);
            }
            letter = letter.nextLetters.get(prefix.charAt(i));
        }

        result.addAll(getDFS(letter, prefix));

        return result.toArray(new String[result.size()]);
    }

    private static ArrayList<String> getDFS(Letter map, String prefix) {
        ArrayList<String> result = new ArrayList<>();
        if (map.end) {
            result.add(prefix);
        }
        // do a DFS on the result tree
        for (Character c : map.nextLetters.keySet()) {
            result.addAll(getDFS(map.nextLetters.get(c), prefix + c));
        }
        return result;
    }
}
