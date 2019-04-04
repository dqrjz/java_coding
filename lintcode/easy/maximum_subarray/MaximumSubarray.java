package easy.maximum_subarray;

/**
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 * <p>
 * Notice:
 * The subarray should contain at least one number.
 * <p>
 * Example:
 * Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * <p>
 * Challenge:
 * Can you do it in time complexity O(n)?
 */
public class MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
//		System.out.println(maxSubarray1(nums));
		System.out.println(maxSubarray2(nums));
//		System.out.println(maxSubarray3(nums));
	}
	
	/**
	 * Version 1: Greedy
	 * Time complexity O(n)
	 *
	 * @param nums A list of integers
	 * @return An integer indicating the sum of max subarray
	 */
	public static int maxSubarray1(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		
		int max = Integer.MIN_VALUE, sum = 0;
		for (int num : nums) {
			// Greedy
			sum += num;
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
//			System.out.println("max=" + max + ", sum =" + sum);
		}
		return max;
	}
	
	/**
	 * Version 2: Prefix Sum (Kadane's algorithm)
	 * Time complexity O(n)
	 *
	 * @param nums A list of integers
	 * @return An integer indicating the sum of max subarray
	 */
	public static int maxSubarray2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			// Prefix Sum
			sum = Math.max(nums[i], sum + nums[i]); // sum = maxEndingHere
			max = Math.max(max, sum); // max = maxSoFar
			System.out.println("sum=" + sum + ", max =" + max);
		}
		return max;
	}
	
	/**
	 * Version 3: Divide and Conquer
	 *
	 * @param nums A list of integers
	 * @return An integer indicating the sum of max subarray
	 */
	public static int maxSubarray3(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return divide(nums, 0, nums.length - 1);
	}
	
	public static int divide(int[] nums, int low, int high) {
		if (low == high)
			return nums[low];
		if (low == high - 1)
			return Math.max(nums[low] + nums[high], Math.max(nums[low], nums[high]));
		int mid = (low + high) / 2;
		int lMax = divide(nums, low, mid - 1);
		int rMax = divide(nums, mid + 1, high);
		
		int mMax = nums[mid];
		int temp = mMax;
		for (int i = mid - 1; i >= low; i--) {
			temp += nums[i];
			if (temp > mMax)
				mMax = temp;
		}
		temp = mMax;
		for (int i = mid + 1; i <= high; i++) {
			temp += nums[i];
			if (temp > mMax)
				mMax = temp;
		}
		return Math.max(mMax, Math.max(lMax, rMax));
	}
}
