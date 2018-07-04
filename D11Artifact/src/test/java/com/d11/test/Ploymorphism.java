package com.d11.test;

public class Ploymorphism {

	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		Child2 c2 = new Child2();
		Parent p2 = new Child();
		Parent p3 = new Child2();
		//Child c4 = (Child) new Parent();
		p.methodA();
		c.methodA();
		c2.methodA();
		p2.methodA();
		p3.methodA();
		//c4.methodA();

	}
}
