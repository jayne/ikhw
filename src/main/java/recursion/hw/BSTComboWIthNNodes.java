package recursion.hw;

public class BSTComboWIthNNodes {



    public static void main(String[] args) {

        int n = 5;


        long result = how_many_BSTs(n);
        System.out.println(result);
    }

    static long how_many_BSTs(int n) {

        if(n==1 || n==0){
            return 1;
        }

        long result = 0;

        for(int i = 1; i<=n; i++){
            long left = how_many_BSTs(i-1);
            long right = how_many_BSTs(n-i);

            result = result + (left * right);
        }

        return result;
    }


}
