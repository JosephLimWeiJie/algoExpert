import unittest
from queue import PriorityQueue

def mergeSortedArrays(arrays):
    mapArrayIdToRunningIdx = {}
    ans = []

    for i in range(0, len(arrays)):
        mapArrayIdToRunningIdx[i] = 0

    # insert initial values into funnel
    # Each element in funnel is in type (value, currRunningIdx, arrayId)
    funnel = PriorityQueue()
    for i in range(0, len(arrays)):
        funnel.put((arrays[i][0], mapArrayIdToRunningIdx[i], i))

    while not funnel.empty():
        currElement = funnel.get()
        currValueToAdd = currElement[0]
        currRunningIdx = currElement[1]
        arrayId = currElement[2]
        ans.append(currValueToAdd)

        nextIdx = currRunningIdx + 1
        if (nextIdx < len(arrays[arrayId])):
            mapArrayIdToRunningIdx[arrayId] = nextIdx
            funnel.put((arrays[arrayId][nextIdx], nextIdx, arrayId))
    
    return ans  

class TestProgram(unittest.TestCase):
    def test_case_1(self):
        arrays = [
            [1, 5, 9, 21],
            [-1, 0],
            [-124, 81, 121],
            [3, 6, 12, 20, 150],
        ]
        output = mergeSortedArrays(arrays)
        self.assertEqual(output, [-124, -1, 0, 1, 3, 5, 6, 9, 12, 20, 21, 81, 121, 150])

if __name__ == '__main__':
    unittest.main()