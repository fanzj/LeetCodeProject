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
	
	public boolean isValid2(String s) {
		if(s=="")
			return true;
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('(', 0);
		map.put('[', 1);
		map.put('{', 2);
		map.put(')', 3);
		map.put(']', 4);
		map.put('}', 5);
		Stack<Character> stack = new Stack<>();
		int pos = 0;
		while(pos<s.length()){
			if(map.get(s.charAt(pos))<3){
				stack.push(s.charAt(pos));
			}else {
				if(!stack.isEmpty()){
					char top = stack.peek();
					if(map.get(s.charAt(pos))-map.get(top)!=3)
						return false;
					else
						stack.pop();
				}
				else
					return false;
			}
			pos++;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s = "(([]))[][]{}";//true
		String s2 = "([)]";//false
		String s3 = "()()";//true
		String s4 = "((";//false
		String s5 = ")}{({))[{{[}";//false
		System.out.println(new ValidParentheses().isValid2(s));
	}
}
