package trees.hw;

import trees.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import static trees.Node.printInorder;

/**
 * Created by jaynehsu on 1/14/19.
 */
public class MergeTwoBST2 {
    static class Node{

        Node left;
        Node right;
        int key;

        Node(int key) {
            this.left = null;
            this.right = null;
            this.key = key;
        }

    }




    public static void main(String[] args) {
        Node result = mergeTwoBSTs(prepData1(), prepData2());
        System.out.println("hi");

    }
    public static Node mergeTwoBSTs(Node one, Node two) {
        LinkedList<Node> oneList = convertToList(one);
        LinkedList<Node> twoList = convertToList(two);

        LinkedList<Node> finalList = mergeSort(oneList, twoList);

        return makeTree(finalList, 0, finalList.size()-1);
    }

    private static LinkedList<Node> convertToList(Node root) {
        LinkedList<Node> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        result.addAll(convertToList(root.left));
        result.add(root);
        result.addAll(convertToList(root.right));

        return result;

    }

    private static Node makeTree(LinkedList<Node> finalList, int start, int end) {
        if(start>end){
            return null;
        }
        int midIndex = (start+end)/2;

        Node root = finalList.get(midIndex);
        root.left = makeTree(finalList, start, midIndex-1);
        root.right = makeTree(finalList, midIndex+1, end);

        return root;
    }

    private static LinkedList<Node> mergeSort(LinkedList<Node> oneList, LinkedList<Node> twoList) {

        int i = 0;
        int j = 0;

        LinkedList<Node> result = new LinkedList<>();

        while (i < oneList.size() && j < twoList.size()) {
            if(oneList.get(i).key <=twoList.get(j).key){
                result.add(oneList.get(i));
                i++;
            }else{
                result.add(twoList.get(j));
                j++;
            }
        }

        while(i<oneList.size()){
            result.add(oneList.get(i++));
        }
        while(j<twoList.size()){
            result.add(twoList.get(j++));
        }

        return result;
    }

    private static Node prepData2() {
        Node one = new Node(2);
        Node two = new Node(0);
        Node three = new Node(3);

        one.left = two;
        one.right = three;

        return one;
    }

    private static Node prepData1() {
        Node one = new Node(5);
        Node two = new Node(3);
        Node three = new Node(9);
        Node four = new Node(1);
        Node five = new Node(4);
        Node six = new Node(8);
        Node seven = new Node(10);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        return one;
    }



}
