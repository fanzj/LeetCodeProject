package com.fzj.leetcode;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
	
		int[][] path = new int[m][n];//path[i][j]表示由(0,0)->(i,j)的路径条数
		for(int i=0;i<n;i++){//第一行
			path[0][i] = 1;
		}
		for(int i=0;i<m;i++){//第一列
			path[i][0] = 1;
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				path[i][j] = path[i-1][j] + path[i][j-1];
			}
		}
		return path[m-1][n-1];
	}
	
	public static void main(String[] args) {
		UniquePaths solution = new UniquePaths();
		int m = 3,n=7;
		System.out.println(solution.uniquePaths(m, n));
	}
}
