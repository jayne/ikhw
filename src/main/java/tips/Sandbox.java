package tips;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jaynehsu on 12/10/18.
 */
public class Sandbox {

    public static void main(String[] args) {
        String str = "abracadabra";
        String[] result = generate_palindromic_decompositions(str);

        System.out.println("\n\nfinally");
        for (String s : result) {
            System.out.println(s);
        }
    }

    static String[] generate_palindromic_decompositions(String s) {
        Set<String> result = getDecompositions(s);

        return result.toArray(new String[result.size()]);
    }

    static Set<String> getDecompositions(String str) {
        Set<String> result = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            String front = str.substring(0, i + 1);
            if (front.equals(str)) {
                if (isPalindrome(str)) {
                    result.add(str);
                }
                return result;
            }

            Set<String> resultFront = getDecompositions(front);

            String back = str.substring(i + 1);
            Set<String> resultBack = getDecompositions(back);

            Set<String> combos = getCombos(resultFront, resultBack);
            result.addAll(combos);

        }

        return result;
    }

    static Set<String> getCombos(Set<String> front, Set<String> back) {
        Set<String> result = new HashSet<>();
        for (String f : front) {
            for (String b : back) {
                String toAdd = f+"|"+b;
                result.add(toAdd);
            }
        }
        return result;
    }

    static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
