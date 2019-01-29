package recursion.youtube;

/**
 * Created by jaynehsu on 12/16/18.
 */
public class PathThatEqualsK {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 5, 2, 0},
                {1, 4, 2, 11},
                {2, 5, 2, 0},
                {2, 21, 2, 2}
        };
        int result = getNumberOfPathForK(arr, 0, 0, 21);

        System.out.println();
        System.out.println(result);



    }


    static int getNumberOfPathForK(int[][] arr, int i, int j, int k) {

        if (i == arr.length || j == arr[0].length || k < 0) {
            return 0;
        }

        if (i == arr.length - 1 && j == arr[0].length - 1 && (k - arr[i][j] == 0)) {
            return 1;
        }

        int down = getNumberOfPathForK(arr, i + 1, j, k - arr[i][j]);
        int right = getNumberOfPathForK(arr, i, j + 1, k - arr[i][j]);

        return right + down;

    }


}
