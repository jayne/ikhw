package tips;

import strings.lecture.Letter;
import trees.Node;

import java.util.*;
import java.util.stream.Stream;

import static trees.Node.printTree;

/**
 * Created by jaynehsu on 12/10/18.
 */

//prefix tree

public class Sandbox {

    public static void main(String[] args) {
//        String text = "abbbc";
//        String pattern = "ab*c";

//        String text = "abcdefg";
//        String pattern = "a.c.*.*gg*";

        String text = "abc";
        String pattern = ".ab*..";


//        String text = "g";
//        String pattern = ".*gg*";


        System.out.println(text + " | " + pattern);
        System.out.println(pattern_matcher(text, pattern));
        System.out.println("end");

    }

    static boolean pattern_matcher(String text, String pattern) {
    }





}






