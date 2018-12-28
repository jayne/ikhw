package sorting.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by jaynehsu on 11/19/18.
 * This was my slow solution
 */
public class ThreeSum2 {
    public static void main(String[] args) {
        int[] arr = {4, -2, -2, -1, -3};

        String[] result = findZeroSum(arr);
        print(result);
    }

    static void print(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }

    static String[] findZeroSum(int[] arr) {
        HashSet<String> result = new HashSet<>();


        for (int i = 0; i < arr.length - 2; i++) {
            int first = arr[i];

            HashMap<Integer, String> map = new HashMap<>();
            for (int j = i + 1; j < arr.length; j++) {
                int second = arr[j];
                int third = -1 * (first + second);
                if (map.containsKey(third)) {
                    ArrayList<Integer> combo = new ArrayList<>();
                    combo.add(first);
                    combo.add(second);
                    combo.add(third);
                    Collections.sort(combo);
                    result.add(combo.get(0) + "," + combo.get(1) + ","+combo.get(2));
                } else {
                    map.put(second, String.valueOf(second));
                }
            }
        }


        return result.toArray(new String[result.size()]);


    }


    //

}
