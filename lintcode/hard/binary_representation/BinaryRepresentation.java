package hard.binary_representation;

/**
 * Given a (decimal - e.g. 3.72) number that is passed in as a string, return the binary
 * representation that is passed in as a string. If the fractional part of the number can
 * not be represented accurately in binary with at most 32 characters, return ERROR.
 * <p>
 * Example:
 * For n = "3.72", return "ERROR".
 * For n = "3.5", return "11.1".
 */
public class BinaryRepresentation {
	public static void main(String[] args) {
		String n = "3.5";
		System.out.println(binaryRepresentation(n));
	}
	
	/**
	 * @param n Given a decimal number that is passed in as a string
	 * @return A string
	 */
	public static String binaryRepresentation(String n) {
		// write your code here
		String[] split = n.split("\\.");
		String integer = parseInteger(split[0]);
		String fraction = parseFraction("0." + split[1]);
		if ("ERROR".equals(fraction)) {
			return "ERROR";
		} else {
			return integer + "." + fraction;
		}
	}
	
	private static String parseInteger(String s) {
		return Integer.toBinaryString(Integer.parseInt(s));
	}
	
	private static String parseFraction(String s) {
		double d = Double.parseDouble(s);
		StringBuilder str = new StringBuilder("");
		while (d > 0) {
			if (str.length() > 32)
				return "ERROR";
			
			d = d * 2;
			if (d >= 1) {
				str.append("1");
				d -= 1;
			} else
				str.append("0");
		}
		return str.toString();
	}
}
