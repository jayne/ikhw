package trees.youtube;

import trees.Node;

/**
 * Created by jaynehsu on 1/4/19.
 */
//O(2^k)
public class DFS {
    static Node dataSetup() {
        Node n21 = new Node(21);
        Node n23 = new Node(23);
        Node n100 = new Node(100);
        Node n8 = new Node(8);
        Node n45 = new Node(45);
        Node n30 = new Node(30);
        Node n18 = new Node(18);
        Node n180 = new Node(180);

        n21.left = n23;
        n21.right = n45;
        n23.left = n100;
        n23.right = n8;
        n45.left = n30;
        n45.right = n18;
        n30.left = n180;

        return n21;
    }

    public static void main(String[] args) {
        traverseDFS(dataSetup());
    }

    static void traverseDFS(Node n){
        if(n==null){
            return;
        }
        System.out.println(n.value);

        traverseDFS(n.left);
        traverseDFS(n.right);
    }
}
