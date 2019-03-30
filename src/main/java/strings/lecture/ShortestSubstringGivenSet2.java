package strings.lecture;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by jaynehsu on 11/8/18.
 */
public class ShortestSubstringGivenSet2 {
    public static void main(String[] args) {
        String str = "hello world";
        char[] set = {'l', 'r', 'w'};

        String result = shortestSubstring(str, set);
        System.out.println(result);
    }

    private static String shortestSubstring(String str, char[] set) {

        HashSet<Character> hashset = new HashSet<>();
        for (char c : set) {
            hashset.add(c);
        }

        HashMap<Character, Integer> store = new HashMap<>(); // character and count
        String shortest = null;

        int i = 0, j = 0;

        while (i <= j && j < str.length()) {
            char c = str.charAt(j);
            if (hashset.contains(c)) {
                if (store.containsKey(c)) {
                    store.put(c, store.get(c) + 1);
                } else {

                    store.put(c, 1);
                }

                if (store.keySet().size() == 1) {
                    i = j;
                    store.put(str.charAt(i), 1);
                } else if (store.keySet().size() == set.length) {
                    while (store.get(str.charAt(i)) > 1) {
                        store.put(str.charAt(i), store.get(str.charAt(i)) - 1);
                        i++;
                        while (i<= j && store.get(str.charAt(i)) == null) {
                            i++;
                        }

                    }

                    String potentialSmallest = str.substring(i, j + 1);
                    System.out.println(potentialSmallest);
                    shortest = shortest == null ? potentialSmallest :
                            shortest.length() < potentialSmallest.length() ? shortest : potentialSmallest;
                }
            }

            j++;
        }


        return shortest;
    }



}
