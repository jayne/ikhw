package trees.youtube;

import trees.Node;

/**
 * Created by jaynehsu on 1/11/19.
 */
// need to go all the way down to the leaf
// bc for all u know the second smallest is the sibling of the smallest
    // this problem
public class FindSecondSmallestInSegTree2 {
    // 4, 5, 6 , 8 ,10, 11, 12, 15
    public static void main(String[] args) {
        Node n = prepData();
        int result = findSecondSmallest(n);
        System.out.println("result: " + result);
    }

    private static int findSecondSmallest(Node n) {
        Node second = n.value==n.left.value ? n.right : n.left;
        Node iter =  n.value==n.left.value ? n.left : n.right;

        while(iter.right!=null && iter.left!=null){

            Node possibleSecond = n.value == iter.left.value ? iter.right : iter.left;
            if(possibleSecond.value<second.value){
                second = possibleSecond;
            }
            iter = n.value==iter.left.value ? iter.left : iter.right;

        }

        return second.value;


    }


    private static Node prepData() {
        Node n1 = new Node(4);

        Node n2 = new Node(6);
        Node n3 = new Node(4);

        Node n4 = new Node(6);
        Node n5 = new Node(10);
        Node n6 = new Node(4);
        Node n7 = new Node(11);

        Node n8 = new Node(8);
        Node n9 = new Node(6);
        Node n10 = new Node(10);
        Node n11 = new Node(12);
        Node n12 = new Node(4);
        Node n13 = new Node(5);
        Node n14 = new Node(11);
        Node n15 = new Node(15);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        n5.left = n10;
        n5.right = n11;
        n6.left = n12;
        n6.right = n13;
        n7.left = n14;
        n7.right = n15;





        return n1;
    }


}
