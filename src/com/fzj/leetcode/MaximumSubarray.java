package com.fzj.leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if (A.length == 0)
			return 0;
		int max = A[0], sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (max < sum)
				max = sum;
			if (sum < 0)
				sum = 0;
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumSubarray solution = new MaximumSubarray();
//		int[] A = { -2, -3, -1, -5, -9 };
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(solution.maxSubArray(A));
	}
}
