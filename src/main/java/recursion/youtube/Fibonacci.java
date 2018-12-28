package recursion.youtube;

/**
 * Created by jaynehsu on 12/11/18.
 */
// Return nth Fibonacci Number
public class Fibonacci {
    public static void main(String[] args) {
        int fib10 = fibonacci(9);
        System.out.println(fib10);
    }

    static int fibonacci(int n){
        if(n<=1){
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}
