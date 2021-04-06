package prompt.hard;

import java.util.*;
import java.io.*;

public class ReverseLinkedList {

    static class LinkedList {
        int value;
        LinkedList next = null;
    
        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList prev = null;
        LinkedList curr = head;

        while (curr != null) {
            LinkedList nextCurr = curr.next;
            LinkedList nextPrev = curr;

            curr.next = prev; 
            prev = nextPrev;
            curr = nextCurr;
        }
        
        return prev;
    }

    public static void printLinkedList(LinkedList head) {
        String toPrint = "(";

        LinkedList curr = head;
        while (curr != null) {
            toPrint += (curr.value + " -> ");
            curr = curr.next;
        }

        toPrint += ")";
        System.out.println(toPrint);
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../../input/reverse_linkedlist.txt"))) {
            String line = br.readLine();
            List<Integer> arr = new ArrayList<>();

            for (String str : line.split(" ")) {
                arr.add(Integer.parseInt(str));
            }

            int[] array = arr.stream().mapToInt(i -> i).toArray();

            LinkedList head = new LinkedList(array[0]);
            LinkedList curr = head;

            for (int i = 1; i < array.length; i++) {
                curr.next = new LinkedList(array[i]);
                curr = curr.next;
            }

            //printLinkedList(head);
            printLinkedList(reverseLinkedList(head));
        } catch (FileNotFoundException foe) {
            System.out.println("Input file not found");
        }

    }
}