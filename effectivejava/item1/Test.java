package com.effectivejava.item1;

public class Test {
	public static void main(String[] args) {
		Human h = new Human();
		h.wantChildSex = true;
		h.wantChildSex = false;
		Child c = Parent.born(h);
		c.sleep();
	}
}
