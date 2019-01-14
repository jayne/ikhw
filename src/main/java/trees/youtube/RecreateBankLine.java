package trees.youtube;

import trees.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jaynehsu on 1/12/19.
 */

// there was a line of people. they dispersed. put them back together.
// all heights unique. each person remembers how many shorter people were ahead of them

public class RecreateBankLine {
    public static void main(String[] args) {
        PriorityQueue<Person> people = prepData();
        Person[] result = mySort(people);
        print(result);


    }

    private static void print(Person[] result) {
        for(int i = 0; i<result.length; i++){
            System.out.print(result[i].height + " ");
        }
        System.out.println();
    }

    // this is a really clever solution
    // using a segment tree type of deal so that you can put them in line much faster
    // a similar interview problem is "put a bunch of people in a line of chairs". once u place them, you update it
    // another interview problem is to find quickly find a minimum amount in a given range
    private static Person[] classSort(PriorityQueue<Person> people){
        Person[] result = new Person[people.size()];

        Node zeroSpot = new Node(0);
        Node oneSpot = new Node(1);
        Node twoSpot = new Node(2);
        Node threeSpot = new Node(3);
        Node fourSpot = new Node(4);
        Node fiveSpot = new Node(5);

        Node root = new Node(6);
        Node a = new Node(4);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(2);

        root.left = a;
        root.right = d;
        a.left = b;
        a.right = c;
        b.left = zeroSpot;
        b.right = oneSpot;
        c.left = twoSpot;
        c.right = threeSpot;
        d.left = fourSpot;
        d.right = fiveSpot;

        while(!people.isEmpty()){
            Person p = people.remove();
            int shorterAhead = p.numShorterAhead;

            Node iter = root;
            while(iter.left!=null && iter.right!=null){
                iter.value = iter.value-1;
                if(shorterAhead < iter.left.value){

                    iter = iter.left;
                }else{

                    iter = iter.right;
                }
            }
            System.out.println("placing " + p.height + " at " + iter.value);
        }


        return result;
    }

    // 2, 3, 5, 1, 6, 4
    // 2(0), 3(1), 5(2), 1(0), 6(4), 4(3)
    private static Person[] mySort(PriorityQueue<Person> people) {
        Person[] result = new Person[people.size()];

        while(!people.isEmpty()){
            Person tallest = people.remove();
            System.out.print("checking out " + tallest.height/*"("+tallest.numShorterAhead+")"*/);
            int numShorter = tallest.numShorterAhead;
            int i =-1; // position of where we put the person (this was key for me)
            while(numShorter>=0){
                i++;
                while(result[i]!=null){
                    i++;
                }

                numShorter--;
            }
            result[i] = tallest;
            System.out.println(" putting it at " + i);
        }

        return result;
    }


    //[height][#of people]
    private static PriorityQueue<Person> prepData() {

        // 2, 3, 5, 1, 6, 4
        // 2(0), 3(1), 5(2), 1(0), 6(4), 4(3)
        Person two = new Person(2,0);
        Person three = new Person(3,1);
        Person five = new Person(5,2);
        Person one = new Person(1,0);
        Person six = new Person(6,4);
        Person four = new Person(4,3);

        Comparator<Person> comp = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.height <= p2.height ? 1 : -1; // use 0 for equal but no need in this example since all heights equal
            }
        };

        PriorityQueue<Person> list = new PriorityQueue<Person>(comp);
        list.add(two);
        list.add(three);
        list.add(five);
        list.add(one);
        list.add(six);
        list.add(four);

        return list;
    }

    static class Person{
        int height;
        int numShorterAhead;
        Person(int height, int numShorterAhead){
            this.height = height;
            this.numShorterAhead = numShorterAhead;
        }
    }
}
