package easy.trailing_zeros;

/**
 * Write an algorithm which computes the number of trailing zeros in n factorial
 * 
 * @author JZ
 *
 */
public class TrailingZeros {
	public static void main(String[] args) {
		long n = 10000L;
//		System.out.println("IntegerMax: \t" + Integer.MAX_VALUE);
//		System.out.println("LongMax: \t" + Long.MAX_VALUE);
		System.out.println("Factorial: \t" + getFactorial(n));
		System.out.println("Trailing zeros: \t" + trailingZeros1(n)); // My original method
		System.out.println("Trailing zeros: \t" + trailingZeros2(n)); // Best method
	}

	// Calculate factorial
	@SuppressWarnings("unused")
	private static long getFactorial(long n) {
		if (n == 1)
			return n;
		else
			return n * getFactorial(n - 1);
	}

	/** Best method */
	public static long trailingZeros2(long n) {
		long sum = 0;
		while ((n /= 5) != 0) {
			sum += n;
		}
		return sum;
	}

	/** My original method */
	public static long trailingZeros1(long n) {
		long numOfFive = 0;
//		long numOfTwo = 0;
		for (long i = 1; i <= n; i++) {
			long j = i;
			while (j % 5 == 0) {
				numOfFive++;
				j /= 5;
			}
//			while (j % 2 == 0) {
//				numOfTwo++;
//				j /= 2;
//			}
		}
//		return Math.min(numOfFive, numOfTwo);
		return numOfFive;
	}
}
