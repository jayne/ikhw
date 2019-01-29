package recursion.hw;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by jaynehsu on 12/26/18.
 */
// generate all expressiosn that evaluate to a number (target)
// solution is to brute force. recurse on the two symbols. use for loop to determine the "skips"
public class Expressions2 {

    public static void main(String[] args) {
        String input = "00000000001";
        int k = 1;
        String[] result = generate_all_expressions(input, k);

        System.out.println("ANSWER");
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }

    }

    private static String[] generate_all_expressions(String input, int k) {


        return genString(input, k, 0, "", 0, 0);
    }

    private static String[] genString(String input, int k, int pos, String subString, int subSum, int prevNumber) {

        if (pos == input.length()) {
//            System.out.println(subString + " = " + subSum); //useful debug print of all expressions generated
            if(subSum==k){
                String[] result = {subString};
                return result;
            }
            return new String[0];
        }


        for (int end = pos; end < input.length(); end++) {
            String incomingPiece = input.substring(pos, end + 1);
            Integer incomingInt = Integer.valueOf(incomingPiece);

            if (pos != 0) {
                // use a '+'
                String[] plusResult = genString(input, k, end + 1,
                        subString + "+" + incomingPiece,
                        subSum + incomingInt,
                        incomingInt);

                // use a '*'
                String[] multResult = genString(input, k, end + 1,
                        subString + "*" + incomingPiece,
                        subSum - prevNumber + prevNumber * incomingInt,
                        prevNumber * incomingInt);

                Stream<String> out = Stream.of(Stream.of(plusResult), Stream.of(multResult)).flatMap(s -> s);
                return out.toArray(s -> new String[s]);

            } else {
                return genString(input, k, end + 1, incomingPiece, incomingInt, incomingInt);
            }
        }
        return new String[0];
    }


}
