package com.fzj.leetcode;

public class BestTimeToBuyAndSellStock {
	
	public int maxProfit(int[] prices) {
//		if(prices.length==0)
//			return 0;
        int max = 0;
        for(int i=0;i<prices.length-1;i++){
        	for(int j=i+1;j<prices.length;j++){
        		if(max < (prices[j]-prices[i])){
        			max = prices[j] - prices[i];
        		}
        		//System.out.println("max = "+max);
        	}
        }
        return max;
    }
	
	public int maxProfit2(int[] prices) {
		if(prices==null || prices.length==0)
			return 0;
		int max = 0;
		int min = prices[0];
		for(int i=0;i<prices.length;i++){
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i]-min);
		}
		return max;
    }

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock sellStock = new BestTimeToBuyAndSellStock();
		//int[] A = {4,5,6,8,3,1,7};
		int[] A = {1,2,3,4,5,6,7};
		//int[] A = {7,6,5,4,3,2,1};
		//int[] A = {};
		//int[] A = {2};
		System.out.println(sellStock.maxProfit2(A));
	}
}
