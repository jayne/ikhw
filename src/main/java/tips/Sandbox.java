package tips;

import trees.Node;

import java.util.*;

import static trees.Node.printTree;

/**
 * Created by jaynehsu on 12/10/18.
 */


public class Sandbox {
    private static Node prepData() {
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

    private static Node prepData2() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n6.right = n7;
        n6.left = n3;
        n3.left = n2;
        n3.right = n4;
        n2.left = n1;
        n4.right = n5;
        return n6;
    }

    public static void main(String[] args) {
        boolean isEqual = isEqual(prepData(), prepData2());
    }

    private static boolean isEqual(Node n1, Node n2) {

        Stack<Node> stack1 = new Stack<>();
        boolean start = true;
        Node iter = n1;
        stack1.push(iter);


        while(!stack1.isEmpty() || start){
            iter = stack1.pop();
            while(iter!=null){
                stack1.push(iter);
                iter = iter.left;
            }
            Node next1 = stack1.pop();
            System.out.println(next1.value);
            if(next1.right!=null){
                stack1.push(next1.right);
            }

            start = false;
        }



        return false;
    }

}




