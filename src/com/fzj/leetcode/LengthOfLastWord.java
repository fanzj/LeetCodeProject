package com.fzj.leetcode;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		String[] str = s.split(" ");
		if(str.length==0)
			return 0;
		else{
			return str[str.length-1].length();
		}
	}
	
	public static void main(String[] args) {
		LengthOfLastWord solution = new LengthOfLastWord();
		String s = "Hello World";
		//String s = "sad";
		System.out.println(solution.lengthOfLastWord(s));
	}
}
