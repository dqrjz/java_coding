package easy.strStr;

/**
 * For a given source string and a target string, you should output the first index(from 0) of target string
 * in source string. If target does not exist in source, just return -1.
 * <p>
 * Example:
 * If source = "source" and target = "target", return -1.
 * If source = "abcdabcdefg" and target = "bcd", return 1.
 * <p>
 * Challenge:
 * O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)
 * <p>
 * Clarification:
 * Do I need to implement KMP Algorithm in a real interview?
 * Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your
 * basic implementation ability. But make sure you confirm with the interviewer first.
 */
public class StrStr {
	public static void main(String[] args) {
		String source = "abcdabcdefg";
		String target = "cda";
		int index = strStr(source, target);
		System.out.println(index);
	}
	
	/**
	 * KMP
	 * @param source: source string to be scanned.
	 * @param target: target string containing the sequence of characters to match
	 * @return a index to the first occurrence of target in source, or -1  if target is not part of source.
	 */
	public static int strStr(String source, String target) {
		// TODO KMP Algorithm
		return source.indexOf(target);
	}
}
