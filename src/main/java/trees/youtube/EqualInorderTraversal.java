package trees.youtube;

import trees.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static trees.Node.printInorder;

/**
 * Created by jaynehsu on 1/10/19.
 */
public class EqualInorderTraversal {
    private static Node prepData() {
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(6);
        Node n4 = new Node(1);
        Node n5 = new Node(3);
        Node n6 = new Node(5);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        return n1;
    }

    private static Node prepData2() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n6.right = n7;
        n6.left = n3;
        n3.left = n2;
        n3.right = n4;
        n2.left = n1;
        n4.right = n5;
        return n6;
    }

    private static Node prepData3() {
        Node n1 = new Node(0);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n6.right = n7;
        n6.left = n3;
        n3.left = n2;
        n3.right = n4;
        n2.left = n1;
        n4.right = n5;
        return n6;
    }

    public static void main(String[] args) {
        Node n1 = prepData();
        Node n2 = prepData2();
        Node n3 = prepData3();

        boolean onetwo = isEqual(n1, n2);
        boolean onethree = isEqual(n1, n3);
        boolean twothree = isEqual(n2, n3);

        System.out.println(onetwo);
        System.out.println(onethree);
        System.out.println(twothree);

        System.out.println();
        printInorder(n1);
        System.out.println();
        printInorder(n2);
    }


    static boolean isEqual(Node n1, Node n2) {
        Stack<Node> stack1 = new Stack<>();
        Node it1 = n1;

        Stack<Node> stack2 = new Stack<>();
        Node it2 = n2;


        while ((!stack1.isEmpty() || it1 != null) && (!stack2.isEmpty() || it2 != null)) {
            while (it1 != null) {
                stack1.add(it1);
                it1 = it1.left;
            }
            it1 = stack1.pop();
            System.out.print(it1.value);
            int value1 = it1.value;
            it1 = it1.right;

            while (it2 != null) {
                stack2.add(it2);
                it2 = it2.left;
            }
            it2 = stack2.pop();
            System.out.print(it2.value);
            int value2 = it2.value;
            it2 = it2.right;

            if (value1 != value2) {
                return false;
            }

        }

        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        return false;
    }

}
