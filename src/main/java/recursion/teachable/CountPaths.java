package recursion.teachable;

/**
 * Created by jaynehsu on 12/11/18.
 */
public class CountPaths {
    public static void main(String[] args) {
        int[][] grid = new int[5][9];
        System.out.println(countPaths(grid));
    }

    static int countPaths(int[][] grid) {
        int result = countPaths(grid, 0, 0);

        System.out.println();
        System.out.println("result: " + result);

        return result;
    }

    static int countPaths(int[][] grid, int first, int second) {
        System.out.println(first + ":" + second);
        if(first==grid.length || second == grid[0].length){
            return 0;
        }else if(first == grid.length-1 && second == grid[0].length-1){
            return 1;
        }


        int goFirst = countPaths(grid, first + 1, second);
        int goSecond = countPaths(grid, first, second + 1);

        int steps = goFirst + goSecond;


        return steps;
    }

    // only need to hit the edge (bc there's only one direction to go)
    static int countPathsShortCut(int[][] grid, int first, int second) {
        System.out.println(first + ":" + second);
//        if(first==grid.length || second == grid[0].length){
//            return 0;
//        }else if(first == grid.length-1 && second == grid[0].length-1){
//            return 1;
//        }

        if(first==grid.length || second == grid[0].length){
            System.out.println("fail");
            return 0;
        }
        if(first == grid.length-1 || second == grid[0].length-1){
            System.out.println("success");
            return 1;
        }

        int goFirst = countPaths(grid, first + 1, second);
        int goSecond = countPaths(grid, first, second + 1);

        int steps = goFirst + goSecond;


        return steps;
    }
}
