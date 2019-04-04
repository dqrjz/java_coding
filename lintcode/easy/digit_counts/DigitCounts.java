package easy.digit_counts;

/**
 * Count the number of k's between 0 and n. k can be 0-9. For example, when n =
 * 12 and k = 1, the result is 5. (1, 10, 11, 12)
 * 
 * @author JZ
 *
 */
public class DigitCounts {
	public static void main(String[] args) {
		int n = 12;
		int k = 1; // k can be 0-9.
		// testMethod(k);
		System.out.println(digitCounts1(n, k));
		System.out.println(digitCounts2(n, k));
	}

	public static void testMethod(int k) {
		boolean flag = true;
		for (int nn = 0; nn < 1000; nn++) {
			if (digitCounts1(nn, k) != digitCounts2(nn, k)) {
				flag = false;
				System.out.println(nn + "," + digitCounts1(nn, k) + "," + digitCounts2(nn, k));
			}
		}
		System.out.println(flag);
	}

	/** Better method */
	// 当某一位上的数字小于k时，该位出现k的次数： 更高位数字 * 当前位数
	// 当某一位上的数字等于k时，该位出现k的次数： 更高位数字 * 当前位数 + 更低位数字 + 1
	// 当某一位上的数字大于k时，该位出现k的次数： (更高位数字 + 1) * 当前位数
	public static int digitCounts2(int n, int k) {
		int count = 0;
		int factor = 1;
		do {
			int low = n % factor;
			// int cur = n % (factor * 10); // Highest digit would be wrong!!!
			int cur = n / factor % 10; // Correct way.
			int high = n / (factor * 10);
			// System.out.println("n=" + n + " [" + high + "," + cur + "," + low + "]
			// factor=" + factor);
			if ((k == 0) && (factor > 1)) {
				if (cur == k)
					count += (high - 1) * factor + low + 1;
				else
					count += high * factor;
			} else {
				if (cur < k)
					count += high * factor;
				else if (cur == k)
					count += high * factor + low + 1;
				else // cur > k
					count += (high + 1) * factor;
			}
			factor *= 10;
		} while (n / factor != 0);
		return count;
	}

	/** My original method */
	public static int digitCounts1(int n, int k) {
		int count = 0;
		for (int i = 0; i <= n; i++) {
			char[] charArray = Integer.toString(i).toCharArray();
			for (char c : charArray) {
				if (Character.toString(c).equals(Integer.toString(k)))
					count++;
			}
		}
		return count;
	}
}
