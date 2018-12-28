package graphs.lecture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by jaynehsu on 11/15/18.
 */
public class CloneGraph {

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

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.addToNeighbor(two);
        two.addToNeighbor(three);
        three.addToNeighbor(four);
        four.addToNeighbor(one);

//        dfs(dataSetup(), new HashSet<Node>());
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
