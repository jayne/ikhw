package recursion.test;

/**
 * Created by jaynehsu on 1/2/19.
 */
public class DiameterOfBinaryTree {
    static class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    static Node buildData1() {
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
        Node n13 = new Node(13);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;
        n5.right = n8;
        n7.left = n9;
        n8.left = n10;
        n8.right = n11;
        n9.right = n12;
        n11.left = n13;

        return n1;
    }

    static Node buildData2(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        return n1;
    }

    public static void main(String[] args) {
        Node n = buildData1();
        int diameter = getDiameter(n);
        System.out.println("diameter: " + diameter);

        Node n2 = buildData2();
        int diameter2 = getDiameter(n2);
        System.out.println("diameter2: " + diameter2);
    }

    static int getDiameter(Node n) {

        if(n==null){
            return 0;
        }

        int leftHeight = getHeight(n.left);
        int rightHeight = getHeight(n.right);

        int leftDiameter = getDiameter(n.left);
        int rightDiameter = getDiameter(n.right);

        return getLargest(leftHeight + rightHeight+1, leftDiameter, rightDiameter);
    }

    static int getLargest(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        }
        return c;
    }

    static int getHeight(Node n) {
        if (n == null) {
            return 0;
        }

        int leftHeight = 1 + getHeight(n.left);
        int rightHeight = 1 + getHeight(n.right);

        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}
