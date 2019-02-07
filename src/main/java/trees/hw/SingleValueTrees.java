package trees.hw;

import trees.Node;
import trees.TreeNode;

import java.lang.reflect.Field;

/**
 * Created by jaynehsu on 1/10/19.
 */
//https://crazycoderzz.wordpress.com/count-the-number-of-unival-subtrees-in-a-binary-tree/
// https://www.geeksforgeeks.org/find-count-of-singly-subtrees/


public class SingleValueTrees {

    public static void main(String[] args) {
        TreeNode root = prepData2();
        int result[] = countUnival(root);
        System.out.println(result[1]);

    }

    // [0] = 0 if false, 1 if true
    // [1] = # of subtrees
    private static int[] countUnival(TreeNode root) {
        int[] result = new int[2];

        if (root == null) {
            result[0] = 1;
            result[1] = 0;
            return result;
        }

        int[] left = countUnival(root.left_ptr);
        int[] right = countUnival(root.right_ptr);

        if(left[0] == 0 || right[0] == 0){  // if either of the below are not single value trees, then neither is this root
            result[0] = 0;
            result[1] = left[1] + right[1];
            return result;
        }

        boolean isMatch = true;
        int count = 0;

        if(left[1] == 0 && right[1] == 0){ // if it is a leaf node
            result[0] = 1;
            result[1] = 1;
            return result;
        }

        if(left[1] != 0) { // left exists...get the child count and check the value against root
            isMatch = root.left_ptr.val == root.val ? true : false;
            count = count + left[1];
        }
        if(right[1]!= 0){ // right exists...get the child count and check the value against root
            isMatch = (root.right_ptr.val != root.val) || isMatch == false ? false : true;
            count = count + right[1];
        }

        count = count + (isMatch? 1 : 0);

        result[0] = isMatch ? 1 : 0;
        result[1] = count;

        return result;
    }

    private static TreeNode prepData() { //6
        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(5);
        TreeNode three = new TreeNode(5);
        TreeNode four = new TreeNode(5);
        TreeNode five = new TreeNode(5);
//        Node six = new Node(5);
        TreeNode seven = new TreeNode(5);

        one.left_ptr = two;
        one.right_ptr = three;

        two.left_ptr = four;
        two.right_ptr = five;

//        three.left = six;
        three.right_ptr = seven;

        return one;

    }

    private static TreeNode prepData2() { //5
        TreeNode n0 = new TreeNode(1);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);

        n0.left_ptr = n1;
        n0.right_ptr = n2;
        n1.left_ptr = n3;
        n1.right_ptr = n4;

        return n0;
    }


}
