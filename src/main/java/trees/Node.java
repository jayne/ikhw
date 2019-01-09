package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jaynehsu on 1/4/19.
 */
public class Node {
    public Node left;
    public Node right;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    public static void printTree(Node n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        int count = 1;

        while (!queue.isEmpty()) {
            Node it = queue.remove();

            System.out.print(it.value);

            if (it.left != null) queue.add(it.left);
            if (it.right != null) queue.add(it.right);

            count--;
            if (count == 0) {
                System.out.println();
                count = queue.size();
            }

        }
    }

    public static void printInorder(Node n){
        if(n==null) return;

        printInorder(n.left);
        System.out.print(n.value + " ");
        printInorder(n.right);

    }


}
