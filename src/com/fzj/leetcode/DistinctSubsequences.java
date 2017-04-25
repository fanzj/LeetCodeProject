package com.fzj.leetcode;


public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		int row = S.length()+1;
		int col = T.length()+1;
		int[][] dp = new int[row][col];
		for(int i=1;i<col;i++){
			dp[0][i] = 0;
		}
		for(int i=0;i<row;i++){
			dp[i][0]=1;
		}
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				if(S.charAt(i-1)==T.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		/*for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(dp[i][j]);
				if(j<col-1)
					System.out.print(" ");
			}
			System.out.println();
		}*/
		return dp[row-1][col-1];
	}
	
	

	
	public static void main(String[] args) {
		DistinctSubsequences solution = new DistinctSubsequences();
		String s = "rabbbit";
		String t = "rabbit";
//		String s = "ccc";
//		String t = "c";
//		String s = "aacaacca";
//		String t = "ca";
		System.out.println("result = "+solution.numDistinct(s, t));
	}
}
