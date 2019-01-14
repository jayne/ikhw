package trees.hw;

import trees.Node;

/**
 * Created by jaynehsu on 1/10/19.
 */
//https://crazycoderzz.wordpress.com/count-the-number-of-unival-subtrees-in-a-binary-tree/
// https://www.geeksforgeeks.org/find-count-of-singly-subtrees/


public class SingleValueTrees {
    private static Node prepData() {
        Node n1 = new Node(5);
        Node n2 = new Node(5);
        Node n3 = new Node(5);
        Node n4 = new Node(5);
        Node n5 = new Node(5);
        Node n6 = new Node(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        return n1;
    }

    private static Node prepData2() {
        Node n1 = new Node(5);
        Node n2 = new Node(4);
        Node n3 = new Node(5);
        Node n4 = new Node(4);
        Node n5 = new Node(4);
        Node n6 = new Node(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        return n1;
    }
    public static void main(String[] args) {
        Node n = prepData();
        int result = findSingleValueTrees(n);
        System.out.println(result);

    }

    static int findSingleValueTrees(Node n) {
        if(n==null){
            return 0;
        }

        int left = findSingleValueTrees(n.left);
        int right = findSingleValueTrees(n.right);

        if((n.right!=null && n.right.value!=n.value) || (n.left!=null && n.left.value!=n.value)){
           return left+right;
        }
        return 1 + left+right;

    }


}
