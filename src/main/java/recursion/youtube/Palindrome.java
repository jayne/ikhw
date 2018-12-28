package recursion.youtube;

/**
 * Created by jaynehsu on 12/11/18.
 */
//runtime O(n^2)
//T(n) = n(n+1)/2
public class Palindrome {
    public static void main(String[] args) {
        String str = "tacoocat";
        System.out.println(isPalindrome(str)); // Big O of space is O(n^2)
        System.out.println(memoryEfficientPalindrome(str, 0, str.length()-1)); // Big O of space is O(n)

    }

    static boolean isPalindrome(String str){
        if(str.length()==1 || str.length()==0){
            return true;
        }

        if(str.charAt(0) == str.charAt(str.length()-1)){
            return isPalindrome(str.substring(1,str.length()-1));
        }else{
            return false;
        }
    }

    static boolean memoryEfficientPalindrome(String str, int l, int r){
        if(l>=r){
            return true;
        }else if(str.charAt(l) == str.charAt(r)){
            return memoryEfficientPalindrome(str, l+1, r-1);
        }else{
            return false;
        }
    }
}
