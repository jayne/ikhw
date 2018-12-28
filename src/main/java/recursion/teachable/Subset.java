package recursion.teachable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jaynehsu on 12/8/18.
 */
// Print all Subsets
public class Subset {
    static int count = 1;

    public static void main(String[] args) {
//        char[] arr = {'t', 'd', 'c', 'o'};
//        char[] arr = {'d', 'c', 'o'};
        char[] arr = {'t', 'o'};
//        char[] arr = {'o'};

//        myFirstSolution(arr); // converts to a List and uses Set

//        mySecondSolution(arr); // uses basic array data structure

        classSolution(arr); //
    }

    static void classSolution(char[] arr) {
        char[] output = new char[arr.length];
        printSubsets(arr, 0, output, 0);
    }

    static void printSubsets(char[] array, int arrPointer, char[] output, int outputCounter) {
        if (arrPointer == array.length) {
            System.out.print(count + ") ");
            for (int j = 0; j < outputCounter; j++) {
                System.out.print(output[j]);
            }
            System.out.println();
            count++;
            return;
        }
        printSubsets(array, arrPointer + 1, output, outputCounter); // does not use the element
        output[outputCounter] = array[arrPointer];
        printSubsets(array, arrPointer + 1, output, outputCounter + 1); // uses the element
    }

    static void mySecondSolution(char[] arr) {
        printSubset(arr, arr.length);
    }

    static String[] printSubset(char[] arr, int size) {
        String[] result;

        if (size == 0) {
            String[] base = {""};
            System.out.println(count++ + ")" + "");
            return base;
        } else {
            String[] subsets = printSubset(arr, size - 1);
            result = new String[subsets.length * 2];

            for (int i = 0; i < subsets.length; i++) {
                String s = subsets[i];
                result[i] = subsets[i];

                String c = String.valueOf(arr[arr.length - size]);
                String str = s.concat(c);
                result[i + subsets.length] = str;

                System.out.println(count++ + ")" + str);
            }

        }

        return result;
    }

    static void myFirstSolution(char[] arr) {
        Set<Set<Character>> results = printSubsets(convertCharArrayToStreamToList(arr));

        print(results);
    }

    static Set<Set<Character>> printSubsets(List<Character> chars) {

        Set<Set<Character>> result = new HashSet<Set<Character>>();

        if (chars.size() == 0) {
            Set empty = new HashSet<Character>();
            empty.add(' ');
            result.add(empty);
            return result;
        }

        Character c = chars.remove(0);
        Set<Set<Character>> subsetResults = printSubsets(chars);

        for (Set set : subsetResults) {
            result.add(set);
            Set newSet = new HashSet(set);
            newSet.add(c);
            result.add(newSet);
        }

        return result;


    }

    static List<Character> convertCharArrayToStreamToList(char[] arr) {
        Stream<Character> cStream = IntStream.range(0, arr.length).mapToObj(i -> arr[i]);
        List<Character> list = cStream.collect(Collectors.toList());
        return list;

    }

    static void print(Set<Set<Character>> str) {

        Iterator it = str.iterator();
        while (it.hasNext()) {
            String s = "";
            Set set = (Set) it.next();
            Iterator subIt = set.iterator();
            while (subIt.hasNext()) {
                Character c = (Character) subIt.next();
                s += c;
            }
            System.out.println(s);
        }
    }


}
