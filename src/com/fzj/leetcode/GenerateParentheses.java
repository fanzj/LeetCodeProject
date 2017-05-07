package com.fzj.leetcode;

import java.util.ArrayList;

public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> list = new ArrayList<>();
		arrange(n, 0, 0, "", list);
		return list;
	}

	/**
	 * 
	 * @param n
	 * @param usedLeft
	 *            当前位置的左括号数
	 * @param usedRight
	 *            当前位置的右括号数
	 * @param s
	 * @param list
	 */
	private void arrange(int n, int usedLeft, int usedRight, String s, ArrayList<String> list) {
		if (usedLeft == n && usedRight == n) {
			list.add(s);
			return;
		}
		if (usedLeft < n) {
			arrange(n, usedLeft + 1, usedRight, s + "(", list);
		}
		if (usedRight < n && usedLeft > usedRight) {
			arrange(n, usedLeft, usedRight + 1, s + ")", list);
		}
	}

	public static void main(String[] args) {
		System.out.println(new GenerateParentheses().generateParenthesis(3));
	}
}
