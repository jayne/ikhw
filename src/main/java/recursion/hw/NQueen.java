package recursion.hw;

import java.util.ArrayList;

public class NQueen {

    public static void main(String[] args) {
        int n = 4;
        String[][] result = find_all_arrangements(n);
        print(result);
    }

    static void print(String[][] result) {
        for (String[] board : result) {
            for (int i = 0; i<board.length; i++) {
                System.out.println(board[i]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void print(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /*
     * Complete the function below.
     */
    static String[][] find_all_arrangements(int n) {
        int[] arr = new int[n];

        fillDefault(arr);

        ArrayList<int[]> result = new ArrayList<>();
        ArrayList<String[]> results = new ArrayList<>();

        permute(results, result, arr, 0);

//        String[][] board = getBoard(result, n);
        return results.toArray(new String[results.size()][n]);
    }

    static String[] makeBoard(int[] arr){ //[3.4.1.2]
        String[] board = new String[arr.length];

        StringBuffer base = new StringBuffer("");
        for(int i =0; i<arr.length; i++){
           base.append('-');
        }

        for(int i = 0; i<arr.length; i++){
            StringBuffer copy = new StringBuffer(base);
            board[i] = String.valueOf(copy.replace(arr[i], arr[i] + 1, "q"));

        }
        return board;
    }


    static void permute(ArrayList<String[]> results, ArrayList<int[]> result, int[] arr, int pos) {
        if (pos == arr.length && isValid(arr,arr.length)) {
            int[] dupe = arr.clone();
            result.add(dupe);
            print(dupe);
            results.add(makeBoard(dupe));
        }

        for (int i = pos; i < arr.length; i++) {
            swap(arr, pos, i);
            if(isValid(arr,pos)) {
                permute(results, result, arr, pos + 1);
            }
            swap(arr, i, pos);
        }

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static boolean isValid(int[] arr, int pos) {

        for (int i = 0; i < pos; i++) {
            for (int j = i + 1; j < pos; j++) {
                if (Math.abs((i - j)) == Math.abs(arr[i] - arr[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    static void fillDefault(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }


}
