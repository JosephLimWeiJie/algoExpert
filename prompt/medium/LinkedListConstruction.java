package prompt.medium;

import java.util.*;

public class LinkedListConstruction {
    
    static class DoublyLinkedList {
        public Node head;
        public Node tail;
    
        public void setHead(Node node) {
            // If node is a standalone node
            if (this.head == null) {
                this.head = node;
                this.tail = node;
                return;
            }

            this.insertBefore(this.head, node);
        }
    
        public void setTail(Node node) {
            if (tail == null) {
                setHead(node);
                return;
            }

            this.insertAfter(this.tail, node);
        }
    
        public void insertBefore(Node node, Node nodeToInsert) {
            // Nothing happens if the nodeToInsert is a standalone node
            if (nodeToInsert == this.head && nodeToInsert == this.tail) {
                return;
            }
            
            this.remove(nodeToInsert);
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            if (node.prev == null) {
                this.head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }

            node.prev = nodeToInsert;
        }
    
        public void insertAfter(Node node, Node nodeToInsert) {
            // Nothing happens if the nodeToInsert is a standalone node
            if (nodeToInsert == this.head && nodeToInsert == this.tail) {
                return;
            }

            this.remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;
            if (node.next == null) {
                this.tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }

            node.next = nodeToInsert;
        }
    
        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }

            Node currNode = this.head;
            int currPosition = 1;
            while (currNode != null && currPosition++ != position) {
                currNode = currNode.next;
            }

            if (currNode != null) {
                insertBefore(currNode, nodeToInsert);
            } else {
                setTail(nodeToInsert);
            }

        }
    
        public void removeNodesWithValue(int value) {
            Node currNode = this.head;

            while (currNode != null) {
                Node toRemove = currNode;
                currNode = currNode.next;
                if (toRemove.value == value) {
                    remove(toRemove);
                }
            }
        }
    
        public void remove(Node node) {
            if (node == this.head) {
                this.head = node.next;
            }

            if (node == this.tail) {
                this.tail = node.prev;
            }

            this.removeNodeBindings(node);
        }

        public void removeNodeBindings(Node node) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            }

            node.next = null;
            node.prev = null;
        }
    
        public boolean containsNodeWithValue(int value) {
            Node currNode = this.head;

            while (currNode != null) {
                if (currNode.value == value) {
                    return true;
                }

                currNode = currNode.next;
            }

            return false;
        } 

        public boolean containsNode(Node node) {
            Node currNode = this.head;

            while (currNode != null) {
                if (currNode == node) {
                    return true;
                }

                currNode = currNode.next;
            }

            return false;
        }
    }

    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static List<Integer> getNodeValuesHeadToTail(DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        Node node = linkedList.head;
        while (node != null) {
          values.add(node.value);
          node = node.next;
        }
        return values;
    }
    
    private static List<Integer> getNodeValuesTailToHead(DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        Node node = linkedList.tail;
        while (node != null) {
          values.add(node.value);
          node = node.prev;
        }
        return values;
    }
    
    private static void bindNodes(Node nodeOne, Node nodeTwo) {
        nodeOne.next = nodeTwo;
        nodeTwo.prev = nodeOne;
    }
    
    private static boolean compare(List<Integer> array1, int[] array2) {
        if (array1.size() != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void TestCase1() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node three2 = new Node(3);
        Node three3 = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);
        linkedList.head = one;
        linkedList.tail = five;
    
        linkedList.setHead(four);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {5, 3, 2, 1, 4}));
    
        linkedList.setTail(six);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 3, 5, 6}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 3, 2, 1, 4}));
    
        linkedList.insertBefore(six, three);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 3, 5, 2, 1, 4}));
    
        linkedList.insertAfter(six, three2);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 3, 6, 3}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4}));
    
        linkedList.insertAtPosition(1, three3);
        System.out.println(
            compare(getNodeValuesHeadToTail(linkedList), new int[] {3, 4, 1, 2, 5, 3, 6, 3}));
            System.out.println(
            compare(getNodeValuesTailToHead(linkedList), new int[] {3, 6, 3, 5, 2, 1, 4, 3}));
    
        linkedList.removeNodesWithValue(3);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 2, 5, 6}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 2, 1, 4}));
    
        linkedList.remove(two);
        System.out.println(compare(getNodeValuesHeadToTail(linkedList), new int[] {4, 1, 5, 6}));
        System.out.println(compare(getNodeValuesTailToHead(linkedList), new int[] {6, 5, 1, 4}));
    
        System.out.println(linkedList.containsNodeWithValue(5));
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
