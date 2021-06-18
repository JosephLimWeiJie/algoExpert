package prompt.medium;

import java.util.*;

public class SumOfLinkedLists {
    
    public static class LinkedList {
        public int value;
        public LinkedList next;
    
        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList ans = new LinkedList(0);
        LinkedList ansHead = ans;
        LinkedList ansPointer = ans;

        LinkedList firstPointer = linkedListOne;
        LinkedList secondPointer = linkedListTwo;
        
        int carryOver = 0;
        while (firstPointer != null || secondPointer != null) {
            int currSum = 0;
            if (firstPointer != null) {
                currSum += firstPointer.value;
                firstPointer = firstPointer.next;
            }

            if (secondPointer != null) {
                currSum += secondPointer.value;
                secondPointer = secondPointer.next;
            }

            currSum += carryOver;

            if (currSum >= 10) {
                ansPointer.next = new LinkedList(currSum % 10);
                carryOver = 1;
            } else {
                ansPointer.next = new LinkedList(currSum);
                carryOver = 0;
            }

            ansPointer = ansPointer.next;
        }

        if (carryOver == 1) {
            ansPointer.next = new LinkedList(carryOver);
        }

        printLinkedList(ansHead.next);
        return ansHead.next;
    }

    public static void printLinkedList(LinkedList head) {
        StringBuilder sb = new StringBuilder();
        LinkedList node = head;
        while (node != null) {
            if (node.next == null) {
                sb.append(node.value);
                node = node.next;
            } else {
                sb.append(node.value + " -> ");
                node = node.next;
            }

        }
        System.out.println(sb.toString());
    }

    public static void TestCase1() {
        LinkedList ll1 = addMany(new LinkedList(2), new int[] {4, 7, 1});
        LinkedList ll2 = addMany(new LinkedList(9), new int[] {4, 5});
        LinkedList expected = addMany(new LinkedList(1), new int[] {9, 2, 2});
        var actual = sumOfLinkedLists(ll1, ll2);
        System.out.println(getNodesInArray(expected).equals(getNodesInArray(actual)));
    }
    
    public static LinkedList addMany(LinkedList linkedList, int[] values) {
        var current = linkedList;
        while (current.next != null) {
            current = current.next;
        }
        for (var value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return linkedList;
    }
    
    public static ArrayList<Integer> getNodesInArray(LinkedList linkedList) {
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        LinkedList current = linkedList;
        while (current != null) {
          nodeValues.add(current.value);
          current = current.next;
        }
        return nodeValues;
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
