import unittest

class BST:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

class TreeInfo:
    def __init__(self, rootIdx):
        self.rootIdx = rootIdx

def reconstructBst(preOrderTraversalValues):
    treeInfo = TreeInfo(0)
    return reconstructBstFromRange(float("-inf"), float("inf"), preOrderTraversalValues, treeInfo)

def reconstructBstFromRange(start, end, preOrderTraversalValues, currSubtreeInfo):
    if (currSubtreeInfo.rootIdx == len(preOrderTraversalValues)):
        return None

    rootValue = preOrderTraversalValues[currSubtreeInfo.rootIdx]
    if (rootValue < start or rootValue >= end):
        return None
    
    currSubtreeInfo.rootIdx += 1
    leftSubtree = reconstructBstFromRange(start, rootValue, preOrderTraversalValues, currSubtreeInfo)
    rightSubtree = reconstructBstFromRange(rootValue, end, preOrderTraversalValues, currSubtreeInfo)
    return BST(rootValue, leftSubtree, rightSubtree)


def getDfsOrder(node, values):
    if node is None:
        return
    values.append(node.value)
    getDfsOrder(node.left, values)
    getDfsOrder(node.right, values)
    return values


class TestProgram(unittest.TestCase):
    def test_case_1(self):
        preOrderTraversalValues = [10, 4, 2, 1, 3, 17, 19, 18]
        tree = BST(10)
        tree.left = BST(4)
        tree.left.left = BST(2)
        tree.left.left.left = BST(1)
        tree.left.right = BST(3)
        tree.right = BST(17)
        tree.right.right = BST(19)
        tree.right.right.left = BST(18)
        expected = getDfsOrder(tree, [])
        actual = reconstructBst(preOrderTraversalValues)
        actualDfsOrder = getDfsOrder(actual, [])
        self.assertEqual(actualDfsOrder, expected)

if __name__ == '__main__':
    unittest.main()