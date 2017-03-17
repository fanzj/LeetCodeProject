package com.single.number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	//自己的求解
	public int singleNumber(int[] A){
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<A.length;i++){
			if(!list.contains(A[i])){
				list.add(A[i]);
			}	
			else{
				list.remove((Integer)A[i]);
			}	
		}
		return list.get(0);
	}
	
	//更好的思路
	public int singleNumber2(int[] A){
		int num = A[0];
		for(int i=1;i<A.length;i++){
			num ^= A[i];//相同的数异或为0，0与一个数异或还是那个数
		}
		return num;		
	}
	
	public static void main(String[] args) {
		int[] a = {1,4,6,73,5,123,4,1,6,123,5};
		System.out.println(new Solution().singleNumber2(a));
	}
}
