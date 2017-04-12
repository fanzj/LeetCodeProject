package com.fzj.leetcode;


public class TrappingRainWater {
	public int trap(int[] A) {
		int sum = 0;
		int left = 0,right = 0;
		int maxPos = 0;
		for(int i=0;i<A.length;i++){
			if(A[maxPos] < A[i]){
				maxPos = i;
			}
		}
		for(int i=0;i<maxPos;i++){
			if(A[i]<left){
				sum += (left-A[i]);
			}else {
				left = A[i];
			}
		}
		for(int i=A.length-1;i>maxPos;i--){
			if(A[i]<right){
				sum += (right-A[i]);
			}else {
				right = A[i];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		TrappingRainWater solution = new TrappingRainWater();
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(solution.trap(A));
	}
}
