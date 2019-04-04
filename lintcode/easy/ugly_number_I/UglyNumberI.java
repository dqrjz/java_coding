package easy.ugly_number_I;

/**
 * Write a program to check whether a given number is a ugly number. Ugly
 * numbers are positive numbers whose prime factors only include 2, 3, 5. For
 * example, 6, 8 are ugly while 14 is not ugly since it includes another prime
 * factor 7.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 *
 * @author JZ
 */
public class UglyNumberI {
	public static void main(String[] args) {
		// int n = 6;
		for (int i = 1; i < 100; i++) {
			if (isUgly(i))
				System.out.print(i + " ");
			
		}
		// System.out.println(isUgly(n));
	}
	
	/** My original method */
	public static boolean isUgly(int n) {
		while (n % 2 == 0)
			n /= 2;
		while (n % 3 == 0)
			n /= 3;
		while (n % 5 == 0)
			n /= 5;
		return n == 1;
	}
}
