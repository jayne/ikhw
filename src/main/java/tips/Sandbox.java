package tips;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jaynehsu on 12/10/18.
 */
public class Sandbox {
    public static void main(String[] args) {
        String str = "jayne";
        testing(str);
    }

    static void testing(String str) {
        String before = str;
        if(str.length()==0) {
            return;
        }

        str = str.substring(1);

        System.out.println(before + ":" + str);
    }

}



