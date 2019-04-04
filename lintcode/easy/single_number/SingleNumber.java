package easy.single_number;

import java.util.Arrays;

/**
 * Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
 * <p>
 * Example:
 * Given [1,2,2,1,3,4,3], return 4
 * <p>
 * Challenge:
 * One-pass, constant extra space.
 */
public class SingleNumber {
	public static void main(String[] args) {
		int[] A = {1,2,2,1,3,7,3};
		System.out.println(Arrays.toString(A));
		System.out.println("rst\ta\trst");
		System.out.println(singleNumber(A));
	}
	
	/**
	 * @param A An integer array
	 * @return An integer
	 */
	public static int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int rst = 0;
		for (int a : A) {
			System.out.print(Integer.toBinaryString(rst));
			System.out.print("\t"+Integer.toBinaryString(a));
			rst ^= a;
			System.out.println("\t"+Integer.toBinaryString(rst));
		}
		return rst;
	}
}
