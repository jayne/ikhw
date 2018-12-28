package recursion.youtube;

/**
 * Created by jaynehsu on 12/14/18.
 */
// Given an array of integers, print all of its subsets

public class Subsets {

    static int count = 0;
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        printSubsets(arr, new int[arr.length], 0, 0);
    }

    static void printSubsets(int[] arr, int[] result, int index, int length){

        if(index == result.length){
            count++;
            System.out.println(toPrint(result,length));
            return;
        }

        printSubsets(arr, result, index+1, length);
        result[length] = arr[index];
        printSubsets(arr, result, index+1, length+1);

    }

    static String toPrint(int[] result, int length){
        String str = count + ")";
        for(int i = 0; i<length; i++){
            str+=result[i] + " ";
        }
        return str;
    }
}
