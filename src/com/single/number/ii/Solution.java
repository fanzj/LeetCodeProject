package com.single.number.ii;

import java.util.Arrays;

public class Solution {
	
	//自己的求解，error
	public int singleNumber(int[] A){
		Arrays.sort(A);
		int count = 1;
		int res = 0;
		for(int i=0;i<A.length-1;i++){
			if(A[i]==A[i+1]){
				count++;
			}else if(count!=3){
				res = A[i];
				break;
			}else if(i==A.length-2){
				res = A[A.length-1];
			}else {
				count=1;
			}
		}
		
		return res;
	}
	
	//更好的思路
	public int singleNumber2(int[] A){
		return 0;
	}
	
	public static void main(String[] args) {
		int[] a = {1,4,6,123,5,123,4,1,6,123,5,73,4,1,6,5};
		System.out.println(new Solution().singleNumber(a));
		
	}
}
