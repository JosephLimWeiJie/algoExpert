package prompt.easy;

import java.util.*;

public class RemoveDuplicatesFromLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;
    
        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList addMany(LinkedList ll, List<Integer> values) {
        LinkedList current = ll;
        while (current.next != null) {
            current = current.next;
        }
        for (int value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return ll;
      }
    
      public static List<Integer> getNodesInArray(LinkedList ll) {
        List<Integer> nodes = new ArrayList<Integer>();
        LinkedList current = ll;
        while (current != null) {
            nodes.add(current.value);
            current = current.next;
        }
        return nodes;
      }
    
    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList curr = linkedList;
        while (curr != null) {
            LinkedList nextNonDuplicate = findNextNonDuplicate(curr);
            curr.next = nextNonDuplicate;
            curr = nextNonDuplicate;
        }

        return linkedList;
    }

    public static LinkedList findNextNonDuplicate(LinkedList linkedList) {
        LinkedList curr = linkedList;
        while (curr.next != null) {
            if (curr.next.value != curr.value) {
                break;
            } else {
                curr = curr.next;
            }
        }

        return curr.next;
    }

    public static void main(String[] args) {
        LinkedList input = new LinkedList(1);
        addMany(input, new ArrayList<Integer>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
        List<Integer> expectedNodes = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 6));
        LinkedList output = removeDuplicatesFromLinkedList(input);
        System.out.println(getNodesInArray(output).equals(expectedNodes));
    }
}