package com.fzj.leetcode;

public class DivideTwoIntegers {
	/**
	 * 使用一般的减法运算，很容易导致超时；
	 * 为了减少做减法的次数，是用成倍的加法操作可以
	 */
	public int divide(int dividend, int divisor) {
		if(dividend ==0 || divisor==0)//除数为0
			return 0;
		boolean isPositive = true;//默认结果为正
		if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)){//结果为负
			isPositive = false;
		}
		long x  = Math.abs((long)dividend);
		long y = Math.abs((long)divisor);
		int res = 0;
		while(x>=y){
			int count = 1;
			long sum = y;
			while(sum+sum<=x){
				sum += sum;
				count += count;
			}
			x -= sum;
			res += count;
		}
		return isPositive?res:-res;
	}
	
	public static void main(String[] args) {
		DivideTwoIntegers solution = new DivideTwoIntegers();
		System.out.format("%d / %d = %d\n", 6,2,solution.divide(6, 2));
		System.out.format("%d / %d = %d\n", 5,3,solution.divide(5, 3));
		System.out.format("%d / %d = %d\n", 6,0,solution.divide(6, 0));
		System.out.format("%d / %d = %d\n", 5,-3,solution.divide(5, -3));
		System.out.format("%d / %d = %d\n", 6,-2,solution.divide(6, -2));
		System.out.format("%d / %d = %d\n", -6,-4,solution.divide(-6, -4));
		System.out.format("%d / %d = %d\n", 0,7,solution.divide(0, 7));
		System.out.format("%d / %d = %d\n", Integer.MAX_VALUE,1,solution.divide(Integer.MAX_VALUE, 1));
	}
}
