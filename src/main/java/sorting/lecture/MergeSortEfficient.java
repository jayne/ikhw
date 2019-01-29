package sorting.lecture;

import java.util.Arrays;

/**
 * Created by jaynehsu on 1/19/19.
 */
public class MergeSortEfficient {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 3, 2, 4, 4, 7, 8, 2, 3, 6, 6, 2, 7};
//        int[] arr = {7, 3, 1,7,2,3};
//        int[] arr = {3, 2};

        mergeSort(arr, 0, arr.length - 1);
        print(arr);

    }

    private static void mergeSort(int[] arr, int start, int end) {

        if (start < end) {
            int mid = (end+start)/2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            mergeArrays(arr, start, end);
        }

    }

    private static void mergeArrays(int[] arr, int start, int end) {
        int mid = (end+start)/2;
        int[] left = Arrays.copyOfRange(arr, start, mid+1);
        int[] right = Arrays.copyOfRange(arr, mid+1, end+1); // required a (+1) because of the fn definition

        int l = 0;
        int r = 0;
        int res = start;

        while (l != left.length && r != right.length) {
            if (left[l] <= right[r]) {
                arr[res++] = left[l++];
            } else {
                arr[res++] = right[r++];
            }
        }

        while (l != left.length) {
            arr[res++] = left[l++];
        }

        while (r != right.length) {
            arr[res++] = right[r++];
        }
    }


    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

}
