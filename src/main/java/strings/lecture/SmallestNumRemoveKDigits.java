package strings.lecture;

import java.util.HashMap;

/**
 * Created by jaynehsu on 11/8/18.
 */
public class SmallestNumRemoveKDigits {
    public static void main(String[] args) {
        String str = "3194";
        int k = 2;

        String result = getSmallestNumByRemovingKDigits(str, k);
        System.out.println(result);

    }

    private static String getSmallestNumByRemovingKDigits(String str, int k) {
        int smallestDigit = Integer.MAX_VALUE;

        for (int i = 0; i <= k; i++) {
            smallestDigit = Math.min(Integer.valueOf(String.valueOf(str.charAt(i))), smallestDigit);

        }

        System.out.println("smallest digit is " + smallestDigit);

        return smallestDigit + str.substring(k + 1, str.length());

    }


}
