package trees.hw;

import trees.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.stream.Collectors;

import static trees.Node.printInorder;

/**
 * Created by jaynehsu on 1/14/19.
 */
public class MergeTwoBST {
    public static void main(String[] args) {
        Node one = prepData1();
        Node two = prepData2();

        Node result = mergeTwoBSTs(one, two);
        System.out.println(result.value);
        System.out.println("tst");
        printInorder(result);

    }

    private static Node prepData1() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(13);

        one.right = two;
        two.right = three;

        return one;
    }

    private static Node prepData2() {
        Node seven = new Node(7);
        Node six = new Node(6);
        Node eight = new Node(8);

        seven.left = six;
        seven.right = eight;

        return seven;
    }

    public static Node mergeTwoBSTs(Node root1, Node root2) {
        ArrayList<Integer> oneList = new ArrayList<>();
        inOrder(root1, oneList);
        ArrayList<Integer> twoList = new ArrayList<>();
        inOrder(root2, twoList);

        ArrayList<Integer> mergedList = mergeLists(oneList, twoList);

        Node result = convertTree(mergedList, 0, mergedList.size());

        return result;
    }

    private static Node convertTree(ArrayList<Integer> mergedList, int start, int end) {
        if(end-start==1){
            return new Node(mergedList.get(start));
        }else if(end-start==0){
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(mergedList.get(mid));


        root.left = convertTree(mergedList,start, mid);
        root.right = convertTree(mergedList, mid+1, end);

        return root;

    }

    private static ArrayList<Integer> mergeLists(ArrayList<Integer> oneList, ArrayList<Integer> twoList) {
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(oneList);
        result.addAll(twoList);

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : 1;
            }
        };
        result.sort(c);

        return result;
    }

    private static void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.value);
        inOrder(root.right, list);
    }


}
