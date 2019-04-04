package easy.search_insert_position;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume NO duplicates in the array.
 * <p>
 * Example:
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * <p>
 * Challenge:
 * O(log(n)) time
 */
public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] A = {1, 3, 5, 6};
		int target1 = 5; // --> 2
		int target2 = 2; // --> 1
		int target3 = 7; // --> 4
		int target4 = 0; // --> 0
		System.out.println(searchInsert(A, target1));
		System.out.println(searchInsert(A, target2));
		System.out.println(searchInsert(A, target3));
		System.out.println(searchInsert(A, target4));
	}
	
	/**
	 * My method
	 *
	 * @param A      an integer sorted array
	 * @param target an integer to be inserted
	 * @return An integer
	 */
	public static int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int start = 0;
		int end = A.length - 1;
		
		while (start < end - 1) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target)
				return mid;
			else if (A[mid] < target)
				start = mid;
			else
				end = mid;
		}
		// By now, start = end - 1
		if (target <= A[start])
			return start;
		else if (target <= A[end])
			return end;
		else
			return end + 1;
	}
}
