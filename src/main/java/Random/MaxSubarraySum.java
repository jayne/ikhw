package Random;

/**
 * Created by jaynehsu on 1/12/19.
 */
// use divide and conquer
//https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};
//        int[] arr = {-2, -5, 6, -2};
        int result = getMaxSum(arr);
    }

    private static int getMaxSum(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int[] range = getMaxSumHelper(arr, start, end);
        System.out.println("max sum: " + range[0]);
        System.out.println("start index: " + range[1]);
        System.out.println("left index: " + range[2]);

        return range[0];
    }

    // [0] = sum of range
    // [start of subarray]
    // [end of subarray]
    private static int[] getMaxSumHelper(int[] arr, int start, int end) {

        if (start == end) {
            int[] baseCase = {arr[start], start, end};
            return baseCase;
        }

        int[] left = getMaxSumHelper(arr, start, (start+end) / 2);
        int[] right = getMaxSumHelper(arr, (start + end) / 2 + 1, end);

        int connected = getSum(arr, left[1], right[2]);

        int max = getMax(left[0], right[0], connected);

        if (max == left[0]) {
            return left;
        } else if (max == right[0]) {
            return right;
        } else {
            int[] result = {max, left[1], right[2]};
            return result;
        }
    }

    private static int getMax(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        }
        return c;
    }

    private static int getSum(int[] arr, int a, int b) {
        int total = 0;
        for (int i = a; i <= b; i++) {
            total += arr[i];
        }
        return total;
    }


}


