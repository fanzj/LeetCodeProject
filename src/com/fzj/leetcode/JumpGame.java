package com.fzj.leetcode;

public class JumpGame {
	public boolean canJump(int[] A) {
		int i=0;
		int count = 0;//ÒÆ¶¯´ÎÊý
		while(i<A.length){
			if(i==A.length-1)
				return true;
			i+=A[i];
			count++;
			if(count>A.length)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		JumpGame solution = new JumpGame();
//		int[] A = {2,3,1,1,4};
//		int[] A = {3,2,1,0,4};
		int[] A = {1};
		System.out.println(solution.canJump(A));
	}
}
