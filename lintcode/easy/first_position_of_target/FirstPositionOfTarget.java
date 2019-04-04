package easy.first_position_of_target;

/**
 * For a given sorted array (ascending order) and a target number,
 * find the first index of this number in O(log n) time complexity.
 * <p>
 * If the target number does not exist in the array, return -1.
 * <p>
 * Example:
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 * <p>
 * Challenge:
 * If the count of numbers is bigger than 2^32, can your code work properly?
 */
public class FirstPositionOfTarget {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 4, 5, 10};
		int target = 7;
		int firstIndex = binarySearch(nums, target);
		System.out.println(firstIndex);
	}
	
	/**
	 * @param nums   The integer array.
	 * @param target Target to find.
	 * @return The first position of target. Position starts from 0.
	 */
	public static int binarySearch(int[] nums, int target) {
		// Cannot just use Arrays.binarySearch() method.
		// Arrays.binarySearch() will return (-(insertion point) - 1)
		// if the target is not contained in the array;
		if (nums == null || nums.length == 0) return -1;
		else {
			int low = 0;
			int high = nums.length - 1;
			
			while (low <= high) {
				int mid = (low + high) >>> 1;
				int midVal = nums[mid];
				
				if (midVal < target)
					low = mid + 1;
				else if (midVal > target)
					high = mid - 1;
				else {
					// target found
					// If multiple target exists, the returned index may not be the first one.
					while (mid > 0 && nums[mid - 1] == nums[mid]) mid--;
					return mid;
				}
//				System.out.println("low=" + low + ", mid=" + mid + ", high=" + high);
			}
			return -1;  // target not found.
		}
	}
}
