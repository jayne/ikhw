package recursion.test;

public class TargetSum {

    public static void main(String[] args) {
        long[] arr = {3,2,4,8};
        long k = 102;
        boolean result = check_if_sum_possible(arr, k);
        System.out.println(result);
    }

    static boolean check_if_sum_possible(long[] arr, long k) {

        return checkSum(arr, 0,0, k, 0, false);
    }

    static boolean checkSum(long[] arr, int ptr, int resultPtr, long k, long total, boolean oneElem){
        if(total==k && oneElem){
            return true;
        }
        if(ptr==arr.length){
                return false;
        }

        for(int i = ptr; i<arr.length; i++){

            boolean doNotAdd = checkSum(arr, ptr+1, resultPtr, k, total, oneElem);
            if(doNotAdd) return true;
            return checkSum(arr, ptr+1,resultPtr+1, k, total+arr[i], true);
        }


        return false;
    }

}
