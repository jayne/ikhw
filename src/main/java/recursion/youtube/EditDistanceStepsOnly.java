package recursion.youtube;

/**
 * Created by jaynehsu on 12/26/18.
 */
// height is string a + string b (you can delete everything and insert everything)
    // choices is 4 (insert,delete,replace, skip)
public class EditDistanceStepsOnly {


    public static void main(String[] args) {
        //        StringBuffer a = new StringBuffer("abc");
//        String b = "";


//        StringBuffer a = new StringBuffer("abcd");
//        String b = "adbc";

        String a = "abc";
        String b = "aecd";

        int path = editDistance(a, 0, b, 0);
        System.out.println(path);
    }

    static int editDistance(String a, int i, String b, int j) {
        if (i == a.length() && j == b.length()) {
            return 0;
        }

        // if first string is empty, choose insert for the rest of the remaining characters
        if (i == a.length()) {
            return b.length() - j;
        }

        // if second string is empty, choose delete for the rest of the remaining characters
        if (j == b.length()) {
            return a.length() - i;
        }

        // if character is the same, skip this index
        if (a.charAt(i) == b.charAt(j)) {
            return editDistance(a, i + 1, b, j + 1);
        }

        int insert = 1 + editDistance(a, i , b, j+1);
        int delete = 1 + editDistance(a, i+1, b, j);
        int replace = 1 + editDistance(a, i+1, b, j+1);

        if (insert <= delete && insert <= replace) {
            return insert;
        } else if (delete <= insert && delete <= replace) {
            return delete;
        } else {
            return replace;
        }
    }


}

