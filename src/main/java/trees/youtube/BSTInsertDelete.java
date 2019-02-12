package trees.youtube;

import trees.Node;

import java.util.Stack;

import static trees.Node.printInorder;
import static trees.Node.printTree;

/**
 * Created by jaynehsu on 1/8/19.
 */
// I use a stack to keep track of what the Parent is
// In real life, I should've just updated Node class to store parent information to save myself from extra traversals
public class BSTInsertDelete {
    private static Node prepData() {
        Node n1 = new Node(5);
        Node n2 = new Node(2);
        Node n3 = new Node(9);
        Node n4 = new Node(1);
        Node n5 = new Node(3);
        Node n6 = new Node(7);
        Node n7 = new Node(12);

        Node n8 = new Node(0);
        Node n9 = new Node(2);
        Node n10 = new Node(3);
        Node n11 = new Node(4);
        Node n12 = new Node(6);
        Node n13 = new Node(8);
        Node n14 = new Node(10);
        Node n15 = new Node(15);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;
        n5.left = n10;
        n5.right = n11;
        n6.left = n12;
        n6.right = n13;
        n7.left = n14;
        n7.right = n15;

        return n1;
    }


    public static void main(String[] args) {
//        doInsert();
        doSuccessor();
//        doDelete();
    }

    static void printStack(Stack<Node> stack) {
        System.out.println();
        System.out.print("STACK: ");
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i).value);
        }
        System.out.println();
    }


    static void doDelete() {
        Node n = prepData();

        printInorder(n);
        System.out.println();
        printTree(n);

        Stack<Node> stack = new Stack();
        int value = 9;


        Node found = findNode(n, value, stack);
        Node parent = stack.pop();

        if (found.left == null && found.right == null) {
            if (parent.left == found) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return;
        }

        if (found.left == null || found.right == null) {
            Node child = found.left == null ? found.right : found.left;
            if (parent.left == found) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            return;
        }

        Node successor = findSuccessor(stack, found);
        Stack<Node> successorStack = new Stack<>();
        findNode(n, successor.value, successorStack);
        Node successorParent = successorStack.pop();

        found.value = successor.value;
        if(successorParent.left == successor){
            successorParent.left = null;
        }else{
            successorParent.right = null;
        }

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
        printInorder(n);
        System.out.println();
        printTree(n);



    }


    static void doSuccessor() {
        Node n = prepData();

        int value = 7;
        Node successor = getSuccessor(n, value);
        printInorder(n);
        System.out.println("Successor of " + value + " is " + successor.value);
        printTree(n);

    }

    static Node getSuccessor(Node n, int value) {
        Stack<Node> stack = new Stack();

        Node found = findNode(n, value, stack);
        Node successor = findSuccessor(stack, found);

        return successor;
    }

    static Node findSuccessor(Stack<Node> stack, Node n) {
        if (n.right != null) {
            Node it = n.right;
            while (it.left != null) {
                it = it.left;
            }

            return it;
        }

        Node it = n;
        Node parent = stack.pop();

        if (parent.left == it) {
            return parent.left;
        }

        while (parent.right == it) {
            it = parent;
            if (stack.isEmpty()) {
                return null;
            }
            parent = stack.pop();
        }
        return parent;

    }


    static Node findNode(Node n, int value, Stack stack) {
        if (n == null) {
            return null;
        }
        if (n.value == value) {
            return n;
        }
        stack.add(n);

        Node found = null;
        if (value <= n.value) {
            found = findNode(n.left, value, stack);
        } else {
            found = findNode(n.right, value, stack);
        }

        return found;

    }

    static void doInsert() {
        Node n = prepData();

        int value = 4;
        insert(n, value);
        printInorder(n);
        System.out.println();
        printTree(n);
    }

    static Node insert(Node n, int value) {
        if (n == null) {
            return new Node(value);
        }

        int rootValue = n.value;
        if (value <= rootValue) {
            n.left = insert(n.left, value);
        } else {
            n.right = insert(n.right, value);
        }

        return n;
    }
}
