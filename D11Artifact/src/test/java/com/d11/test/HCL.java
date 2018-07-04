package com.d11.test;

import java.util.Scanner;

public class HCL {
	static int fact=1;
	//1. public / private
	public static void main(String[] args) {
		System.out.println("Welcome to HCL");
		//2. Fibonacci Series in Java without using recursion
		fibonacciIterative();
		//2.1 Fibonacci Series using recursion in java
		fibonacciRecursive();
		//3. Factorial Program using loop in java
		//Complexity of iterative Fibonacci –
		//For this it will be O(n)
		factorialIterative();
		//4. Factorial Program using recursion in java
		//Complexity of recursive Fibonacci –
		//The recursive equation for this algorithm is T(n)=T(n−1)+T(n−2)+Θ(1)
		//For this it will be T(n)=Θ(ϕn)
		//where ϕ is the golden ratio (ϕ=(1+5√) / 2).
		factorialRecursive();
		//5. Triangle Type Program
		triangleType();
		//6. Reverse a String in Java
		strReverse();
		strReverse2();
		strReverse3();		
	}
	/*private static void main(String[] args) {
		System.out.println("The method main(String[]) from the type HCL is never used locally");
	}*/

	public static void fibonacciIterative()
	{    
		int n1=0,n2=1,n3,i,count=10;    
		System.out.print(n1+" "+n2);//printing 0 and 1    
		for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed    
		{    
			n3=n1+n2;    
			System.out.print(" "+n3);    
			n1=n2;    
			n2=n3;    
		}    
	}

	static int n1=0,n2=1,n3=0;    
	static void printFibonacci(int count){    
		if(count>0){    
			n3 = n1 + n2;    
			n1 = n2;    
			n2 = n3;    
			System.out.print(" "+n3);   
			printFibonacci(count-1);    
		}    
	}    
	public static void fibonacciRecursive(){    
		int count=10;    
		System.out.print(n1+" "+n2);//printing 0 and 1    
		printFibonacci(count-2);//n-2 because 2 numbers are already printed   
	} 

	public static void factorialIterative(){  
		int i,fact=1;  
		int number=5;//It is the number to calculate factorial    
		for(i=1;i<=number;i++){    
			fact=fact*i;    
		}    
		System.out.println("Factorial of "+number+" is: "+fact);    
	}

	public static void factorialRecursive(){  
		int i;  
		int number=4;//It is the number to calculate factorial    
		fact = factorial(number); 
		factorialOwn(number);   
		System.out.println("Factorial of "+number+" is: "+fact);    
	}

	static int factorial(int n){    
		if (n == 0)    
			return 1;    
		else    
			return(n * factorial(n-1));    
	}  
	static void factorialOwn(int number) {
		if(number>0){
			fact = number * fact;
			number = number - 1;
			factorial(number);
		}
	}  

	public static void triangleType() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		if(a==b && b==c)
			System.out.println("Equilateral");

		else if(a == (b+c) || c == (b+a) || b == (a+c) )
			System.out.println("Not a triangle");

		else if ((a==b && b!=c ) || (a!=b && c==a) || (c==b && c!=a))
			System.out.println("Isosceles");

		else if(a!=b && b!=c && c!=a)
			System.out.println("Scalene");
	}

	public static void strReverse()
	{
		System.out.println("Enter string to reverse:");

		Scanner read = new Scanner(System.in);
		String str = read.nextLine();
		String reverse = "";

		for(int i = str.length() - 1; i >= 0; i--)
		{
			reverse = reverse + str.charAt(i);
		}

		System.out.println("Reversed string is:");
		System.out.println(reverse);
	}


	public static void strReverse2()
	{
		System.out.println("Enter string to reverse:");

		Scanner read = new Scanner(System.in);
		String str = read.nextLine();

		StringBuilder sb = new StringBuilder(str);

		System.out.println("Reversed string is:");
		System.out.println(sb.reverse().toString());
	}


	public static void strReverse3()
	{
		System.out.println("Enter string to reverse:");

		Scanner read = new Scanner(System.in);
		String str = read.nextLine();

		StringBuilder sb = new StringBuilder();

		for(int i = str.length() - 1; i >= 0; i--)
		{
			sb.append(str.charAt(i));
		}

		System.out.println("Reversed string is:");
		System.out.println(sb.toString());
	}
	
}
