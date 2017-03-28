package com.fzj.leetcode;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		if(m==0){
			for(int k=0;k<B.length;k++){
				A[k] = B[k];
			}
		}else {
			int i=m-1,j=n-1;
			int s = m+n-1;
			while(i>=0 && j>=0){
				if(A[i]>B[j]){
					A[s--] = A[i--];
				}else {
					A[s--] = B[j--];
				}
			}
			while(j>=0){//A先耗尽，把B剩下的直接插入
				A[s--] = B[j--];
			}
		}
	}
	
	public void print(int[] A,int len){
		for(int i=0;i<len;i++){
			System.out.print(A[i]);
			if(i<len-1)
				System.out.print(" ");
			else
				System.out.println();
		}
	}
	
	public static void main(String[] args) {
		/*int[] A = new int[]{-5,-3,1,3,5,7,9,-1,-1,-1,-1,-1,-1,-1};
		int[] B = new int[]{2,4,6,8,10,12};
		MergeSortedArray solution = new MergeSortedArray();
		solution.merge(A, 7, B, 6);
		solution.print(A, 13);*/
		
		int[] A = new int[]{4,5,6,-1,-1,-1,-1,-1};
		int[] B = new int[]{1,2,3};
		MergeSortedArray solution = new MergeSortedArray();
		solution.merge(A, 3, B, 3);
		solution.print(A, 6);
	}
}
