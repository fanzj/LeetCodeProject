package com.fzj.leetcode;

public class BestTimeToBuyAndSellStock_II {
	
	public int maxProfit(int[] prices) {
		int max = 0;
		for(int i=1;i<prices.length;i++){
			int diff = prices[i]-prices[i-1];
			if(diff>0){
				max += diff;
			}
		}
		return max;
    }
	
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock_II sellStock = new BestTimeToBuyAndSellStock_II();
		//int[] A = {4,5,6,8,3,1,3,7};
		//int[] A = {1,2,3,4,5,6,7};
		//int[] A = {7,6,5,4,3,2,1};
		//int[] A = {};
		//int[] A = {2};
		int[] A = {6,1,3,2,4,7};
		System.out.println(sellStock.maxProfit(A));
	}
}
