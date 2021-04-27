import unittest

def maxSubsetSumNoAdjacent(array):
    if (len(array) == 0):
        return 0
    elif (len(array) == 1):
        return array[0]
    else:
        array[1] = max(array[0], array[1])
        for i in range(2, len(array)):
            array[i] = max(array[i - 2] + array[i], array[i - 1])
        return array[len(array) - 1]
        
class TestProgram(unittest.TestCase):
    def test_case_1(self):
        self.assertEqual(maxSubsetSumNoAdjacent([75, 105, 120, 75, 90, 135]), 330)

if __name__ == '__main__':
    unittest.main()