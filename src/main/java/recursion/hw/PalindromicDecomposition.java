package recursion.hw;

import java.util.HashSet;
import java.util.Set;

public class PalindromicDecomposition {
    public static void main(String[] args) {
        String str = "abracadabra";
//        String str = "abba";
        String[] result = generate_palindromic_decompositions(str);

        for (String s : result) {
//            System.out.println(s);
        }
    }

    static String[] generate_palindromic_decompositions(String s) {
        Set<String> result = new HashSet<>();

        getDecompositions(result, s, 0, "");

        return result.toArray(new String[result.size()]);
    }

    static void getDecompositions(Set result, String str, int pos, String soFar){
        if(pos==str.length()){
            result.add(soFar);
            System.out.println(soFar);
            return;
        }

        for(int i = pos; i<str.length(); i++){
            if(isPalindrome(str,pos,i)){
                String newSoFar = str.substring(pos, i+1);
//                System.out.println(newSoFar);

                if(pos==0){
                    getDecompositions(result, str, i+1, newSoFar );
                }else{
                    getDecompositions(result, str, i+1, soFar + "|" + newSoFar );
                }
            }
        }
    }

    static boolean isPalindrome(String s, int i, int j) {
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
