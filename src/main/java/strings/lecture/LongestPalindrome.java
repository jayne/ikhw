package strings.lecture;

/**
 * Created by jaynehsu on 3/11/19.
 */
// Time: O(n^2) // there is a manscher's algorithm that will do this with O(n)
    // Solution: check if the character in question is the middle
public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "abcbaabcbcdddd";
        String lp = getLP(str);
        System.out.println(lp);
    }

    private static String getLP(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            // check if it is middle
            int j = i, k =i;
            while(j>=0 && k<str.length() && str.charAt(j)==str.charAt(k)){
                String sub = str.substring(j, k+1);
                result = sub.length() > result.length() ? sub : result;
                j--; k++;
            }

            j=i;
            k=i+1;
            // check if it is left of middle
            while(j>=0 && k<str.length() && str.charAt(j)==str.charAt(k)){
                String sub = str.substring(j, k+1);
                result = sub.length() > result.length() ? sub : result;
                j--; k++;
            }

        }

        return result;
    }
}
