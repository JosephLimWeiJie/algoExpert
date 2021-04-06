package prompt.easy;

import java.util.*;

public class DepthFirstSearch {
    
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for (Node child : this.children) {
                child.depthFirstSearch(array);
            }

            return array;            
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static boolean compare(List<String> arr1, String[] arr2) {
        if (arr1.size() != arr2.length) {
          return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
          if (!arr1.get(i).equals(arr2[i])) {
            return false;
          }
        }
        return true;
      }

    public static void main(String[] args) {
        Node graph = new Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        
        String[] expected = {"A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H"};
        List<String> inputArray = new ArrayList<String>();
        System.out.println(compare(graph.depthFirstSearch(inputArray), expected));
    }
}
