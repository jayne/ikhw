package trees.hw;

import trees.Node;

import static trees.Node.printInorder;

/**
 * Created by jaynehsu on 1/14/19.
 */
// this problem is tricky because the root you return is not the one you attach to. you have to traverse (hence the while)
public class UpsideDown {
    public static void main(String[] args) {
        Node n1 = prepData1();
        Node n2 = prepData2();
        Node result = turnUpsideDown(n2);

        printInorder(result);
    }

//    private static Node turnUpsideDown(Node n1) {
//
//        if (n1.left == null && n1.right == null) {
//            return n1;
//        }
//
//        Node root = n1;
//        Node left = n1.left;
//        Node right = n1.right;
//
//        root.left = null;
//        root.right = null;
//
//        Node newRoot = turnUpsideDown(left);
//        Node toAttach = newRoot;
//        while(toAttach!=null && toAttach.right!=null) {
//            toAttach = toAttach.right;
//        }
//        toAttach.left = right;
//        toAttach.right = root;
//
//        return newRoot;
//
//    }

    private static Node turnUpsideDown(Node n1) {

        if (n1.left == null && n1.right == null) {
            return n1;
        }

        Node root = n1;
        Node left = n1.left;
        Node right = n1.right;

        root.left = null;
        root.right = null;

        Node newRoot = turnUpsideDown(left);
        Node toAttach = newRoot;
        while(toAttach!=null && toAttach.right!=null) {
            toAttach = toAttach.right;
        }
        toAttach.left = right;
        toAttach.right = root;

        return newRoot;

    }

    private static Node prepData1() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        one.left = two;
        one.right = three;

        return one;
    }

    private static Node prepData2() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        four.left = six;
        four.right = seven;

        return one;
    }


}
