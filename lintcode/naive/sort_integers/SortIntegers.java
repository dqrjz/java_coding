package naive.sort_integers;

/**
 * Given an integer array, sort it in ascending order.
 * Use selection sort, bubble sort, insertion sort or any O(n2) algorithm.
 * <p>
 * Example:
 * Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
 */
public class SortIntegers {
	public static void main(String[] args) {
		int[] ints = {3, 2, 1, 4, 5, 3, 0, 9, 5, 7};
//		int[] ints = null;
//		selectionSort(ints);
//		bubbleSort(ints);
		insertionSort(ints);
		
		if (ints == null) System.out.println(ints);
		else for (int i : ints) System.out.print(i + " ");
		
	}
	
	public static void insertionSort(int[] ints) {
		if (ints != null) {
			for (int i = 1; i < ints.length; i++) {
				int temp = ints[i];
				int j;
				for (j = i - 1; j >= 0 && ints[j] > temp; j--)
					ints[j + 1] = ints[j];
				ints[j + 1] = temp;
			}
		}
	}
	
	public static void bubbleSort(int[] ints) {
		if (ints != null) {
			for (int i = 0; i < ints.length - 1; i++) {
				for (int j = i; j < ints.length; j++) {
					if (ints[j] < ints[i]) {
						int temp = ints[i];
						ints[i] = ints[j];
						ints[j] = temp;
					}
				}
			}
		}
	}
	
	public static void selectionSort(int[] ints) {
		if (ints != null) {
			for (int i = 0; i < ints.length - 1; i++) {
				int minIndex = i;
				for (int j = i + 1; j < ints.length; j++) {
					if (ints[j] < ints[minIndex])
						minIndex = j;
				}
				if (minIndex != i) {
					int temp = ints[i];
					ints[i] = ints[minIndex];
					ints[minIndex] = temp;
				}
			}
		}
	}
	
}
