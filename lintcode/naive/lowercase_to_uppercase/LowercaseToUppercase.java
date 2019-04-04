package naive.lowercase_to_uppercase;

/**
 * Convert a lowercase character to uppercase.
 *
 * @author JZ
 */
public class LowercaseToUppercase {
	public static void main(String[] args) {
		char c = lowercaseToUppercase('b');
		System.out.println(c);
	}
	
	/** My original method */
	public static char lowercaseToUppercase(char character) {
//		return character-=(97-65);
		return character-=32;
	}
}
