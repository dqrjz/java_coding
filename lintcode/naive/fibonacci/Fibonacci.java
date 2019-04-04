package naive.fibonacci;

/**
 * Find the Nth number in Fibonacci sequence.
 * <p>
 * A Fibonacci sequence is defined as follow:
 * <p>
 * The first two numbers are 0 and 1.
 * The i th number is the sum of i-1 th number and i-2 th number.
 * The first ten numbers in Fibonacci sequence is:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 * <p>
 * Notice: The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.
 */
public class Fibonacci {
	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			
			System.out.print(fibonacci2(i) + " ");
		}
	}
	
	/** Better method */
	/* This method will only need O(1) space */
	/* We can optimize the space by storing the previous two numbers only */
	/* because that is all we need to get the next Fibannaci number in series. */
	private static int fibonacci2(int n) {
		if (n < 3) return n - 1;
		int first = 0;
		int second = 1;
		int third = 1;
		int i = 3;
		while (i <= n) {
			third = first + second;
			first = second;
			second = third;
			i++;
		}
		return third;
	}
	

	
	
	/** My original method */
	// Exceeds time limit!
	public static int fibonacci1(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		return fibonacci1(n - 1) + fibonacci1(n - 2);
	}
}
