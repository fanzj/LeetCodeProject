package com.fzj.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if(s.length()%2!=0)
			return false;
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(stack.isEmpty()){
				if(c==')' || c==']' || c=='}'){
					return false;
				}
				stack.push(c);
			}else {
				char top = stack.peek();
				if(c=='(' || c=='[' || c=='{'){
					stack.push(c);
				}else if(c==map.get(top)){
					stack.pop();
				}else {
					return false;
				}
			}
		}
		if(!stack.isEmpty())
			return false;
		
		return true;
	}

	public static void main(String[] args) {
		String s = "(([]))[][]{}";//true
		String s2 = "([)]";//false
		String s3 = "()()";//true
		String s4 = "((";//false
		String s5 = ")}{({))[{{[}";//false
		System.out.println(new ValidParentheses().isValid(s5));
	}
}
