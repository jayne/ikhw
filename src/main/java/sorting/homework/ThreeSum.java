package sorting.homework;

import com.sun.deploy.util.StringUtils;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jaynehsu on 11/19/18.
 */
public class ThreeSum {
    public static void main(String[] args) {
//        int[] arr = {10, 3, -4, 1, -6, 9};
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
        HashSet<String> set = new HashSet<>();
       Arrays.sort(arr);

       for(int first =0; first<arr.length-2; first++){
           int firstVal = arr[first];

           int second = first+1;
           int third = arr.length-1;

           while(second<third){
               int num = arr[second]+arr[third];
               if(num==(-firstVal)){
                set.add(arr[first] + "," + arr[second] + "," + arr[third]);
                second++;
                third--;
               }else if(num>-firstVal){
                   third--;
               }else{
                   second++;
               }
           }
       }

       return set.toArray(new String[set.size()]);




    }

}
