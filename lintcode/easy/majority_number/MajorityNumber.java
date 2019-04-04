package easy.majority_number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.
 * <p>
 * Notice:
 * You may assume that the array is non-empty and the majority number always exist in the array.
 * <p>
 * Example:
 * Given [1, 1, 1, 1, 2, 2, 2], return 1.
 * <p>
 * Challenge:
 * O(n) time and O(1) extra space
 */
public class MajorityNumber {
	public static void main(String[] args) {
		Integer[] nums = {1, 1, 1, 1, 2, 2, 2};
		System.out.println(majorityNumber(Arrays.asList(nums)));
	}
	
	/**
	 * My original method (HashMap)
	 *
	 * @param nums a list of integers
	 * @return find a  majority number
	 */
	public static int majorityNumber(List<Integer> nums) {
		HashMap<Integer, Integer> count = new HashMap<>();
		int majorNum = 0;
		int maxCount = 0;
		for (Integer num : nums) {
			if (count.containsKey(num))
				count.put(num, count.get(num) + 1);
			else
				count.put(num, 1);
			if (count.get(num) > maxCount) {
				maxCount = count.get(num);
				majorNum = num;
			}
		}
		return majorNum;
	}
}
