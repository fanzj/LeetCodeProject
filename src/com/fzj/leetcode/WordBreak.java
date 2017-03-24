package com.fzj.leetcode;

import java.util.HashSet;
import java.util.Set;


public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		int len = s.length();
		boolean dp[] = new boolean[len+1];
		dp[0] = true;
		for(int i=1;i<=len;i++){
			for(int j=0;j<i;j++){
				if(dp[j] && dict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
	} 
	
	public static void main(String[] args) {
		WordBreak wordBreak = new WordBreak();
		Set<String> dict = new HashSet<>();
		/*String s = "leetcode";
		dict.add("leet");
		dict.add("code");*/
		String s = "abcdeefg";
		dict.add("ab");
		dict.add("cde");
		dict.add("ee");
		dict.add("cd");
		dict.add("fg");
		System.out.println(wordBreak.wordBreak(s, dict));
	}
}
