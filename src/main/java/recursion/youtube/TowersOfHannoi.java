package recursion.youtube;


import java.util.Arrays;
import java.util.Stack;

/**
 * Created by jaynehsu on 12/17/18.
 */
// time comlexity is 2^n
    // height is n.
public class TowersOfHannoi {

    public static void main(String[] args) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();

        a.push(5);
        a.push(4);
        a.push(3);
        a.push(2);
        a.push(1);

        hanoi(a.size(), a, b, c);
        print(a, b, c);
    }

    static void hanoi(int size, Stack a, Stack b, Stack c) {

        if (size == 0) {
            return;
        }

        hanoi(size - 1, a, c, b);
        print(a, b, c);
        b.push(a.pop());  //move 1 piece of A to B
        hanoi(size - 1, c, b, a);
    }

    static void print(Stack a, Stack b, Stack c) {
        System.out.println(
                "A:" + Arrays.toString(a.toArray())
                        + "\t\tB:" + Arrays.toString(b.toArray())
                        + "\t\tC:" + Arrays.toString(c.toArray())
        );
    }
}
