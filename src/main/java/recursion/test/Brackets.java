package recursion.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

// time complexity is O(2^n) i think...
public class Brackets {

    public static void main(String[] args) {

//        mySolution();

        classSolution();

    }

    static void classSolution() {
        int n = 3;
        String[] result = getBrackets("", n, n);
        for (String s : result) {
            System.out.println(s);
        }
    }

    static String[] getBrackets(String prefix, int open, int close) {


        if (close == 0) {
            String[] result = {prefix};
            return result;
        }

        String[] left = {}, right = {};
        // choose (
        if (open > 0) {
            left = getBrackets(prefix + "(", open - 1, close);
        }

        // choose )
        if (close > open) {
            right = getBrackets(prefix + ")", open, close-1);
        }

        return Stream.concat(Arrays.stream(left), Arrays.stream(right))
                .toArray(String[]::new);

    }

//    static void mySolution() {
//        int n = 3;
//        String[] result = find_all_well_formed_brackets(n);
//        for (String s : result) {
//            System.out.println(s);
//        }
//
//    }
//
//
//    static String[] find_all_well_formed_brackets(int n) {
//
//        Set<String> result = new HashSet<>();
//
//        if (n == 1) {
//            String str = "()";
//            result.add(str);
//            return result.toArray(new String[result.size()]);
//        }
//
//        String[] prior = find_all_well_formed_brackets(n - 1);
//
//        for (String s : prior) {
//            for (int i = 0; i < s.length(); i++) {
//                String front = s.substring(0, i);
//
//                String back = s.substring(i);
//                String toAdd = front + "()" + back;
////                if (result.contains(toAdd)) {
////                    System.out.println("duplicate!"); // this was debug code to show my solution is not the most time efficient
////                }
//                result.add(toAdd);
//            }
//        }
//
//        return result.toArray(new String[result.size()]);
//    }


}
