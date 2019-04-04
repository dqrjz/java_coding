package easy.median;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given a unsorted array with integers, find the median of it.
 * A median is the middle number of the array after it is sorted.
 * If there are even numbers in the array, return the N/2-th number after sorted.
 * <p>
 * Example:
 * Given [4, 5, 1, 2, 3], return 3.
 * Given [7, 9, 4, 5], return 5.
 * <p>
 * Challenge:
 * O(n) time.
 */
public class Median {
	/**
	 * 最小堆
	 * 首先将数组的前（n+1）／2个元素建立一个最小堆。
	 * 然后，对于下一个元素，和堆顶的元素比较，如果小于等于，丢弃之，接着看下一个元素。
	 * 如果大于，则用该元素取代堆顶，再调整堆，接着看下一个元素。重复这个步骤，直到数组为空。
	 * 当数组都遍历完了，那么，堆顶的元素即是中位数。
	 *
	 * @param nums A list of integers
	 * @return An integer denotes the middle number of the array
	 */
	public static double median3(int[] nums) {
		// TODO Learn!
		int heapSize = nums.length / 2 + 1;
		PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
		for (int i = 0; i < heapSize; i++) {
			heap.add(nums[i]);
		}
		for (int i = heapSize; i < nums.length; i++) {
			if (heap.peek() < nums[i]) {
				heap.poll();
				heap.add(nums[i]);
			}
		}
		if (nums.length % 2 == 1) {
			return (double) heap.peek();
		} else {
			return (double) (heap.poll() + heap.peek()) / 2.0;
		}
	}
	
	
	/**
	 * Better method
	 *
	 * @param nums A list of integers
	 * @return An integer denotes the middle number of the array
	 */
	public int median2(int[] nums) {
		return sub(nums, 0, nums.length - 1, (nums.length + 1) / 2);
	}
	
	private int sub(int[] nums, int start, int end, int size) {
		int mid = (start + end) / 2;
		int pivot = nums[mid];
		int i = start - 1, j = end + 1;
		for (int k = start; k < j; k++) {
			if (nums[k] < pivot) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[k];
				nums[k] = tmp;
			} else if (nums[k] > pivot) {
				j--;
				int tmp = nums[j];
				nums[j] = nums[k];
				nums[k] = tmp;
				k--;
			}
		}
		if (i - start + 1 >= size) {
			return sub(nums, start, i, size);
		} else if (j - start >= size) {
			return nums[j - 1];
		} else {
			return sub(nums, j, end, size - (j - start));
		}
	}
	
	
	/**
	 * My original method (Obviously too slow)
	 *
	 * @param nums A list of integers
	 * @return An integer denotes the middle number of the array
	 */
	public int median(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		if (len % 2 == 1)
			return nums[len / 2];
		else
			return nums[(len - 1) / 2];
	}
}
