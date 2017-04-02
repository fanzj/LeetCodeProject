package com.fzj.leetcode;

public class Sqrtx {
	/**
	 * ¶þ·Ö·¨
	 * 
	 * @param x
	 * @return
	 */
	public int sqrt(int x) {
		int low = 0;
		int high = x;
		while (low <= high) {
			long mid = (low + high) / 2;
			if (mid * mid == x)
				return (int)mid;
			else if (mid * mid < x)
				low = (int) (mid + 1);
			else
				high = (int) (mid - 1);
		}
		return high;
	}

	public static void main(String[] args) {
		Sqrtx sqrtx = new Sqrtx();
		System.out.println(sqrtx.sqrt(9));
	}
}
