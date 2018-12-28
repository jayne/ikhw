package sorting.test;

/**
 * Created by jaynehsu on 12/4/18.
 */

// This the TAs code
// It's similar to insertion sort
// It starts from index 0 and traverses up
// There is a map (if a number has been previously encountered)
// there is an array of a size of the max values that can be represented in the array (ie: 0-9)
// Using the map, numbers slowly swap to the correct position

// THis is similar to counting sort.

// Gave up on figuring out the details. Will circle back to this later


import java.util.Arrays;
import java.util.Scanner;

public class GenericSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter max value that can be present in the array: ");
        int k = in.nextInt();
        System.out.println("Valid values in the array are integers between 1 and " + k + " inclusive");

        System.out.println("Enter n: ");
        int n = in.nextInt();
        System.out.println("Enter values: ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        sort(a, k);

        System.out.println(Arrays.toString(a));

        in.close();
    }

    static void sort(int[] a, int k) {
        /* streakEndPointer[val] should always have the value corresponding
         * to the end of the streak of value 'val' (inclusive) in the array that is sorted till now
         * */
        int[] streakEnd = new int[k + 1];
        boolean[] isElementFound = new boolean[k + 1];

        //initialize with -1 as no streak is formed now
        for (int i = 0; i <= k; i++) {
            streakEnd[i] = -1;
            isElementFound[i] = false;
        }

        int n = a.length;

        for (int i = 0; i < n; i++) {
            System.out.println("\n\n");
            System.out.println("evaluating " + a[i] + " located at index a[" + i + "]");
            System.out.println("a[]");
            print(a);
            System.out.println("isElementFound[]");
            print(isElementFound);
            System.out.println("streakEnd[]");
            print(streakEnd);

            int curVal = a[i];
            if (!isElementFound[curVal]) {
                int nearestSmallerValueFound = 0;
                for (int val = curVal - 1; val >= 1; val--) {
                    if (isElementFound[val]) {
                        nearestSmallerValueFound = val;
                        System.out.println("\tfound nearestSmallerValue: " + nearestSmallerValueFound);
                        break;
                    }
                }

                if (nearestSmallerValueFound != 0) {
                    streakEnd[curVal] = streakEnd[nearestSmallerValueFound];
                }
                isElementFound[curVal] = true;
            }
            System.out.println("isElementFound[]");
            print(isElementFound);
            System.out.println("streakEnd[]");
            print(streakEnd);

            //we do a cyclic swap using a[i] as the temporary position
            for (int val = curVal; val < k; val++) {
                if (isElementFound[val]) {
                    System.out.println("before swap a[]: " + i + ":" + (streakEnd[val] + 1));
                    print(a);
                    swap(i, streakEnd[val] + 1, a);
                    streakEnd[val]++;
                    System.out.println("after swap a[]");
                    print(a);
                    System.out.println("after swap streakEnd[]");
                    print(streakEnd);
                }
            }
        }

        System.out.println("streak end pointers:");
        System.out.println(Arrays.toString(streakEnd));

    }

    static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" [" + i + "]" + arr[i]);
        }
        System.out.println();
    }

    static void print(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                System.out.print(" [" + i + "]" + "T ");
            } else {
                System.out.print(" [" + i + "]" + "F ");
            }

        }
        System.out.println();
    }
}