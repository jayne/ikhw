package graphs.lecture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by jaynehsu on 11/15/18.
 */
public class Traversal {

    static class Node{
        int num;
        ArrayList<Node> toNeighbor = new ArrayList();

        Node(int num){
            this.num = num;
        }

        void addToNeighbor(Node n){
            toNeighbor.add(n);
        }
    }

    static Node dataSetup(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node (4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        one.addToNeighbor(two);
        one.addToNeighbor(three);
        two.addToNeighbor(four);
        three.addToNeighbor(four);
        four.addToNeighbor(five);
        four.addToNeighbor(six);
        five.addToNeighbor(seven);
        six.addToNeighbor(seven);

        return one;

    }


    public static void main(String[] args) {
//        dfs(dataSetup(), new HashSet<Node>());
        bfs(dataSetup(), new LinkedList<Node>());
    }

    static void bfs(Node n, LinkedList<Node> queue){
        HashSet<Node> visited = new HashSet<Node>();

        System.out.println(n.num);
        visited.add(n);
        for(Node neighbor: n.toNeighbor){
            queue.add(neighbor);
        }

        while(!queue.isEmpty()){
            Node next = queue.remove();
            visited.add(next);
            System.out.println(next.num);
            for(Node neighbor: next.toNeighbor){
                if(!visited.contains(neighbor) && !queue.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

    }

    static void dfs(Node n, HashSet<Node> visited){
        System.out.println(n.num);
        visited.add(n);
        for(Node neighbor : n.toNeighbor){
            if(!visited.contains(neighbor)){
                dfs(neighbor, visited);
            }
        }

    }
}
