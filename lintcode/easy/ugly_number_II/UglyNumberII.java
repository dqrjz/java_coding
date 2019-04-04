package easy.ugly_number_II;

import java.util.ArrayList;

/**
 * Ugly number is a number that only have factors 2, 3 and 5. Design an
 * algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3,
 * 4, 5, 6, 8, 9, 10, 12...
 * <p>
 * Note that 1 is typically treated as an ugly number.
 * <p>
 * Example: If n=9, return 10.
 *
 * @author JZ
 */
public class UglyNumberII {
	public static void main(String[] args) {
		int n = 9;
		System.out.println(nthUglyNumber1(n));
//		for (int i = 1; i < 40; i++) {
//			System.out.print(nthUglyNumber1(i) + " ");
//		}
	}
	
	/** My method (corrected) */
	// 1 2 3 4 5 6 8 9 10 12 15 16 18 20 24 25 27 30 32 36 40 45 48 50 54 60 64 72
	// 75 80 81 90 96 100 108 120 125 128 135 ...
	// 1x2->2x2  2x2->3x2  3x2->4x2->5x2
	// 1x3  1x3->2x3  2x3  2x3->3x3  3x3
	// 1x5  1x5  1x5  1x5->2x5  2x5  2x5
	public static int nthUglyNumber1(int n) {
		ArrayList<Integer> uglyNum = new ArrayList<>();
		uglyNum.add(1);
		if (n > 1) {
			int[] factorIndices = {0, 0, 0};
			while (uglyNum.size() < n) {
				int n2 = uglyNum.get(factorIndices[0]) * 2;
				int n3 = uglyNum.get(factorIndices[1]) * 3;
				int n5 = uglyNum.get(factorIndices[2]) * 5;
				int minN = Math.min(n2, Math.min(n3, n5));
				uglyNum.add(minN);
				if (n2 == minN) factorIndices[0]++;
				if (n3 == minN) factorIndices[1]++;
				if (n5 == minN) factorIndices[2]++;
			}
		}
		return uglyNum.get(n - 1);
	}
}
