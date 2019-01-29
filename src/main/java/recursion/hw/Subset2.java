package recursion.hw;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Subset2 {
    public static void main(String[] args) {
        String str = "zxy";
        String[] result = generate_all_subsets(str);

        for(String s: result){
            System.out.println(s);
        }

    }


    static String[] generate_all_subsets(String s) {
        return getSubs(s, 0, "");

    }

    static String[] getSubs(String str, int ptr, String prev){

        if(ptr==str.length()){
            String[] result = {prev};
            return result;
        }

        char c = str.charAt(ptr);

        // include c
        String[] include = getSubs(str, ptr+1, prev+c);

        // do not include c
        String[] skip = getSubs(str, ptr+1, prev);

        return Stream.of(Stream.of(include), Stream.of(skip)).flatMap(s -> s).toArray(s -> new String[s]);

    }

}
