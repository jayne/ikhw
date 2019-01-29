package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jaynehsu on 1/4/19.
 */
public class TreeNode {

    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;

    public TreeNode() {
        this.left_ptr = null;
        this.right_ptr = null;
    }

    public TreeNode(int val) {
        this.val = val;
        this.left_ptr = null;
        this.right_ptr = null;
    }


}
