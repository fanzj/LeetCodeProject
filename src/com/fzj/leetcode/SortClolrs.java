package com.fzj.leetcode;

public class SortClolrs {
	public void sortColors(int[] A) {
		int dp[]={0,0,0};
		for(int i=0;i<A.length;i++){
			dp[A[i]]++;
		}
		int k = 0;
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[i];j++){
				A[k++] = i;
			}
		}
		
	}
	
	public void sortColors2(int[] A) {
		int begin = 0;
		int end = A.length-1;
		int cur = 0;
		while(cur<=end){
			if(A[cur]==0){
				int temp = A[cur];
				A[cur] = A[begin];
				A[begin] = temp;
				begin++;
				cur++;
			}else if(A[cur]==2){
				int temp = A[cur];
				A[cur] = A[end];
				A[end] = temp;
				end--;
			}else {
				cur ++;
			}
		}
	}
	
	public void swap(int a,int b){
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void main(String[] args) {
		SortClolrs sortClolrs = new SortClolrs();
		int[] A = {1,0,2,0,1,1,2,0,0,1};
		sortClolrs.sortColors2(A);
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]);
			if(i<A.length-1)
				System.out.print(" ");
			else
				System.out.println();
		}
	}
}
