package Medium;

import java.util.*;

class Program {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.

            // Time:  O(logN) average, O(N) worst
            // Space: O(logN) average, O(N) worse

            if (value < this.value) {
                if (this.left == null) {
                    this.left = new BST(value);
                } else {
                    this.left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    this.right.insert(value);
                }
            }

            // Do not edit the return statement of this method.
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.

            // Time:  O(logN) average, O(N) worst
            // Space: O(logN) average, O(N) worse

            if (value == this.value) {
                return true;
            } else if (value > this.value) {
                if (this.right == null) {
                    return false;
                } else {
                    return this.right.contains(value);
                }
            } else if (value < this.value) {
                if (this.left == null) {
                    return false;
                } else {
                    return this.left.contains(value);
                }
            }

            return false;
        }


        public BST remove(int value) {
            // Write your code here.
            this.remove(value, null);
            // Do not edit the return statement of this method.
            return this;
        }

        public void remove(int value, BST parent) {

            // Time:  O(logN) average, O(N) worst
            // Space: O(logN) average, O(N) worse

            // Case 1: value < this.value
            if (value < this.value) {
                if (this.left != null) {
                    this.left.remove(value, this);
                }
            // Case 2: value > this.value
            } else if (value > this.value) {
                if (this.right != null) {
                    this.right.remove(value, this);
                }
            // Case 3: value == this.value
            } else {
                // if this current node has 2 children
                if (this.left != null && this.right != null) {
                    this.value = this.right.getMinValue();
                    this.right.remove(this.value, this);
                // if this current node has no parent
                } else if (parent == null) {
                    if (this.left != null) {
                        this.value = this.left.value;
                        this.right = this.left.right;
                        this.left = this.left.left;
                    } else if (this.right != null) {
                        this.value = this.right.value;
                        this.left = this.right.left;
                        this.right = this.right.right;
                    } else {
                        // do nothing for single node case
                    }

                // if this current node is the single left child of a parent
                } else if (parent.left == this) {
                    parent.left = this.left != null ? this.left : this.right;
                // if this current node is the single right child of a parent
                } else if (parent.right == this) {
                    parent.right = this.left != null ? this.left : this.right;
                }
            }
        }

        public int getMinValue() {
            if (this.left == null) {
                return this.value;
            } else {
                return this.left.getMinValue();
            }
        }
    }
}
