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
class Solution2 {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
	public int aplusb(int a, int b) {
		while (b != 0) {
			System.out.println(Integer.toBinaryString(a));
			System.out.println(Integer.toBinaryString(b));
			System.out.println("..................");
			int carry = a & b; // their carry (actually, need to move to right by one bit.)
			a = a ^ b; // their plus result without carry.
			b = carry << 1;
		}
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		return a;
	}
};