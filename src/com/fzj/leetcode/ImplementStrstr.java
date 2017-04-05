package com.fzj.leetcode;

public class ImplementStrstr {
	public String strStr(String haystack, String needle) {
		if(haystack.length()<needle.length())
			return null;
		if(needle.length()==0)
			return haystack;
		int m = haystack.length();
		int n = needle.length();
		for(int i=0;i+n<=m;i++){
			if(haystack.substring(i, i+n).equals(needle)){
				return haystack.substring(i);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		ImplementStrstr solution = new ImplementStrstr();
		String haystack = "aba";
		String needle = "b";
		System.out.println(solution.strStr(haystack, needle));
	}
}
