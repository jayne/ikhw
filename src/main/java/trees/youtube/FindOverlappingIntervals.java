package trees.youtube;

import trees.Interval;

import java.util.ArrayList;

/**
 * Created by jaynehsu on 1/13/19.
 */
public class FindOverlappingIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> data = prepData();

        ArrayList<ArrayList<Interval>> overlaps = getOverlaps(data);
        print(overlaps);



    }

    private static void print(ArrayList<ArrayList<Interval>> overlaps) {
        for(ArrayList<Interval> arr : overlaps){
            System.out.println(arr.get(0) + "overlaps with " + arr.get(1));
        }
    }

    private static ArrayList<ArrayList<Interval>> getOverlaps(ArrayList<Interval> data) {

        ArrayList<ArrayList<Interval>> result = new ArrayList<>();

        // Build Interval Tree
        Interval root = null;
        for(int i = 0; i<data.size(); i++){
            Interval incoming = data.get(i);
            if(root==null){
                root = incoming;
            }else{
                Interval iter = root;


                boolean set = false;
                while(!set) {
                    // set the overall max as you traverse through the tree
                    if(iter.overallmax < incoming.max){
                        iter.overallmax = incoming.max;
                    }

                    // traverse down left or right of iter
                    if (incoming.min < iter.min) {
                        if(incoming.max < iter.max){
                            ArrayList<Interval> overlap = new ArrayList<>();
                            overlap.add(incoming);
                            overlap.add(iter);
                            result.add(overlap);

                        }
                        if (iter.left == null) {
                            iter.left = incoming;
                            set = true;
                        } else {
                            iter = iter.left;
                        }
                    }else{
                        if(incoming.min < iter.max){
                            ArrayList<Interval> overlap = new ArrayList<>();
                            overlap.add(incoming);
                            overlap.add(iter);
                            result.add(overlap);

                        }
                        if( iter.right == null){
                            iter.right = incoming;
                            set = true;
                        }else{
                            iter = iter.right;
                        }
                    }
                }
            }
        }

        //

        return result;
    }

    private static  ArrayList<Interval>  prepData() {
        Interval a = new Interval(1,5);
        Interval b = new Interval(3,7);
        Interval c = new Interval(2,6);
        Interval d = new Interval(10,15);
        Interval e = new Interval(5,6);

        ArrayList<Interval> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        result.add(c);
        result.add(d);
        result.add(e);

        return result;

    }


}
