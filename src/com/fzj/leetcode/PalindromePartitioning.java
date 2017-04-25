package com.fzj.leetcode;

import java.util.ArrayList;

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		int n = s.length();
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		if(n==0)
			return list;
		if(n==1){
			ArrayList<String> tempList = new ArrayList<>();
			tempList.add(s);
			list.add(tempList);
		}else {
			for(int i=1;i<n+1;i++){
				String temp = s.substring(0, i);
				if(isPalindrome(temp)){
					if(i==n){
						ArrayList<String> tempList = new ArrayList<>();
						tempList.add(temp);
						list.add(tempList);
					}else {
						ArrayList<ArrayList<String>> list2 = partition(s.substring(i));
						for(int j=0;j<list2.size();j++){
							ArrayList<String> tempList = new ArrayList<>();
							tempList.add(temp);
							tempList.addAll(list2.get(j));
							list.add(tempList);
						}
					}
				}
			}
		}
			
		return list;
	}
	
	/**
	 * ÊÇ·ñ»ØÎÄ
	 * @param s
	 * @return
	 */
	private boolean isPalindrome(String s){
		for(int i=0;i<s.length()/2;i++){
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePartitioning solution = new PalindromePartitioning();
		String str = "aab";
		System.out.println(solution.partition(str));
	}
}
