package Hard;

import java.util.*;

class Program {

    public static LinkedList findLoop(LinkedList head) {

        // Time:  O(n)
        // Space: O(1)

        /**
         * Second pointer travels by 1 node more than first pointer
         * distance travelled by first pointer = D + P
         * distance travelled by second pointer = 2D + 2P
         * 2D + 2P = D + P + P + R (remaining portion of distance)
         * R = D
         *
         * This is to prove that when first pointer and second pointer coincides,
         * by shifting first pointer back to the head position and have
         * both pointers traverse by D times, both will reach the origin of the loop.
         */

        LinkedList firstPointer = head;
        LinkedList secondPointer = head;

        firstPointer = head.next;
        secondPointer = head.next.next;

        while (firstPointer != secondPointer) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
        }

        firstPointer = head;
        while (firstPointer != secondPointer) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return firstPointer;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList four = new LinkedList(4);
        LinkedList five = new LinkedList(5);
        LinkedList six = new LinkedList(6);
        LinkedList seven = new LinkedList(7);
        LinkedList eight = new LinkedList(8);
        LinkedList nine = new LinkedList(9);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = four;

        System.out.println(findLoop(head));
    }
}
