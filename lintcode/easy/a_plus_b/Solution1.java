package easy.a_plus_b;

/**
 * Write a function that add two numbers A and B.
 * You should not use + or any arithmetic operators.
 * 
 * a and b are both 32-bit integers.
 * You can use bit operation.
 * 
 * @author JZ
 *
 */
public class Solution1 {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
	public int aplusb(int a, int b) {
		int res = 0;
		int carry = 0;
		for (int i = 0; i < 32; i++) {
			int a1 = a & 1;
			int b1 = b & 1;
			int val = 0;
			if (a1 == 1 && b1 == 1 && carry == 1) {
				val = 1;
				carry = 1;
			} else if ((a1 == 1 && b1 == 1) || (a1 == 1 && carry == 1) || (b1 == 1 && carry == 1)) {
				val = 0;
				carry = 1;
			} else if (a1 == 1 || b1 == 1 || carry == 1) {
				val = 1;
				carry = 0;
			} else {
				val = 0;
				carry = 0;
			}
			val = val << i;
			res = res | val;
			a = a >> 1;
			b = b >> 1;
		System.out.println(Integer.toBinaryString(val));
		System.out.println(Integer.toBinaryString(res));
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println("**********");
		}

		return res;
    }
}
