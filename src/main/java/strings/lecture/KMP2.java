package strings.lecture;

import java.util.ArrayList;

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
public class KMP2 {
    public static void main(String[] args) {
        String str = "AABAACAADAABAABA";
        String pat = "AABA";
//        String pat = "AAACAAAAX"; //0 1 2 0 1 2 3 3 0


//        String pat = "abaabab";

        ArrayList<String> matches = getMatches(str, pat);
    }

    private static ArrayList<String> getMatches(String str, String pat) {
        int[] lps = getPattern(pat);
        for (int i = 0; i < pat.length(); i++) {
            System.out.print(lps[i] + " ");
        }
        System.out.println();


        return getMatchesHelper(str, pat, lps);
    }

    private static ArrayList<String> getMatchesHelper(String str, String pat, int[] lps) {
        ArrayList<String> result = new ArrayList<>();

        int j = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);


            char p = pat.charAt(j);
            if (c == p) {
                j++;
                if (j == pat.length()) {
                    System.out.println("found match");
//                    System.out.println(str.substring(0, i+1) + " | ");

                    int start = i-pat.length()+1;
                    System.out.println(str.substring(0, start) + " | "
                            + str.substring(start, i+1) + " | "
                            + str.substring(i+1));

                    j = lps[j - 1];
                }
            } else {
                j = lps[j];
            }


        }
        return null;
    }

    private static int[] getPattern(String pat) {
        int i = 0;
        int j = 1;

        int[] result = new int[pat.length()];
        result[0] = 0;

        while (j < pat.length()) {
            if (pat.charAt(i) == pat.charAt(j)) {
                i++;
                result[j] = i;
                j++;
            } else {
                if (i == 0) {
                    result[j] = 0;
                    j++;
                } else {
                    i = result[i - 1];
                }

            }

        }

        return result;
    }

}

