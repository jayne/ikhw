package trees.test;

import java.util.Vector;

/**
 * Created by jaynehsu on 1/16/19.
 */
public class FindHeightOfTree {
    static class TreeNode {
        Vector<TreeNode> vec = new Vector<TreeNode>(0);

        TreeNode() {
            vec.clear();
        }
    }

    ;

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode();
        TreeNode t2 = new TreeNode();
        TreeNode t3 = new TreeNode();
        TreeNode t4 = new TreeNode();
        TreeNode t5 = new TreeNode();
        TreeNode t6 = new TreeNode();
        TreeNode t7 = new TreeNode();
        TreeNode t8 = new TreeNode();
        TreeNode t9 = new TreeNode();

        t1.vec.add(t2);
        t1.vec.add(t3);
        t1.vec.add(t4);

        t2.vec.add(t5);
        t2.vec.add(t6);

        t5.vec.add(t7);
        t5.vec.add(t8);
        t5.vec.add(t9);

        int height = find_height(t1);
        System.out.println(height);

    }

    static int find_height(TreeNode root) {
        int max = 0;
        for (TreeNode t : root.vec) {
            int childHeight = find_height(t);
            max = Math.max(max, childHeight);

        }

        if(root.vec.size()==0){
            return 0;
        }

        return max+1;
    }
}
