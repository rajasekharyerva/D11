package com.d11.test;

public class OccurenceOfChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "AsjbakjbfAJBJBZ";
		int[] chArr = new int[26];
		input = input.toLowerCase();

		for(int i=0; i<input.length(); i++){
			//System.out.println(input.charAt(i));
			//System.out.println((int)input.charAt(i) - 97);
			chArr[(int)input.charAt(i) - 97] = chArr[(int)input.charAt(i) - 97] + 1;
		}

		System.out.println("----------------------------");

		for(int i=0; i<chArr.length; i++){
			System.out.println(chArr[i]);
		}
	}
}
