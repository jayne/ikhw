package trees.youtube;

import trees.Node;

import static trees.Node.printTree;

/**
 * Created by jaynehsu on 1/8/19.
 */
public class CloneTreeToDoubleSize {
    private static Node prepData() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
//        Node n4 = new Node(4);
//        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        return n1;
    }

    public static void main(String[] args) {
        Node n = prepData();
        doubleTree(n);
        printTree(n);
    }

    // making a copy of each node to the left
    static void doubleTree(Node n){
        if(n==null){
            return;
        }

        Node copy = new Node(n.value);

        doubleTree(n.left);
        doubleTree(n.right);

        Node tempLeft = n.left;
        n.left = copy;
        copy.left = tempLeft;
    }

}
