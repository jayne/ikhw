package trees.youtube;

import trees.Node;

/**
 * Created by jaynehsu on 1/11/19.
 */
// passing down valid intervals each time <- this is key. not just checking root but the boundaries that exist before it

public class IsBTaBST {
    private static Node prepData1() { // is a BST
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

    private static Node prepData2() { //not a bst
        Node n1 = new Node(4);

        Node n2 = new Node(2);
        Node n3 = new Node(6);

        Node n4 = new Node(1);
        Node n5 = new Node(5);
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

    private static Node prepData3() { //not a bst
        Node n1 = new Node(2);

        Node n2 = new Node(2);
        Node n3 = new Node(2);

        n1.left = n2;
        n1.right = n3;

        return n1;
    }

    public static void main(String[] args) {
        Node bst = prepData1();
        boolean bstResult = isBST(bst, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(bstResult);

        Node btonly = prepData2();
        boolean btonlyResult = isBST(btonly, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(btonlyResult);

        Node btonly3 = prepData3();
        boolean btonlyResult3 = isBST(btonly3, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(btonlyResult3);


    }

    static boolean isBST(Node n, int min, int max) {
        if (n == null) {
            return true;
        }

        if (n.value <= max && n.value > min) {
            return
                    isBST(n.left, min, n.value < max ? n.value : max)
                            &&
                            isBST(n.right, n.value > min ? n.value : min, max);
        } else {
            return false;
        }

    }
}
