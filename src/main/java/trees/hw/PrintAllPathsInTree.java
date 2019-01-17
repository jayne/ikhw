package trees.hw;

import trees.Node;

import java.util.LinkedList;

/**
 * Created by jaynehsu on 1/14/19.
 */
//https://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
public class PrintAllPathsInTree {
    public static void main(String[] args) {
        Node root = prepData();
        traverse(root, new LinkedList<Integer>());
    }

    private static Node prepData() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;

        return one;
    }

    private static void traverse(Node n, LinkedList<Integer> list){

        list.add(n.value);
        if(n.left==null & n.right==null)
        {
            for(int i = 0; i<list.size(); i++){
                System.out.print(list.get(i));
            }
            System.out.println();
            return;
        }


        traverse(n.left, list);
        list.removeLast();

        traverse(n.right, list);
        list.removeLast();

    }
}
