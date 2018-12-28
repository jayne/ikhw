package sorting.homework;

/**
 * Created by jaynehsu on 11/19/18.
 */
public class GroupTheNumbers {

    public static void main(String[] args) {
        int [] arr = {3,5};
        int[] result = solve(arr);

        print(result);

    }

    static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
    static int[] solve(int[] arr) {
        int i = 0;
        int j = arr.length-1;

        while(i<j){
            while(i<arr.length && arr[i]%2==0){
                i++;
            }
            while(j>=0 && arr[j]%2==1){
                j--;
            }

            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

        }
        return arr;

    }


}
