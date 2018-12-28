package recursion.youtube;

/**
 * Created by jaynehsu on 12/20/18.
 */

// . match any one character
// * match 0 or more of any char
public class MatchExpression {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "aabc";
        String str3 = "ababc";
        String str4 = "ajkbjbc";


        String exp1 = "a*a";
        String exp2 = "a*";
        String exp3 = "*ba";
        String exp4 = "aba";
        String exp5 = "ab.";
        String exp6 = "a*bc**??";

//        System.out.println(isMatch(str1, exp5));

        System.out.println(isMatch("abbc", "a?c", 0, 0));

    }

    static boolean isMatch(String str, String exp, int ePtr, int sPtr) {

        if (sPtr == str.length() && ePtr == exp.length()) {
            return true;
        } else if (ePtr == exp.length()) {
            return false;
        } else if (sPtr == str.length()) {

            for (int i = ePtr; i < exp.length(); i++) {
                char e = exp.charAt(i);
                if (e != '*' && e!='?') {
                    return false;
                }
            }
            return true;
        }

        char s = str.charAt(sPtr);
        char e = exp.charAt(ePtr);

        if (e == '.') {
            return isMatch(str, exp, ePtr + 1, sPtr + 1);

        } else if (e == '*') {

            if (isMatch(str, exp, ePtr, sPtr + 1) || //multiple
                    isMatch(str, exp, ePtr + 1, sPtr)) { // 0 times
                return true;
            }

            return false;
        } else if (e=='?') {
            if (isMatch(str, exp, ePtr+1, sPtr + 1) || //1
                    isMatch(str, exp, ePtr + 1, sPtr)) { // 0 times
                return true;
            }

            return false;
        } else {
            if (s != e) {
                return false;
            }
            return isMatch(str, exp, ePtr + 1, sPtr + 1);
        }
    }

}
