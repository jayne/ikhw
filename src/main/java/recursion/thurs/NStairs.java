package recursion.thurs;

/**
 * Created by jaynehsu on 12/22/18.
 */
// Given n stairs, how many different ways can you reach the top (you can only take one step or two steps at a time)
    // example: 5 steps (11111)(2111)(1211)(1121)(1112)(221)(212)(122)
public class NStairs {

    public static void main(String[] args) {
        int n = 5;
        int result = numPaths(n);
        System.out.println(result);


    }

    static int numPaths(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }

        int oneStep = numPaths(n-1);
        int twoStep = numPaths(n-2);
        return oneStep + twoStep;

    }
}
