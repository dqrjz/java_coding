package easy.product_of_array_exclude_itself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integers array A.
 * <p>
 * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.
 * <p>
 * Example:
 * For A = [1, 2, 3], return [6, 3, 2].
 */
public class ProductOfArrayExcludeItself {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		List<Long> res1 = productExcludeItself1(nums);
		List<Long> res2 = productExcludeItself2(nums);
		System.out.println(res1);
		System.out.println(res2);
	}
	
	private static List<Long> productExcludeItself2(List<Integer> nums) {
		ArrayList<Long> res = new ArrayList<>();
		int len = nums.size();
		long[] left = new long[len];
		long[] right = new long[len];
		
		right[len - 1] = 1;
		for (int i = len - 2; i >= 0; i--)
			right[i] = right[i + 1] * nums.get(i + 1);
		
		left[0] = 1;
		res.add(left[0] * right[0]);
		for (int i = 1; i < len; i++) {
			left[i] = left[i - 1] * nums.get(i - 1);
			res.add(left[i] * right[i]);
		}
		return res;
	}
	
	
	/**
	 * Solution on http://www.jiuzhang.com/solutions/product-of-array-exclude-itself/
	 * I think it can be improved.
	 *
	 * @param nums Given an integers array A
	 * @return A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
	 */
	public static List<Long> productExcludeItself1(List<Integer> nums) {
		int len = nums.size();
		ArrayList<Long> res = new ArrayList<>();
		long[] f = new long[len];
		
		long tmp = 1;
		f[len - 1] = nums.get(len - 1);
		int i;
		for (i = len - 2; i >= 0; --i) {
			f[i] = nums.get(i);
			f[i] = f[i] * f[i + 1];
		}
		
		long now;
		for (i = 0; i < len; ++i) {
			
			now = tmp;
			if (i < len - 1)
				res.add(now * f[i + 1]);
			else
				res.add(now);
			now = nums.get(i);
			tmp = tmp * now;
			
		}
		return res;
	}
}
