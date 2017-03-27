package com.fzj.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			String element = tokens[i];
			switch (element) {
			case "+": {//判断为操作符,从栈顶弹出两个元素,因为逆波兰表示的特性，操作数肯定在操作符前
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x+y);
			}
				break;
			case "-": {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x-y);
			}
				break;
			case "*": {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x*y);
			}
				break;
			case "/": {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(x/y);
			}
				break;
			default: {//为数字，压栈
				stack.push(Integer.valueOf(element));
			}
				break;
			}
			
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
		String[] tokens1 = { "2", "1", "+", "3", "*" };
		System.out.println(solution.evalRPN(tokens1));
		String[] tokens2 = { "4", "13", "5", "/", "+" };
		System.out.println(solution.evalRPN(tokens2));
	}
}
