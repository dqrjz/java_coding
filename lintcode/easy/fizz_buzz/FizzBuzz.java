package easy.fizz_buzz;

import java.util.ArrayList;

/**
 * Given number n. Print number from 1 to n. But:
 * <p>
 * when number is divided by 3, print "fizz".
 * when number is divided by 5, print "buzz".
 * when number is divided by both 3 and 5, print "fizz buzz".
 * <p>
 * Example:
 * If n = 15, you should return:
 * <p>
 * [
 * "1", "2", "fizz",
 * "4", "buzz", "fizz",
 * "7", "8", "fizz",
 * "buzz", "11", "fizz",
 * "13", "14", "fizz buzz"
 * ]
 * <p>
 * Challenge:
 * Can you do it with only one if statement?
 */
public class FizzBuzz {
	public static void main(String[] args) {
		int n = 15;
		System.out.println(fizzBuzz2(n));
	}
	
	/** Alternate method (using only one if statement) */
	public static ArrayList<String> fizzBuzz2(int n) {
		ArrayList<String> results = new ArrayList<>();
		
		// 1. Put in all the numbers
		for (int i = 1; i <= n; i++) {
			results.add(String.valueOf(i));
		}
		
		// 2. Loop every 3 elements and set to "fizz"
		for (int i = 1; i * 3 <= n; i++) {
			results.set(i * 3 - 1, "fizz");
		}
		
		// 3. Loop every 5 elements.
		// Set to "fizz buzz" if also dividable by 3. Set to "buzz" if not.
		for (int i = 1; i * 5 <= n; i++) {
			if (i * 5 % 3 == 0)
				results.set(i * 5 - 1, "fizz buzz");
			else
				results.set(i * 5 - 1, "buzz");
		}
		return results;
	}
	
	/**
	 * Raw method
	 *
	 * @param n As description.
	 * @return A list of strings.
	 */
	public static ArrayList<String> fizzBuzz1(int n) {
		ArrayList<String> results = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				results.add("fizz buzz");
			} else if (i % 5 == 0) {
				results.add("buzz");
			} else if (i % 3 == 0) {
				results.add("fizz");
			} else {
				results.add(String.valueOf(i));
			}
		}
		return results;
	}
	
}
