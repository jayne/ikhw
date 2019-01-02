package tips;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jaynehsu on 12/10/18.
 */
public class Sandbox {
    public static void main(String[] args) {
        long[] arr = {1,2,3,4,5};
        long[] cloned = new long[arr.length-1];
        for(int i = 0; i<arr.length-1; i++){
            System.out.println(i);
            cloned[i] = arr[i+1];
        }




    }

}

