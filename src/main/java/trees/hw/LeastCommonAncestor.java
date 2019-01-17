package trees.hw;

import trees.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;


/**
 * Created by jaynehsu on 1/14/19.
 */
public class LeastCommonAncestor {


    public static void main(String[] args) {
        tc1(); // 5
        tc2(); // 1
//        tc3(); // stack overflow error..not sure how to fix

    }

    private static void tc2() {
        Node root = new Node(1);
        Node n2 = new Node(2);
        root.left = n2;

        int lca = pickLca(root, n2, root);
        System.out.println(lca);

    }

    private static void tc3() {
        Node root = new Node(1);
        Node iter = root;
        for (int i = 2; i <= 97263; i++) {
            Node next = new Node(i);
            iter.left = next;
            iter = next;
        }
        Node toTest = iter;

        for (int i = 97264; i <= 100000; i++) {
            Node next = new Node(i);
            iter.left = next;
            iter = next;
        }

//        System.out.println(root.value);
//        System.out.println(toTest.value);
//        System.out.println(iter.value);

        pickLca(root, toTest, iter);


    }

    private static void tc1() {
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);


        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.right = n9;
        n5.left = n8;


        int lca = pickLca(root, n8, n9);
        System.out.println(lca);
    }

    static int pickLca(Node head, Node a, Node b) {
//        return lcaCountLevels(head, a, b);
//        return mylca(head, a, b);
        return mlcaNodes(head, a, b);


    }

    private static int mlcaNodes(Node head, Node a, Node b) {
        Node alist = new Node(head.value);
        Node blist = new Node(head.value); // a little hacky. the head value is duplicated in the list


        traverse(head, a, alist);
        traverse(head, b, blist);

        int i = 0;
        int num = -1;
        while(alist!=null && blist!=null && alist.value==blist.value){
            num = alist.value;

            alist = alist.left;
            blist = blist.left;

        }

        return num;

}

    private static boolean traverse(Node root, Node a, Node list) {

        Node possible = new Node(root.value);
        list.left = possible;

        if (a == root) {
            return true;
        }

        if (root.left!=null && traverse(root.left, a, list.left)) {
            return true;
        }
        if (root.right!=null && traverse(root.right, a, list.left)) {
            return true;
        }

        list.left = null;

        return false;
    }


    private static int lcaCountLevels(Node head, Node a, Node b) {
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> levels = new ArrayList<>();
        HashMap<Integer, Integer> indexes = new HashMap<>();

        if (traverseStoreLevels(head, a, b, values, levels, 0, indexes)) {
            int start = Math.min(indexes.get(a.value), indexes.get(b.value));
            int end = Math.max(indexes.get(a.value), indexes.get(b.value));
            int minLevel = Integer.MAX_VALUE;
            int index = -1;

            while (start <= end) {
                if (levels.get(start) < minLevel) {
                    minLevel = levels.get(start);
                    index = start;
                }
                start++;
            }
            return values.get(index);


        }
        return -1;


    }

    private static void print(ArrayList<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            System.out.print(values.get(i) + " ");
        }
        System.out.println();
    }

    private static boolean traverseStoreLevels(Node head, Node a, Node b, ArrayList<Integer> values, ArrayList<Integer> levels, int level, HashMap<Integer, Integer> indexes) {

        System.out.println(head.value);
        values.add(head.value);
        levels.add(level);

        if (head.value == a.value || head.value == b.value) {
            indexes.put(head.value, levels.size() - 1);
            if (indexes.size() == 2) {
                return true;
            }
        }

        if (head.left != null) {
            if (traverseStoreLevels(head.left, a, b, values, levels, level + 1, indexes)) {
                return true;
            }
            values.add(head.value);
            levels.add(level);
        }
        if (head.right != null) {
            if (traverseStoreLevels(head.right, a, b, values, levels, level + 1, indexes)) {
                return true;
            }
            values.add(head.value);
            levels.add(level);
        }
        return false;

    }


    static int mylca(Node head, Node a, Node b) {
        LinkedList<Integer> alist = new LinkedList<>();
        traverse(head, a, alist);
        LinkedList<Integer> blist = new LinkedList<>();
        traverse(head, b, blist);

        if (alist.size() >= 1 && blist.size() >= 1) {
            int common = alist.get(0);

            for (int i = 0; i < alist.size(); i++) {
                if (i < alist.size() && i < blist.size()) {
                    if (alist.get(i) != blist.get(i)) {
                        return common;
                    }
                    common = alist.get(i);
                }
            }

            return common;
        }

        return -1;
    }

    private static boolean traverse(Node root, Node a, LinkedList<Integer> ll) {
        if (root == null) {
            return false;
        }


//        System.out.println(root.value);
        ll.add(root.value);

        if (a == root) {
            return true;
        }

        if (traverse(root.left, a, ll)) {
            return true;
        }
        if (traverse(root.right, a, ll)) {
            return true;
        }

        ll.removeLast();
        return false;
    }


}
