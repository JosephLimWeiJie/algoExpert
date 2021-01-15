package Hard;

import java.util.*;

class Program {

    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {

        // Time:  O(n + m) where n and m are the length of the first and second linkedLists respectively.
        // Space: O(1)

        LinkedList pOne = headOne;
        LinkedList pTwo = headTwo;
        LinkedList pOnePrev = null;

        while (pOne != null && pTwo != null) {
            if (pOne.value < pTwo.value) {
                pOnePrev = pOne;
                pOne = pOne.next;
            } else {
                if (pOnePrev != null) {
                    pOnePrev.next = pTwo;
                }

                pOnePrev = pTwo;
                pTwo = pTwo.next;
                pOnePrev.next = pOne;
            }
        }

        if (pOne == null) {
            pOnePrev.next = pTwo;
        }

        return (headOne.value < headTwo.value) ? headOne : headTwo;
    }

    public static void main(String[] args) {
        LinkedList headOne = new LinkedList(2);
        headOne.next = (new LinkedList(6));
        headOne.next.next = (new LinkedList(7));
        headOne.next.next.next = (new LinkedList(8));
        headOne.next.next.next.next = (null);

        LinkedList headTwo = new LinkedList(1);
        headTwo.next = (new LinkedList(3));
        headTwo.next.next = (new LinkedList(4));
        headTwo.next.next.next = (new LinkedList(5));
        headTwo.next.next.next.next = (new LinkedList(9));
        headTwo.next.next.next.next.next = (new LinkedList(10));
        headTwo.next.next.next.next.next.next = (null);

        String ans = "";
        LinkedList mergeLinkedLists = mergeLinkedLists(headOne, headTwo);
        while (mergeLinkedLists != null) {
            ans += mergeLinkedLists.value;
            ans += " -> ";
            mergeLinkedLists = mergeLinkedLists.next;
        }
        ans += "null";
        System.out.println(ans);
    }
}
