package trees.hw;

import trees.Node;

/**
 * Created by jaynehsu on 2/2/19.
 */
// this solution doesn't work. node 6 is somehow used?
public class LargestBSTfromBT {
    public static void main(String[] args) {
        Node root = prepData();
        Answer ans = getLargestTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(ans.size);
        System.out.println(ans.isTree);
        System.out.println(ans.largestNode.value);

    }

    static Answer getLargestTree(Node root, int min, int max) {
        Answer answer = new Answer();
        if (root == null) {
            answer.size = 0;
            answer.isTree = true;
            return answer;
        }


        Answer leftAns = new Answer();
        Answer rightAns = new Answer();

        if (root.left != null) {
            leftAns = getLargestTree(root.left, min, root.value);
        }

        if (root.right != null) {
            rightAns = getLargestTree(root.right, root.value, max);
        }

        if (root.value > min && root.value <= max && leftAns.isTree && rightAns.isTree) {
            answer.size = leftAns.size + rightAns.size + 1;
            answer.isTree = true;
            answer.largestNode = root;

        } else {
            if (root.left == null && root.right == null) {
                answer.largestNode = root;
                answer.size = 1;
            }else{
                if(leftAns.size>rightAns.size){
                    answer.size = leftAns.size;
                    answer.largestNode = leftAns.largestNode;
                }else{
                    answer.size = rightAns.size;
                    answer.largestNode = rightAns.largestNode;
                }
            }
            answer.isTree = false;
        }


        return answer;
    }

    static class Answer {
        int size = 0;
        boolean isTree = true;
        Node largestNode = null;
    }

    private static Node prepData() {
        Node one = new Node(10);
        Node two = new Node(6);
        Node three = new Node(12);
        Node four = new Node(7);
        Node five = new Node(4);
        Node six = new Node(11);
        Node seven = new Node(14);
        Node eight = new Node(13);
        Node nine = new Node(16);

        one.left = two;
        one.right = three;


        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        seven.left = eight;
        seven.right = nine;

        return three;
    }


}
