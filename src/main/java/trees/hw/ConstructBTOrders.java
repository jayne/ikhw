package trees.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jaynehsu on 2/6/19.
 */
public class ConstructBTOrders {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            value = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
//        tc1();
        tc2();
    }

    private static void tc2() {
        List<Integer> inorder = new ArrayList<>();
        inorder.add(3);
        inorder.add(2);
        inorder.add(1);
        inorder.add(5);
        inorder.add(4);
        inorder.add(6);

        List<Integer> preorder = new ArrayList<>();
        preorder.add(1);
        preorder.add(2);
        preorder.add(3);
        preorder.add(4);
        preorder.add(5);
        preorder.add(6);


        TreeNode result = constructBinaryTree(inorder, preorder);
        System.out.println(result.value);
    }

    private static void tc1() {
        List<Integer> inorder = new ArrayList<>();
        inorder.add(6);
        inorder.add(7);
        inorder.add(5);

        List<Integer> preorder = new ArrayList<>();
        preorder.add(5);
        preorder.add(6);
        preorder.add(7);

        TreeNode result = constructBinaryTree(inorder, preorder);
        System.out.println(result.value);
    }

    // this is class solution
    public static TreeNode constructBinaryTree(List<Integer> inorder, List<Integer> preorder) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }
        return constructBinaryTreeHelper(preorder, map, 0, preorder.size() - 1, 0);
    }


    public static TreeNode constructBinaryTreeHelper(List<Integer> preorder,
                                                     HashMap<Integer, Integer> inorderMap,
                                                     int start,
                                                     int end,
                                                     int preOrderIndex) {

        if (start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.get(preOrderIndex));

        if (start == end) {
            return root;
        }

        int inorderRootIndex = inorderMap.get(preorder.get(preOrderIndex));

        root.left = constructBinaryTreeHelper(preorder, inorderMap,
                start, inorderRootIndex - 1,
                preOrderIndex + 1);

        root.right = constructBinaryTreeHelper(preorder, inorderMap,
                inorderRootIndex + 1, end,
                preOrderIndex + (inorderRootIndex - start) + 1);

        return root;
    }


    // this is my solution
    public static TreeNode constructBinaryTreeMySln(List<Integer> inorder, List<Integer> preorder) {


        if (inorder == null || inorder.size() == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder.get(0));
        TreeNode left = null, right = null;

        int inorderRootIndex = inorder.indexOf(preorder.get(0));

        if (inorder.size() > 1) {
            left = constructBinaryTreeMySln(
                    inorder.subList(0, inorderRootIndex),
                    preorder.subList(1, 1+inorderRootIndex));

            right = constructBinaryTreeMySln(
                    inorder.subList(inorderRootIndex+1, inorder.size()),
                    preorder.subList(1+inorderRootIndex, preorder.size()));

        }

        root.left = left;
        root.right = right;


        return root;
    }

}
