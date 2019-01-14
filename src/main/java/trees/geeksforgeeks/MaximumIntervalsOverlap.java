package trees.geeksforgeeks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jaynehsu on 1/13/19.
 */
//https://www.geeksforgeeks.org/find-the-point-where-maximum-intervals-overlap/
public class MaximumIntervalsOverlap {


    public static void main(String[] args) {
        int arr[] = {1, 2, 10, 5, 5};
        int dep[] = {4, 6, 12, 9, 12};

        int point = getMax(arr, dep);
        System.out.println(point);
    }


    private static int getMax(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int numOfGuests = 0;
        int maxNumOfGuests = 0;
        int maxTime = 0;

        int arrPtr = 0;
        int depPtr = 0;

        //
        while (arrPtr < arr.length) { // only care about arrivals because departures can only decrase the maxNumOfGuests
            if (arr[arrPtr] < dep[depPtr]) {
                numOfGuests++;
                if(numOfGuests>maxNumOfGuests){
                    maxNumOfGuests = numOfGuests;
                    maxTime = arr[arrPtr];
                }
                arrPtr++;
            } else if (arr[arrPtr] > dep[depPtr]) {
                numOfGuests--;
                depPtr++;
            } else if (arr[arrPtr] == dep[depPtr]) {
                arrPtr++;
                depPtr++;
            }

        }

        return maxTime;
    }


}
