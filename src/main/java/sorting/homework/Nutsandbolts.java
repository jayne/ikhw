package sorting.homework;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jaynehsu on 11/8/18.
 */
public class Nutsandbolts {
    public static void main(String[] args) {
        int nuts[] = {6,38,32,35,9,19,21};
        int bolts[] = {6,32,35,21,38,19,9};

//        String[] one = solveBruteForce(nuts, bolts);
//        print(one);

        String[] two = solve(nuts,bolts);
        print(two);
    }

    static String[] solve(int[] nuts, int[] bolts){
        ArrayList<String> result = new ArrayList<String>();
        quickSort(nuts,bolts, 0, nuts.length-1);

        for(int i = 0; i<nuts.length; i++){
            result.add(nuts[i] + " " + bolts[i]);
        }

        return result.toArray(new String[nuts.length]);
    }


    static void quickSort(int[] nuts, int[] bolts, int start, int end){

        if(start>=end){
            return;
        }

        int pivotIndex = partition(nuts, bolts, start, end);

        quickSort(nuts, bolts,  start, pivotIndex-1);
        quickSort(nuts, bolts, pivotIndex+1, end);

        return;
    }

    static int partition(int[] nuts, int[] bolts, int start, int end){
        // use nut to sort bolts
        int smallerIndex = start-1;
        for(int i = start; i<end; i++){
            if(bolts[i] < nuts[end]){
                smallerIndex++;
//                swap(bolts, i, smallerIndex);
                int temp = bolts[i];
                bolts[i] = bolts[smallerIndex];
                bolts[smallerIndex] = temp;
            }else if(bolts[i] == nuts[end]){
//                swap(bolts, i, end);
                int temp = bolts[i];
                bolts[i] = bolts[end];
                bolts[end] = temp;
                i--;
            }
        }

        //use bolt to sort nuts
        smallerIndex = start-1;
        for(int i = start; i<end; i++){
            if(nuts[i] < bolts[end]){
                smallerIndex++;
//                swap(nuts, i, smallerIndex);
                int temp = nuts[i];
                nuts[i] = nuts[smallerIndex];
                nuts[smallerIndex] = temp;
            }else if(nuts[i] == bolts[end]){
//                swap(nuts, i, end);
                int temp = nuts[i];
                nuts[i] = nuts[end];
                nuts[end] = temp;

                i--;
            }
        }

        int temp = nuts[smallerIndex+1];
        nuts[smallerIndex+1] = nuts[end];
        nuts[end] = temp;

        temp = bolts[smallerIndex+1];
        bolts[smallerIndex+1] = bolts[end];
        bolts[end] = temp;


//        swap(bolts, smallerIndex+1, end);
//        swap(nuts, smallerIndex+1, end);


        return smallerIndex+1;
    }



    static void print(String[] arr){
        for(String s: arr){
            System.out.println(s);
        }
    }


    static String[] solveBruteForce(int[] nuts, int[] bolts) {
        ArrayList<String> result = new ArrayList();

        for( int i=0; i<nuts.length; i++){
            for(int j = 0; j<bolts.length; j++){
                if(nuts[i] == bolts[j]){
                    result.add(nuts[i] + " " + bolts[j]);
                    break;
                }
                System.out.println("eval " + i + " " + j);
            }

        }

        return result.toArray(new String[nuts.length]);

    }

}
