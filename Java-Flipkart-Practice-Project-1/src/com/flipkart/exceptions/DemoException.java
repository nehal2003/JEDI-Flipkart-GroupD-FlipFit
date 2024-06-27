package com.flipkart.exceptions;

public class DemoException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		int a,b,c;
		a=10;b=0;c=a/b;
		System.out.println(c);
	    }
		catch (ArithmeticException e) {
			System.out.println("Invalid arithmetic operation"+ e.getMessage());
		}
		finally {
			System.out.println("Code ended");
		}
	}
}
