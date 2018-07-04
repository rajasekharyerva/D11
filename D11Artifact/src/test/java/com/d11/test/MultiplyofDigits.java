package com.d11.test;

public class MultiplyofDigits {
  
 static int digSum(int n)
 {
     int sum = 1;

     // Loop to do sum while sum is not less than or equal to 9
     while (n > 0 || sum > 9) 
     {
         if (n == 0) {
             n = sum;
             sum = 1;
         }
         sum = sum *(n % 10);
         System.out.println(sum);
         System.out.println("-----");
         n /= 10;
     }
     return sum;
 }
  
 // Driver code
 public static void main(String argc[])
 {
     int n = 12345;
     System.out.println(digSum(n));
 }
}

