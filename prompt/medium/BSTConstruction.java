package prompt.medium;

public class BSTConstruction {

    static class BST {
        public int value;
        public BST left;
        public BST right;
    
        public BST(int value) {
            this.value = value;
        }
    
        public BST insert(int value) {
            BST currNode = this;
            while (true) {
                if (value < currNode.value) {
                    if (currNode.left == null) {
                        currNode.left = new BST(value);
                        break;
                    } else {
                        currNode = currNode.left;
                    }
                } else {
                    if (currNode.right == null) {
                        currNode.right = new BST(value);
                        break;
                    } else {
                        currNode = currNode.right;
                    }
                }
            }

            return this;
        }
    
        public boolean contains(int value) {
            BST currNode = this;
            while (currNode != null) {
                if (value < currNode.value) {
                    currNode = currNode.left;
                } else if (value > currNode.value) {
                    currNode = currNode.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }
    
        public void remove(int value, BST parent) {
            BST currNode = this;
            while (currNode != null) {
                if (value < currNode.value) {
                    parent = currNode;
                    currNode = currNode.left;
                } else if (value > currNode.value) {
                    parent = currNode;
                    currNode = currNode.right;
                } else {
                    // Case 1: node with 2 children
                    if (currNode.left != null && currNode.right != null) {
                        currNode.value = currNode.right.getLeftMostChild();
                        currNode.right.remove(currNode.value, currNode);
                    // Case 2: root node edge case
                    } else if (parent == null) {
                        if (currNode.left != null) {
                            // Note that order matters
                            currNode.value = currNode.left.value;
                            currNode.right = currNode.left.right;
                            currNode.left = currNode.left.left;
                        } else if (currNode.right != null) {
                            // Note that order matters
                            currNode.value = currNode.right.value;
                            currNode.left = currNode.right.left;
                            currNode.right = currNode.right.right;
                        } else {
                            // do nothing
                        }
                    // Case 3: if current node is the left child of a parent
                    } else if (parent.left == currNode) {
                        parent.left = currNode.left != null ? currNode.left : currNode.right;
                    // Case 4: if current node is the right child of a parent
                    } else if (parent.right == currNode) {
                        parent.right = currNode.left != null ? currNode.left : currNode.right;
                    }
                    break;
                }
            }
        }

        public int getLeftMostChild() {
            if (this.left == null) {
                return this.value;
            } else {
                return this.left.getLeftMostChild();
            }
        }
    }

    public static void main(String[] args) {
        var root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        root.insert(12);
        System.out.println(root.right.left.left.value == 12);

        root.remove(10);
        System.out.println(root.contains(10) == false);
        System.out.println(root.value == 12);

        System.out.println(root.contains(15));
    }
}
