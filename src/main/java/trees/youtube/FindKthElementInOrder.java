package trees.youtube;

import trees.Node;

import java.util.Stack;

import static trees.Node.printInorder;

/**
 * Created by jaynehsu on 1/9/19.
 */
// alternative is to findMin. and then do successor*k
    // another alternative is pass by reference an Integer instead of using a stack
public class FindKthElementInOrder {
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
        Node n10 = new Node(2);
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
        Node n = prepData();

        printInorder(n);
        System.out.println();

        int order = 7;
        Node kth = findKthElementInOrder(n, order);
        System.out.println(order + ")" + kth.value);

    }

    static Node findKthElementInOrder(Node n, int order){
        Stack<Node> stack = new Stack();
        Node result = preOrder(n, order, stack);
        return result;
    }

    static Node preOrder(Node n, int order, Stack<Node> stack){
        if(n==null){
            return null;
        }

        Node left = preOrder(n.left, order, stack);
        stack.add(n);
        if(stack.size()==order){
            return n;
        }
        Node right = preOrder(n.right, order, stack);

        return left==null ? right : left;
    }
}
