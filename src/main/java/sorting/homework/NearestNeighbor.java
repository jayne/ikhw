package sorting.homework;

import java.util.Arrays;

/**
 * Created by jaynehsu on 1/18/19.
 */
public class NearestNeighbor {
    public static void main(String[] args) {
        int[][] n_points = {
                {2, 2}, //2
                {5, 10}, //11
                {1, 1}, //1
                {-4, 9}, //9
                {3, 2} // 3
        };

        int px = 0;
        int py = 0;
        int[][] result = find_nearest_neighbours(px, py, n_points, 4);
//        int[][] result = find_nearest_neighbours(0, 0, n_points, 2);

        for (int i = 0; i <= result.length; i++) {
            double distance = calcDistance(n_points[i][0], n_points[i][1], px, py);
            System.out.println(n_points[i][0] + "," + n_points[i][1] + " : " + distance);
        }

    }

    // Complete the find_nearest_neighbours function below.
    static int[][] find_nearest_neighbours(int px, int py, int[][] n_points, int k) {

        int index = k-1;

        sortNeighbors(px, py, n_points, index, 0, n_points.length - 1);

        return Arrays.copyOf(n_points, index);
    }

    // quicksort
    private static void sortNeighbors(int px, int py, int[][] n_points, int k, int start, int end) {

        if(start>=end){
            return;
        }

        int pivot = end;
        double pivotValue = calcDistance(n_points[pivot][0], n_points[pivot][1], px, py);

        int pivotPosition = start;
        for (int i = start; i <= end; i++) {
            double checkedValue = calcDistance(n_points[i][0], n_points[i][1], px, py);
            if (checkedValue < pivotValue) {
                swap(n_points, pivotPosition, i);
                pivotPosition++;
            } else {

            }

        }
        swap(n_points, pivotPosition, end);

        // decide whether to recurse beginning half or later half
        if(k==pivotPosition){
            return;
        }else if(k<pivotPosition){
            sortNeighbors(px, py, n_points, k, start, pivotPosition-1);
        }else{
            sortNeighbors(px, py, n_points, k, pivotPosition+1, end);
        }

    }

    private static void swap(int[][] n_points, int pivotPosition, int i) {
        int[] temp = n_points[pivotPosition];
        n_points[pivotPosition] = n_points[i];
        n_points[i] = temp;

    }


    private static double calcDistance(int x, int y, int px, int py) {
        return Math.sqrt(Math.pow(x - px, 2) + Math.pow(y - py, 2));
    }


}
