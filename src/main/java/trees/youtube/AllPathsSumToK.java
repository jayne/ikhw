package trees.youtube;

import trees.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jaynehsu on 1/4/19.
 */


public class AllPathsSumToK {

    static Node buildData1() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(3);
        Node n13 = new Node(13);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;
        n5.right = n8;
        n7.left = n9;
        n8.left = n10;
        n8.right = n11;
        n9.right = n12;
        n11.left = n13;

        return n1;
    }

    public static void main(String[] args) {
        Node n = buildData1();
        int k = 26;

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = getPaths(n, k, path);

        print(paths);
    }

    private static void print(List<List<Integer>> paths) {
        for (List<Integer> l : paths) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    private static List getPaths(Node n, int k, List<Integer> path) {
        List<List<Integer>> result = new ArrayList<>();

        if (n == null) {

            return result;
        }

        k = k - n.value;
        path.add(n.value);

        if (n.left == null && n.right == null && k == 0) {
            List onePath = new ArrayList();
            onePath.addAll(path);
            result.add(onePath);
            path.remove(path.size() - 1);
            return result;
        }


        List<List<Integer>> left = getPaths(n.left, k, path);
        List<List<Integer>> right = getPaths(n.right, k, path);

        path.remove(path.size() - 1);

        result.addAll(left);
        result.addAll(right);
        return result;
    }

}


