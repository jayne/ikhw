package tips;

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


}
