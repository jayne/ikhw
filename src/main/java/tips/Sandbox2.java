package tips;

import java.util.HashSet;
import java.util.Set;

public class Sandbox2 {

    public static void main(String[] args) {
        String str = "abracadabra";
//        String str = "abc";
        String[] result = generate_palindromic_decompositions(str);

        System.out.println("\n\nfinally");
        for (String s : result) {
            System.out.println(s);
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
            return;
        }

        for(int i = pos; i<str.length(); i++){
            if(isPalindrome(str,pos,i)){
                String newSoFar = str.substring(pos, i+1);

                if(pos==0){
                    getDecompositions(result, str, i+1, str.substring(pos, i+1) );
                }else{
                    getDecompositions(result, str, i+1, soFar + "|" + str.substring(pos, i+1) );
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
