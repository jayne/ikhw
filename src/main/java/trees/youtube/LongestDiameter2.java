package trees.youtube;

import trees.Node;

import java.util.ArrayList;

/**
 * Created by jaynehsu on 1/12/19.
 */
public class LongestDiameter2 {

    private static Node prepData() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.right = n6;
        n5.right = n7;
        n6.left = n8;
        n6.right = n9;
        n7.left = n10;
        n8.left = n11;
        n11.right = n12;
        return n1;
    }

    public static void main(String[] args) {
        Node n = prepData(); // ans: 9
        int longestDiamater = getDiameter(n);
        System.out.println(longestDiamater);

    }

    private static int getDiameter(Node n) {
        int[] diamater = getDiameterHelper(n);
        return diamater[0];
    }

    //[0] = overall longest length thus far (could include this node or it could not)
    //[1] = longest length of one leg (could be from left or right)
    private static int[] getDiameterHelper(Node n) {
        if(n==null){
            int[] result = {0,0};
            return result;
        }

        int[] leftResult = getDiameterHelper(n.left);
        int[] rightResult = getDiameterHelper(n.right);

        int[] result = new int[2];

        result[0] = getMax(leftResult[0], rightResult[0], 1+leftResult[1]+rightResult[1]);
        result[1] = 1+ Math.max(leftResult[1], rightResult[1]);


        return result;


    }

    private static int getMax(int a, int b, int c) {
        return Math.max(a,Math.max(b,c));
    }

}
