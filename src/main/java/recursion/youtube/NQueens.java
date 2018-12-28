package recursion.youtube;

/**
 * Created by jaynehsu on 12/17/18.
 */
// n has to be greater than 3

// my solution had a [][] to represent [i][j]
public class NQueens {
    public static void main(String[] args) {

        int n = 4;
//        mySln(n);
        mySlnOneDArray(n);

        usingPermutations(n); //(n^2)*n! // n factorial to generate all permutations...n squared to validate
//
    }


    static void usingPermutations(int n) {

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        permutations(arr, 0);
    }

    static boolean isValid(int[] arr, int index) {
        if (index == 0) {
            return true;
        }
        for (int i = 0; i < index; i++) {
            for (int j = i + 1; j <= index; j++) {
                int x = i - j;
                int y = arr[i] - arr[j];

                if (x == y || x == -y) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printLine(int[] arr, int length) {
        for (int i = 0; i <= length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }


    // uses permutations to solve the problem.
    // as the front part is being created, check to see if it is valid.
    // if not, don't continue creating the end of that particular string
    static void permutations(int[] arr, int index) {
        if (index == arr.length - 1) {
            if (isValid(arr, index)) {
                print(arr); // graph representation
            }
        } else {
            for (int j = index; j < arr.length; j++) {
                swap(arr, j, index);
                if (isValid(arr, index)) { // THIS WAS FUCKING KEY
                    permutations(arr, index + 1);
                }
                swap(arr, index, j);
            }
        }
    }

    static void swap(int[] arr, int j, int i) {
//        System.out.println("swap " + arr[i] + ":" + arr[j]);
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (result[i] == j) {
                    System.out.print("[Q]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // it uses a one dimensional array to represent the i and j coordinates
    // i coordinate was the index. j coordinate was the value.
    static void mySlnOneDArray(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        putQueens(result, 0);
        print(result);
    }

    static boolean isValid(int[] result, int i, int j) {
        for (int k = 0; k < i; k++) {
            int iDiff = i - k;
            int jDiff = j - result[k];

            if (iDiff == jDiff || iDiff == -jDiff || j == result[k]) {
                return false;
            }
        }
        result[i] = j;
        return true;

    }

    static boolean putQueens(int[] result, int i) {
        if (i == result.length) {
            return true;
        }

        for (int j = 0; j < result.length; j++) {
            if (isValid(result, i, j)) {
                if (putQueens(result, i + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    static void mySln(int n) {
        String[][] board = new String[n][n];
        boolean result = putQueens(board, n);
        print(board);
        System.out.println(result);
    }

    static boolean isValid(String[][] board, int i, int j) {
        // check up
        int checkI = i - 1;
        while (checkI >= 0) {
            if (board[checkI][j] != null) {
                return false;
            }
            checkI--;
        }

        // check left diag
        checkI = i - 1;
        int checkJ = j - 1;

        while (checkI >= 0 && checkJ >= 0) {
            if (board[checkI][checkJ] != null) {
                return false;
            }
            checkI--;
            checkJ--;
        }


        // check right diag
        checkI = i - 1;
        checkJ = j + 1;

        while (checkI >= 0 && checkJ < board.length) {
            if (board[checkI][checkJ] != null) {
                return false;
            }
            checkI--;
            checkJ++;
        }

        board[i][j] = "Q";
        return true;
    }

    static boolean putQueens(String[][] board, int numQueensLeft) {
        if (numQueensLeft == 0) {
            return true;
        }

        int i = board.length - numQueensLeft;
        for (int j = 0; j < board.length; j++) {
            if (isValid(board, i, j)) {
                if (putQueens(board, numQueensLeft - 1)) {
                    return true;
                } else {
                    board[i][j] = null;
                }
            }
        }

        return false;
    }

    static void print(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String square = board[i][j] == null ? "[ ]" : "[" + board[i][j] + "]";
                System.out.print(square);
            }
            System.out.println();
        }
        System.out.println();
    }
}
