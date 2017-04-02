package com.fzj.leetcode;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (A[mid] == target)
				return mid;
			else if (target < A[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

	public static void main(String[] args) {
		SearchInsertPosition solution = new SearchInsertPosition();
		int[] A = { 1, 3, 5, 6 };
		System.out.println(solution.searchInsert(A, 5));
		System.out.println(solution.searchInsert(A, 2));
		System.out.println(solution.searchInsert(A, 7));
		System.out.println(solution.searchInsert(A, 0));
	}
}
