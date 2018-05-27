package com.d11.test;

public class HCL {
	static int fact=1;
	//1. public / private
	/*public static void main(String[] args) {
		System.out.println("Welcome to HCL");
	}*/
	/*private static void main(String[] args) {
		System.out.println("The method main(String[]) from the type HCL is never used locally");
	}*/

	//2. Fibonacci Series in Java without using recursion
	/*public static void main(String args[])  
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
	}*/

	//2.1 Fibonacci Series using recursion in java
	/*static int n1=0,n2=1,n3=0;    
	static void printFibonacci(int count){    
		if(count>0){    
			n3 = n1 + n2;    
			n1 = n2;    
			n2 = n3;    
			System.out.print(" "+n3);   
			printFibonacci(count-1);    
		}    
	}    
	public static void main(String args[]){    
		int count=10;    
		System.out.print(n1+" "+n2);//printing 0 and 1    
		printFibonacci(count-2);//n-2 because 2 numbers are already printed   
	} */

	//3. Factorial Program using loop in java
	/*public static void main(String args[]){  
		int i,fact=1;  
		int number=5;//It is the number to calculate factorial    
		for(i=1;i<=number;i++){    
			fact=fact*i;    
		}    
		System.out.println("Factorial of "+number+" is: "+fact);    
	}*/

	//4. Factorial Program using recursion in java
	/*public static void main(String args[]){  
		int i;  
		int number=4;//It is the number to calculate factorial    
		//fact = factorial(number); 
		factorial(number);   
		System.out.println("Factorial of "+number+" is: "+fact);    
	}*/

	/*static int factorial(int n){    
	if (n == 0)    
		return 1;    
	else    
		return(n * factorial(n-1));    
	} */ 
	/*static void factorial(int number) {
		if(number>0){
			fact = number * fact;
			number = number - 1;
			factorial(number);
		}
	}  */

	//5. Triangle Type Program
	/*public static void main(String[] args) {
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
    }*/

	//6. Test cases for user registration form

	/*Test Scenarios of a Registration Form:
		Verify that all the specified fields are present on the registration page
	Verify that the required/mandatory fields are marked with * against the field
	Verify that for better user interface dropdowns, radio buttons and checkboxes etc fields are displayed wherever possible instead of just textboxes
	Verify the page has both submit and cancel/reset buttons at the end
	Verify that clicking submit button after entering all the required fields, submits the data to the server
	Verify that clicking cancel/reset button after entering all the required fields, cancels the submit request and resets all the fields
	Verify that whenever possible validation should take place at client side
	Verify that not filling the mandatory fields and clicking submit button will lead to validation error
	Verify that not filling the optional fields and clicking submit button will still send data to server without any validation error
	Check the upper limit of the textboxes
	Check validation on date and email fields (only valid dates and valid email Ids should be allowed
	Check validation on numeric fields by entering alphabets and special characters
	Verify that leading and trailing spaces are trimmed
	Verify that entering blank spaces on mandatory fields lead to validation error
	Verify that after making a request to the server and then sending the same request again with the same unique key will lead to server side validation error*/

	//7. Sample Test Cases for Payment Gateway Testing
	
	/*Sr#	Test Cases
	1	During the payment process try to change the payment gateway language
	2	After successful payment, test all the necessary components, whether it is retrieved or not
	3	Check what happens if payment gateway stops responding during payment
	4	During the payment process check what happens if session ends
	5	During the payment process check what happens in back end
	6	Check what happens if payment process fails
	7	Check the Data-base entries whether they store credit card details or not
	8	During payment process check error pages and security pages
	9	Check settings of pop-up blocker, and see what happens if pop up blocker is on and off
	10	Between payment gateway and application check buffer pages
	11	Check on successful payment, a success code is send to the application and a confirmation page is show to the user
	12	Verify whether the transaction processes immediately or processing is hand to your bank
	13	After successful transaction check if the payment gateway returns to your application
	14	Check all format and messages when successful payment process
	15	Unless you don't have an authorization receipt from payment gateway, good should not be shipped
	16	Inform the owner for any transaction processed through e-mail. Encrypt the content of the mail
	17	Check the amount format with currency format
	18	Check if each of the payment options are selectable
	19	Check if each listed payment option opens the respective payment option according to specification
	20	Verify whether the payment gateway defaults to the desired debit/credit card option
	21	Verify the default option for debit card shows card selection drop down menu*/
	
	
	// Reverse a String in Java
		/*public static void main(String[] args)
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
		}*/
		

		    /*public static void main(String[] args)
		    {
		        System.out.println("Enter string to reverse:");
		        
		        Scanner read = new Scanner(System.in);
		        String str = read.nextLine();
		        
		        StringBuilder sb = new StringBuilder(str);
		        
		        System.out.println("Reversed string is:");
		        System.out.println(sb.reverse().toString());
		    }
		    */
	
    /*public static void main(String[] args)
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
    }*/
		    

	// Difference between String and StringBuffer/StringBuilder in java is that 
	/*String object is immutable whereas StringBuffer/StringBuilder objects are mutable. 
	By immutable, we mean that the value stored in the String object cannot be changed. 
	StringBuffer and StringBuilder have the same methods with one difference and that’s of synchronization. 
	StringBuffer is synchronized( which means it is thread safe and hence you can use it when you implement threads for your methods) 
	whereas StringBuilder is not synchronized( which implies it isn’t thread safe).
	So, if you aren’t going to use threading then use the StringBuilder class as it’ll be more efficient than StringBuffer due to the absence of synchronization.*/
	
	//Array Vs. Arraylist
	/*Array	ArrayList
	Array is a fixed length data structure whose length cannot be modified once array object is created.	ArrayList is dynamic in nature which means it can resize itself to grow when required.
	The size of an array remains static throughout the program.	The size of an ArrayList can grow dynamically depending on load and capacity.
	It uses assignment operator to store elements.	It uses the add() attribute to insert elements.
	It can contain primitives as well as objects of same or different data type.	Primitives are not allowed in ArrayList. It can only contain object types.
	Arrays and Generics do not go hand in hand.	Generics are allowed in ArrayList.
	Arrays can be multi-dimensional.	ArrayList is single dimensional.
	It’s a native programming component where the elements are stored in contiguous memory locations.	It’s a class from the collections framework of Java where the objects are never stored in contiguous locations.
	Length variable is used to determine the length of the Array.	Size () method is used to determine the size of the ArrayList.
	Takes less memory than ArrayList to store specified elements or objects.	Takes more memory than the Array to store objects.
	Iterating over an array is faster than iterating over an ArrayList.	Iterating over an ArrayList is significantly slower in terms of performance.*/


	// HashSet vs HashMap

		/*HASHSET	HASHMAP
		HashSet class implements the Set interface	HashMap class implements the Map interface
		In HashSet we store objects(elements or values) e.g. If we have a HashSet of string elements then it could depict a set of HashSet elements: {“Hello”, “Hi”, “Bye”, “Run”}	HashMap is used for storing key & value pairs. In short it maintains the mapping of key & value (The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls.) This is how you could represent HashMap elements if it has integer key and value of String type: e.g. {1->”Hello”, 2->”Hi”, 3->”Bye”, 4->”Run”}
		HashSet does not allow duplicate elements that means you can not store duplicate values in HashSet.	HashMap does not allow duplicate keys however it allows to have duplicate values.
		HashSet permits to have a single null value.	HashMap permits single null key and any number of null values.*/	
}
