package com.fzj.leetcode;

public class JumpGame_II {
	public int jump(int[] A) {
		int[] dp = new int[A.length];// dp存放到各点的最小步数
		for (int i = 0; i < dp.length; i++) {
			int max = Math.min(i + A[i], A.length - 1);// 从i点出发能走的最远距离
			for (int j = i + 1; j <= max; j++) {
				if (dp[j] == 0)// 如果位置没被走过,则到达j点的步数为dp[i]+1
					dp[j] = dp[i] + 1;
			}
			if (dp[A.length - 1] != 0)// 当第一次到达终点时,肯定是到达终点最短的步数
				break;
		}
		return dp[A.length - 1];
	}

	public static void main(String[] args) {
		JumpGame_II solution = new JumpGame_II();
		int[] A = { 2, 3, 1, 1, 4 };
		System.out.println(solution.jump(A));
	}
}
