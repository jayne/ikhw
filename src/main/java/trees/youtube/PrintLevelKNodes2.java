package trees.youtube;

import trees.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jaynehsu on 1/4/19.
 */
//O(nlogn)
public class PrintLevelKNodes2 {
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

    public static void main(String[] args) {
        int level = 4;
        usingDFS(buildData1(),  level);
        System.out.println();
        usingBFS(buildData1(), level);

    }

    private static void usingBFS(Node root, int level) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int currLevel = 1;


        while(!queue.isEmpty()){
            int size = queue.size();

            if(currLevel==level){
                while(!queue.isEmpty()){
                    System.out.print(queue.remove().value + " " );
                }

                System.out.println();

                return;
            }

            while(size!=0) {
                Node n = queue.remove();
                if(n.left!=null) {
                    queue.add(n.left);
                }
                if(n.right!=null) {
                    queue.add(n.right);
                }
                size--;
            }

            currLevel++;
        }
    }

    private static void usingDFS(Node root, int level) {
        int currLevel = 1;
        usingDFS(root, level, currLevel);


    }

    private static void usingDFS(Node root, int level, int currLevel) {
        if(root==null){
            return;
        }
        if(level==currLevel){
            System.out.println(root.value);
            return;
        }

        usingDFS(root.left, level, currLevel+1);
        usingDFS(root.right, level, currLevel+1);
    }
}
