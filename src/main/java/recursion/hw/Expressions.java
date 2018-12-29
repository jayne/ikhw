package recursion.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by jaynehsu on 12/26/18.
 */
// generate all expressiosn that evaluate to a number (target)
// solution is to brute force. recurse on the two symbols. use for loop to determine the "skips"
public class Expressions {

    public static void main(String[] args) {

        String str = "00000000001";
        long target = 1;

//        String str = "22";
//        long target = 4;

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

    static void genExp(String str, String currStr, long target, int i, long currSum, long last, ArrayList<String> result) {

        if (i == str.length()) {
            System.out.println(currStr);
            if (currSum == target) {
                result.add(currStr);
            }
            return;
        }
        for (int j = i + 1; j <= str.length(); j++) {
            String num = str.substring(i, j);

            long digit = Long.valueOf(num);
            if (i == 0) {
                genExp(str, num, target, j, digit, digit, result);
            } else {

//             add plus
                String plusStr = currStr + "+" + num;
                long plusSum = currSum + digit;
                genExp(str, plusStr, target, j, plusSum, digit, result);

                // add mult
                long multSum = currSum - last + last * digit;
                genExp(str, currStr + "*" + num, target, j, multSum, digit * last, result);


            }
        }

    }


}
