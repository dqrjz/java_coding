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
public class Test {
	public static void main(String[] args) {
//		Solution1 s1 = new Solution1();
		Solution2 s2 = new Solution2();
		int a = 5;
		int b = 7;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(".........");
//		System.out.println(s1.a_plus_b(a, b));
		System.out.println(s2.aplusb(a, b));
	}
}
