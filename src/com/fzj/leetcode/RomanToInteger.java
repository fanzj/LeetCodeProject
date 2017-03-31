package com.fzj.leetcode;

import java.util.HashMap;
import java.util.Map;


public class RomanToInteger {
	public int romanToInt(String s) {
		int res = 0;
		Map<String, Integer> map = new HashMap<>();
		String[] keys = { "I", "V", "X", "L", "C", "D", "M", "IV", "IX", "XL", "XC", "CD", "CM" };
		int[] values = { 1, 5, 10, 50, 100, 500, 1000, 4, 9, 40, 90, 400, 900 };
		for(int i=0;i<keys.length;i++){
			map.put(keys[i], values[i]);
		}
		if(s.length()==1)
			return map.get(s);
		for(int i=s.length()-1;i>0;){
			String cur = String.valueOf(s.charAt(i));
			String next = String.valueOf(s.charAt(i-1));
			if(map.containsKey(next+cur)){
				res += map.get(next+cur);
				i -= 2;
			}
			else {
				res += map.get(cur);
				i--;
			}
			if(i==0){
				String tmp = String.valueOf(s.charAt(0));
				res += map.get(tmp);
			}
		}
		return res;
	}
	
	public int romanToInt2(String s) {
		int ans = 0;
		int preValue = 0;
		Map<Character, Integer> map = new HashMap<>();
		char[] keys = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		int[] values = { 1, 5, 10, 50, 100, 500, 1000};
		for(int i=0;i<keys.length;i++){
			map.put(keys[i], values[i]);
		}
		for(int i=s.length()-1;i>=0;i--){
			int curValue = map.get(s.charAt(i));
			if(curValue<preValue)
				ans -= curValue;
			else
				ans += curValue;
			preValue = curValue;
		}
		return ans;
	}

	public static void main(String[] args) {
		RomanToInteger solution = new RomanToInteger();
		//String str = "MMMCMXCIX";
		String str = "MIV";
		System.out.println(solution.romanToInt2(str));
	}
}
