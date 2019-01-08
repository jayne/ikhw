package trees.teachable;

import trees.Node;

/**
 * Created by jaynehsu on 1/5/19.
 */
public class Orders {
    public static void main(String[] args) {
        Node n = prepData();

        System.out.println("in order");
        printInOrder(n);
        System.out.println("\n\npre order");
        printPreOrder(n);
        System.out.println("\n\npost order");
        printPostOrder(n);
    }

    // LEFT, RIGHT, ROOT
    private static void printPostOrder(Node n) {
        if(n==null){
            return;
        }
        printPostOrder(n.left);
        printPostOrder(n.right);
        System.out.print(n.value);

    }

    // ROOT, LEFT, RIGHT
    private static void printPreOrder(Node n) {
        if(n==null){
            return;
        }
        System.out.print(n.value);
        printPreOrder(n.left);
        printPreOrder(n.right);
    }

    // LEFT, ROOT, RIGHT
    static void printInOrder(Node n){
        if(n==null){
            return;
        }

        printInOrder(n.left);
        System.out.print(n.value);
        printInOrder(n.right);
    }

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
}
