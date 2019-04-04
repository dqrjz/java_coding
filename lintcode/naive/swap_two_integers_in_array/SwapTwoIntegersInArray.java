package naive.swap_two_integers_in_array;

/**
 * Given an array and two indexes, swap the integers on the two indices.
 * <p>
 * Example: Given [1,2,3,4] and index1 = 2, index2 = 3. The array will change to [1,2,4,3] after swapping.
 * You don't need return anything, just swap the integers in-place.
 */
public class SwapTwoIntegersInArray {
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		int index1 = 0;
		int index2 = 2;
		swapIntegers(A, index1, index2);
		if (A == null) System.out.println(A);
		else for (int i : A) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * @param A      An integer array
	 * @param index1 the first index
	 * @param index2 the second index
	 */
	public static void swapIntegers(int[] A, int index1, int index2) {
		if ((A != null) && (A.length > Math.max(index1, index2)) && (0 <= Math.min(index1, index2)))
			if (index1 != index2) {
				int temp = A[index1];
				A[index1] = A[index2];
				A[index2] = temp;
			}
	}
}
