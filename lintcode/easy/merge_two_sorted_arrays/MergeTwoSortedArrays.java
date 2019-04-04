package easy.merge_two_sorted_arrays;

/**
 * Merge two given sorted integer array A and B into a new sorted integer array.
 * <p>
 * Example:
 * A=[1,2,3,4]
 * B=[2,4,5,6]
 * return [1,2,2,3,4,4,5,6]
 * <p>
 * Challenge:
 * How can you optimize your algorithm if one array is very large and the other is very small?
 */
public class MergeTwoSortedArrays {
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		int[] B = {2, 4, 5, 6, 9, 10, 13};
		int[] C = mergeSortedArray(A, B);
		if (C == null)
			System.out.println(C);
		else for (int i : C) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * @param A sorted integer array A
	 * @param B sorted integer array B
	 * @return A new sorted integer array
	 */
	public static int[] mergeSortedArray(int[] A, int[] B) {
		if (A == null)
			if (B == null)
				return null;
			else
				return B;
		else if (B == null)
			return A;
		else {
			int[] C = new int[A.length + B.length];
			int i = 0;
			boolean aEnd = false;
			int j = 0;
			boolean bEnd = false;
			int k = 0;
			while (true) {
				if (i == A.length) {
					aEnd = true;
					break;
				}
				if (j == B.length) {
					bEnd = true;
					break;
				}
				if (A[i] < B[j])
					C[k++] = A[i++];
				else C[k++] = B[j++];
			}
			if (aEnd)
				while (j < B.length)
					C[k++] = B[j++];
			else if (bEnd)
				while (i < A.length)
					C[k++] = A[i++];
			return C;
		}
	}
}
