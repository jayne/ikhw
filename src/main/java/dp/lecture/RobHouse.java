package dp.lecture;

/**
 * Created by jaynehsu on 11/29/18.
 */


public class RobHouse {
    public static void main(String[] args) {
        int[] arr = {100, 1, 2, 200, 3};
        int[] table = getTable(arr);

        for(int i = 0; i<table.length; i++){
            System.out.print(table[i] + " ");
        }

        String[] result = getMarkedHouses(table, arr);

    }

    static String[] getMarkedHouses(int[] table, int[] arr){
        String[] result = new String[table.length-2];

        for(int i = 0; i<result.length; i++){
            //TODO: figure out logic here
        }


        return result;
    }

    static int[] getTable(int[] arr){
        int[] table = new int[arr.length+2];

        for(int i = arr.length-1; i>=0; i--){

            if(i>arr.length){
                table[i] = 0;
            }

            table[i] = max(arr[i] + table[i+2], table[i+1]);
        }

        return table;
    }

    static int max(int a, int b){
        if(a>b) return a;
        return b;
    }








}
