package Medium;

import java.util.*;

// Feel free to add new properties and methods to the class.
class Program {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.

        }

        public void setTail(Node node) {
            // Write your code here.
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
            Node prevNode = node.prev;
            nodeToInsert.next = prevNode.next;
            nodeToInsert.prev = prevNode;
            prevNode.next = nodeToInsert;

        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.
        }

        public void remove(Node node) {
            // Write your code here.

        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            // Time:  O(n)
            // Space: O(1)
            Node currNode = this.head;
            while (currNode.next != null && currNode.value != value) {
                currNode = this.head.next;
            }

            return currNode != null;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
