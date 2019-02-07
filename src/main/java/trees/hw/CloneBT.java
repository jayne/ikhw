package trees.hw;

import trees.Node;

/**
 * Created by jaynehsu on 2/1/19.
 */
public class CloneBT {
    public static void main(String[] args) {
        Node original = prepData2();
        Node cloned = cloneTree(original);

        System.out.println("hi");
    }

    static Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }

        Node newRoot = new Node(root.value);
        newRoot.left = cloneTree(root.left);
        newRoot.right = cloneTree(root.right);

        return newRoot;
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
