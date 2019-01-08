package trees.youtube;

import trees.Node;

import java.util.LinkedList;

/**
 * Created by jaynehsu on 1/4/19.
 */
//O(nlogn)
public class PrintLevelKNodes {
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
        usingDFS(buildData1(), 1, 4);
        System.out.println();
        usingBFS(buildData1(), 4);
    }

    static void usingBFS(Node n, int target) {
        //TODO: continue here
        LinkedList<Node> queue = new LinkedList<>();
        int width = 1;

        queue.add(n);
        queue.add(null);

        while (queue.size() != 1) {
            Node node = queue.remove();
            if(node==null){
                target--;
                if(target==1){
                    break;
                }

                node=queue.remove();
                queue.add(null);
            }

            if (node.left != null) {
                queue.add(node.left);
                width++;
            }

            if (node.right != null) {
                queue.add(node.right);
                width++;
            }

        }

        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i).value + " ");
        }
        System.out.println();
    }

    static void usingDFS(Node n, int level, int target) {
        if (n == null) {
            return;
        }

        if (level == target) {
            System.out.print(n.value + " ");
        }

        usingDFS(n.right, level + 1, target);
        usingDFS(n.left, level + 1, target);

    }
}
