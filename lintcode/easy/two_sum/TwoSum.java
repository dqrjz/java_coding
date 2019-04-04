package easy.two_sum;

import java.util.ArrayList;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.
 * <p>
 * Notice:
 * You may assume that each input would have exactly one solution
 * <p>
 * Example:
 * numbers=[2, 7, 11, 15], target=9
 * return [0, 1]
 * <p>
 * Challenge:
 * Either of the following solutions are acceptable:
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] numbers = {1, 0, -1};
		int target = -1;
		int[] res = twoSum(numbers, target);
		System.out.println("[" + res[0] + ", " + res[1] + "]");
	}
	
	/**
	 * My original method
	 *
	 * @param numbers An array of Integer
	 * @param target  target = numbers[index1] + numbers[index2]
	 * @return [index1 + 1, index2 + 1] (index1 < index2)
	 */
	public static int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;
		}
		
		int[] res = new int[2];
		ArrayList<Integer> prev = new ArrayList<>();
		prev.add(numbers[0]);
		for (int i = 1; i < numbers.length; i++) {
			int match = target - numbers[i];
			if (prev.contains(match)) {
				res[0] = prev.indexOf(match);
				res[1] = i;
				break;
			} else
				prev.add(numbers[i]);
		}
		return res;
	}
}
