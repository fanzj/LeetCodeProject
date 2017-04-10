package com.fzj.leetcode;

public class ImplementStrstr {
	public String strStr(String haystack, String needle) {
		if (haystack.length() < needle.length())
			return null;
		if (needle.length() == 0)
			return haystack;
		int m = haystack.length();
		int n = needle.length();
		for (int i = 0; i + n <= m; i++) {
			if (haystack.substring(i, i + n).equals(needle)) {
				return haystack.substring(i);
			}
		}
		return null;
	}

	/**
	 * KMPËã·¨Çó½â
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public String strStr2(String haystack, String needle) {
		if(haystack==null || needle==null || needle.length()==0)
			return haystack;
		if(needle.length()>haystack.length())
			return null;
		int[] next = getNext(needle);
		int i=0,j=0;
		while(i<haystack.length() && j<needle.length()){
			if(j==-1 || haystack.charAt(i)==needle.charAt(j)){
				i++;
				j++;
			}else {
				j = next[j];
			}
		}
		if(j>=needle.length()){
			return haystack.substring(i-needle.length());
		}else {
			return null;
		}
	}

	public int[] getNext(String needle) {
		int j = -1;
		int i = 0;
		int[] next = new int[needle.length()];
		next[i] = j;
		while(i<needle.length()-1){
			if(j==-1 || needle.charAt(i)==needle.charAt(j)){
				i++;
				j++;
				if(needle.charAt(i)!=needle.charAt(j)){
					next[i] = j;
				}else {
					next[i] = next[j];
				}
			}else {
				j = next[j];
			}
		}
		return next;
	}

	public static void main(String[] args) {
		ImplementStrstr solution = new ImplementStrstr();
		/*String haystack = "aba";
		String needle = "b";
		System.out.println(solution.strStr(haystack, needle));*/
		String ss = "BBC ABCDAB ABCDABCDABDE";
		String str = "ABCDABD";
		int[] next = solution.getNext(str);
		for(int i=0;i<next.length;i++){
			System.out.print(next[i]);
			if(i<next.length-1)
				System.out.print(" ");
			else
				System.out.println();
		}
		System.out.println(solution.strStr2(ss, str));
	}
}
