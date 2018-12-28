package recursion.teachable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jaynehsu on 12/4/18.
 */
public class Permutation {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};

        char[] arrD = {'a', 'b', 'b', 'c', 'c'};

//        mySolution(arr);
//        classSolution(arr);
        classSolutionNoDuplicates(arrD, 0);
    }

    static void classSolutionNoDuplicates(char[] arr, int i ){
        if(i==arr.length-1){
            System.out.println(print(arr));
            return;
        }

        for(int j = i; j<arr.length; j++){
            if((arr[i]!=arr[j] || i==j) && !inPrevious(arr,i,j)) { // Edge case that instructor didn't tell us
                swap(arr, i, j);
                classSolutionNoDuplicates(arr, i + 1);
                swap(arr, j, i);
            }
        }


    }

    static boolean inPrevious(char[] arr, int i,  int j){
//        System.out.println("checking from " + i + " to " + j);
        for(int k= i; k<j; k++){
            if(arr[k]==arr[j]){
                return true;
            }
        }
        return false;
    }

    static String print(char[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }


    static void permute(char[] arr, int i) {

        if(i==arr.length-1){
            System.out.println(print(arr));
        }else {
            for (int j = i; j < arr.length; j++) {
                swap(arr, i, j);
                permute(arr, i + 1);
                swap(arr, j, i);
            }
        }

    }

    static void swap(char[] arr, int i, int j) {

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void classSolution(char[] arr) {
        permute(arr, 0);
    }

    static void mySolution(char[] arr) {
        Stream<Character> cStream = IntStream.range(0, arr.length).mapToObj(i -> arr[i]);
        List<Character> list = cStream.collect(Collectors.toList());

        Set<String> result = permute(list);
        System.out.println("!!!");
        print(result);
    }

    static void print(Set<String> set) {
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println();
    }

    static Set<String> permute(List<Character> list) {
        Set<String> set = new HashSet<>();

        //base case
        if (list.size() == 1) {
            String s = String.valueOf(list.get(0));
            set.add(s);
            return set;
        }

        //recursive
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            List<Character> subList = new ArrayList(list);
            subList.remove(i);

            Set<String> subSet = permute(subList);
            for (String s : subSet) {
                set.add(c + s);
            }
        }
        return set;
    }
}
