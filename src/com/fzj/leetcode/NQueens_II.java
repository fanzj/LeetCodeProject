package com.fzj.leetcode;

public class NQueens_II {

	private int count = 0;
	
	public int totalNQueens(int n) {
		int[] cols = new int[n];
		arrange(0, n, cols);
		return count;
	}
	
	/**
	 *  
	 * @param m µ±Ç°ÁÐ
	 * @param n
	 * @return
	 */
	public void arrange(int m,int n,int[] cols){
		boolean[] rows = new boolean[n];
		for(int i=0;i<m;i++){
			rows[cols[i]] = true;
			int d = m-i;
			if(cols[i]-d>=0)
				rows[cols[i]-d]=true;
			if(cols[i]+d<n)
				rows[cols[i]+d]=true;
		}
		for(int i=0;i<n;i++){
			if(rows[i])
				continue;
			cols[m] = i;
			if(m<n-1)
				arrange(m+1, n, cols);
			else
				count++;
		}
	}
	
	public static void main(String[] args) {
		NQueens_II solution = new NQueens_II();
		System.out.println(solution.totalNQueens(8));
	}
}
