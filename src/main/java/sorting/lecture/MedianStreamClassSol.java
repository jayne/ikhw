package sorting.lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jaynehsu on 11/29/18.
 */

/**
 * This is the solution that Geeta did in class.
 * Using two hash trees...to track left and right of median
 */
public class MedianStreamClassSol {
    public static void main(String[] args) {
        int arr[] = {2, 5, 3, 4, 6, 7};
        double result[] = median(arr);

        print(arr);
        print(result);
    }

    static void print(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " \t");
        }
        System.out.println();
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " \t\t");
        }
        System.out.println();
    }


    static double[] median(int[] arr) {
        ArrayList<Double> result = new ArrayList<>();

        PriorityQueue<Integer> right = new PriorityQueue<>();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o2==o1) return 0;
                if(o2>o1) return 1;
                return -1;
            }
        };

        PriorityQueue<Integer> left = new PriorityQueue<>(comparator);

        for(int i = 0; i<arr.length; i++){
            int incomingValue = arr[i];

            if(left.size() < right.size()){
                if(nonEmpty(right) && incomingValue<right.peek()){
                    left.add(incomingValue);
                }else{
                    right.add(left.remove());
                    left.add(incomingValue);
                }
                result.add((double)(left.peek() + right.peek())/2);

            }else if (left.size() > right.size()){
                if(nonEmpty(left) && incomingValue>left.peek()){
                    right.add(incomingValue);
                }else{
                    left.add(right.remove());
                    right.add(incomingValue);
                }

                result.add((double)(left.peek() + right.peek())/2);

            } else if (left.size() == right.size()){
                if(nonEmpty(right) && incomingValue>right.peek()){
                    result.add((double)right.peek());
                    right.add(incomingValue);
                }else if(nonEmpty(left) && incomingValue<left.peek()){
                    result.add((double)left.peek());
                    left.add(incomingValue);
                }else{
                    result.add((double)incomingValue);
                    left.add(incomingValue);
                }
            }
        }


        Double[] wrapper = result.toArray(new Double[result.size()]);
        double[] doubleArray = Arrays.stream(wrapper).mapToDouble(Double::doubleValue).toArray();
        return doubleArray;
    }

    static boolean nonEmpty(PriorityQueue<Integer> pq){
        if(pq.peek()==null){
            return false;
        }
        return true;
    }
}
