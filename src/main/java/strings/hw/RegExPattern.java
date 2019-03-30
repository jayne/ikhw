package strings.hw;

/**
 * Created by jaynehsu on 3/29/19.
 */
public class RegExPattern {

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
        // Write your code here
        return pattern_matcher(text, text.length() - 1, pattern, pattern.length() - 1);
    }


    private static boolean pattern_matcher(String text, int i, String pattern, int j) {
        if (i == -1 && j == -1) {
            return true;
        }
        if (i == -1) { // string has ended
            while (j >= 0) {
                if (pattern.charAt(j) != '*') {
                    return false;
                }
                j = j - 2;
            }
            return true;
        }
        if (j == -1) { // pattern has ended
            return false;
        }


        char ct = text.charAt(i);
        char cp = pattern.charAt(j);


        if (cp == '.' || cp == ct) {
            return pattern_matcher(text, i - 1, pattern, j - 1);

        } else if (cp == '*') {
            while (j >= 3 && pattern.charAt(j - 2) == '*' && pattern.charAt(j - 3) == pattern.charAt(j - 1)) {
                j = j - 2;
            }

            // matches at least one
            char base = pattern.charAt(j - 1);

            // matches 0
            return pattern_matcher(text, i, pattern, j - 2) || ((base == ct || base == '.') && pattern_matcher(text, i - 1, pattern, j));

        }

        return false;
    }
}
