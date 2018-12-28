package sorting.test;

/**
 * Created by jaynehsu on 12/3/18.
 */
public class MergeFirstIntoSecond {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};

        int[] arr2 = {2, 4, 6, 0, 0, 0};

        int[] result = merger_first_into_second(arr1, arr2);

        for(int i = 0; i<result.length; i++){
            System.out.print(result[i]);
        }
    }

    static void print(int[] result){
        for(int i = 0; i<result.length; i++){
            System.out.print(result[i]);
        }
        System.out.println();
    }

    // alternative way to do basically the same thing
    static int[] merger_first_into_second2(int[] arr1, int[] arr2) {
        int i = arr2.length - 1;
        int oneCounter = arr1.length-1;
        int twoCounter = arr1.length-1;

        while(i>=0){
            int lowest;
            if(oneCounter<0){
                lowest = twoCounter;
                arr2[i--]=arr2[twoCounter--];
            }
            else if(twoCounter<0){
                lowest = oneCounter;
                arr2[i--]=arr1[oneCounter--];
            }else if(arr1[oneCounter]>arr2[twoCounter]){
                arr2[i--] = arr1[oneCounter--];
            }else{
                arr2[i--] = arr2[twoCounter--];
            }

        }
        return arr2;
    }

    static int[] merger_first_into_second(int[] arr1, int[] arr2) {
        int pointer1 = arr1.length-1;
        int pointer2 = arr1.length-1;
        int pointerArray = arr2.length-1;

        for(pointerArray = arr2.length-1; pointerArray>=0 && (pointer1>=0 && pointer2>=0); pointerArray--){
                if (arr2[pointer2] > arr1[pointer1]) {
                    arr2[pointerArray] = arr2[pointer2];
                    pointer2--;
                } else {
                    arr2[pointerArray] = arr1[pointer1];
                    pointer1--;
                }
        }

        while(pointer1>=0){
            arr2[pointerArray] = arr1[pointer1];
            pointer1--;
            pointerArray--;
        }

        return arr2;

    }
}
