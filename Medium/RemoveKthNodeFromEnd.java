package Medium;

import java.util.*;

class Program {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {

        // Time:  O(n)
        // Space: O(1)

        int counter = 0;
        LinkedList first = head;
        LinkedList second = head;

        while (counter < k) {
            second = second.next;
            counter++;
        }

        if (second == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
