package Random;

import trees.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by jaynehsu on 1/13/19.
 */

public class DoIntervalsOverlap {
    public static void main(String[] args) {
        ArrayList<Interval> data = prepData();

        boolean overlaps = hasOverlap(data);
        if (overlaps) {
            printBefore(data);
            Stack<Interval> combinedOverlaps = combineOverlaps(data);
            System.out.println();
            printAfter(combinedOverlaps);
        }
    }

    private static void printBefore(ArrayList<Interval> data) {
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }

    private static void printAfter(Stack<Interval> combinedOverlaps) {
        Iterator<Interval> it = combinedOverlaps.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    private static Stack<Interval> combineOverlaps(ArrayList<Interval> data) {
        Stack<Interval> stack = new Stack<>();
        for (int i = 0; i < data.size(); i++) {
            Interval curr = data.get(i);

            if (stack.isEmpty()) {
                stack.push(curr);
            } else {
                if (stack.peek().max >= curr.min ) {
                    if(curr.max > stack.peek().max) {
                        Interval old = stack.pop();
                        old.max = curr.max;
                        stack.push(old);
                    }

                } else {
                    stack.push(curr);
                }
            }

        }


        return stack;
    }

    private static boolean hasOverlap(ArrayList<Interval> data) {
        Collections.sort(data);

        Interval iter = null;
        int currMax = Integer.MIN_VALUE;

        for (int i = 0; i < data.size(); i++) {
            if (iter == null) {
                iter = data.get(i);
                currMax = data.get(i).max;
            } else {
                iter = data.get(i);
                if (iter.max < currMax) {
                    System.out.println("Overlap found with this interval: " + data.get(i));
                    System.out.println();
                    return true;
                }
                currMax = currMax < iter.max ? iter.max : currMax;
            }
        }

        return false;
    }


    private static ArrayList<Interval> prepData() {
        Interval a = new Interval(1, 5);
        Interval b = new Interval(3, 7);
        Interval c = new Interval(2, 6);
        Interval d = new Interval(10, 15);
        Interval e = new Interval(5, 6);

        ArrayList<Interval> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        result.add(c);
        result.add(d);
        result.add(e);

        return result;

    }


}
