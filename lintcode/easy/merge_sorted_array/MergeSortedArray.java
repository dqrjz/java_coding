package easy.merge_sorted_array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <p>
 * Notice:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 * <p>
 * Example:
 * A = [1, 2, 3, empty, empty], B = [4, 5]
 * After merge, A will be filled as [1, 2, 3, 4, 5]
 */
public class MergeSortedArray {
	public static void main(String[] args) {
		int[] A = new int[5];
		int m = 3;
		A[0] = 1;
		A[1] = 2;
		A[2] = 4;
		int[] B = {3, 5};
		int n = 2;
		mergeSortedArray(A, m, B, n);
		
		display(A);
	}
	
	private static void display(int[] A) {
		StringBuilder sb = new StringBuilder("[");
		for (int a : A) {
			sb.append(a).append(",");
		}
		sb.setCharAt(sb.lastIndexOf(","), ']');
		System.out.println(sb);
	}
	
	/**
	 * My original method
	 *
	 * @param A sorted integer array A which has m elements, but size of A is m+n
	 * @param m An integer
	 * @param B sorted integer array B which has n elements
	 * @param n An integer
	 */
	public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
		for (int i = m + n - 1; i >= 0; i--) {
			if (n == 0) {
				A[i] = A[m-- - 1];
				continue;
			}
			if (m == 0) {
				A[i] = B[n-- - 1];
				continue;
			}
			if (A[m - 1] >= B[n - 1])
				A[i] = A[m-- - 1];
			else
				A[i] = B[n-- - 1];
		}
	}
}
