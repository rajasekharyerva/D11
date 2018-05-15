package com.d11.test;
import java.util.HashMap;
/*Longest Substring Without Repeating Characters (Java)*/
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class LongestSubstr {
	private Set<String> subStrList = new HashSet<String>();
	private int finalSubStrSize = 0;

	public Set<String> getLongestSubstr(String input){
		//reset instance variables
		subStrList.clear();
		finalSubStrSize = 0;
		// have a boolean flag on each character ascii value
		boolean[] flag = new boolean[256];
		Map<Character, Character> chMap = new HashMap<Character, Character>();
		int j = 0;
		char[] inputCharArr = input.toCharArray();
		System.out.println("Input \t\t\t===> "+input);
		for (int i = 0; i < inputCharArr.length; i++) {
			char c = inputCharArr[i];
			if (flag[c]) {
				extractSubString(inputCharArr,j,i);
				for (int k = j; k < i; k++) {
					if (inputCharArr[k] == c) {//repeated char equal to iteration k, increase j index and break
						j = k + 1;
						System.out.println("Reindexing to \t\t===> "+j);
						break;
					}
					System.out.println("Set "+inputCharArr[k]+ " \t\t\t===> " + false);
					flag[inputCharArr[k]] = false;// making true as false
					System.out.println("Sub Iteration \t\t===> "+k);
				}   
			} else {
				System.out.println("Set "+c+" \t\t\t===> " + true);
				flag[c] = true;
			}
			System.out.println("Iteration \t\t===> "+i);
		}
		extractSubString(inputCharArr,j,inputCharArr.length);
		return subStrList;
	}

	private String extractSubString(char[] inputArr, int start, int end){
		StringBuilder sb = new StringBuilder();
		for(int i=start;i<end;i++){
			sb.append(inputArr[i]);
		}
		String subStr = sb.toString();
		System.out.println("SubString \t\t===> "+subStr);
		if(subStr.length() > finalSubStrSize){
			finalSubStrSize = subStr.length();
			subStrList.clear();
			System.out.println("NonRepeat Max-SubString ===> "+subStr);
			subStrList.add(subStr);
		} else if(subStr.length() == finalSubStrSize){
			subStrList.add(subStr);
		}

		return sb.toString();
	}

	public static void main(String a[]){
		LongestSubstr mls = new LongestSubstr();
		//System.out.println(mls.getLongestSubstr("abcded"));
		System.out.println(mls.getLongestSubstr("abcabc"));
		/*System.out.println(mls.getLongestSubstr("java_language_is_sweet"));
		System.out.println(mls.getLongestSubstr("java_java_java_java"));
		System.out.println(mls.getLongestSubstr("abcabcbb"));*/
	}
}