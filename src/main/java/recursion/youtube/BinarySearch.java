package recursion.youtube;

/**
 * Created by jaynehsu on 12/14/18.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,4,5,6,7,8,9,13,15,16};
        int[] arr2 = {2,4,6,7,8,9,13,15,16};

        int indexRecursive = recursively(arr, 5, 0, arr.length-1);
        int indexIteratively = iteratively(arr, 5);

        int indexRecursive2 = recursively(arr2, 5, 0, arr.length-1);
        int indexIteratively2 = iteratively(arr2, 5);

        System.out.println(indexRecursive);
        System.out.println(indexRecursive2);

        System.out.println(indexIteratively);
        System.out.println(indexIteratively2);

    }

    public static int recursively(int[] arr, int value, int start, int end){
        if(start>end){
            return -1;
        }

        int midIndex = (start + end)/2;

        if(arr[midIndex]==value){
            return midIndex;
        }else if(arr[midIndex] > value){
            return recursively(arr,value,start, midIndex-1);
        }else{
            return recursively(arr, value, midIndex+1, end);
        }

    }

    public static int iteratively(int[] arr, int value){
        int start = 0;
        int end = arr.length;


        while(start<=end){
            int midIndex = (start + end)/2;
            int midValue = arr[midIndex];

            if(midValue>value){
                end = midIndex-1;
            }else if(midValue<value){
                start=midIndex+1;
            }else{
                return midIndex;
            }
        }

        return -1;
    }


}
