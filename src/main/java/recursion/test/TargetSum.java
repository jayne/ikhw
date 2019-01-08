package recursion.test;


//space O(n) //  it is n because of the stack tree.
// time O(2^n)
public class TargetSum {

    public static void main(String[] args) {
        long[] arr = {3,2,4,8};
        long k = 10;
        boolean result = check_if_sum_possible(arr, k);
        System.out.println(result);
    }

    static boolean check_if_sum_possible(long[] arr, long k) {

        return checkSum(arr, 0, k, false);
    }

    static boolean checkSum(long[] arr, int ptr, long diff, boolean oneElem){
        if(diff==0 && oneElem){
            return true;
        }
        if(ptr==arr.length){
                return false;
        }

        for(int i = ptr; i<arr.length; i++){

            boolean doNotAdd = checkSum(arr, ptr+1, diff, oneElem);
            if(doNotAdd) return true;
            return checkSum(arr, ptr+1, diff-arr[i], true);
        }


        return false;
    }

}
