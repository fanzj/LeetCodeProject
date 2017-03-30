package com.fzj.leetcode;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		if(A==null || A.length==0)
			return 0;
		int len = 1;
		for(int i=1;i<A.length;i++){
			if(A[i]!=A[i-1]){
				A[len++] = A[i];
			}
		}
		return len;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
		//int[] A = {1,1,2,3,3,3,4,5,5};
		int[] A = {1};
		int len = solution.removeDuplicates(A);
		System.out.println(len);
		for(int i=0;i<len;i++){
			System.out.print(A[i]);
			if(i<len-1)
				System.out.print(" ");
			else
				System.out.println();
		}
	}
}
