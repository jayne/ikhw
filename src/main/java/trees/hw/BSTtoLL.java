package trees.hw;

import trees.TreeNode;

import java.util.ArrayList;

/**
 * Created by jaynehsu on 1/30/19.
 */
public class BSTtoLL {
    public static void main(String[] args) {
//        myMethod();

        tutorialMethod();


    }

    private static void tutorialMethod() {
        TreeNode data = prepData();
        TreeNode root = convert(data);
        TreeNode iter = root;
        for (int i = 0; i < 15; i++) {
            System.out.println(iter.val);
            iter = iter.right_ptr;
        }

    }

    private static TreeNode convert(TreeNode root) {

        // base case is leaf node
        if (root.left_ptr == null && root.right_ptr == null) {
            root.left_ptr = root;
            root.right_ptr = root;
            return root;
        }

        TreeNode head = null;
        TreeNode tail = null;

        // check if there is a left
        if (root.left_ptr != null) {
            TreeNode leftHead = convert(root.left_ptr);
            TreeNode leftEnd = leftHead.left_ptr;

            leftEnd.right_ptr = root;
            root.left_ptr = leftEnd;

            head = leftHead;
        }

        head = head == null ? root : head;

        // check if there is a right
        if (root.right_ptr != null) {
            TreeNode rightHead = convert(root.right_ptr);
            TreeNode rightTail = rightHead.left_ptr;

            root.right_ptr = rightHead;
            rightHead.left_ptr = root;

            tail =rightTail;
        }

        tail = tail == null ? root : tail;

        tail.right_ptr = head;
        head.left_ptr = tail;

        return head;
    }

    private static void myMethod() {
        TreeNode data = prepData();
        ArrayList<TreeNode> store = new ArrayList<>(); // 0 for head, 1 for tail
        BSTtoLL(data, store);
        TreeNode iter = data;
        for (int i = 0; i < 15; i++) {
            System.out.println(iter.val);
            iter = iter.left_ptr;
        }
    }

    static void BSTtoLL(TreeNode root, ArrayList<TreeNode> store) {
        // base case is leaf node
        if (root.left_ptr == null && root.right_ptr == null) {
            store.add(0, root);
            store.add(1, root);
            return;
        }

        TreeNode head = null;
        TreeNode tail = null;

        if (root.left_ptr != null) {
            ArrayList<TreeNode> left = new ArrayList<>();
            BSTtoLL(root.left_ptr, left);
            head = left.get(0);
            left.get(1).right_ptr = root;
            root.left_ptr = left.get(1);
        }

        if (root.right_ptr != null) {
            ArrayList<TreeNode> right = new ArrayList<>();
            BSTtoLL(root.right_ptr, right);
            tail = right.get(1);
            right.get(0).left_ptr = root;
            root.right_ptr = right.get(0);
        }

        head = head == null ? root : head;
        tail = tail == null ? root : tail;

        head.left_ptr = tail;
        tail.right_ptr = head;

        store.add(0, head);
        store.add(1, tail);


        return;
    }

    private static TreeNode prepData() {
        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(3);
        TreeNode three = new TreeNode(9);
        TreeNode four = new TreeNode(1);
        TreeNode five = new TreeNode(4);
        TreeNode six = new TreeNode(8);
        TreeNode seven = new TreeNode(10);

        one.left_ptr = two;
        one.right_ptr = three;
        two.left_ptr = four;
        two.right_ptr = five;
        three.left_ptr = six;
        three.right_ptr = seven;

        return two;
    }
}
