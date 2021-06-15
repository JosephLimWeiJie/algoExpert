package interview_questions;

import java.io.*;
import java.util.*;

public class Sim2 {

    static class Kattio extends PrintWriter {
        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }
    
        public boolean hasMoreTokens() {
            return peekToken() != null;
        }
    
        public int getInt() {
            return Integer.parseInt(nextToken());
        }
    
        public double getDouble() {
            return Double.parseDouble(nextToken());
        }
    
        public long getLong() {
            return Long.parseLong(nextToken());
        }
    
        public String getWord() {
            return nextToken();
        }
    
    
    
        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;
    
        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) { }
            return token;
        }
    
        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }
    

    public static class DoubleLinkedList {
        Node head = null;
        Node tail = null;

        public void addLast(char c) {
            Node newNode = new Node(c);

            if (head == null) {
                this.head = newNode;
                this.tail = newNode;
                this.head.prev = null;
                this.tail.next = null;
            } else {
                this.tail.next = newNode;
                newNode.prev = this.tail;
                newNode.next = null;
                this.tail = newNode;
            }
        }

        public void removeLast() {
            // Empty DoubleLinkedList case
            if (this.head == null && this.tail == null) {
                return;
            }

            // 1 Single Node case
            if (this.head == this.tail) {
                this.clear();
                return;
            }

            Node secondLastNode = this.tail.prev;
            secondLastNode.next = null;
            this.tail = secondLastNode;

        }

        public boolean isEmpty() {
            return (this.head == null && this.tail == null);
        }

        public void clear() {
            this.head = null;
            this.tail = null;
        }

        /** Connect another double linkedList to the head of this linkedList object. */
        public void combineAtHead(DoubleLinkedList other) {
            other.tail.next = this.head;
            this.head.prev = other.tail;
            this.head = other.head;
        }
 
        /** Connect another double linkedList to the tail of this linkedList object. */
        public void combineAtTail(DoubleLinkedList other) {
            this.tail.next = other.head;
            other.head.prev = this.tail;
            this.tail = other.tail;
        }

        public String printDoubleLinkedList() {
            if (this.head == null) {
                return "";
            }
            Node currNode = this.head;
            StringBuilder sb = new StringBuilder();

            while (currNode != null) {
                sb.append(currNode.c);
                currNode = currNode.next;
            }

            return sb.toString();
        }


        public class Node {
            char c;
            Node prev;
            Node next;

            public Node(char c) {
                this.c = c;
            }
        }
    }
    
    public static String cleanLine(String lineToClean) {
        DoubleLinkedList sentence = new DoubleLinkedList();
        DoubleLinkedList helper = new DoubleLinkedList();
        boolean isUsingHelper = false;

        for (int i = 0; i < lineToClean.length(); i++) {
            char c = lineToClean.charAt(i);

            if (c == '<') {
                if (isUsingHelper) {
                    helper.removeLast();
                } else {
                    sentence.removeLast();
                }
            } else if (c == '[') {
                // abc[ac[x -> acabc
                if (!helper.isEmpty()) {
                    sentence.combineAtHead(helper);
                    helper.clear();
                }

                isUsingHelper = true;
            } else if (c == ']') {
                if (!helper.isEmpty()) {
                    sentence.combineAtHead(helper);
                }

                isUsingHelper = false;
            } else {
                if (isUsingHelper) {
                    helper.addLast(c);
                } else {
                    sentence.addLast(c);
                }
            }

        }

        return sentence.printDoubleLinkedList();
    }

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int  n = io.getInt();
        
        try {
            while (n > 0) {
                String line = io.r.readLine();
                io.println(cleanLine(line));
                n--;
            }
        } catch (IOException ioe) {
            io.println("I/O Error");
        }


        io.close();
    }
}
