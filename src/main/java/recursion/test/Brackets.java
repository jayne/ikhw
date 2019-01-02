package recursion.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Brackets {

    public static void main(String[] args) {
        int n = 3;
        String[] result = find_all_well_formed_brackets(n);

        for(String s: result){
            System.out.println(s);
        }

    }


    static String[] find_all_well_formed_brackets(int n) {

        Set<String> result = new HashSet<>();

        if (n==1){
            String str = "()";
            result.add(str);
            return result.toArray(new String[result.size()]);
        }

        String[] prior = find_all_well_formed_brackets(n-1);

        for(String s: prior){
           for(int i = 0; i<s.length(); i++){
               String front = s.substring(0,i);

               String back = s.substring(i);
               String toAdd = front + "()" + back;
               result.add(toAdd);
           }
        }

        return result.toArray(new String[result.size()]);
    }


}
