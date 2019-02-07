package trees.hw;

import trees.Node;
import trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * Created by jaynehsu on 1/14/19.
 */
public class LeastCommonAncestor2 {

    public static void main(String[] args) {

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


        LinkedList<TreeNode> values = new LinkedList<>();
        LinkedList<Integer> levels = new LinkedList<>();
        HashMap<Integer, Integer> indexesOfFoundNode = new HashMap<>();


        traverse(one, five, four, 0, values, levels, indexesOfFoundNode);
        TreeNode result = getLCA(values, levels, five, four, indexesOfFoundNode);
        System.out.println(result.val);

    }

    private static TreeNode getLCA(LinkedList<TreeNode> values, LinkedList<Integer> levels, TreeNode a, TreeNode b, HashMap<Integer, Integer> indexesOfFoundNode) {
        int minIndex = Math.min(indexesOfFoundNode.get(a.val), indexesOfFoundNode.get(b.val));
        int maxIndex = Math.max(indexesOfFoundNode.get(a.val), indexesOfFoundNode.get(b.val));

        int min = Integer.MAX_VALUE;
        int indexOfMin = -1;

        for(int i = minIndex; i<maxIndex; i++){
            if(levels.get(i)<min){
                min = levels.get(i);
                indexOfMin = i;
            }
        }

        return indexOfMin == -1 ? null : values.get(indexOfMin);
    }

    private static boolean traverse(TreeNode root, TreeNode a, TreeNode b, int level,
                                    LinkedList<TreeNode> values, LinkedList<Integer> levels, HashMap<Integer, Integer> indexesOfFoundNode) {

        if (root.val == a.val) {
            indexesOfFoundNode.put(a.val, values.size());
        }

        if (root.val == b.val) {
            indexesOfFoundNode.put(b.val, values.size());
        }

        if(indexesOfFoundNode.size()==2){
            return true;
        }

        values.add(root);
        levels.add(level);

        if(root.left_ptr!=null) {
            boolean left = traverse(root.left_ptr, a, b, level + 1, values, levels, indexesOfFoundNode);
            if(left) return true;
            values.add(root);
            levels.add(level);
        }

        if(root.right_ptr!=null) {
            boolean right = traverse(root.right_ptr, a, b, level + 1, values, levels, indexesOfFoundNode);
            if(right) return true;
            values.add(root);
            levels.add(level);
        }

        return false;
    }



}
