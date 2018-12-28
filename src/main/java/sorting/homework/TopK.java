package sorting.homework;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jaynehsu on 11/19/18.
 */
public class TopK {
    public static void main(String[] args) {
        int[] arr = {1,6,3,4,2,3,4,6,7,8};

        int[] top5 = topK(arr,5);

        print(top5);
    }

    static void print(ArrayList<Integer> arr){
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i));
        }
        System.out.println();
    }

    static void print(int[] arr){
        for(int i: arr){
            System.out.print(i);
        }
        System.out.println();
    }


    static int[] topK(int[] arr, int k) {

        ArrayList<Integer> minHeap = new ArrayList<>();

        for(int i : arr){
            addToHeap(minHeap, i, k);
        }

        Integer[] wrapper = minHeap.toArray(new Integer[minHeap.size()]);
        return Arrays.stream(wrapper).mapToInt(Integer::intValue).toArray();

    }

    static void addToHeap(ArrayList<Integer> minHeap, int i, int k){

        if(!minHeap.contains(i)) {
            if (minHeap.size() < k) {
                minHeap.add(i);
                heapifyUp(minHeap, minHeap.size() - 1);
            } else {
                if (i > minHeap.get(0)) {
                    minHeap.set(0, i);
                    heapifyDown(minHeap, 0);
                }
            }
        }
        return;
    }

    static void heapifyUp(ArrayList<Integer> minHeap,int index ){
        if(index==0){
            return;
        }

        int parentIndex = (index+1)/2-1;
        if(minHeap.get(index)<minHeap.get(parentIndex)){
            int temp = minHeap.get(parentIndex);
            minHeap.set(parentIndex, minHeap.get(index));
            minHeap.set(index, temp);
            heapifyUp(minHeap, parentIndex);
        }

    }

    static void heapifyDown(ArrayList<Integer> minHeap, int rootIndex){
        int leftChildIndex = (rootIndex+1)*2-1;
        int rightChildIndex = (rootIndex+1)*2;

        int smallest = rootIndex;

        if(rightChildIndex<minHeap.size() && minHeap.get(rightChildIndex) < minHeap.get(smallest)){
            smallest = rightChildIndex;
        }

        if(leftChildIndex<minHeap.size() && minHeap.get(leftChildIndex) < minHeap.get(smallest)){
            smallest = leftChildIndex;
        }

        if(smallest!=rootIndex){
            int temp = minHeap.get(smallest);
            minHeap.set(smallest, minHeap.get(rootIndex));
            minHeap.set(rootIndex, temp);
            heapifyDown(minHeap, smallest);
        }

        return;

    }
}
