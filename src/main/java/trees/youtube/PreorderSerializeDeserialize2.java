package trees.youtube;

import trees.Node;

import java.util.Stack;

import static trees.Node.printInorder;

/**
 * Created by jaynehsu on 1/9/19.
 */
public class PreorderSerializeDeserialize2 {
    private static Node prepData() {
        Node n1 = new Node(5);
        Node n2 = new Node(3);
        Node n3 = new Node(17);
//        Node n4 = new Node(2);
        Node n5 = new Node(4);
        Node n6 = new Node(16);


        n1.left = n2;
        n1.right = n3;
//        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        return n1;

        //5 3 2 . . 4 . . 17 16 . . .
    }

    public static void main(String[] args) {

        Node n = prepData();
        String serialize = serialize(n);
        System.out.println(serialize);

        Node root = deserialize(serialize);
        System.out.println("\tNow printing in order : ");
        printInorder(root);
    }

    private static Node deserialize(String serialize) {
        String[] arr = serialize.split(" ");

        return deserializeHelper(arr, 0, arr.length-1);

    }

    private static Node deserializeHelper(String[] arr, int start, int end) {
        //base case of 1
        if(start==end){
            return null;
        }
        // base case of 3
        if(end-start==2){
            return new Node(Integer.valueOf(arr[start]));
        }

        Node root = new Node(Integer.valueOf(arr[start]));
        int mid = getMid(arr, start, end);

        root.left = deserializeHelper(arr, start+1, mid-1);
        root.right = deserializeHelper(arr, mid, end);

        return root;
    }

    private static int getMid(String[] arr, int start, int end) {
        int position = start;
        while(position<end){
            String element = arr[position];
            if(!element.equals(".") && Integer.valueOf(arr[position])>Integer.valueOf(arr[start])){
                return position;
            }
            position++;
        }
        return position;
    }


    // root, left, right
    private static String serialize(Node n) {
        return n==null ? "." : n.value + " " + serialize(n.left) + " " + serialize(n.right);
    }
}
