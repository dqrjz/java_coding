package naive.hex_conversion;

/**
 * Given a decimal number n and an integer k, Convert decimal number n to base-k.
 * <p>
 * Notice:
 * 1.   0<=n<=2^31-1, 2<=k<=16
 * 2.   Each letter over 9 is indicated in uppercase
 * <p>
 * Example 1:
 * Given n = 5, k = 2
 * return "101"
 * <p>
 * Example 2:
 * Given n = 30, k = 16
 * return "1E"
 */
public class HexConversion {
	public static void main(String[] args) {
		System.out.println(hexConversion(5, 2));
		System.out.println(hexConversion(30, 16));
	}
	
	/**
	 * @param n a decimal number
	 * @param k an Integer representing base-k
	 * @return a base-k number
	 */
	public static String hexConversion(int n, int k) {
		if (n == 0) return "0";
		StringBuilder sb = new StringBuilder("");
		while (n != 0) {
			int remainder = n % k;
			n /= k;
			if (remainder < 10) sb.append(remainder);
			else sb.append((char) (remainder - 10 + 'A'));
		}
		return sb.reverse().toString();
	}
}
