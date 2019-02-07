package trees.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jaynehsu on 2/1/19.
 */
public class PopulateSiblingPointers {

    public static void main(String[] args) {
//        mySln();
        bestSln(prepData2());
    }

    // my solution uses eulers method
    private static void mySln() {
        ArrayList<TreeNode> tns = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        TreeNode root = prepData2();

        populateEuler(root, tns, values, 0);
        populateSiblingPtrs(tns, values);

        System.out.println("hi");
    }

    private static void populateSiblingPtrs(ArrayList<TreeNode> tns, ArrayList<Integer> values) {
        HashMap<Integer, TreeNode> tracker = new HashMap<>();

        for (int i = 0; i < tns.size(); i++) {
            int level = values.get(i);
            TreeNode tn = tns.get(i);

            if (tracker.get(level) == null) {
                tracker.put(level, tn);
            } else if (tracker.get(level) != tn) {
                tracker.get(level).nextRight = tn;
                tracker.put(level, tn);
            }
        }


    }

    private static void populateEuler(TreeNode root, ArrayList<TreeNode> tns, ArrayList<Integer> values, int level) {
        tns.add(root);
        values.add(level);

        if (root.left_ptr != null) {
            populateEuler(root.left_ptr, tns, values, level + 1);
            tns.add(root);
            values.add(level);
        }

        if (root.right_ptr != null) {
            populateEuler(root.right_ptr, tns, values, level + 1);
            tns.add(root);
            values.add(level);
        }

    }

    private static class TreeNode {
        int data;
        TreeNode left_ptr, right_ptr;
        TreeNode nextRight;

        public TreeNode(int item) {
            data = item;
            left_ptr = right_ptr = null;
            nextRight = null;
        }
    }

    private static TreeNode prepData2() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.left_ptr = two;
        one.right_ptr = three;
        two.left_ptr = four;
        two.right_ptr = five;
        three.left_ptr = six;
        three.right_ptr = seven;

        return one;
    }

    public static void bestSln(TreeNode n) {
        Queue<TreeNode> toPrint = new LinkedList<>();
        toPrint.add(n);

        while(!toPrint.isEmpty()){
            TreeNode prev = null;
            int size = toPrint.size();

            while(size!=0){
                TreeNode iter = toPrint.remove();
                if(prev==null){
                    prev = iter;
                }else{
                    prev.nextRight = iter;
                    prev = iter;
                }
                System.out.print(iter.data + " ");
                if(iter.left_ptr!=null) toPrint.add(iter.left_ptr);
                if(iter.right_ptr!=null) toPrint.add(iter.right_ptr);
                size--;
            }
            System.out.println();
        }
    }

    public static void KEYprintTree(TreeNode n) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(n);
        int count = 1;

        while (!queue.isEmpty()) {
            TreeNode it = queue.remove();

            System.out.print(it.data);

            if (it.left_ptr != null) queue.add(it.left_ptr);
            if (it.right_ptr != null) queue.add(it.right_ptr);

            count--;
            if (count == 0) {
                System.out.println();
                count = queue.size();
            }

        }
    }
}
