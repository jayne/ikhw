package sorting.homework;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jaynehsu on 11/15/18.
 */
public class MergeKSortedArrays {
    public static void main(String[] args) {
        int arr[][] = {
                {4, 4, 7, 11, 13, 20, 26, 34},
                {0, 8, 10, 19, 23, 27, 34, 41},
                {5, 7, 7, 7, 12, 19, 25, 26},
                {9, 12, 19, 27, 33, 35, 39, 46},
                {0, 3, 10, 18, 18, 22, 24, 33},
                {9, 12, 20, 21, 30, 35, 35, 42},
                {7, 8, 12, 12, 21, 24, 33, 42},
                {7, 8, 11, 18, 18, 21, 23, 29},
                {7, 8, 14, 15, 23, 30, 30, 35},
                {4, 5, 11, 12, 16, 17, 18, 20}
        };

        mergeKSortedArrays(arr);


    }

    static void mergeKSortedArrays(int[][] arr) {
        ArrayList<Node> tree = createBaseArray(arr);

        int[] sorted = getMerged(tree, arr);

        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
        System.out.println();

    }

    static int[] getMerged(ArrayList<Node> tree, int[][] arr) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        while (tree.size() > 0) {
            result.add(tree.get(0).value);

            Node next = getNext(tree, arr);
            if (next != null) {
                tree.set(0, next);
                heapifyDown(tree, 1);
            } else {
                // swap
                tree.set(0, tree.get(tree.size()-1));
                tree.remove(tree.size()-1);
                heapifyDown(tree, 1);
            }

        }
        Integer[] wrapper = result.toArray(new Integer[result.size()]);
        int[] intArray = Arrays.stream(wrapper).mapToInt(Integer::intValue).toArray();

        return intArray;
    }

    static Node getNext(ArrayList<Node> tree, int[][] arr) {
        if (tree.get(0).index == arr[0].length - 1) {
            return null;
        }
        return new Node(
                arr[tree.get(0).arrNum][tree.get(0).index + 1],
                tree.get(0).index + 1,
                tree.get(0).arrNum);

    }

    static void heapifyDown(ArrayList<Node> tree, int index) {
        int leftChild = index * 2;
        int rightChild = index * 2 + 1;
        int smallest = index;


        if (rightChild <= tree.size() && tree.get(rightChild - 1).value < tree.get(index - 1).value) {
            smallest = rightChild;
        }

        if (leftChild <= tree.size() && tree.get(leftChild - 1).value < tree.get(smallest - 1).value) {
            smallest = leftChild;
        }

        if (smallest != index) {
            Node temp = tree.get(smallest - 1);
            tree.set(smallest - 1, tree.get(index - 1));
            tree.set(index - 1, temp);

            heapifyDown(tree, smallest);
        }

        print(tree);
        return;
    }

    static void print(ArrayList<Node> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i).value + " ");
        }
        System.out.println();
    }

    static ArrayList<Node> createBaseArray(int[][] arr) {

        ArrayList<Node> tree = new ArrayList<Node>();

        // create initial Heap
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i][0], 0, i);
            insert(tree, i, node);
        }

        return tree;
    }

    static void insert(ArrayList<Node> tree, int i, Node n) { //min at top
        tree.add(i, n);
        heapifyUp(tree, i);


    }

    static void heapifyUp(ArrayList<Node> tree, int i) {
        int parentIndex = ((i + 1) / 2) - 1;

        if (i == 0) return;

        while (tree.get(parentIndex).value > tree.get(i).value) {

            Node temp = tree.get(parentIndex);
            tree.set(parentIndex, tree.get(i));
            tree.set(i, temp);

            i = parentIndex;
            parentIndex = ((i + 1) / 2) - 1;

            if (i == 0) {
                return;
            }

        }

    }


    static class Node {
        int value;
        int index;
        int arrNum;

        Node(int value, int index, int arrNum) {
            this.value = value;
            this.index = index;
            this.arrNum = arrNum;
        }
    }

}
