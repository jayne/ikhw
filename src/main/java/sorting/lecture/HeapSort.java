package sorting.lecture;

/**
 * Created by jaynehsu on 11/15/18.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr=  {3,6,4,5,1,2,4};

//        int[] maxArr = maxHeap(arr);
        int[] minArr = minHeap(arr);

        print(minArr);
        int min = popMin(minArr);
        System.out.println(min);
        print(minArr);
    }

    static int popMin(int[] minArr){
        int min = minArr[0];
        return min;
    }


    static int[] minHeap(int[] arr){
        for(int j = arr.length; j>1; j--){
            int i = j;
            //while(i>1) {
                int parent = i/2;
                if (arr[i - 1] < arr[parent - 1]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[parent - 1];
                    arr[parent - 1] = temp;
                }
                //i = parent;
           // }
        }
        return arr;
    }

    static int[] maxHeap(int[] arr){
        for(int j = arr.length; j>1; j--){
            int i = j;
            while(i>1) {
                int parent = i/2;
                if (arr[i - 1] > arr[parent - 1]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[parent - 1];
                    arr[parent - 1] = temp;
                }
                i = parent;
            }
        }
        return arr;
    }


    static void print(int[] arr){
        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

}
