package easy.minimum_subarray;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, find the subarray with smallest sum.
 * Return the sum of the subarray.
 * <p>
 * Notice:
 * The subarray should contain one integer at least.
 * <p>
 * Example:
 * For [1, -1, -2, 1], return -3.
 */
public class MinimumSubarray {
	public static void main(String[] args) {
//		Integer[] nums = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
		Integer[] nums = {1, -1, -2, 1};
		System.out.println(minSubarray(Arrays.asList(nums)));
	}
	
	/**
	 * Prefix Sum
	 * Time complexity O(n)
	 *
	 * @param nums A list of integers
	 * @return An integer indicating the sum of minimum subarray
	 */
	private static int minSubarray(List<Integer> nums) {
		if (nums == null || nums.size() == 0)
			return 0;
		
		int min = Integer.MAX_VALUE, sum = 0;
		for (int i = 0; i < nums.size(); i++) {
			// Prefix Sum
			sum = Math.min(nums.get(i), sum + nums.get(i));
			min = Math.min(min, sum);
		}
		return min;
	}
}
