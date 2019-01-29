package recursion.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PalindromicDecomposition2 {
    public static void main(String[] args) {

        String str = "abracadabra";
//        String str = "abdba";
        String[] result = generate_palindromic_decompositions(str);

        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }

    }

    static String[] generate_palindromic_decompositions(String s) {
        return getDecompositions(s, 0, "");
    }

    static String[] getDecompositions(String str, int pos, String soFar){
        if(pos==str.length()){
            String[] result = {soFar};
            return result;
        }

        ArrayList<String> result = new ArrayList<>();
        for(int i = pos; i<str.length(); i++){
            if(isPalindrome(str, pos, i)){
                String thusFar = soFar.isEmpty() ? str.substring(pos, i+1) : soFar + "|" + str.substring(pos, i+1);
                String[] res = getDecompositions(str, i+1, thusFar);
                Collections.addAll(result, res);
            }
        }

        return result.toArray(new String[result.size()]);
    }


    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


}
