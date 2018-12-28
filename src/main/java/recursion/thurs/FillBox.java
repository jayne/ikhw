package recursion.thurs;

/**
 * Created by jaynehsu on 12/22/18.
 */
// How many ways to fill a box (2byN) given (1by2) blocks

public class FillBox {
    public static void main(String[] args) {
        int n = 5;
        int ways = calcWays(n);
        System.out.println(ways);
    }

    static int calcWays(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }

        return calcWays(n-1) + calcWays(n-2);
    }
}
