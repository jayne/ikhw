package recursion.teachable;

/**
 * Created by jaynehsu on 12/4/18.
 */
//Assume that the input is an array of size 'n' where 'n' is an even number.
// Additionally, assume that  half the integers are even and the other half are odd.
// Print only those permutations where odd and even integers alternate

public class PermutationOddEven {

    static int counter = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4,5,6,7,8,9,10};
        permute(arr, 0);
        System.out.println("\n" + counter);
    }

    static String print(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += " " + arr[i];
        }
        return result;
    }


    static void permute(int[] arr, int toLock) {

        if (toLock == arr.length-1) {
            System.out.println(print(arr));
            counter++;
            return;
        }

        for (int j = toLock; j < arr.length; j++) {
            swap(arr, toLock, j);
            boolean canProceed = canProceed(arr, toLock);


            if(canProceed) {
                permute(arr, toLock + 1);
            }
            swap(arr, j, toLock);
        }
    }

    static boolean canProceed(int[] arr, int toLock){
        if(toLock==0){
            return true;
        }else if(arr[toLock-1]%2==0 && arr[toLock]%2==1){
            return true;
        }else if(arr[toLock]%2==0 && arr[toLock-1]%2==1) {
            return true;
        }
        return false;
    }

    static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
