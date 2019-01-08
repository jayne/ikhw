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
        Node n12 = new Node(12);
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
        List<LinkedList<Node>> paths = getPaths(n, new LinkedList<Node>(), 0, 26);
        print(paths);

//        classSolutionPrintPaths(n, new LinkedList<Node>(), 26);
    }

    static void classSolutionPrintPaths(Node n, LinkedList<Node> path, int target){
        if(n==null){
            return;
        }
        path.add(n);
        target = target-n.value;
        if(n.left == null && n.right == null && target==0){
            print(path);
            return;
        }

        classSolutionPrintPaths(n.left, path, target);
        classSolutionPrintPaths(n.right, path, target);

        path.removeLast();



    }

    static void print(LinkedList<Node> path){
        Iterator<Node> iter = path.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next().value + " ");
        }
        System.out.println();
    }

    static void print(List<LinkedList<Node>> paths) {
        for (int i = 0; i < paths.size(); i++) {
            LinkedList<Node> path = paths.get(i);
            Iterator<Node> iter = path.iterator();
            while(iter.hasNext()){
                System.out.print(iter.next().value + " ");
            }
            System.out.println();
        }

    }


    static List<LinkedList<Node>> getPaths(Node n, LinkedList path, int total, int target) {
        List list = new ArrayList<LinkedList>();
        if (n == null) {
            return list;
        }

        path.add(n);

        if (n.left == null && n.right == null) {
            if (n.value + total == target) {
                list.add((LinkedList<Node>)path.clone());
                return list;
            }
        }

        total = total + n.value;

        List<LinkedList<Node>> left = getPaths(n.left, path, total, target);
        List<LinkedList<Node>> right = getPaths(n.right, path, total, target);

        path.removeLast();

        list.addAll(left);
        list.addAll(right);

        return list;
    }


}


