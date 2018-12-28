package sorting.lecture;

/**
 * Created by jaynehsu on 11/25/18.
 */
public class KthSmallest {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3, 2, 1, 5, 6, 7, 7, 8, 9};
//        int arr[] = {1, 8, 9, 4, 3, 6, 5};
        int k = usingQuickSort(arr, 3, 0, arr.length - 1);

        System.out.println(k);

    }

    static int usingQuickSort(int[] arr, int k, int start, int end) {
        if(start>=end){
            return arr[end];
        }
        //choose end element as pivot
        int pivotValue = arr[end];

        int newPivotIndex = start;
        for (int i = start; i < end; i++) {

            if (arr[i] < pivotValue) {
                if (i != newPivotIndex) {
                    int temp = arr[i];
                    arr[i] = arr[newPivotIndex];
                    arr[newPivotIndex] = temp;
                }
                newPivotIndex++;
            }
        }

        int temp = arr[end];
        arr[end] = arr[newPivotIndex];
        arr[newPivotIndex] = temp;

        if (newPivotIndex == k - 1) {
            return newPivotIndex;
        } else if (newPivotIndex > k - 1) {
            return usingQuickSort(arr, k, start, newPivotIndex - 1);
        } else {
            return usingQuickSort(arr, k, newPivotIndex + 1, end);
        }


    }
}

