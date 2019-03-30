package trees.youtube;

import trees.Node;

import java.util.ArrayList;

/**
 * Created by jaynehsu on 1/12/19.
 */
// at each node, they have a left and a right. return the node in the tree that has the longest path to 2 leaves (left + right)

public class LongestDiameter {

    private static Node prepData() { //
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

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.right = n6;
        n5.right = n7;
        n6.left = n8;
        n6.right = n9;
        n7.left = n10;
        n8.left = n11;
        n11.right = n12;
        return n1;
    }

    public static void main(String[] args) {
        Node n = prepData(); // ans: 9
        ArrayList<Integer> diameter = getDiameter(n);
        System.out.println("Answer" + diameter.get(0));
    }

    // [0] longest
    // [1] left-longest length
    // [2] right - longest length
    // parent picks the largest one out of the right/left
    //
    // depth and diameter

//    public static ArrayList<Integer> getDiameter(Node n){
//
//        ArrayList<Integer> result = new ArrayList<>();
//
//        if(n==null){
//            result.add(0);
//            result.add(0);
//            result.add(0);
//            return result;
//        }
//
//        System.out.println(n.value);
//
//        ArrayList<Integer> left = getDiameter(n.left);
//        int leftOnePath = left.get(1) > left.get(2) ? left.get(1) : left.get(2);
//
//        ArrayList<Integer> right = getDiameter(n.right);
//        int rightOnePath = right.get(1) > right.get(2) ? right.get(1) : right.get(2);
//
//        int diameter = getLargest(left.get(0), right.get(0), leftOnePath+rightOnePath+1);
//        result.add(diameter);
//        result.add(leftOnePath+1);
//        result.add(rightOnePath+1);
//
//        return result;
//    }

    static int getLargest(int a, int b, int c){
        if(a>=b && a>=c){
            return a;
        }else if(b>=a && b>=c){
            return b;
        }
        return c;
    }

    // diameter
    // height
    public static ArrayList<Integer> getDiameter(Node n){

        ArrayList<Integer> result = new ArrayList<>();

        if(n==null){
            result.add(0);
            result.add(0); //-1 if counting edges
            return result;
        }

        System.out.println(n.value);

        ArrayList<Integer> left = getDiameter(n.left);
        int leftOnePath = left.get(1);

        ArrayList<Integer> right = getDiameter(n.right);
        int rightOnePath = right.get(1);

        int diameter = getLargest(left.get(0), right.get(0), leftOnePath+rightOnePath+1);
        int longestPath = getLargest(0,leftOnePath+1, rightOnePath+1);
        result.add(diameter);
        result.add(longestPath);

        return result;
    }

}
