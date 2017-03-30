package com.fzj.leetcode;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int i=0,j=0;
		for(i=1;i<col;i++){//处理第一行
			grid[0][i] += grid[0][i-1];
		}
		for(i=1;i<row;i++){//处理第一列
			grid[i][0] += grid[i-1][0];
		}
		for(i=1;i<row;i++){
			for(j=1;j<col;j++){
				int min = Math.min(grid[i-1][j], grid[i][j-1]);
				grid[i][j] += min;
			}
		}
		return grid[row-1][col-1];
	}

	public static void main(String[] args) {
		MinimumPathSum solution = new MinimumPathSum();
		int[][] grid = { { 2, 1, 3, -5, -2, 0 }, { -1, 4, 0, 2, 1, -7 }, { 3, -5, -2, 1, 1, 0 },
				{ 4, 5, -3, 5, 2, 1 } };
		int res = solution.minPathSum(grid);
		System.out.println(res);
	}
}
