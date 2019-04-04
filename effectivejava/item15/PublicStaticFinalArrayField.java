package com.effectivejava.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  final修饰的数组成员，其内容依然是可以修改的
 */

public class PublicStaticFinalArrayField {
	public static void main(String[] args) {
		Test.VALUES1[1] = "4";
		Test.VALUES2[3] = 8;
		// Test.VALUE3 = 2;
		// System.out.println(Test.toStrings());
		System.out.println(new Test() {
			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder("[");
				for (Object obj : VALUES1)
					sb.append(obj + ", ");
//				for (int i = 0; i < VALUES1.length; i++) {
//					sb.append(VALUES1[i] + ", ");
//				}
				sb.setCharAt(sb.lastIndexOf(","), ']');
				sb.append("\n[");
//				for (int i = 0; i < VALUES2.length; i++) {
//					sb.append(VALUES2[i] + ", ");
//				}
				for (Object obj : VALUES2)
					sb.append(obj + ", ");
				sb.setCharAt(sb.lastIndexOf(","), ']');
				return sb.toString().trim();
			}
		});

		Test t = new Test("hallo".toCharArray());
//		for (Object obj : t.a) 
//			System.out.print(obj);
		System.out.println(Arrays.toString(t.a));

		t.change("hello".toCharArray());
//		for (Object obj : t.a) 
//			System.out.print(obj);
		System.out.println(Arrays.toString(t.a));

		
		// 解决方法1
		System.out.println(Test.VALUES);
		// 解决方法2
		System.out.println(Arrays.toString(Test.values()));
	}
}

class Test {
	public static final String[] VALUES1 = { "1", "2", "3" }; // Mutable!
	public static final int[] VALUES2 = { 1, 2, 3, 4 }; // Mutable!
	public static final int VALUE3 = 1; // Immutable
	public final char a[]; // Mutable! (与是否static无关)
	
	// 解决方法1
	private static final String[] PRIVATE_VALUES1 = { "a", "b", "c" };
	public static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES1));
	
	// 解决方法2
	private static final String[] PRIVATE_VALUES2 = { "d", "e", "f" };
	public static final String[] values() {
		return PRIVATE_VALUES2.clone();
	}
	

	public Test() {
		this.a = new char[] { ' ', ' ', ' ', ' ', ' ' };
	}

	public Test(char a[]) {
		this.a = a;
	}

	public void change(char b[]) {
		for (int i = 0; i < a.length; i++) {
			a[i] = b[i];
		}
	}

//	public static String toStrings() {
//		StringBuilder sb = new StringBuilder("[");
//		for (int i = 0; i < VALUES1.length; i++) {
//			sb.append(VALUES1[i] + ", ");
//		}
//		sb.setCharAt(sb.lastIndexOf(","), ']');
//		sb.append("\n[");
//		for (int i = 0; i < VALUES2.length; i++) {
//			sb.append(VALUES2[i] + ", ");
//		}
//		sb.setCharAt(sb.lastIndexOf(","), ']');
//		return sb.toString().trim();
//	}
}