package trees.youtube;

import trees.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jaynehsu on 1/7/19.
 */
public class OrdersNoRecursion {

    private static Node prepData() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        return n1;
    }

    public static void main(String[] args) {
        Node n = prepData();

        System.out.println("in order");
        printInOrder(n);
        System.out.println("\n\npre order");
        printPreOrder(n);
        System.out.println("\n\npost order");
        printPostOrder(n);
        System.out.println("\n\npost order w/ one stack");
        printPostOrderOneStack(n);

    }

    // left, root, right 4251637
    private static void printInOrder(Node n) {
        Stack<Node> stack = new Stack<>();
        Node it = n;

        while (!stack.isEmpty() || it != null) {
            while (it != null) {
                stack.add(it);
                it = it.left;
            }
            it = stack.pop();
            System.out.print(it.value);

            it = it.right;


        }

    }

    // root, left, right 1245367
    private static void printPreOrder(Node n) {

        Stack<Node> stack = new Stack<>();
        stack.push(n);

        while (!stack.isEmpty()) {
            Node it = stack.pop();

            System.out.print(it.value);

            if (it.right != null) {
                stack.push(it.right);
            }
            if (it.left != null) {
                stack.push(it.left);
            }

        }


    }

    // left, right, root 4526731
    private static void printPostOrder(Node n) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> rootStack = new Stack<>();

        stack.push(n);

        while (!stack.isEmpty()) {
            Node it = stack.pop();
            rootStack.push(it);

            if (it.left != null) {
                stack.push(it.left);
            }
            if (it.right != null) {
                stack.push(it.right);
            }
        }

        while (!rootStack.isEmpty()) {
            Node print = rootStack.pop();
            System.out.print(print.value);
        }

    }

    // left, right, root 4526731
    private static void printPostOrderOneStack(Node n) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> rootStack = new Stack<>();

        Node it = n;
        boolean start = true;

        while (!stack.isEmpty() || start) {
            while (it != null) {
                if (it.right != null) {
                    stack.push(it.right);
                }
                stack.push(it);
                it = it.left;
            }

            it = stack.pop();


            if (it.right != null && it.right == (stack.isEmpty() ? null : stack.peek())) {
                Node next = stack.pop();
                stack.push(it);
                it = next;
            } else {
                System.out.print(it.value);
                it = null; // this was fucking key
            }
            start = false;

        }
    }

    // post order with no stacks. check morris traversal. i did not implement

}
