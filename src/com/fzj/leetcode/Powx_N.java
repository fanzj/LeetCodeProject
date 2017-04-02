package com.fzj.leetcode;

public class Powx_N {
	public double pow(double x, int n) {
		if(n==0)
			return 1;
		if(n<0)
			return 1/x * pow(1/x, -(n+1));
		if(n%2==0)
			return pow(x*x, n/2);
		else
			return x*pow(x*x, n/2);
	}

	public static void main(String[] args) {
		Powx_N solution = new Powx_N();
		System.out.println(solution.pow(3, 3));
	}
}
