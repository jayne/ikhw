package recursion.youtube;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jaynehsu on 12/14/18.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
//        usingJavaDS();
//        usingNodes();
        usingNodesSkipK();
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setNext(Node n) {
            this.next = n;
        }
    }

    static Node reverseListNodes(Node n ){

        Node next = n.next;

        if(next==null){
            return n;
        }

        Node result = reverseListNodes(next);

        next.next = n;
        n.next = null;

        return result;

    }

    static void usingNodes() {
        Node last = new Node(4, null);
        Node n3 = new Node(3, last);
        Node n2 = new Node(2, n3);
        Node start = new Node(1, n2);

        print(start);
        Node result = reverseListNodes(start);
        print(result);

    }

    static void usingNodesSkipK() {
        Node last = new Node(6, null);
        Node n5 = new Node(5, last);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node start = new Node(1, n2);

        print(start);
        int k = 2;
        Node result = reverseListNodesSkipK(start,k);
        print(result);

    }

    static Node reverseListNodesSkipK(Node start, int k){
        System.out.println(start.value);


        Node knode = start;
        for(int i = 0; i<k-1; i++){
            knode = knode.next;
        }

        if(knode.next == null){
            return start;
        }

        Node ret = knode.next; // ret stores the looking ahead part...56->34....finds the 6....ALTERNATIVE is to have this node passed back
        for(int i = 0; i<k-1; i++){
            ret = ret.next;
        }

        Node newHead = reverseListNodesSkipK(knode.next, k);

        print(newHead);

        knode.next = null;

        ret.next = start;

        return newHead;


    }

    static void print(Node n){
        if(n==null){
            System.out.println();
            return;
        }
        System.out.print(n.value + " ");
        print(n.next);
    }

    static void usingJavaDS() {
        List<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        List<Integer> result = new LinkedList<>();
        reverseLinkedList(ll, result, 0);
    }

    static void reverseLinkedList(List list, List result, int index) {
        if (index == list.size() - 1) {
            result.add(list.get(index));
        } else {
            reverseLinkedList(list, result, index + 1);
            result.add(list.get(index));
        }

    }


}
