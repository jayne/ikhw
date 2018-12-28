package recursion.teachable;

/**
 * Created by jaynehsu on 12/10/18.
 */
public class SubsetsSumClosestToK {
    public static void main(String[] args) {
//        int[] arr = {2,3,4,500,6,7,8,100};
//        int sum = 20;

        int[] arr = {3, 5, 11};
        int sum = 13;


        int[] answer = permute(arr, 0, new int[arr.length], 0, sum);

        System.out.println("ANSWER BELOW");
        for (int i : answer) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    static int sum(int[] bestResult) {
        int total = 0;
        for (int i : bestResult) {
            total += i;
        }
        return total;
    }

    static int[] permute(int[] arr, int i, int[] result, int j, int sum) {

        if (i == arr.length) {
            int[] closest = new int[j];
            for (int p = 0; p < j; p++) {
                closest[p] = result[p];
            }
            return closest;
        }


        int[] skip = permute(arr, i + 1, result, j, sum);
        int skipDif = Math.abs(sumSoFar(skip) - sum);

        result[j] = arr[i];

        int[] use = permute(arr, i + 1, result, j + 1, sum);
        int useDif = Math.abs(sumSoFar(use) - sum);

        int[] closest = skipDif < useDif ? skip : use;

//        System.out.println("SKIP("+skipDif+"): " + print(skip) + "   USE("+useDif+"): " + print(use));
//        System.out.println("WINNER: " + print(closest));
//        System.out.println();

        return closest;
    }

    static int sumSoFar(int[] arr){
        int result  = 0;
        for(int i : arr){
            result+=i;
        }
        return result;
    }

    static String print(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] + " ";
        }
        return result;
    }
}
