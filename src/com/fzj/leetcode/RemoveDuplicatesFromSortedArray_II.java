package com.fzj.leetcode;

public class RemoveDuplicatesFromSortedArray_II {

	public int removeDuplicates(int[] A) {
		if(A==null || A.length==0)
			return 0;
		int count = 1;
		int B[] = new int[A.length];
		int k = 1;
		B[0] = A[0];
		for(int i=1;i<A.length;i++){
			if(A[i]==A[i-1]){
				count++;
				if(count<=2){
					B[k++] = A[i];
				}
			}else {
				count = 1;
				B[k++] = A[i];
			}
		}
		System.arraycopy(B, 0, A, 0, k);
		return k;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray_II solution = new RemoveDuplicatesFromSortedArray_II();
		//int[] A = {1,1,1,2,2,3,4,4,4,4,5,5,6};
		//int[] A = {1,1,1,2,2,3,4,4,4,4,5,5};
		//int[] A = {1,1,1,2,2,3,4,4,4,4};
//		int[] A = {1,2,2,3,4,4,4,4};
		int[] A = {1,1};
		int len = solution.removeDuplicates(A);
		System.out.println("len = "+len);
		for(int i=0;i<len;i++){
			System.out.print(A[i]);
			if(i<len-1)
				System.out.print(" ");
			else
				System.out.println();
		}
	}
}
