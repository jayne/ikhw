package sorting.lecture;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jaynehsu on 11/29/18.
 */

/**
 * This was my solution.
 * It creates a base of two numbers.
 * Then median is computed each time (3 numbers to 2 numbers and vice versa)
 */


public class MedianStream {
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

        int leftValue = 0;
        int rightValue = 0;
        int med = 0;

        for (int i = 0; i < arr.length; i++) {
            int incomingValue = arr[i];

            //base case
            if (i == 0) {
                result.add((double) arr[i]);
                med = arr[i];
            } else if (i == 1) {
                result.add((double) (med + arr[i]) / 2);
                if (arr[i] < med) {
                    leftValue = arr[i];
                    rightValue = med;
                } else {
                    leftValue = med;
                    rightValue = arr[i];
                }
            }

            // all other cases
            else if (i % 2 == 0) { // going from two values to three values
                System.out.println("reading " + arr[i] + "\t l: " + leftValue + " r:" + rightValue);
                if(arr[i] > leftValue && arr[i] < rightValue){
                    result.add((double)arr[i]);
                    med = arr[i];
                }else if(arr[i]<leftValue){
                    med = leftValue;
                    leftValue = arr[i];
                    result.add((double)med);
                }else{
                    med = rightValue;
                    rightValue = arr[i];
                    result.add((double)med);
                }
            }else if(i%2 ==1){ // going from three values to two values
                System.out.println("reading " + arr[i] + "\t l: " + leftValue + " m:" + med + " r:" + rightValue );
                if(arr[i]<leftValue){
                    rightValue = med;
                    result.add((double)(med+leftValue)/2);
                }else if(arr[i]>rightValue){
                    leftValue = med;
                    result.add((double)(med+rightValue)/2);
                }else if(arr[i] < med){
                    leftValue = arr[i];
                    rightValue = med;
                    result.add((double)(med+arr[i])/2);
                }else if(arr[i] > med){
                    rightValue = arr[i];
                    leftValue = med;
                    result.add((double)(med+arr[i])/2);
                }
            }


        }


        Double[] wrapper = result.toArray(new Double[result.size()]);
        double[] doubleArray = Arrays.stream(wrapper).mapToDouble(Double::doubleValue).toArray();
        return doubleArray;
    }
}
