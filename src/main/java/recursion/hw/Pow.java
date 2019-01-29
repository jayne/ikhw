package recursion.hw;

/**
 * Created by jaynehsu on 1/25/19.
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(pow(2,3));

    }

    static float pow(float dblbase, int ipower) {
        if(ipower==0){
            return 1;
        }

        return dblbase * pow(dblbase, ipower-1);

    }
}
