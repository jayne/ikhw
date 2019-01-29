package sorting.lecture;

import java.util.Arrays;

/**
 * Created by jaynehsu on 1/19/19.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 3, 2, 4, 4, 7, 8, 2, 3, 6, 6, 2, 7};
//        int[] arr = {7, 3, 1,7,2,3};

        int[] result = mergeSort(arr);
        print(result);

    }

    private static int[] mergeSort(int[] arr) {
        if(arr.length<2){
            return arr;
        }
        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid,arr.length));

        int[] merged = mergeArrays(left, right);

        return merged;

    }

    private static int[] mergeArrays(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int l = 0;
        int r = 0;
        int res = 0;

        while (l != left.length && r != right.length) {
            if (left[l] <= right[r]) {
                result[res++] = left[l++];
            } else {
                result[res++] = right[r++];
            }
        }

        while (l != left.length) {
            result[res++] = left[l++];
        }

        while (r != right.length) {
            result[res++] = right[r++];
        }

        return result;
    }

    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

}
