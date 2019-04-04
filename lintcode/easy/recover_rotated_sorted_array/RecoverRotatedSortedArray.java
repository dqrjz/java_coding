package easy.recover_rotated_sorted_array;

import java.util.Arrays;
import java.util.List;

/**
 * Given a rotated sorted array, recover it to sorted array in-place.
 * <p>
 * Clarification:
 * What is rotated array?
 * For example, the original array is [1,2,3,4], the rotated array of it
 * can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 * <p>
 * Example:
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * <p>
 * Challenge:
 * In-place, O(1) extra space and O(n) time.
 */
public class RecoverRotatedSortedArray {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(4, 5, 1, 2, 3);
		recoverRotatedSortedArray(nums);
		System.out.println(nums);
	}
	
	/**
	 * Correct method
	 * Refer to RotateString.java (Alternate method)
	 *
	 * @param nums An integer array
	 */
	public static void recoverRotatedSortedArray(List<Integer> nums) {
		for (int i = 0; i < nums.size() - 1; i++) {
			if (nums.get(i) > nums.get(i + 1)) {
				reverse(nums, 0, i);
				reverse(nums, i + 1, nums.size() - 1);
				reverse(nums, 0, nums.size() - 1);
				return;
			}
		}
	}
	
	private static void reverse(List<Integer> nums, int start, int end) {
		for (; start < end; start++, end--) {
			Integer temp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, temp);
		}
	}
}
