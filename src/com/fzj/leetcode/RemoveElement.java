package com.fzj.leetcode;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int[] B = new int[A.length];
		int len = 0;
		for(int i=0;i<A.length;i++){
			if(A[i]!=elem){
				B[len++] = A[i];
			}
		}
		System.arraycopy(B, 0, A, 0, len);
		return len;
	}
	
	public static void main(String[] args) {
		RemoveElement solution = new RemoveElement();
//		int[] A = {1,2,3,4,5,3,2,1};
//		int elem = 3;
		int[] A = {4,5,4};
		int elem = 4;
		System.out.println(solution.removeElement(A, elem));
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]+" ");
		}
	}
}
