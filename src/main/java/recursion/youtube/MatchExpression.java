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

        System.out.println(isMatch("abbc", "a??c", 0, 0));

    }

    public static boolean isMatch(String str, String exp, int ptrStr, int ptrExp){

        if(ptrStr == str.length() && ptrExp==exp.length()){
            return true;
        }else if(ptrExp == exp.length()){
            return false;
        }else if(ptrStr == str.length()){
            for(char c : exp.substring(ptrExp+1).toCharArray()){
                if( c!='?' && c!='*') return false;
            }
            return true;
        }

        char strChar = str.charAt(ptrStr);
        char expChar = exp.charAt(ptrExp);

        if(expChar == '.'){
            return isMatch(str, exp, ptrStr+1, ptrExp + 1);
        }
        if(expChar == '?'){
            boolean zero = isMatch(str, exp, ptrStr, ptrExp+1);
            boolean one =  isMatch(str, exp, ptrStr+1, ptrExp+1);
            return zero || one;
        }

        if(expChar == '*'){
            boolean zero = isMatch(str, exp, ptrStr, ptrExp+1);
            boolean more = isMatch(str, exp, ptrStr+1, ptrExp);
            return zero || more;
        }

        if(expChar == strChar){
            return isMatch(str, exp, ptrStr+1, ptrExp + 1);
        }

        return false;
    }

}
