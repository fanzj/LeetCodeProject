package com.fzj.leetcode;

import java.util.ArrayList;

public class Triangle {
	/**
	 * 从上往下
	 * 
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < triangle.size(); i++) {
			ArrayList<Integer> cur = triangle.get(i);
			ArrayList<Integer> pre = triangle.get(i - 1);
			for (int j = 0; j < cur.size(); j++) {
				if (j == 0) {
					cur.set(j, cur.get(j) + pre.get(0));
				} else if (j == cur.size() - 1) {
					cur.set(j, cur.get(j) + pre.get(pre.size() - 1));
				} else {
					cur.set(j, cur.get(j) + Math.min(pre.get(j - 1), pre.get(j)));
				}
			}
		}
		ArrayList<Integer> res = triangle.get(triangle.size() - 1);
		for (int i = 0; i < res.size(); i++) {
			min = Math.min(min, res.get(i));
		}
		return min;
	}

	/**
	 * 从下往上
	 * 
	 * @param triangle
	 * @return
	 */
	public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				triangle.get(i).set(j,
						triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
			}
		}
		return triangle.get(0).get(0);
	}

	public static void main(String[] args) {
		Triangle solution = new Triangle();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int[][] A = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
		for (int i = 0; i < A.length; i++) {
			ArrayList<Integer> subList = new ArrayList<>();
			for (int j = 0; j < A[i].length; j++) {
				subList.add(A[i][j]);
			}
			list.add(subList);
		}
		System.out.println("min = " + solution.minimumTotal2(list));
	}
}
