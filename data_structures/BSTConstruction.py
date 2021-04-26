from typing import get_type_hints
import unittest

class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def insert(self, value):
        # Write your code here.
        # Do not edit the return statement of this method.
        currNode = self
        while True:
            if (value < currNode.value):
                if (currNode.left is None):
                    currNode.left = BST(value)
                    break
                else:
                    currNode = currNode.left
            else:
                if (currNode.right is None):
                    currNode.right = BST(value)
                    break
                else:
                    currNode = currNode.right

        return self

    def contains(self, value):
        # Write your code here.
        currNode = self
        while (currNode != None):
            if (currNode.value == value):
                return True
            elif (value > currNode.value):
                currNode = currNode.right
            else:
                currNode = currNode.left
        return False

    def remove(self, value, parent=None):
        currNode = self
        while (currNode != None):
            if (value > currNode.value):
                parent = currNode
                currNode = currNode.right
            elif (value < currNode.value):
                parent = currNode
                currNode = currNode.left
            else:
                # 2 children
                if (currNode.left != None and currNode.right != None):
                    currNode.value = currNode.right.getLeftMostChildValue()
                    currNode.right.remove(currNode.value, currNode)
                # 1 child case - currNode has no parent
                elif parent is None:
                    if (currNode.left != None):
                        currNode.value = currNode.left.value
                        currNode.right = currNode.left.right
                        currNode.left = currNode.left.left
                    elif (currNode.right != None):
                        currNode.value = currNode.right.value
                        currNode.left = currNode.right.left
                        currNode.right = currNode.right.right
                    else:
                        # single node case
                        pass
                # 1 child case - currNode is left of parent
                elif parent.left is currNode:
                    parent.left = currNode.left if currNode.left is not None else currNode.right
                # 1 child case - currNode is right of parent
                elif parent.right is currNode:
                    parent.right = currNode.left if currNode.left is not None else currNode.right
                break
            
        return self

    def getLeftMostChildValue(self):
        if self.left is None:
            return self.value
        else:
            return self.left.getLeftMostChildValue()


class TestProgram(unittest.TestCase):
    def test_case_1(self):
        root = BST(10)
        root.left = BST(5)
        root.left.left = BST(2)
        root.left.left.left = BST(1)
        root.left.right = BST(5)
        root.right = BST(15)
        root.right.left = BST(13)
        root.right.left.right = BST(14)
        root.right.right = BST(22)

        root.insert(12)
        self.assertTrue(root.right.left.left.value == 12)

        root.remove(10)
        self.assertTrue(not root.contains(10))
        self.assertTrue(root.value == 12)

        self.assertTrue(root.contains(15))


if __name__ == '__main__':
    unittest.main()