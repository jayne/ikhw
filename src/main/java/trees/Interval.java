package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jaynehsu on 1/4/19.
 */
public class Interval implements Comparable<Interval>{
    public Interval left;
    public Interval right;
    public int min;
    public int max;
    public int overallmax;

    public Interval(int min, int max, int overallmax) {
        this.min = min;
        this.max = max;
        this.overallmax = overallmax;
    }

    public Interval(int min, int max) {
        this.min = min;
        this.max = max;
        this.overallmax = max;
    }

    @Override
    public String toString() {
        return "Interval{" +
                ", min=" + min +
                ", max=" + max +
                ", overallmax=" + overallmax +
                '}';
    }

    @Override
    public int compareTo(Interval o) {
        if(this.min==o.min) return 0;
        if(this.min>o.min) return 1;
        return -1;
    }
}
