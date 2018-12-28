package recursion.teachable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaynehsu on 12/4/18.
 */
//Assume that the input is an array of size 'n' where 'n' is an even number.
// Additionally, assume that  half the integers are even and the other half are odd.
// Print only those permutations where odd and even integers alternate
    
public class PermutationValidWord {

    static int counter = 0;

    public static void main(String[] args) {
        char[] arr = {'i','l','s','e','t','n'};
        permute(arr, 0);
        System.out.println("\n" + counter);
    }

    static String print(char[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += " " + arr[i];
        }
        return result;
    }


    static void permute(char[] arr, int toLock) {

        if (toLock == arr.length-1 && isValidWord(arr)) {
            System.out.println(print(arr));
            counter++;
            return;
        }

        for (int j = toLock; j < arr.length; j++) {
            swap(arr, toLock, j);

            if(isValidWordPrefix(arr, toLock+1)) {
                permute(arr, toLock + 1);
            }
            swap(arr, j, toLock);
        }
    }


    static boolean isValidWord(char[] arr){
        List<String> dict = new ArrayList<>();
        dict.add("listen");
        dict.add("silent");

        String arrStr = String.copyValueOf(arr);
        if(dict.contains(arrStr)) {
            return true;
        }
        return false;
    }

    static boolean isValidWordPrefix(char[] arr, int a_size){
        List<String> dict = new ArrayList<>();
        dict.add("listen");
        dict.add("silent");

        String arrStr = String.copyValueOf(arr).substring(0,a_size-1);

        for(String s : dict){
            if(s.substring(0,a_size-1).equals(arrStr)){
                return true;
            }
        }
        return false;
    }

    static void swap(char[] arr, int i, int j) {

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
