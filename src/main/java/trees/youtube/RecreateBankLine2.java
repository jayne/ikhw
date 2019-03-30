package trees.youtube;

import trees.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jaynehsu on 1/12/19.
 */

// this solution is more flexible than my original one. but holy hell it was more difficult to write

public class RecreateBankLine2 {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 0, 2, 5}; //answer: 3, 0, 4, 1, 2, 5

        Node root = null;
        Node[] result = prepData(arr, root);
        for(int i =0; i<result.length; i++){
            System.out.print(result[i].value + " ");
        }
        System.out.println();
    }

    private static Node[] prepData(int[] arr, Node root) {
        // prepare the container to deliver the answer
        Node[] result = new Node[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Node(-1);
        }
        root = buildContainer(result);

        // now fill the container using root
        for (int i = arr.length - 1; i >= 0; i--) {
            putInLine(root, i, arr[i]);
        }

        return result;
    }

    private static void putInLine(Node root, int height, int numOfPeopleShorter) {
        if(root.left.value==-1 || root.right.value==-1){
            if(numOfPeopleShorter==1 || (numOfPeopleShorter==0 && root.left.value!=-1)){
                root.right.value = height;
            }else{
                root.left.value = height;
            }
            root.value = root.value-1;
            return;
        }


        if (numOfPeopleShorter < root.left.value) {
            putInLine(root.left, height, numOfPeopleShorter);
        } else {
            putInLine(root.right, height, numOfPeopleShorter - root.left.value);
        }
        root.value = root.value-1;
    }

    private static Node buildContainer(Node[] nodes) {
        if (nodes.length == 1) {
            if (nodes[0].value == -1) {
                return new Node(1);
            } else {
                return nodes[0]; // this is the root
            }
        }

        ArrayList<Node> parents = new ArrayList<>();

        int numParents = nodes.length / 2;
        int i = 0;
        while (numParents != 0) {
            Node parent;
            if (nodes[i].value == -1) {
                parent = new Node(2);
                parent.left = nodes[i];
                parent.right = nodes[i + 1];
            } else {
                parent = new Node(nodes[i].value + nodes[i + 1].value);
                parent.left = nodes[i];
                parent.right = nodes[i + 1];
            }
            parents.add(parent);
            i += 2;
            numParents--;
        }

        if (nodes.length % 2 == 1) {
            if (nodes[nodes.length - 1].value == -1) {
                Node parent = new Node(1);
                parent.left = nodes[nodes.length - 1];
                parents.add(parent);

            } else {
                parents.add(nodes[nodes.length - 1]);
            }
        }

        return buildContainer(parents.toArray(new Node[parents.size()]));


    }
}
