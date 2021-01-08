import java.util.*;

class Program {

    public static LinkedList reverseLinkedList(LinkedList head) {

        // Time:  O(n)
        // Space: O(1)

        LinkedList curr = head;
        LinkedList prev = null;

        while (curr != null) {
            LinkedList tempCurr = curr;
            LinkedList nextCurr = curr.next;
            curr.next = prev;

            curr = nextCurr;
            prev = tempCurr;
        }

        return prev;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
