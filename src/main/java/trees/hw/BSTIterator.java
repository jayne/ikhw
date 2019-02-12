package trees.hw;

import trees.TreeNode;

import java.util.Stack;

/**
 * Created by jaynehsu on 2/7/19.
 */
public class BSTIterator {

    public static void main(String[] args) {
        TreeNode root = prepData();
        BSTIterator iterator = new BSTIterator(root);


        iterator.next();    // return 3
        iterator.next();    // return 7
        iterator.hasNext(); // return true
        iterator.next();    // return 9
        iterator.hasNext(); // return true
        iterator.next();    // return 15
        iterator.hasNext(); // return true
        iterator.next();    // return 20
        iterator.hasNext(); // return false
    }

    private static TreeNode prepData() {
        TreeNode root = new TreeNode(7);
        TreeNode t3 = new TreeNode(3);
        TreeNode t15 = new TreeNode(15);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);

        root.left_ptr = t3;
        root.right_ptr = t15;

        t15.left_ptr = t9;
        t15.right_ptr = t20;
        return root;
    }

    TreeNode root;
    Stack<TreeNode> stack = new Stack<>();


    ////////////////////////////////////////////////

    public BSTIterator(TreeNode root) {
        this.root = root;
        addToStack(root);
    }

    private void addToStack(TreeNode root) {
        this.stack.add(root);

        TreeNode iter = root.left_ptr;
        while(iter!=null){
            this.stack.push(iter);
            iter = iter.left_ptr;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode nextNode = stack.pop();

        if(nextNode.right_ptr!=null){
            addToStack(nextNode.right_ptr);
        }

        System.out.println(nextNode.val);
        return nextNode.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {

        System.out.println( !stack.isEmpty());
        return !stack.isEmpty();
    }
}
