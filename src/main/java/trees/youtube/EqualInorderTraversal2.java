package trees.youtube;

import trees.Node;

import java.util.Stack;

import static trees.Node.printInorder;

/**
 * Created by jaynehsu on 1/10/19.
 */
public class EqualInorderTraversal2 {
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

        Node n8 = new Node(8);

        n6.right = n7;
        n6.left = n3;
        n3.left = n2;
        n3.right = n4;
        n2.left = n1;
        n4.right = n5;
//        n7.right = n8;
        return n6;
    }

    public static void main(String[] args) {
        boolean isEqual = isEqual(prepData(), prepData2());
        System.out.println(isEqual);
//        inOrder(prepData());
    }

    private static boolean inOrder(Node root) {
        Stack<Node> stack1 = new Stack();
        Node iter = root;

        while (!stack1.isEmpty() || iter != null) {

            while (iter != null) {
                stack1.push(iter);
                iter = iter.left;
            }

            iter = stack1.pop();
            System.out.println(iter.value);

            iter = iter.right;


        }


        return true;
    }

    private static boolean isEqual(Node n1, Node n2) {

        Stack<Node> stack1 = new Stack<>();
        Node iter1 = n1;

        Stack<Node> stack2 = new Stack<>();
        Node iter2 = n2;

        while ((!stack1.isEmpty() || iter1 != null) && (!stack2.isEmpty() || iter2!=null)) {
            while (iter1 != null) {
                stack1.push(iter1);
                iter1 = iter1.left;
            }
            Node next1 = stack1.pop();
            System.out.println(next1.value);
            int value1 = next1.value;
            iter1 = next1.right;

            while(iter2!=null){
                stack2.push(iter2);
                iter2 = iter2.left;
            }
            Node next2 = stack2.pop();
            System.out.println(next2.value);
            int value2 = next2.value;
            iter2 = next2.right;

            if(value1!=value2){
                return false;
            }

        }

        if(!stack1.isEmpty() || iter1 != null || !stack2.isEmpty() || iter2!=null){
            return false;
        }

        return true;
    }

}
