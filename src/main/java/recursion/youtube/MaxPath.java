package recursion.youtube;

/**
 * Created by jaynehsu on 12/16/18.
 */
public class MaxPath {
    public static void main(String[] args) {
        int[][] arr = {
                {1,5,6,2},
                {1,3,2,1},
                {2,1,1,3},
                {2,1,1,3},
                {1,0,0,1}
        };

        int maxPath = getMaxPath(arr, 0, 0);
        System.out.println(maxPath);
    }

    static int getMaxPath(int[][] arr, int i , int j){

        if(i==arr.length || j==arr[0].length){
            return -Integer.MAX_VALUE;
        }

        if(i==arr.length-1 && j==arr[0].length-1){
            return arr[i][j];
        }

        int moveJ = getMaxPath(arr, i, j+1);
        int moveI = getMaxPath(arr, i+1, j);

        return moveJ>moveI ? moveJ+arr[i][j] : moveI+arr[i][j];
    }
}
