package recursion.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by jaynehsu on 1/24/19.
 */
public class StringsFromWildCard {
    public static void main(String[] args) {
        String str  = "1?10?";
        String[] result = find_all_possibilities(str);

        for(String s : result){
            System.out.println(s);
        }
    }

    static String[] find_all_possibilities(String str) {
        int firstIndex = str.indexOf("?");
        if (firstIndex == -1){
            String[] result = {str};
            return  result;
        }

        // replace with 0
        String [] zero = find_all_possibilities(str.substring(0,firstIndex) + "0" + str.substring(firstIndex+1,str.length()));

        // replace with 1
        String [] one = find_all_possibilities(str.substring(0,firstIndex) + "1" + str.substring(firstIndex+1,str.length()));

        return combine(zero, one);
//        return Stream.of(Stream.of(zero), Stream.of(one)).flatMap(s->s).toArray(s->new String[s]);
    }

    private static String[] combine(String[] zero, String[] one) {
        ArrayList<String> result = new ArrayList<>(Arrays.asList(zero));
        result.addAll(Arrays.asList(one));

        return result.toArray(new String[result.size()]);
    }


}
