package trees.hw;

import trees.Node;
import trees.TreeNode;

import java.util.ArrayList;

import static trees.Node.printInorder;

/**
 * Created by jaynehsu on 1/14/19.
 */
public class UpsideDown2 {
    public static void main(String[] args) {
        TreeNode tn = flipUpsideDown(prepData1());
        System.out.println(tn.val);


        TreeNode.printInorder(tn);
    }

    static TreeNode flipUpsideDown(TreeNode root) {
        if(root==null || root.left_ptr==null){
            return root;
        }

        TreeNode newRoot = flipUpsideDown(root.left_ptr);

        TreeNode oldLeft = root.left_ptr;
        oldLeft.right_ptr = root;
        oldLeft.left_ptr = root.right_ptr;

        root.left_ptr = null;
        root.right_ptr = null;

        return newRoot;
    }

    private static TreeNode prepData1() {
        TreeNode one = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);
//        TreeNode five = new TreeNode(5);
//        TreeNode six = new TreeNode(6);
//        TreeNode seven = new TreeNode(7);
//
//        one.left_ptr = two;
//        one.right_ptr = three;
//        two.left_ptr = four;
//        two.right_ptr = five;
//        four.left_ptr = six;
//        four.right_ptr = seven;

        return one;
    }


}
