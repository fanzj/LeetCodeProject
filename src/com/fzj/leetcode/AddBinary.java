package com.fzj.leetcode;

public class AddBinary {
	public static String addBinary(String a, String b) {
		if(a.length()==0)
			return b;
		if(b.length()==0)
			return a;
		StringBuffer sb = new StringBuffer();
		char[] ca = a.toCharArray();
		char[] cb = b.toCharArray();
		int i = ca.length-1;
		int j = cb.length-1;
		int jw = 0;//½øÎ»
		while(i>=0 && j>=0){
			int v = (ca[i]-'0') + (cb[j]-'0') + jw;
			sb.append(v%2);
			jw = v/2;
			i--;
			j--;
		}
		while(i>=0){
			int v = (ca[i]-'0') + jw;
			sb.append(v%2);
			jw = v/2;
			i--;
		}
		while(j>=0){
			int v = (cb[j]-'0') + jw;
			sb.append(v%2);
			jw = v/2;
			j--;
		}
		if(jw!=0)
			sb.append(jw);
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		String a = "1101";
		String b = "11";
		System.out.println(AddBinary.addBinary(a, b));
	}
}
