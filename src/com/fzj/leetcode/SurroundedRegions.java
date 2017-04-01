package com.fzj.leetcode;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if(board.length==0)
			return ;
		int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
		int row = board.length;//行
		int col = board[0].length;//列
		for(int i=0;i<col;i++){//第一行和最后一行
			if(board[0][i]=='O'){
				board[0][i]='*';
				dfs(board, 0, i, direction);
			}
			if(board[row-1][i]=='O'){
				board[row-1][i] = '*';
				dfs(board, row-1, i, direction);
			}
		}
		for(int i=0;i<row;i++){//第一列和最后一列
			if(board[i][0]=='O'){
				board[i][0]='*';
				dfs(board, i, 0, direction);
			}
			if(board[i][col-1]=='O'){
				board[i][col-1]='*';
				dfs(board, i, col-1, direction);
			}
		}
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(board[i][j]=='O'){
					board[i][j]='X';
				}else if(board[i][j]=='*'){
					board[i][j]='O';
				}
			}
		}
	}
	
	public void dfs(char[][] board,int x,int y,int[][] direction){
		for(int i=0;i<direction.length;i++){
			int nx = x + direction[i][0];
			int ny = y + direction[i][1];
			if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && board[nx][ny]=='O'){
				board[nx][ny] = '*';
				dfs(board, nx, ny, direction);
			}
		}
	}

	public static void main(String[] args) {
		SurroundedRegions solution = new SurroundedRegions();
		char[][] board = { { 'X', 'X', 'X', 'X' }, 
						   { 'X', 'O', 'O', 'X' }, 
						   { 'X', 'X', 'O', 'X' },
						   { 'X', 'O', 'X', 'X' } };
		solution.solve(board);
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j]);
				if(j<board[0].length-1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
