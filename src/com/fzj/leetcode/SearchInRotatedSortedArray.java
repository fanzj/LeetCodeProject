package com.fzj.leetcode;

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		int low1 = 0, high1 = 0;
		int low2 = 0, high2 = A.length - 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				high1 = i - 1;
				low2 = i;
			}
		}
		while (low1 <= high1) {
			int mid1 = (low1 + high1) / 2;
			if (target == A[mid1])
				return mid1;
			else if (target < A[mid1])
				high1 = mid1 - 1;
			else
				low1 = mid1 + 1;
		}
		while (low2 <= high2) {
			int mid2 = (low2 + high2) / 2;
			if (target == A[mid2])
				return mid2;
			else if (target < A[mid2])
				high2 = mid2 - 1;
			else
				low2 = mid2 + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
		int[] A = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(solution.search(A, 6));// 2
		System.out.println(solution.search(A, 2));// 6
		System.out.println(solution.search(A, 3));// -1
	}
}
