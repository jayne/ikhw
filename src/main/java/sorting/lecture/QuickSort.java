package sorting.lecture;

import java.util.Arrays;

/**
 * Created by jaynehsu on 11/10/18.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] one = {3,6,1,7,5};
        quickSort(one, 0, one.length-1);

        System.out.println(Arrays.toString(one));
    }

    static void quickSort(int[] arr, int start, int end){
        if(start>=end){
            return;
        }

        int pivotIndex = partition(arr,start,end);

        quickSort(arr,start, pivotIndex-1);
        quickSort(arr, pivotIndex+1, end );
    }

    static int partition(int[] arr, int start, int end){

        int pivotValue = arr[end];
        int pivotIndex = start-1; // index of smaller elements

        for(int i = start; i<end; i++){
            if(arr[i] <= pivotValue){
                pivotIndex++;

                int temp = arr[i];
                arr[i] = arr[pivotIndex];
                arr[pivotIndex] = temp;
            }
        }

        int temp = arr[end];
        arr[end] = arr[pivotIndex+1];
        arr[pivotIndex+1] = temp;


        return pivotIndex+1;
    }



}
