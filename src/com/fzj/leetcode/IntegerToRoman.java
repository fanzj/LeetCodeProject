package com.fzj.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	public String intToRoman(int num) {
		Map<Integer, String> map = new HashMap<>();
		int[] keys = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] values = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
		String res = "";
		for (int i = 0; i < keys.length; i++) {
			int count = num/keys[i];
			for(int j=0;j<count;j++){
				res += map.get(keys[i]);
			}
			num %= keys[i];
		}
		return res;
	}

	
	public static void main(String[] args) {
		IntegerToRoman solution = new IntegerToRoman();
		String str = "MMMCMXCIX";
		System.out.println(solution.intToRoman(3999));
		String str2 = "MIV";
		System.out.println(solution.intToRoman(1004));
	}
}
