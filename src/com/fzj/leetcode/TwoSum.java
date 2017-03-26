package com.fzj.leetcode;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		for(int i=0;i<numbers.length;i++){
			for(int j=i+1;j<numbers.length;j++){
				if(numbers[i]+numbers[j]==target){
					res[0] = i+1;
					res[1] = j+1;
					return res;
				}
			}
		}
		return res;
	}
	
	public int[] twoSum2(int[] numbers, int target) {
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = numbers.length;
		for(int i=0;i<n;i++){
			if(map.containsKey(target-numbers[i])){
				res[0] = map.get(target-numbers[i])+1;
				res[1] = i+1;
			}else {
				map.put(numbers[i], i);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
//		int numbers[] = {2,7,11,15};
//		int target = 9;
		int numbers[] = {3,2,4};
		int target = 6;
		int[] res = twoSum.twoSum2(numbers, target);
		System.out.println("index1="+(res[0])+", index2="+(res[1]));
		
	}
}
