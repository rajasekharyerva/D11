package com.d11.test;

import java.util.HashMap;
import java.util.Map;

public class OIQ {

	public static void main(String[] args) {
		// 1.TODO "bengaluru is my city" - "B.I.M.C"
			initCapFormat("bengaluru is my city");
		// 2.TODO "sumit" - "itsum"
			inputsInterchangeable("sumit", "itsum");
		// 3.TODO 6699 - 69
			// 6*9+6+9
		// 4.TODO LIKE operator
			// SQL_LINUX.odt
		// 5.TODO numbers div by 5 in 1....10/5cr
			countDivisibles(1, 100, 5);
		// 6.TODO count vowels in statement
			getCountofVowels("THIS website is aw3som3");
		// 7.CSS bold
			// <strong> or <b> tag also, you can try with css <span style="font-weight:bold">text</span>

	}

	private static void inputsInterchangeable(String input1, String input2) {
		Map<Character, Integer> iMap1 = new HashMap<Character, Integer>();
		Map<Character, Integer> iMap2 = new HashMap<Character, Integer>();
		// Condition1
		if(input1.length() == input2.length()) {
			iMap1 = getCharCountMap(input1);
			iMap2 = getCharCountMap(input2);
			if(iMap1.equals(iMap2))
			System.out.println("Inputs are interchangeble");
		} else
			System.out.println("Inputs are not interchangeble");

	}

	private static Map<Character, Integer> getCharCountMap(String input) {
		Map<Character, Integer> iMap = new HashMap<Character, Integer>();
		int len = input.length();
		for (int i = 0; i < len; ++i) {
			char charAt = input.charAt(i);
			if (!iMap.containsKey(charAt))
				iMap.put(charAt, 1);
			else
				iMap.put(charAt, iMap.get(charAt) + 1);
		}
		return iMap;
	}

	private static void initCapFormat(String input) {
		String[] strArray = input.split(" ");
		String output ="";
		for(String str: strArray)
			output = output.concat(str.substring(0, 1).concat("."));

		output = output.substring(0, output.length() - 1);
		output = output.toUpperCase();
		System.out.println(output);
	}

	public static void getCountofVowels(String input) {
		String line = input; //
		int vowels = 0, consonants = 0, digits = 0, spaces = 0;

		//line = line.toLowerCase();
		for(int i = 0; i < line.length(); ++i)
		{
			char ch = line.charAt(i);
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
				++vowels;
			} else if((ch >= 'a'&& ch <= 'z') || (ch >= 'A'&& ch <= 'Z')) {
				++consonants;
			} else if( ch >= '0' && ch <= '9') {
				++digits;
			} else if (ch ==' ') {
				++spaces;
			}
		}

		System.out.println("Vowels: " + vowels);
		System.out.println("Consonants: " + consonants);
		System.out.println("Digits: " + digits);
		System.out.println("White spaces: " + spaces);
	}

	public static void countDivisibles(int A, int B, int M)
	{
		int retVal = (B / M) - (A / M);
		// Add 1 explicitly as A is divisible by M
		if (A % M == 0)
			retVal+= 1;
		// A is not divisible by M
		System.out.println(retVal);
		//return retVal;
	}
}
