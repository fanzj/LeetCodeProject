package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations_II {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		boolean[] visited = new boolean[num.length];
		Arrays.sort(num);
		dfs(list, temp, 0, num, visited);
		return list;
	}
	
	private void dfs(ArrayList<ArrayList<Integer>> list,ArrayList<Integer> temp,int step,int[] num,boolean[] visited){
		if(step==num.length){
			list.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i=0;i<num.length;i++){
			if(!visited[i]){
				visited[i] = true;
				temp.add(num[i]);
				dfs(list, temp, step+1, num, visited);
				visited[i] = false;
				temp.remove(temp.size()-1);
				while (i<num.length-1 && num[i]==num[i+1]) {
					i++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Permutations_II solution = new Permutations_II();
		int[] num = {2,1,1};
		System.out.println(solution.permuteUnique(num));
	}
}
