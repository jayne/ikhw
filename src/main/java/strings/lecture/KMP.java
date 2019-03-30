package strings.lecture;

/**
 * Created by jaynehsu on 2/27/19.
 */
//
// n = length(str); m = length(pat)

// build table
// time: O(m)
// space: O(m)

// matching traversals
// time: O(n)
// space: O(1)

// overall
// time: O(m+n)
// space: O(m)



// TODO: this solution does not work. LPS is not properly created
public class KMP {
    public static void main(String[] args) {
//        String str = "abxaababxab";
        String str = "AABAACAADAABAABA";

//        String pat = "AABA";
//        String pat = "abacdaabaab";
//        String pat = "AAACAAAAX"; //0 1 2 0 1 2 3 3 0
//        String pat = "AACAAAX";

        String pat = "abaabab";


        int[] lps = getLPS(pat);

        for (int i = 0; i < lps.length; i++) {
            System.out.print(lps[i] + " ");
        }
        System.out.println();

        printPatternMatch(str, pat, lps);
    }

    private static void printPatternMatch(String str, String pat, int[] lps) {
        int length = 0;
        int i = 0;

        while(i<str.length()){
            char strLetter = str.charAt(i);
            char patLetter = pat.charAt(length);

            System.out.println("comparing " + strLetter + " " + patLetter);

            if (str.charAt(i) == pat.charAt(length)) {
                length++;
                i++;
                if (length == pat.length()) {
                    System.out.println("pattern found " + (i-length) + " : " + i);
                    length = lps[length - 1];
                }
            } else {
                while (str.charAt(i) != pat.charAt(length) && length != 0) {
                    length = lps[length-1];
                }
                if(length==0){
                    i++;
                }
            }
        }

    }


    private static int[] getLPS(String pat) {
        int[] result = new int[pat.length()];

        int length = 0;
        result[0] = length;


        for (int i = 1; i < pat.length(); i++) {
            if (pat.charAt(length) == pat.charAt(i)) {
                length++;
                result[i] = length;
            } else {
                while (length != 0 && pat.charAt(i) != pat.charAt(length)) {
                    length = result[length - 1];
                }
                result[i] = length == 0 ? 0 : result[length] + 1;

            }
        }

        return result;
    }
}

