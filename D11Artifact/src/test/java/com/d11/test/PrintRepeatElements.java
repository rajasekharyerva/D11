package com.d11.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintRepeatElements {
	public static void main(String argc[])
	{
		//Given a list with recurring values such as L1= [23,23,56,34,56,11] return the recurring values in a new list.
		int[] arr = new int[]{2, 4, 5, 5, 6, 3, 3};
		returnRecurringValues(arr);
		//Given a dictionary insert a key with the value xyz my_dict= {"Ana":{"location": "sfo" ,"pets: "cats" }}
		String[] strArr = new String[]{"Ana", "location", "sfo" ,"pets", "cats"};
		List<String>  list  = new ArrayList<String>();
		list  = Arrays.asList(strArr);
		System.out.println("================");
		List<String>  list2  = new ArrayList<String>(list);
		list2.add("ayz");
		Collections.sort(list2);
		for(String str: list2)
			System.out.println(str);


	}
	//Given a list with recurring values such as L1= [23,23,56,34,56,11] return the recurring values in a new list.
	private static void returnRecurringValues(int[] arr) {
		for(int i=0; i<arr.length;i++){
			for(int j=i+1; j<arr.length;j++){
				if(arr[i] == arr[j]) {
					System.out.println(arr[i]);
					break;
				}
			}
		}

	}
}
