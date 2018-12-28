package recursion.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by jaynehsu on 12/26/18.
 */
public class Expressions {

    public static void main(String[] args) {

        String str = "22";
        long target = 4;

        String[] result = generate_all_expressions(str, target);
        for (String s : result) {
            System.out.println(s);
        }

//        boolean b = isValid("0+5*0+5*05", 5);
//        System.out.println(b);

//        String t="0+5*0+5*05";
//        t = t.replaceFirst("5[*]0","0");
//        System.out.println(t);

//        String s = "2x3";
//        System.out.println(s.substring(2,3));
//        System.out.println(s.substring(1));
//        System.out.println(s.substring(2));
    }

    static String[] generate_all_expressions(String s, long target) {
        String[] result = generateString(s, 0, "", target);

        ArrayList<String> arr = new ArrayList<>();
        for (String str : result) {
            if (isValid(str, target)) {
                arr.add(str);
            }
        }

        return arr.toArray(new String[arr.size()]);
    }

    static boolean isValid(String s, long target) {
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '+') {
                i = j + 1;
            } else if (s.charAt(j) == '*') {
                long num1 = Long.valueOf(s.substring(i, j));
                int k = j + 1;
                while (k < s.length() && !(s.charAt(k) == '+' || s.charAt(k) == '*')) {
                    k++;
                }
                long num2 = Long.valueOf(s.substring(j + 1, k));
                long res = num1 * num2;
                String regex = s.substring(i,k);
                regex = regex.replace("*","[*]");
                s = s.replaceFirst(regex, String.valueOf(res));
                j = i;
            }
        }
        i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '+') {
                long num1 = Long.valueOf(s.substring(i, j));
                int k = j + 1;
                while (k < s.length() && !(s.charAt(k) == '+' || s.charAt(k) == '*')) {
                    k++;
                }
                long num2 = Long.valueOf(s.substring(j + 1, k));
                long res = num1 + num2;
                s = s.replace(s.substring(i, k), String.valueOf(res));
//                j=i+String.valueOf(res).length();
                j = i;
            }
        }


        return Long.valueOf(s) == target;

    }

    static String[] generateString(String original, int i, String current, long target) {
        if (i == original.length()) {
            String[] result = {current};
            return result;
        }
        if (current == "") {
            return generateString(original, 1, String.valueOf(original.charAt(0)), target);
        }

        String plus = current + "+" + original.charAt(i);
        String[] plusResult = generateString(original, i + 1, plus, target);
        ArrayList<String> p = new ArrayList<>(Arrays.asList(plusResult));

        String mult = current + "*" + original.charAt(i);
        String[] multResult = generateString(original, i + 1, mult, target);
        ArrayList<String> m = new ArrayList<>(Arrays.asList(multResult));

        String skip = current + original.charAt(i);
        String[] skipResult = generateString(original, i + 1, skip, target);
        ArrayList<String> s = new ArrayList<>(Arrays.asList(skipResult));


        p.addAll(m);
        p.addAll(s);

        return p.toArray(new String[p.size()]);


    }


}
