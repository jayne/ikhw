package tips;

import java.util.ArrayList;

/**
 * Created by jaynehsu on 12/10/18.
 */
public class Sandbox {
    public static void main(String[] args) {

        String str = "050505";
        long target = 5;

        String[] result = generate_all_expressions(str, target);
        for (String s : result) {
            System.out.println(s);
        }

    }

    static String[] generate_all_expressions(String s, long target) {
        ArrayList<String> result = new ArrayList<>();
        genExp(s, s, target, 0, 0, 0, result);
        return result.toArray(new String[result.size()]);
    }

    static void genExp(String str, String currStr, long target, int i, int currSum, int last, ArrayList<String> result) {

        if (i == str.length()) {
            if (currSum == target) {
                result.add(currStr);
            }
            return;
        }

        int digit = Integer.valueOf(String.valueOf(str.charAt(i)));
        if (i == 0) {
            genExp(str, String.valueOf(digit), target, i + 1, digit, digit, result);
        } else {

            // add plus
//            String plusStr = currStr + "+" + digit;
//            int plusSum = currSum + digit;
//            genExp(str, plusStr, target, i + 1, plusSum, digit, result);

            // add mult
            int multSum = currSum-last + last*digit;
            genExp(str, currStr + "*" + digit, target,i+1, multSum, digit*last, result);

            // skip
            int skipSum = currSum-last + (last*10+digit);
            genExp(str, currStr + digit, target, i + 1, skipSum, last*10+digit, result);
        }

    }


}
