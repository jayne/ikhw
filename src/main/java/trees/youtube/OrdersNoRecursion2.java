package trees.youtube;

import trees.Node;
import trees.TreeNode;

import java.util.Stack;

/**
 * Created by jaynehsu on 1/7/19.
 */
public class OrdersNoRecursion2 {
    public static void main(String[] args) {
//        recursive(prepData());
        System.out.println();
        System.out.println("Start here");
        postOrder(prepData());


    }

    //test
    private static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode iter = root;
        boolean start = true;

        while(!stack.isEmpty() || start){
            while(iter!=null){
                if(iter.right_ptr!=null){
                    stack.push(iter.right_ptr);
                }
                stack.push(iter);
                iter = iter.left_ptr;
            }

            iter = stack.pop();

            if(!stack.isEmpty() && iter.right_ptr == stack.peek()){
                TreeNode next = stack.pop();
                stack.push(iter);
                iter = next;

            }else{
                System.out.println(iter.val);
                iter = null;
            }
            start = false;
        }
    }

    // left, right, root
    //1,4,3,8,10,9,5
//    private static void postOrder(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        boolean start = true;
//        TreeNode iter = root;
//
//        while(!stack.isEmpty() || start){
//            while(iter!=null) {
//                if(iter.right_ptr!=null) {
//                    stack.push(iter.right_ptr);
//                }
//                stack.push(iter);
//                iter = iter.left_ptr;
//            }
//
//            iter = stack.pop();
//
////            if(iter.right_ptr==null || stack.isEmpty()
////                    || stack.peek().left_ptr == iter || stack.peek().right_ptr==iter){
////                System.out.println(iter.val);
////                iter = null;
////            }else{
////                TreeNode next = stack.pop();
////                stack.push(iter);
////                iter = next;
////            }
//
//            if (iter.right_ptr != null && !stack.isEmpty()
//                    && iter.right_ptr == stack.peek()) {
//                TreeNode next = stack.pop();
//                stack.push(iter);
//                iter = next;
//            } else {
//                System.out.print(iter.val);
//                iter = null; // this was fucking key
//            }
//
//
//            start = false;
//        }
//
//    }

    // root, left, right
    // 5, 3, 1, 4, 9, 8, 10
    private static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode iter = root;
        stack.push(root);

        while(!stack.isEmpty()){
            iter = stack.pop();
            System.out.println(iter.val);
            if(iter.right_ptr!=null) {
                stack.push(iter.right_ptr);
            }
            if(iter.left_ptr!=null) {
                stack.push(iter.left_ptr);
            }
        }

    }

    // left, root, right
    //1, 3, 4, 5, 8, 9, 10
    private static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode iter = root;

        while(!stack.isEmpty() || iter!=null){
            while(iter!=null){
                stack.push(iter);
                iter = iter.left_ptr;
            }
            iter = stack.pop();
            System.out.println(iter.val);
            iter = iter.right_ptr;
        }
    }


    private static void recursive(TreeNode treeNode) {
        if (treeNode == null) return;

        recursive(treeNode.left_ptr);
        System.out.print(treeNode.val + " ");

        recursive(treeNode.right_ptr);
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

        return one;
    }

}
