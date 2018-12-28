package recursion.youtube;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by jaynehsu on 12/21/18.
 */
public class StringPatternMatch {
    public static void main(String[] args) {
//        String s = "box fox box s"; //a b a c
//        String p = "abac";
//        System.out.println(withSpaces(s.split(" "), p, 0, new HashMap<String, String>()));

        String s1 = "ablueblue"; //a b  b
        String s2 = "abluebluee"; // also matches a b b
        String s3 = "abb";
        String s4 = "jdcc";
        String s5 = "jblbl";

        String p1 = "abb";

        System.out.println(withoutSpaces(s1, 0, 1, p1, 0, new HashMap<String, String>()));
        System.out.println(withoutSpaces(s2, 0, 1, p1, 0, new HashMap<String, String>()));
        System.out.println(withoutSpaces(s3, 0, 1, p1, 0, new HashMap<String, String>()));
        System.out.println(withoutSpaces(s4, 0, 1, p1, 0, new HashMap<String, String>()));
        System.out.println(withoutSpaces(s5, 0, 1, p1, 0, new HashMap<String, String>()));


        String s6 = "j";
        String p2 = "jd";
        System.out.println(withoutSpaces(s6, 0, 1, p2, 0, new HashMap<String, String>()));


    }

    static boolean withSpaces(String[] arr, String pat, int ptr, HashMap<String, String> map) {
        if (ptr == arr.length && ptr == pat.length()) {
            return true;
        }
        if (ptr == arr.length || ptr == pat.length()) {
            return false;
        }

        String value = String.valueOf(pat.charAt(ptr));
        String key = arr[ptr];
        ;

        String mapValue = map.get(key);
        if (mapValue == null) {
            map.put(key, value);
        } else if (!mapValue.equals(value)) {
            return false;
        }

        return withSpaces(arr, pat, ptr + 1, map);
    }


    static void print(HashMap<String, String> map){
        for(String key: map.keySet()){
            System.out.println(key + ":" + map.get(key));
        }
    }
    // key is the word FROM PATTERN
    // value is the 'a','b' FROM STRING
    static boolean withoutSpaces(String str, int ptrStr, int length, String pat, int ptrPat, HashMap<String, String> map) {
        if(ptrStr == str.length() && ptrPat == pat.length()){
//            print(map);
            return true;
        }
        if (ptrStr + length > str.length() || ptrPat >= pat.length()) {
            return false;
        }

        String key = String.valueOf(pat.charAt(ptrPat)); // the pattern
        String value = str.substring(ptrStr, ptrStr + length); // the word

//        System.out.println("value: " + value + "\t\tkey: " + key);
        String inMap = map.get(key);

        if (inMap == null) {
//            System.out.println("Pattern not exist. Put it in the dictionary" + key + ":" + value);
            map.put(key, value);
            boolean isGoodKey = withoutSpaces(str, ptrStr + length, 1, pat, ptrPat + 1, map);
            if(isGoodKey){
                return true;
            }else{
                map.remove(key,value);
                return withoutSpaces(str, ptrStr, length+1, pat, ptrPat, map);
            }
        } else if (inMap.equals(value)) {
//            System.out.println("Pattern exist." + value + ":" + key);

            // good. existing match
            return withoutSpaces(str, ptrStr + length, 1, pat, ptrPat + 1, map);
        } else if(inMap.startsWith(value)){
            return withoutSpaces(str, ptrStr, length+1, pat, ptrPat, map);
        } else{
//            System.out.println("the key(pattern) does not match pattern(string)" + key + ":" + value);
            return false;
        }


    }

}


//
//{  String value = String.valueOf(pat.charAt(ptrPat));
//
//        while (ptrStr + length > str.length()) {
//        String potentialKey = str.substring(ptrStr, ptrStr + length);
//
//        if (map.get(potentialKey) == null) {
//        map.put(potentialKey, value);
//        }else{
//        String currentValue = map.get(potentialKey);
//        if(currentValue!=value){
//        return false;
//        }
//        }
//
//        return withoutSpaces(str,ptrStr + length, pat, ptrPat + 1, map);
//        }
//        return false;
//        }