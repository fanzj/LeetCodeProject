package com.fzj.leetcode;

import java.util.ArrayList;

public class NQueens {

	public ArrayList<String[]> solveNQueens(int n) {
		int[] cols = new int[n];// 存放摆放结果，cols[i]=j表示第i列为行j
		ArrayList<String[]> list = new ArrayList<>();
		arrange(cols, 0, n, list);
		return list;
	}

	/**
	 * 
	 * @param cols
	 * @param m
	 *            当前列
	 * @param n
	 *            n皇后
	 * @param list
	 *            存放结果
	 */
	public void arrange(int[] cols, int m, int n, ArrayList<String[]> list) {
		boolean[] rows = new boolean[n];
		for (int i = 0; i < m; i++) {// 找出对当前列m来说，哪些行不能摆放
			rows[cols[i]] = true;// m不能摆放在cols[i]行
			int d = m - i;
			if (cols[i] - d >= 0)
				rows[cols[i] - d] = true;// m不能摆放在i的斜对角
			if (cols[i] + d < n)
				rows[cols[i] + d] = true;// m不能摆放在i的反斜对角
		}
		for (int i = 0; i < n; i++) {// 遍历行
			if (rows[i])
				continue;
			cols[m] = i;//m列摆放行i
			if(m<n-1){//不是最后一行
				arrange(cols, m+1, n, list);
			}else {
				//输出保存
				String[] s = new String[n];
				for(int j=0;j<n;j++){//行
					StringBuffer sb = new StringBuffer();
					for(int k=0;k<n;k++){
						if(j==cols[k])
							sb.append("Q");
						else
							sb.append(".");
					}
					s[j] = sb.toString();
				}
				list.add(s);
			}
		}
	}

	public static void main(String[] args) {
		NQueens solution = new NQueens();
		ArrayList<String[]> res = solution.solveNQueens(8);
		for(int i=0;i<res.size();i++){
			String[] str = res.get(i);
			for(int j=0;j<str.length;j++){
				System.out.println(str[j]);
			}
			System.out.println();
		}
		System.out.println("解法："+res.size());
	}
}
