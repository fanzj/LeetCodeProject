package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordBreak_II {
	
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		return dfs(s, dict, map);
	}
	
	public ArrayList<String> dfs(String s, Set<String> dict,HashMap<String, ArrayList<String>> map) {
		if(map.containsKey(s))
			return map.get(s);
		
		ArrayList<String> list = new ArrayList<>();
		if(s.equals("")){
			list.add("");
		}else {
			int len = s.length();
			for(int i=1;i<=len;i++){
				String sub = s.substring(0, i);
				if(dict.contains(sub)){
					ArrayList<String> tempList = dfs(s.substring(i), dict, map);
					if(tempList.size()==0)
						continue;
					else{
						for(int j=0;j<tempList.size();j++){
							StringBuffer sb = new StringBuffer();
							sb.append(sub).append(" ").append(tempList.get(j));
							list.add(sb.toString().trim());
						}
					}
				}
			}
		}
		map.put(s, list);
		return list;
	}	
	
	public static void main(String[] args) {
		WordBreak_II solution = new WordBreak_II();
		String[] dicts = {"cat", "cats", "and", "sand", "dog"};
		//String[] dicts = {"catsanddog"};
		Set<String> dict = new HashSet<>();
		for(int i=0;i<dicts.length;i++){
			dict.add(dicts[i]);
		}
		String s = "catsanddog";
		System.out.println(solution.wordBreak(s, dict));
	}
}
