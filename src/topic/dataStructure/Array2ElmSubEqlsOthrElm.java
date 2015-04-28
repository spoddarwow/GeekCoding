package topic.dataStructure;

import java.util.HashSet;

/**
 * @author xspro
 *
 *         Given an array of int values design an efficient approach to find if
 *         the sum of any 2 values in the array is equal to a 3rd value in the
 *         same array.
 */
public class Array2ElmSubEqlsOthrElm {

	public static void main(String[] args) {
		int[] array = { 1, 6, 3, 10, 11, 18, 9 };
		findSumNPrint(array);
	}

	private static void findSumNPrint(int[] array) {
		HashSet<Integer> arraySet = new HashSet<Integer>();
		// O(N)
		for (int i : array) {
			arraySet.add(i);
		}

		boolean sumFound = false;
		int x = 0, y = 1;
		while (!sumFound && y < array.length - 1) {
			if (arraySet.contains(array[x] + array[y])) {
				sumFound = true;
			} else {
				x++;
				y++;
			}
		}
		if (sumFound) {
			System.out.println("2 numbers are : " + array[x] + " and "
					+ array[y]);
		} else {
			System.out.println("No valid numbers.");
		}

	}

}
