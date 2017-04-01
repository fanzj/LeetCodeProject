package com.fzj.leetcode;

import java.util.ArrayList;

public class PascalsTriangle_II {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> subList = null;
		for(int i=0;i<=rowIndex;i++){
			subList = new ArrayList<>();
			for(int j=0;j<=i;j++){
				if(j==0 || j==i)
					subList.add(1);
				else
					subList.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
			}
			list.add(subList);
		}
		return subList;
	}
	
	public ArrayList<Integer> getRow2(int rowIndex) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<=rowIndex;i++){
			list.add(1);
			for(int j=i-1;j>0;j--){
				list.set(j, list.get(j)+list.get(j-1));
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		PascalsTriangle_II solution = new PascalsTriangle_II();
		System.out.println(solution.getRow2(3));
		
	}
}
