package recursion.teachable;

/**
 * Created by jaynehsu on 12/10/18.
 */
public class SubsetsOfACertainSize {
    public static void main(String[] args) {
        char[] arr = {'a','b','c','d','e','f'};
        char[] arr2 = {'a','b','c','d'};
        int size = 3;
        permute(arr2, 0, new char[arr2.length], 0, size);
    }

    static void permute(char[] arr, int i, char[] output, int j, int size){

        if(i==arr.length){
            if(j==size){
                for(int p = 0; p<size; p++){
                    System.out.print(output[p]);
                }
                System.out.println();
            }
            return;
        }


        permute(arr, i+1, output, j, size);
        output[j] = arr[i];
        permute(arr, i+1, output, j+1, size);

    }
}
