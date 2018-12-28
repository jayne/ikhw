package recursion.youtube;

/**
 * Created by jaynehsu on 12/17/18.
 */
public class KnightTour {

    static int[] iMoves = {-1, -2, -2, -1, 1, 1, 2, 2};
    static int[] jMoves = {-2, -1, 1, 2, -2, 2, -1, 1};

    static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                System.out.print("\t" + grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        mySln();
    }

    static void mySln() {
        int size = 8;
        int arr[][] = new int[size][size];

        boolean result = mvKnight(0, 0, 1, arr);
        System.out.println(result);
        print(arr);

    }

    static boolean mvKnight(int i, int j, int step, int[][] arr) {

//        print(arr);
        // guards
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != 0) {
            return false;
        }

        arr[i][j] = step;

        // base case
        if (step == arr.length * arr.length) {
            return true;
        }

        // changing state
        for (int k = 0; k < iMoves.length; k++) {
            boolean next = mvKnight(i + iMoves[k], j + jMoves[k], step + 1, arr);
            if (next) {
                return true;
            }
        }

        arr[i][j]=0;
        return false;
    }



}
