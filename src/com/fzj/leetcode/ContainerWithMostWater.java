package com.fzj.leetcode;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int maxArea = 0;
		for(int i=0;i<height.length-1;i++){
			for(int j=i+1;j<height.length;j++){
				int temp = Math.min(height[i], height[j]) * (j-i);
				if(maxArea<temp)
					maxArea = temp;
			}
		}
		return maxArea;
	}
	
	public int maxArea2(int[] height) {
		int maxArea = 0;
		int l=0,r = height.length-1;
		while(l<r){
			int temp = Math.min(height[l], height[r])*(r-l);
			if(maxArea < temp)
				maxArea = temp;
			if(height[l]<height[r])
				l++;
			else
				r--;
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		ContainerWithMostWater solution = new ContainerWithMostWater();
//		int[] height = {2,3,1,4,5};
	//	int[] height = {0,2};//0
		int[] height = {1,2,4,3};
		System.out.println("maxArea = "+solution.maxArea2(height));
	}
}
