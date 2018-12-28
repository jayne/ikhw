package recursion.teachable;

/**
 * Created by jaynehsu on 12/10/18.
 */
public class SubsetsEqualToK {
    static int count = 0;
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7,8};
        int sum = 10;
        permute(arr, 0, new int[arr.length], 0, 0, sum);
        System.out.println("count: " + count);

    }

    static void permute(int[] arr, int i, int[] output, int j, int sumSoFar, int sum){
        if(sumSoFar>sum){
            return;
        }

        if(i==arr.length){
            if(sumSoFar==sum){
                for(int p = 0; p<j; p++){
                    System.out.print(output[p] + " ");
                }
                System.out.println();
            }

            return;
        }


        permute(arr, i+1, output, j, sumSoFar, sum);
        output[j] = arr[i];
        permute(arr, i+1, output, j+1, sumSoFar+arr[i], sum);



    }
}
