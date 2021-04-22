import unittest

class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

class TreeInfo:
    def __init__(self, diameter, height):
        self.diameter = diameter
        self.height = height

def binaryTreeDiameter(tree):
    return getTreeInfo(tree).diameter

def getTreeInfo(tree):
    if (tree is None):
        return TreeInfo(0, 0)
    
    leftTreeInfo = getTreeInfo(tree.left)
    rightTreeInfo = getTreeInfo(tree.right)

    pathWithRoot = leftTreeInfo.height + rightTreeInfo.height
    currDiameter = max(pathWithRoot, leftTreeInfo.diameter, rightTreeInfo.diameter)
    currHeight = max(leftTreeInfo.height, rightTreeInfo.height) + 1

    return TreeInfo(currDiameter, currHeight)

class TestProgram(unittest.TestCase):
    def test_case_1(self):
        root = BinaryTree(1)
        root.left = BinaryTree(3)
        root.left.left = BinaryTree(7)
        root.left.left.left = BinaryTree(8)
        root.left.left.left.left = BinaryTree(9)
        root.left.right = BinaryTree(4)
        root.left.right.right = BinaryTree(5)
        root.left.right.right.right = BinaryTree(6)
        root.right = BinaryTree(2)
        expected = 6
        actual = binaryTreeDiameter(root)
        self.assertEqual(actual, expected)


if __name__ == "__main__":
    unittest.main()