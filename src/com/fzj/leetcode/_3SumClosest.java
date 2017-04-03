package com.fzj.leetcode;

public class _3SumClosest {
	public int threeSumClosest(int[] num, int target) {
		int sum = 0, error = 0, result = 0, min = Integer.MAX_VALUE;
		for(int i=0;i<num.length;i++){
			for(int j=i+1;j<num.length;j++){
				for(int k=j+1;k<num.length;k++){
					sum = num[i]+num[j]+num[k];
					error = Math.abs(sum-target);
					if(error==0)
						return sum;
					if(error<min){
						min = error;
						result = sum;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		_3SumClosest solution = new _3SumClosest();
		// int[] num = { -1, 2, 1, -4 };
		// int target = 1;
		int[] num = { 1, 1, -1, -1, 3 };// 3
		int target = 3;
		System.out.println(solution.threeSumClosest(num, target));
	}
}
