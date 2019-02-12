package trees.youtube;

import trees.Node;

import java.util.Stack;

import static trees.Node.printInorder;
import static trees.Node.printTree;

/**
 * Created by jaynehsu on 1/8/19.
 */
// I use a stack to keep track of the Parent path is
public class BSTFindPrevAndNextAndDelete {
    private static Node prepData() {
        Node n1 = new Node(5);
        Node n2 = new Node(2);
        Node n3 = new Node(9);
        Node n4 = new Node(1);
        Node n5 = new Node(3);
        Node n6 = new Node(7);
        Node n7 = new Node(12);

        Node n8 = new Node(0);
        Node n9 = new Node(2);
        Node n11 = new Node(4);
        Node n12 = new Node(6);
        Node n13 = new Node(8);
        Node n14 = new Node(10);
        Node n15 = new Node(15);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;
        n5.right = n11;
        n6.left = n12;
//        n6.right = n13;
        n7.left = n14;
        n7.right = n15;

        return n1;
    }



    private static void delete(Node root, int j) {
        // create parentStack
        Stack<Node> stack = new Stack();
        getPathToChild(root, j, stack);

        // if node.left exists recursively find the largest node
        Node currNode = stack.pop();

        // check if leaf node, if so, delete
        if(currNode.left == null && currNode.right == null) {
            Node parent = stack.pop();
            if (parent.left == currNode) {
                parent.left = null;
            }else{
                parent.right = null;
            }
            return;
        }

        // check if there's only one child
        if(currNode.left == null){
            currNode.value = currNode.right.value;
            currNode.right = null;
            return;
        }
        if(currNode.right == null){
            currNode.value = currNode.left.value;
            currNode.left = null;
            return;
        }

        // default is now 2 children
        boolean findPrevious = false; //toggle this depending on the approach you want
        if(findPrevious){
            Node prev = findPrev(root, currNode.value);
            Stack<Node> prevPathStack = new Stack<>();
            getPathToChild(root, prev.value, prevPathStack);
            prevPathStack.pop();
            Node prevParent = prevPathStack.pop();

            currNode.value = prev.value;
            if(prevParent.left == prev){
                prevParent.left = null;
            }else{
                prevParent.right = null;
            }
        }else{
            Node next = findNext(root, currNode.value);
            Stack<Node> nextPathStack = new Stack<>();
            getPathToChild(root, next.value, nextPathStack);
            nextPathStack.pop();
            Node prevParent = nextPathStack.pop();

            currNode.value = next.value;
            if(prevParent.left == next){
                prevParent.left = null;
            }else{
                prevParent.right = null;
            }
        }

    }

    public static void main(String[] args) {
        Node n = prepData();
        int k = 5;
        Node next = findNext(n, k);
        Node prev = findPrev(n, k);
        System.out.println("The previous value to " + k + " is " + prev.value);
        System.out.println("The next value to " + k + " is " + next.value);

        Node.printInorder(n);
        System.out.println();
        int j = k;
        delete(n, j);
        System.out.println("Delete " + j);
        Node.printInorder(n);
    }

    private static Node findNode(Node root, int j) {
        if(root==null){ return null; }
        if(root.value == j){ return root; }

        if(j<= root.value){
            return findNode(root.left, j);
        }else{
            return findNode(root.right, j);
        }
    }


    private static Node findPrev(Node root, int i) {
        // create parentStack
        Stack<Node> stack = new Stack();
        getPathToChild(root, i, stack);

        // if node.left exists recursively find the largest node
        Node currNode = stack.pop();
        if(currNode.left!=null){
            currNode = currNode.left;
            while(currNode.right!=null){
                currNode = currNode.right;
            }
            return currNode;
        }

        // otherwise go up the parent stack. if parent.right = node, return parent. if not, recurse until true.
        Node parent = stack.pop();

        while(parent.right!=currNode){
            currNode = parent;
            parent = stack.pop();
        }
        return parent;
    }

    private static boolean getPathToChild(Node root, int i, Stack<Node> stack) {
        if (root == null) {
            return false;
        }

        stack.push(root);

        if (root.value == i) {
            return true;
        }

        if (i <= root.value) {
            boolean left = getPathToChild(root.left, i, stack);
            if (left) return true;
        } else {
            boolean right = getPathToChild(root.right, i, stack);
            if (right) return true;
        }
        stack.pop();
        return false;
    }

    private static Node findNext(Node root, int i) {


        // create parentStack
        Stack<Node> stack = new Stack();
        getPathToChild(root, i, stack);

        // if(node.right exists) recursively find the smallest node
        Node currNode = stack.pop();
        if(currNode.right!=null){
            currNode = currNode.right;
            while(currNode.left!=null){
                currNode = currNode.left;
            }
            return currNode;
        }

        // otherwise, go up the parent stack. if the node = parent.left, return the parent. if not, recurse until true.
        Node parent = stack.pop();

        while(parent.left!=currNode){
            currNode = parent;
            parent = stack.pop();
        }
        return parent;

    }


}
