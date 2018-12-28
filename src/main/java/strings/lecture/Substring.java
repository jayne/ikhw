package strings.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by jaynehsu on 11/8/18.
 */
public class Substring {
    public static void main(String[] args) {
        String str = "shortest substring containing set";
        String str_brute = bruteForce(str);

        String str_s1 = s1(str);

        System.out.println("brute: " + str_brute);
        System.out.println("solution1: " + str_s1);
    }

    //WIP
    static String s1(String str){

        HashMap<Character,Integer> map = new HashMap();

        String shortest = null;

        for(int i = 0, j = 0; j<str.length(); j++){
            if(!map.containsKey(str.charAt(j))){
                map.put(str.charAt(j),1);
                shortest = str.substring(i,j+1);
            }else{
                map.put(str.charAt(j), map.get(str.charAt(j))+1);
                while(map.get(str.charAt(i))>1){
                    map.put(str.charAt(i), map.get(str.charAt(i))-1);
                    i++;
                    shortest = str.substring(i,j+1);
                }
            }
        }

        return shortest;
    }

    static String bruteForce(String str){

        // get all substrings
        ArrayList<String> listOfString = new ArrayList();
        for(int i=0; i<str.length(); i++){
            String s = "";
            for(int j = i; j<str.length(); j++){
                s = s + str.charAt(j);
                listOfString.add(s);
            }
        }

        // get all characters
        HashSet<Character> set = new HashSet<Character>();
        for(Character c : str.toCharArray()){
            set.add(c);
        }

        // find the shortest length that contains all characters
        String shortestString = str;
        for(String s : listOfString){
            boolean b = true;
            for(Character c : set){
                if(!(s.contains(String.valueOf(c)))){
                   b = false;
                   break;
                }
            }
            if(b==true){
                if(s.length()<shortestString.length()){
                    shortestString = s;
                }
            }
        }
        return shortestString;

    }


}
