package com.fzj.leetcode;

public class UniqueBinarySearchTrees {

	//选择一个节点，它的左右子树个数的乘积就是总的个数，可以递归解决
	public int numTrees(int n) {
		if(n<=1)
			return 1;
		int num = 0;
		for(int i=1;i<=n;i++){
			num += numTrees(i-1)*numTrees(n-i);
		}
		return num;
	}
	
	//非递归.动态规划
	public int numTrees2(int n) {
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++){
			for(int j=1;j<=i;j++){
				dp[i] += dp[j-1]*dp[i-j];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees binarySearchTrees = new UniqueBinarySearchTrees();
		System.out.println(binarySearchTrees.numTrees2(3));
	}
}
