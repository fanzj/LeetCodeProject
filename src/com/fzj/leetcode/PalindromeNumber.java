package com.fzj.leetcode;

public class PalindromeNumber {
	 public boolean isPalindrome(int x) {
		 if(x<0)
			 return false;
		 int temp = x;
		 int y = 0;
		 while(temp!=0){
			 y = y*10 + temp%10;
			 temp /= 10;
		 }
		// System.out.format("x = %d, y = %d\n", x,y);
		 if(x==y)
			 return true;
		 else
			 return false;
	 }
	 
	 public static void main(String[] args) {
		 PalindromeNumber solution = new PalindromeNumber();
		 int x = -2147447412;
		 System.out.println(solution.isPalindrome(x));
	}
}
