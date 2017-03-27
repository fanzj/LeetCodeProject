package com.fzj.leetcode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {// 字符串预处理
			char ch = s.charAt(i);
			if (ch >= 'a' && ch <= 'z') {// 转成大写
				sb.append((char) (ch - 32));
			} else if ((ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
				sb.append((char) ch);
			}
		}
		System.out.println(sb.toString());
		int len = sb.length();
		for (int i = 0; i < len / 2; i++) {
			if (sb.charAt(i) != sb.charAt(len - 1 - i))
				return false;
		}
		return true;
	}



	public static void main(String[] args) {
		ValidPalindrome validPalindrome = new ValidPalindrome();
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		System.out.println(validPalindrome.isPalindrome(s1));
	}
}
