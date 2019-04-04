package easy.reverse_words_in_a_string;

/**
 * Given an input string, reverse the string word by word.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * <p>
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * <p>
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInAString {
	public static void main(String[] args) {
		String s = " the sky    is blue  ";
		String res = reverseWords(s);
		System.out.println(res);
	}
	
	/**
	 * My original method
	 *
	 * @param s A string
	 * @return A string
	 */
	public static String reverseWords(String s) {
		String[] ls = s.trim().split("\\s+");
		StringBuilder res = new StringBuilder();
		int i;
		for (i = ls.length - 1; i > 0; i--) {
			res.append(ls[i]).append(" ");
		}
		res.append(ls[i]);
		return res.toString();
	}
}
