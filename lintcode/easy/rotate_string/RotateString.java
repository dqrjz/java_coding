package easy.rotate_string;

/**
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 * <p>
 * Example:
 * Given "abcdefg".
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * offset=4 => "defgabc"
 * offset=5 => "cdefgab"
 * offset=6 => "bcdefga"
 * offset=7 => "abcdefg"
 * <p>
 * Challenge:
 * Rotate in-place with O(1) extra memory.
 */
public class RotateString {
	public static void main(String[] args) {
		for (int offset = 0; offset <= 7; offset++) {
			char[] str = "abcdefg".toCharArray(); // cbaabc defabc
			rotateString1(str, offset);
//			rotateString2(str, offset);
			System.out.println("offset=" + offset + " => \"" + String.copyValueOf(str) + "\"");
		}
	}
	
	/** Alternate method */
	public static void rotateString2(char[] str, int offset) {
		if ((str == null) || (str.length == 0) || (offset % str.length == 0))
			return;
		offset %= str.length;
		
		// 1. Flip the entire string
		for (int i = 0; i < str.length / 2; i++) {
			char c = str[i];
			str[i] = str[str.length - i - 1];
			str[str.length - i - 1] = c;
		}
		
		// 2. Flip the offset part
		for (int i = 0; i < offset / 2; i++) {
			char c = str[i];
			str[i] = str[offset - i - 1];
			str[offset - i - 1] = c;
		}
		
		// 3. Flip the rest part
		for (int i = 0; i < (str.length - offset + 1) / 2; i++) {
			char c = str[offset + i];
			str[offset + i] = str[str.length - i - 1];
			str[str.length - i - 1] = c;
		}
	}
	
	/**
	 * My original method (actually works!)
	 *
	 * @param str    An array of char
	 * @param offset An integer
	 */
	public static void rotateString1(char[] str, int offset) {
		if ((str == null) || (str.length == 0) || (offset % str.length == 0)) {
			return;
		}
		offset %= str.length;
		int pinIndex = str.length - offset;
		int swapIndex = 0;
		for (int i = 1; i < str.length; i++) {
			if (pinIndex == swapIndex) {
				pinIndex = (pinIndex + 1) % str.length;
				swapIndex = (++swapIndex + offset) % str.length;
			} else {
				char c = str[pinIndex];
				str[pinIndex] = str[swapIndex];
				str[swapIndex] = c;
				swapIndex = (swapIndex + offset) % str.length;
			}
			System.out.println(String.copyValueOf(str) + ", pinIndex=" + pinIndex + ", swapIndex=" + swapIndex);
		}
	}
	
}
