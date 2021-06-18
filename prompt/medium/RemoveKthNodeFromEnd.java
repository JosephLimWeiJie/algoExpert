package prompt.medium;

import java.util.*;

public class RemoveKthNodeFromEnd {
    
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList firstRunningPointer = head;
        LinkedList secondRunningPointer = head;

        int counter = k;
        while (counter > 0) {
            firstRunningPointer = firstRunningPointer.next;
            counter--;
        }

        // First case: firstRunningPointer is at the end of linkedList
        if (firstRunningPointer == null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }

        // Second case: firstRunningPointer is somewhere in the middle of linkedList
        while (firstRunningPointer.next != null) {
            firstRunningPointer = firstRunningPointer.next;
            secondRunningPointer = secondRunningPointer.next;
        }

        secondRunningPointer.next = secondRunningPointer.next.next;
        printLinkedList(head);
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

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void TestCase1() {
        TestLinkedList test = new TestLinkedList(0);
        test.addMany(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        int[] expected = {0, 1, 2, 3, 4, 5, 7, 8, 9};
        removeKthNodeFromEnd(test, 4);
        System.out.println(compare(test.getNodesInArray(), expected));
    }
    
    public static boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
          return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
          if (arr1.get(i) != arr2[i]) {
            return false;
          }
        }
        return true;
    }
    
    static class TestLinkedList extends LinkedList {
    
        public TestLinkedList(int value) {
            super(value);
        }
    
        public void addMany(int[] values) {
            LinkedList current = this;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new LinkedList(value);
                current = current.next;
            }
        }
    
        public List<Integer> getNodesInArray() {
            List<Integer> nodes = new ArrayList<Integer>();
            LinkedList current = this;
            while (current != null) {
                nodes.add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
