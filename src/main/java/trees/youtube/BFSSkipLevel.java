package trees.youtube;

import trees.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jaynehsu on 1/8/19.
 */
public class BFSSkipLevel {
    private static Node prepData() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        return n1;
    }

    public static void main(String[] args) {
        Node n = prepData();
        bfs(n);
    }

    private static void bfs(Node n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        int count = 1;
        boolean display = true;

        while(!queue.isEmpty()){
            Node it = queue.remove();

            if(display) {
                System.out.println(it.value);
            }

            if(it.left!=null) queue.add(it.left);
            if(it.right!=null) queue.add(it.right);

            count--;
            if(count==0){
                count = queue.size();
                display = !display;
            }

        }
    }

//    static void bfs(Node root) {
//        Queue<Node> qe = new LinkedList<>();
//
//        if(root == null) return;
//
//        qe.add(root);
//        int count = qe.size();
//
//        while(count!=0)
//        {
//            System.out.print(qe.peek().value);
//            System.out.print("  ");
//            if(qe.peek().left!=null) qe.add(qe.peek().left);
//            if(qe.peek().right!=null) qe.add(qe.peek().right);
//            qe.remove();
//            count = count -1;
//            if(count == 0 )
//            {
//                System.out.println("  ");
//                count = qe.size();
//            }
//        }
//    }
}
