package recursion.hw;

import java.util.ArrayList;

public class Subset {
    public static void main(String[] args) {
        String s = "abcd";
        String[] subsets = generate_all_subsets(s);

        for(String subs: subsets){
            System.out.println(subs);
        }
    }

    static String[] generate_all_subsets(String s) {
        ArrayList<String> arr = new ArrayList<>();

        generateSubsets(s, 0, arr, "");

        return arr.toArray(new String[arr.size()]);
    }


    static void generateSubsets(String s, int ptr, ArrayList<String> store, String sub){

        if(ptr==s.length()){
            store.add(sub);
            return;
        }

        generateSubsets(s,ptr+1, store, sub);

        generateSubsets(s, ptr+1, store, sub+s.charAt(ptr));



    }
}
