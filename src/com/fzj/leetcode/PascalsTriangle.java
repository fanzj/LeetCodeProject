package com.fzj.leetcode;

import java.util.ArrayList;

public class PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if(numRows<=0)
			return list;
		ArrayList<Integer> initList = new ArrayList<>();
		initList.add(1);
		list.add(initList);
		for(int i=1;i<numRows;i++){
			ArrayList<Integer> preList = list.get(i-1);
			ArrayList<Integer> subList = new ArrayList<>();
			subList.add(1);
			for(int j=0;j<preList.size()-1;j++){
				subList.add(preList.get(j)+preList.get(j+1));
			}
			subList.add(1);
			list.add(subList);
		}
		return list;
	}
	
	public static void main(String[] args) {
		PascalsTriangle solution = new PascalsTriangle();
		int num = 0;
		System.out.println(solution.generate(num));
	}
}
