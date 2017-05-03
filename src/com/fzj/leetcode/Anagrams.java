package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0;i<strs.length;i++){
			char[] ch = strs[i].toCharArray();
			Arrays.sort(ch);
			String tmps = String.valueOf(ch);
//			System.out.println(tmps);
			if(map.containsKey(tmps)){
				if(map.get(tmps)!=-1)
					list.add(strs[map.get(tmps)]);
				list.add(strs[i]);
				map.put(tmps, -1);
			}else {
				map.put(tmps, i);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		String[] strs = {"apple","array","rraya","dasfw","yarra","apple"};
		System.out.println(new Anagrams().anagrams(strs));
		
	}
}
