package graphs.lecture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by jaynehsu on 11/15/18.
 */

public class ShortestPath {
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
        Node four = new Node (4);

        one.addToNeighbor(two);
        one.addToNeighbor(three);
        two.addToNeighbor(four);
        three.addToNeighbor(two);
        // i was not paying attention :(
        LinkedList shortestPath = shortestPath(one,four);
        printPath(shortestPath);
    }

    static void printPath(LinkedList<Node> list){
        System.out.println("printing path ");
        Iterator<Node> i = list.iterator();
        while(i.hasNext()){
            System.out.print(i.next().num + " " );
        }
        System.out.println();
    }

    static LinkedList shortestPath(Node a, Node b){
        LinkedList path = new LinkedList();
        LinkedList<Node> queue = new LinkedList<Node>();

        HashSet<Node> visited = new HashSet<Node>();

        visited.add(a);
        path.add(a);
        for(Node neighbor: a.toNeighbor){
            if(neighbor != b) {
                queue.add(neighbor);
            }
            else{
                System.out.println("found!");
            }
        }

        while(!queue.isEmpty()){
            Node next = queue.remove();
            path.add(next);
            visited.add(next);
            for(Node neighbor: next.toNeighbor){
                if(!visited.contains(neighbor) && !queue.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

        return path;
    }
}
