package com.d11.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class T10QA {
	static Set<String> stringSet = new HashSet<String>();
	static int lstringSet = 0;
	public static void main(String[] args) {
		//Question-1: Write Code To Filter Duplicate Elements From An Array And Print As A List?
		findDuplicates();
		
		//Question-2: Write Code To Sort The List Of Strings Using Java Collection?
		sortStrings();
		
		//Question-3: Write A Function To Reverse A Number In Java?
		invertNumber();
		
		//Question-4: Write A Method To Check Prime No. In Java?
		findPrime();
		
		//Question-5: Write A Java Program To Find Out The First Two Max Values From An Array?
		findTwoMaxValue();
		
		//Question-6: Write A Java Program To Find The Longest Substring From A Given String Which Doesn’t Contain Any Duplicate Characters?
		findSubstr();
		
		//Question-7: Write Java Code To Get Rid Of Multiple Spaces From A String?
		removeExtraSpaces();
		
		//Question-8: Write Java Code To Identify A Number As Palindrome?
		identifyPalindrome();
		
		//Question-9: Write Java Code To Swap Two Numbers Without Using A Temporary Variable?
		smartSwapping();
		
		//Question-10: Write A Java Program To Demonstrate String Reverse With And Without StringBuffer Class?
		invertString();

	}


	public static void findDuplicates() {
		ArrayList<String> list = new ArrayList<String>();

		// Form a list of numbers from 0-9.
		for (int i = 0; i < 10; i++) {
			list.add(String.valueOf(i));
		}

		// Insert a new set of numbers from 0-5.
		for (int i = 0; i < 5; i++) {
			list.add(String.valueOf(i));
		}

		System.out.println("Input list : " + list);
		System.out.println("\nFiltered duplicates : " + processList(list));
	}

	public static Set<String> processList(List<String> listContainingDuplicates) {

		final Set<String> resultSet = new HashSet<String>();
		final Set<String> tempSet = new HashSet<String>();

		for (String yourInt : listContainingDuplicates) {
			if (!tempSet.add(yourInt)) {
				resultSet.add(yourInt);
			}
		}
		return resultSet;
	}


	public static void sortStrings() {

		String[] inputList = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"aug", "Sep", "Oct", "nov", "Dec" };

		// Display input un-sorted list.
		System.out.println("-------Input List-------");
		showList(inputList);

		// Call to sort the input list.
		Arrays.sort(inputList);

		// Display the sorted list.
		System.out.println("\n-------Sorted List-------");
		showList(inputList);

		// Call to sort the input list in case-sensitive order.
		System.out.println("\n-------Sorted list (Case-Sensitive)-------");
		Arrays.sort(inputList, String.CASE_INSENSITIVE_ORDER);

		// Display the sorted list.
		showList(inputList);
	}

	public static void showList(String[] array) {
		for (String str : array) {
			System.out.print(str + " ");
		}
		System.out.println();
	}



	//Question-3: Write A Function To Reverse A Number In Java?
	public static void invertNumber() {
		long lnum = 654321;
		System.out.println("Input value : " + lnum);
		System.out.println("Inverted value : " + doInvert(lnum));
	}
	public static long doInvert(long number) {

		long invert = 0;
		while (number != 0) {
			invert = (invert * 10) + (number % 10);
			number = number / 10;
		}
		return invert;
	}




	//Question-4: Write A Method To Check Prime No. In Java?
	//If a number n is not a prime, it can be factored into two factors a and b:
	//n = a*b
	//If both a and b were greater than the square root of n, a*b would be greater than n. 
	//So at least one of those factors must be less than or equal to the square root of n, and to check if n is prime, 
	//we only need to test for factors less than or equal to the square root.
	public static void findPrime() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter an int value : ");
		int input = scan.nextInt();
		if (checkPrime(input)) {
			System.out.println("Input value " + input + " is a prime number.");
		} else {
			System.out.println("Input value " + input
					+ " is not a prime number.");
		}
	}

	public static boolean checkPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}


	//Question-5: Write A Java Program To Find Out The First Two Max Values From An Array?
	public static void findTwoMaxValue() {

		int list[] = { 15, 24, 48, 21, 43, 11, 79, 93 };

		getTwoMaxValues(list);
	}
	public static void getTwoMaxValues(int[] nums) {
		int maxOne = 0;
		int maxTwo = 0;
		for (int n : nums) {
			if (maxOne < n) {
				maxTwo = maxOne;
				maxOne = n;
			} else if (maxTwo < n) {
				maxTwo = n;
			}

		}

		System.out.println("Max1 - " + maxOne);
		System.out.println("Max2 - " + maxTwo);
	}



	//Question-6: Write A Java Program To Find The Longest Substring From A Given String Which Doesn’t Contain Any Duplicate Characters?
	public static void findSubstr() {

		System.out.println("Actual Strings ------------ | ---- Longest Non-Repeated Strings");
		System.out.println("Software_Programmer"+ "         |         " + findStr("Software_Programmer"));
		System.out.println("Software_Developer_In_Test"+  "  |         " + findStr("Software_Developer_In_Test"));
		System.out.println("developers_write_unit_tests"+  " |         " + findStr("developers_write_unit_tests"));
		System.out.println("javajavbasp.net"+  "             |         " + findStr("javajavbasp.net"));
	}


	public static Set<String> findStr(String input) {

		// Reset instance data.
		stringSet.clear();
		lstringSet = 0;

		// Set a boolean flag on each char's ASCII value.
		boolean[] flag = new boolean[256];
		int j = 0;
		char[] inputCharArr = input.toCharArray();
		for (int i = 0; i < inputCharArr.length; i++) {
			char c = inputCharArr[i];
			if (flag[c]) {
				extractSubString(inputCharArr, j, i);
				for (int k = j; k < i; k++) {
					if (inputCharArr[k] == c) {
						j = k + 1;
						break;
					}
					flag[inputCharArr[k]] = false;
				}
			} else {
				flag[c] = true;
			}
		}
		extractSubString(inputCharArr, j, inputCharArr.length);
		return stringSet;
	}

	private static String extractSubString(char[] inputArr, int start, int end) {

		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++) {
			sb.append(inputArr[i]);
		}
		String subStr = sb.toString();
		if (subStr.length() > lstringSet) {
			lstringSet = subStr.length();
			stringSet.clear();
			stringSet.add(subStr);
		} else if (subStr.length() == lstringSet) {
			stringSet.add(subStr);
		}

		return sb.toString();
	}

	//Question-7: Write Java Code To Get Rid Of Multiple Spaces From A String?
	public static void removeExtraSpaces(){
		String input = "Try    to    remove   extra   spaces.";
		StringTokenizer substr = new StringTokenizer(input, " ");
		StringBuffer sb = new StringBuffer();

		while(substr.hasMoreElements()){
			sb.append(substr.nextElement()).append(" ");
		}

		System.out.println("Actual string: " + input);
		System.out.println("Processed string: " + sb.toString().trim());
	}


	//Question-8: Write Java Code To Identify A Number As Palindrome?
	public static void identifyPalindrome() {
		try {
			BufferedReader object = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.println("Input number");
			int inputValue = Integer.parseInt(object.readLine());
			int n = inputValue;
			int rev = 0;
			System.out.println("Input value is : ");
			System.out.println(" " + inputValue);
			for (int i = 0; i <= inputValue; i++) {
				int r = inputValue % 10;
				inputValue = inputValue / 10;
				rev = rev * 10 + r;
				i = 0;
			}
			System.out.println("Post reversal : " + " ");
			System.out.println(" " + rev);
			if (n == rev) {
				System.out.print("Input value is a palindrome.");
			} else {
				System.out.println("Input value is not a palindrome.");
			}
		} catch (Exception e) {
			System.out.println("Out of Range.");
		}
	}


	//Question-9: Write Java Code To Swap Two Numbers Without Using A Temporary Variable?
	public static void smartSwapping() {
		int numX = 10;
		int numY = 20;
		System.out.println("Pre-swapping state:");
		System.out.println("numX value: " + numX);
		System.out.println("numY value: " + numY);
		System.out.println("");

		numX = numX + numY;
		numY = numX - numY;
		numX = numX - numY;
		System.out.println("Post-swapping state:");
		System.out.println("numX value: " + numX);
		System.out.println("numY value: " + numY);
	}


	public static String invertWithStringBuffer(String str) {
		StringBuffer buffer = new StringBuffer(str);
		buffer.reverse();
		return buffer.toString();
	}

	public static String invertWithoutStringBuffer(String str) {
		int length = str.length();
		String original = str;
		String invert = "";
		for (int i = length - 1; i >= 0; i--) {
			invert = invert + original.charAt(i);
		}
		return invert;
	}

	//Question-10: Write A Java Program To Demonstrate String Reverse With And Without StringBuffer Class?
	public static void invertString() {
		System.out.println("Inverted String with StringBuffer class: "+ invertWithStringBuffer("987654321"));
		System.out.println("");
		System.out.println("Inverted String without StringBuffer class: "+ invertWithoutStringBuffer("kjihgfedcba"));
	}
}
