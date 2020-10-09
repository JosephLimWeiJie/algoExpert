import java.util.*;

class Program {
    public static int[] insertionSort(int[] array) {

        // Time: O(n ** 2) Worst-casse
        // Space: O(1)

		if (array.length == 0) {
			return new int[] {};
		}

		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j > 0 && array[j] < array[j - 1]) {
				swap(j, j - 1, array);
				j--;
			}
		}

    return array;
  }

	public static void swap(int first, int second, int[] array) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}
