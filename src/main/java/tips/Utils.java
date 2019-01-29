package tips;

import trees.Node;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jaynehsu on 11/29/18.
 */
public class Utils {
    static void arrayListToArray(){
        ArrayList<Integer> result = new ArrayList();
        Integer[] wrapper = result.toArray(new Integer[result.size()]);
        int[] intArray = Arrays.stream(wrapper).mapToInt(Integer::intValue).toArray();
    }

    static void implementPriorityQueue(){
        PriorityQueue<Integer> min = new PriorityQueue<>();
        min.add(3);
        min.add(5);
        min.add(4);

        while(!min.isEmpty()){
            int value = min.remove();
            System.out.println(value);
        }

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o2==o1) return 0;
                if(o2>o1) return 1;
                return -1;
            }
        };

        PriorityQueue<Integer> max = new PriorityQueue<>(comparator);
        max.add(3);
        max.add(5);
        max.add(4);

        while(!max.isEmpty()){
            int value = max.remove();
            System.out.println(value);
        }
    }

    static void convertCharArrayToStreamToList(char[] arr){
        Stream<Character> cStream = IntStream.range(0, arr.length).mapToObj(i -> arr[i]);
        List<Character> list = cStream.collect(Collectors.toList());

    }

    static String printChar(List chars){
        String str = new String();
        for(int i = 0; i<chars.size(); i++){
            str+= chars.get(i);
        }
        str+="\n";
        return str;
    }

    static String[] combineArrays(String[] a, String[] b, String[] c){

//        return (String[]) Stream.concat(Stream.of(plusResult), Stream.of(multResult)).toArray(b -> new String[b]);
        Stream<String> out = Stream.of(Stream.of(a), Stream.of(b), Stream.of(c)).flatMap(s -> s);
        return out.toArray(s -> new String[s]);
    }

    public static void main(String[] args) {
        implementPriorityQueue();
    }

    private static void printTree(Node n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        int count = 1;

        while (!queue.isEmpty()) {
            Node it = queue.remove();

            System.out.print(it.value);

            if (it.left != null) queue.add(it.left);
            if (it.right != null) queue.add(it.right);

            count--;
            if (count == 0) {
                System.out.println();
                count = queue.size();
            }

        }
    }

    private static void comparatorExamplePriorityQueue(){
        Comparator<Node> comp = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
//                System.out.println(o1.value + " " + o2.value);
                return o1.value >= o2.value ? 1 : -1;
            }
        };

        Node n1 = new Node(6);
        Node n2 = new Node(4);
        Node n3 = new Node(9);

        PriorityQueue<Node> pq = new PriorityQueue(3, comp);
        pq.add(n1); //6
        pq.add(n2); // 4
        pq.add(n3);// 10

        System.out.println("!!!!");
        Node popped = pq.remove();
        System.out.println(popped.value);
        popped = pq.remove();
        System.out.println(popped.value);
        popped = pq.remove();
        System.out.println(popped.value);
        System.out.println("$$$$$");
    }

}
