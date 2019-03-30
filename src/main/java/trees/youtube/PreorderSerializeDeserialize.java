package trees.youtube;

import trees.Node;

import java.util.Stack;

import static trees.Node.printInorder;

/**
 * Created by jaynehsu on 1/9/19.
 */
// this solution only does single numbers
public class PreorderSerializeDeserialize {
    private static Node prepData() {
        Node n1 = new Node(5);
        Node n2 = new Node(3);
        Node n3 = new Node(7);
        Node n4 = new Node(2);
        Node n5 = new Node(4);
        Node n6 = new Node(6);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        return n1;
    }

    public static void main(String[] args) {
//        String preOrder = "532..4..76...";

        Node n = prepData();
        String serialize = serialize(n);
//        System.out.println(serialize);

        Node root = deserialize(serialize);
        System.out.println("!!!!");
        printInorder(root);
    }

    private static String serialize(Node n) {
        return n == null ? "." : n.value + serialize(n.left) + serialize(n.right);
    }

    private static Node deserialize(String str) {

        Node root = null;
        Node iter = null;
        Stack<Node> stack = new Stack<>();

        int i = 0;
        boolean left = true;

        while (i < str.length()) {
            char c = str.charAt(i);

            if(root==null){ // prep work
                root = new Node(Integer.parseInt(String.valueOf(str.charAt(0))));
                iter = root;
                stack.add(root);
            }else {
                if (c != '.') {
                    iter = iter==null ? stack.pop() : iter;

                    Node node = new Node(Integer.parseInt(String.valueOf(str.charAt(i))));
                    stack.push(node);

                    if (left) {
                        iter.left = node;
                    } else {
                        iter.right = node;
                    }

                    iter = node;
                    left = true;


                } else {
                    iter = left ? stack.pop() : null;
                    left = false;

                }
            }

            i++;
        }

        return root;

    }

//    private static Node deserialize(String str) {
//
//        Node root = new Node(Integer.parseInt(String.valueOf(str.charAt(0))));
//        Node iter = root;
//        Stack<Node> stack = new Stack<>();
//        stack.add(root);
//
//        int i = 1;
//        boolean left = true;
//
//        while (i < str.length()) {
//            char c = str.charAt(i);
//
//            if (c != '.') {
//
//                if(iter==null){
//                    iter = stack.pop();
//                    left = false;
//                }
//                Node node = new Node(Integer.parseInt(String.valueOf(str.charAt(i))));
//                stack.push(node);
//
//                if(left) {
//                    iter.left = node;
//                    iter = node;
//                }else{
//                    iter.right = node;
//                    iter = node;
//                    left = true;
//                }
//
//            }else{
//                if(left){
//                    iter = stack.pop(); //peek?
//                    left = !left;
//                }else{
//                    iter = null;
//
//                }
//            }
//
//            i++;
//        }
//
//        return root;
//
//    }
}
