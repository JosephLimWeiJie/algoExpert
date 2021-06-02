package interview_questions;

import java.util.*;

public class Sim {

    public static class LinkedList {
        Node head;
        Node tail;

        public LinkedList() {
            this.head = null;
            this.tail = null;
        }

        public LinkedList(String s) {
            Node toStart = new Node(s);
            this.head = toStart;
            this.tail = toStart;
        }

        public Node addAtRunningPointer(String s, Node pointer) {
            Node toAdd = new Node(s);

            // if linkedList is empty 
            if (this.head == null && this.tail == null) {
                this.head = toAdd;
                this.tail = toAdd;
                pointer = this.head;
                return pointer;
            }

            if (pointer == this.tail) {
                toAdd.prev = this.tail;
                this.tail.next = toAdd;
                this.tail = toAdd;
                pointer = this.tail;
            } else {
                // if pointer currently at this.head
                if (pointer.prev == null) {
                    toAdd.next = this.head;
                    this.head.prev = toAdd;
                    this.head = toAdd;
                    pointer = toAdd.next;
                } else {
                    pointer = pointer.prev;
                    toAdd.next = pointer.next;
                    toAdd.prev = pointer;
                    pointer.next.prev = toAdd;
                    pointer.next = toAdd;
                    pointer = toAdd.next;
                }
            }

            return pointer;
        }

        public void removeLast() {
            if (this.tail == this.head) {
                this.head = null;
                this.tail = null;
                return;
            }

            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        public void removeMiddle(Node toRemove) {
            Node next = toRemove.next;
            Node prev = toRemove.prev;
            prev.next = next;
            next.prev = prev;
        }

        public int size() {
            Node currNode = this.head;
            int size = 0;

            while (currNode != null) {
                size++;
                currNode = currNode.next;
            }

            return size;
        }
        
        public String printLinkedList() {
            StringBuilder sb = new StringBuilder();

            Node currNode = this.head;
            while (currNode != null) {
                sb.append(currNode.s);
                currNode = currNode.next;
            }

            return sb.toString();
        }
    }

    public static class Node {
        String s;
        Node next;
        Node prev;

        public Node(String s) {
            this.s = s;
            this.next = null;
            this.prev = null;
        }
    }
    
    public static String cleanLine(String lineToClean) {
        // Get the first head of linkedList
        int i = 0;
        for (int j = 0; j < lineToClean.length(); j++) {
            if (!lineToClean.substring(j, j + 1).equals("[") && !lineToClean.substring(j, j + 1).equals("<") && !lineToClean.substring(j, j + 1).equals("]")) {
                i = j;
                break;
            }
        }

        if (i == 0) {
            return new LinkedList().printLinkedList();
        }

        LinkedList linkedList = new LinkedList(lineToClean.substring(i, i+1));
        Node runningPointer = linkedList.tail;
        for (int k = i + 1; k < lineToClean.length(); k++) {
            // System.out.println(linkedList.printLinkedList());
            String s = lineToClean.substring(k, k + 1);
            if (s.equals("]") && runningPointer != null) {
                runningPointer = linkedList.tail;
            } else if (s.equals("[") && runningPointer != null) {
                runningPointer = linkedList.head;
            } else if (s.equals("<") && runningPointer != null) {
                if (runningPointer == linkedList.tail) {
                    runningPointer = runningPointer.prev;
                    linkedList.removeLast();
                } else {
                    runningPointer = runningPointer.prev;
                    linkedList.removeMiddle(runningPointer);
                }
            } else {
                Node nextPointer = linkedList.addAtRunningPointer(s, runningPointer);
                runningPointer = nextPointer;
            }
            
        }

        return linkedList.printLinkedList();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n > 0 && sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(cleanLine(line));
            n--;
        }
    }
}
