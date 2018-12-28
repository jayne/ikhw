package recursion.youtube;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by jaynehsu on 12/23/18.
 */
// Make S1(perform operations) into S2(Target string)
public class EditDistance {
    public static void main(String[] args) {
//        StringBuffer a = new StringBuffer("abc");
//        String b = "";


//        StringBuffer a = new StringBuffer("abcd");
//        String b = "adbc";

        StringBuffer a = new StringBuffer("abc");
        String b = "aecd";

        Stack<String> path = editDistance(a, 0, b, 0);

//        System.out.println("winner");
        print(path);


    }

    static void print(Stack path) {
        while (!path.isEmpty()) {
            System.out.println(path.pop());
        }
        System.out.println();
    }

    static Stack<String> editDistance(StringBuffer a, int i, String b, int j) {

        Stack<String> path = new Stack<>();
        StringBuffer copy = new StringBuffer(a);

        if (a.toString().equals(b)) {
//            System.out.println("matches");
            path.add("matches");
            //print(path);
//            System.out.println();
            return path;
        }

        while ((i < a.length() && j < b.length()) && (a.charAt(i) == b.charAt(j))) {
            i++;
            j++;
        }

        Character charA = null, charB = null;

        if (i < a.length()) {
            charA = a.charAt(i);
        }
        if (j < b.length()) {
            charB = b.charAt(j);
        }

        //insert
        Stack insertPath = null;
        if (charB != null) {
//            System.out.println("inserting");
            copy = new StringBuffer(a);
            copy.insert(i, charB);
            insertPath = editDistance(copy, i + 1, b, j + 1);
            insertPath.add("insert " + charB);

        }

        //delete
        Stack deletePath = null;
        if (charA != null) {
//            System.out.println("deleting");
            copy = new StringBuffer(a);
            copy.deleteCharAt(i);
            deletePath = editDistance(copy, i, b, j);
            deletePath.add("delete " + charA);

        }


        //replace
        Stack replacePath = null;
        if (charA != null && charB != null) {
//            System.out.println("replacing");
            copy = new StringBuffer(a);
            copy.setCharAt(i, charB);
            replacePath = editDistance(copy, i + 1, b, j + 1);
            replacePath.add("replace " + charA + " " + charB);

        }


        // find the lowest
        int insert = insertPath == null ? Integer.MAX_VALUE : insertPath.size();
        int delete = deletePath == null ? Integer.MAX_VALUE : deletePath.size();
        int replace = replacePath == null ? Integer.MAX_VALUE : replacePath.size();

        if (insert <= delete && insert <= replace) {
            return insertPath;
        } else if (delete <= insert && delete <= replace) {
            return deletePath;
        } else {
            return replacePath;
        }
    }


}
