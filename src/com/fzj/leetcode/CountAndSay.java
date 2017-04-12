package com.fzj.leetcode;

public class CountAndSay {
	public String countAndSay(int n) {
		if(n==1)
			return "1";
		String s = "11";
		StringBuffer sb = new StringBuffer(s);
		for(int i=1;i<n-1;i++){
			int count = 1;
			sb = new StringBuffer();
			for(int j=1;j<s.length();j++){
				char pre = s.charAt(j-1);
				char cur = s.charAt(j);
				if(pre==cur){
					count++;
				}else {
					sb.append(count).append(pre);
					count = 1;
				}
				if(j==s.length()-1)
					sb.append(count).append(cur);
			}
			
			s = sb.toString();
			//System.out.println(sb.toString());
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		CountAndSay solution = new CountAndSay();
		System.out.println(solution.countAndSay(0));
	}
}
