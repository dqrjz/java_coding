package com.effectivejava.item1;

public class Parent {
	public static Child born(Human h) {
		if (h.wantChildSex)
			return new Boy();
		else
			return new Girl();
	}
}
