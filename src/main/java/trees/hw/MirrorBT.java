package trees.hw;

import trees.Node;

/**
 * Created by jaynehsu on 2/1/19.
 */
public class MirrorBT {
    public static void main(String[] args) {
        TreeNode original = prepData2();
        mirror_image(original);
        System.out.println("hi");
    }


    private static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void mirror_image(TreeNode root) {
        if(root==null) return;

        mirror_image(root.left);
        mirror_image(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    private static TreeNode prepData2() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        return one;
    }
}
