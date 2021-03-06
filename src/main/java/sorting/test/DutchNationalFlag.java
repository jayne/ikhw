package sorting.test;

/**
 * Created by jaynehsu on 12/3/18.
 */
public class DutchNationalFlag {
    public static void main(String[] args) {
        String input = "GR";
//        String input = "GRGRRBGBGBBGRBGBRBGBGBRGGBGBRBBRRBBGRBRGBRBRBGGRRGGGGRGBBBRBRBRBBRBRRRBGBBGRBGBBBGRRBGRRBGRGRBGGGGGRRGBGRGRBRRBGGRGRRGGRRGBBRBBRRGGRGGBRBBBGBRGBBRRRGRBRBGRGBRRGBBBBGBGGGBGGGRRRRRRBRRGRBBBGBRGBBBBBRGBGGRBBRBGRRBBRBGRBGRRRRGRGRBRBBRRRGBGRRRGRRBRBGGGGGRBBRGRGBBRGRRRRRRBBGGBRBRGRBGGGGRGGGGRRRBRRGRGRGRBRRBGRGRGGBRRGRBRGBGBBRGBBBBRBRGRRGRGBGBGGBBGRRGGBBRRBRBRRRBGBGBBGGBBGGRRGBRBBBRRBRGGGBGBRRBRRBRGGGBGGGGGBGBBRRGRGRGRRBGBGBRBGBGRRBRBRRRBGBGBBBGGBBRRGRRGGGGBBRBGRRRBGRBGBRRBRRRRBGGGBGGGGRRGRBBRBBGBBBBGRRGRRRBGGRGBGRGGBBGGGBBRBBGGGRRBBBBBGGGBGGRGGGGRGGRGRRRGGRRRGRRGRBRRRRBRBGBGRBGGRRGBGRRGGGRGRRRBRRGGBGRRGGRGGGBBBBGBRRBGRRBRGGRBGBRBGBBBRRGRBRBRRBRBGBBBGRGBGRRBRGRRGGRBRRBBBGBBRBGGGGRGGRRGBRGGGGBBRGRGRGGBRBGBRRBRBRGRGRRGRRBBGBRRBRRRBRRRGRRGGRGRBBRGGRRBRGGGBGRRBBGBRBGRBBGBRGRBRRRGRGBRRGBRBGGBGGGBRBRBGGBBRBRRBGRGGRGGRBRBRRRGRGGRBGBRGRBRBGRGGBGGGGBBBBGBGGGBGRBBBBBRBBBGRRGRRBGBBBBGBBBBBRRGGRRGGRBGBGBRRGRRBBRGBGGBGGRRGRGGBRRGRRBBGRGBGGRBGRBGGBBBBRBBGBRRGGBGGGGGGGBBGGRRRBRRRBGRBRGBBBBRGRBBRBGBGGBBBRGBBGGRGBRGBBGRRBGRRGRBGRRGBGBGRRRRGBBBRRBGRRRRRRBBRGGGGRRBGRGRGRGBBGBBBGGBRGRRGGBBBBBRBRGBGGBBBGGGRGGRGRRGBBBRBBGBRGBBBRRRGBGGGBRRBRBGBBGRRGRGRGRBBRBRGGGRBRGGGRBRBBRGGRBGGRRRBGGRRBBGBRGGBGBBGGRGBGRBGRRRRGGBGRBBBBGRBBGRRRBRBRGBGRBBBBRRGGRBRGRGBGBBBRRRGRRRRRRBRRBRBBGRBBBBBRGRBRGBGBBBBRRGRBGRBBRGGRBRBGRBGRGRRRGRGGRRBBGGBRBGGRBBGRBGBBGRBBBGGBBRBGBGGGRBBGRGGGGBBRRGRRBGGBRBRBRRRBRGRBGRBRBBRGBGBGBRRGBGRGGRBGRRBRGRGBRGBRBRBRRRRGBBBRGGBRBGRBGRBRBGGRGRGBGBRGRBBRBRBGRGGRRRBGBGRGGBBRBRRRBGGGRGGRBRRBRGBGGBBGGGGRGGGBBBBBBGGRRBGBRBBBGRBRGGBGGRGRRRBGBBRBRGRBGRRBRBBBRGGGBRRGRRBBBGBRGRGBBRGBBGBGBBBGGGRGRBGGBBBRGGBGRGGBGBBGBBGBGBRRBBRGBGRBRRGRBBGBRRGBBRBRBGGRRBRRGRGRBGGGBRRRBGBGGGBGBBGGGGRRBRRBBGRBRBBGRRRGRRGRBGGRGRBRGRGRBBGRBBRBGGRBRRBRBGBBGRGBBRRRRGRGGRBBBGRGBGGGBBRRBBGRBBBRRRRGRBGBBBGGRBBRBBRRRRBGRGGRRBGGBBBRRGGRBRGRBRRRBBRBRBGBBGBGRRRRGGRGGGRGGBRGGBBGGGBRRRBGBRBGGRGRBRRBGRRBBBRGBGBBGGBRGBGGBGRGBBBGBRRRRBGBRBGBGBGGRGGRBRBBRRBBBBRGBGBRBRBGRGRRBGGBBGGGGRRBBGGRBGBGBBGRBBGBBRGGRGGGBBRGRRBGRGGGBBRBGGRRGBRGBGRBRGGBRBGRRRBRBGGBBGRBBBGRRGBGGRBRGRBRRBRRBRRBRRRBBRBGBBBRRBBRGRBBRBBGRGRBBRRGBRGGGGRGRBRBRBRGBRGGGRBBBRRGGBBRRBBBBBGBGBGRGGBBRRBGGRGRBBBGGBBRBRBRRGRBGRBRGGGRRBRBRGGBGBRGBBRBBRGBGGRGBGGRRBBBBGGBBRRBBBRGRBBGRRRRBBBRGGRGGGBRGRGRBRBGRRRRRGRBBGRGGBBRGGRBGRBBGGBGBBRGBRRRRRGBGBRBGRRRBGGBRRBBBRGGBRGGBGGBRRRRGBBBRGGRGRBGRRRBBBRRRGRBBRRBBGBGBGRGRGGGGGGBGGGBBRGRRGGBBBBGBRGBBGRGBGBRRRBRRRRBBRBGGGRBBGBRBRRGRRRBGGRBRBGRGGGRGRRBGBGRRRGRBGRRBBGRRBGRBBBGRRRRRBBBBGGRBGBBRGGGRGRGGRRGBBRRRRBBRBBRGGRRBRBGBGBGRBRRGRGBBGRBBGRBBRRBRRRBBRGBGRRGGRBRRRRRBBGRRRRBRGBBRRGBGGBRGGBGBRGGRGBGBBRRRBBBBBGRRBBGRBGGBRGBRBGBBGGRGRRGRGBBGRGGBBRGGRGBBRRGGBBRRBGRBRRBGBGBBBBGGGBRBGRBGRBRGBGRBGRRGRBBBGBG";
        System.out.println(dutch_flag_sort(input));

    }

    static String dutch_flag_sort(String balls) {
        char[] cballs = balls.toCharArray();

        int pointerR1 = 0;
        int pointerB1 = balls.length()-1;

        for(int i = 0; i<balls.length(); i++){
            if(cballs[i]=='R'){
                char temp = cballs[i];
                cballs[i] = cballs[pointerR1];
                cballs[pointerR1] = temp;
                pointerR1++;
            }else if(cballs[i]=='B' && i<pointerB1){
                char temp = cballs[i];
                cballs[i] = cballs[pointerB1];
                cballs[pointerB1] = temp;
                pointerB1--;
                i--;
            }
        }
        return new String(cballs);
    }

    static String sort(String balls){
        char[] chars = balls.toCharArray();

        int pointerR1 = 0;
        int pointerB3 = balls.length()-1;

        for(int i = 0; i<chars.length; i++){
            System.out.println("\t" + new String(chars));
            if(chars[i] == 'R'){
                char temp = chars[i];
                chars[i] = chars[pointerR1];
                chars[pointerR1] = temp;
                pointerR1++;

            }else if(chars[i] == 'B' && i<=pointerB3){
                char temp = chars[i];
                chars[i] = chars[pointerB3];
                chars[pointerB3] = temp;
                pointerB3--;
                i--;
            }

        }

        return new String(chars);
    }
}
