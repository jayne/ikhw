package strings.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by jaynehsu on 11/8/18.
 */
public class ShortestSubstringGivenSet {
    public static void main(String[] args) {
        String str = "hello world";
        char[] charSet = {'l', 'r', 'w'};
        String result = shortestSubstring(str, charSet);
        System.out.println(result);
    }

    private static String shortestSubstring(String str, char[] charSet) {
        HashMap<Character, Integer> count = new HashMap<>();
        fillMap(count, charSet);
        String smallest = "";
        int start = 0;
        int end = 0;

        while (end < str.length()) {
            char endLetter = str.charAt(end);
            if (count.containsKey(endLetter)) {
                count.put(endLetter, count.get(endLetter) + 1);

                // increaseStart
                boolean checkStart = true;
                while (checkStart) {
                    while (!count.containsKey(str.charAt(start))) { // skip over characters not in the set
                        start++;
                    }
                    if (count.get(str.charAt(start)) > 1) { // if count is greater than one, can skip
                        int newCount = count.get(str.charAt(start)) - 1;
                        count.put(str.charAt(start), newCount );
                        start++;
                    }

                    if (count.containsKey(str.charAt(start)) && count.get(str.charAt(start)) == 1) { // if count is one. stay
                        checkStart = false;
                    }
                }
                smallest = str.substring(start, end + 1);
                System.out.println(smallest);
            }



            end++;

        }


        return smallest;
    }

    private static void fillMap(HashMap<Character, Integer> count, char[] charSet) {
        for (char c : charSet) {
            count.put(c, 0);
        }
    }


}
