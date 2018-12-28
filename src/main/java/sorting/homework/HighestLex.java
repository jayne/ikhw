package sorting.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by jaynehsu on 11/20/18.
 */
public class HighestLex {

    public static void main(String[] args) {

        String[] one = {
                "key1 abcd",
                "key2 zzz",
                "key1 hello",
                "key3 world",
                "key1 hello"
        };

        String[] result = solve(one);
        print(result);
    }

    static void print(String[] result){
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }


    static String[] solve(String[] arr) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String[] keyValue = arr[i].split(" ");
            String key = keyValue[0];
            String value = keyValue[1];

            if(!hm.containsKey(key)){
                ArrayList<String>  valueList = new ArrayList<>();
                valueList.add(value);
                hm.put(key,valueList);
            }else{
                ArrayList<String> valueList = hm.get(key);
                valueList.add(value);
                hm.put(key,valueList);
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for(String key : hm.keySet()){
            ArrayList valueList = hm.get(key);
            Collections.sort(valueList);
            String str = key + ":" + valueList.size() + "," + valueList.get(valueList.size()-1);
            result.add(str);
        }

        return result.toArray(new String[result.size()]);
    }


}
