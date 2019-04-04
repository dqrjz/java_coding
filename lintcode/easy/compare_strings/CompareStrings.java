package easy.compare_strings;

/**
 * Compare two strings A and B, determine whether A contains all of the characters in B.
 * <p>
 * The characters in string A and B are all Upper Case letters.
 * <p>
 * Notice:
 * The characters of B in A are not necessary continuous or ordered.
 * <p>
 * Example:
 * For A = "ABCD", B = "ACD", return true.
 * For A = "ABCD", B = "AABC", return false.
 */
public class CompareStrings {
	public static void main(String[] args) {
		String A = "ABCD";
		String B = "AABC";
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			compareStrings1(A, B);
		}
		System.out.println(compareStrings1(A, B));
		long t2 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			compareStrings2(A, B);
		}
		System.out.println(compareStrings2(A, B));
		long t3 = System.currentTimeMillis();
		System.out.println((t2 - t1) + ", " + (t3 - t2)); // Method 2 is faster
	}
	
	/**
	 * Better method (Using the fact that all letters are Upper Case)
	 *
	 * @param A A string
	 * @param B A string
	 * @return if string A contains all of the characters in B return true else return false
	 */
	private static boolean compareStrings2(String A, String B) {
		int[] counts = new int[26];
		for (int i = 0; i < 26; i++)
			counts[i] = 0;
		
		for (int i = 0; i < A.length(); i++)
			counts[A.charAt(i) - 'A']++;
		
		for (int i = 0; i < B.length(); i++)
			if (--counts[B.charAt(i) - 'A'] < 0) return false;
		
		return true;
	}
	
	/**
	 * My original method
	 *
	 * @param A A string
	 * @param B A string
	 * @return if string A contains all of the characters in B return true else return false
	 */
	public static boolean compareStrings1(String A, String B) {
		StringBuilder a = new StringBuilder(A);
		for (int i = 0; i < B.length(); i++) {
			Character b = B.charAt(i);
			if (a.indexOf(b.toString()) == -1)
				return false;
			else a.deleteCharAt(a.indexOf(b.toString()));
		}
		return true;
		
		
	}
}