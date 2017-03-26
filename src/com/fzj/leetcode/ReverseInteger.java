package com.fzj.leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		boolean isPositive = true;//是否为正数
		if(x<0){
			x = -x;
			isPositive = false;
		}
		int[] num = new int[20];
		int count = 0;
		while(x!=0){
			num[count++] = x%10;
			x/=10;
		}
		//前导0去除,以-1代替，这些位置将去除
		for(int i=0;i<count;i++){
			if(num[i]!=0){
				break;
			}	
			else{
				num[i] = -1;
			}
		}
		x = 0;
		for(int i=0;i<count;i++){
			if(num[i]!=-1){
				x = x*10+num[i];
			}
		}
		if(x>Integer.MAX_VALUE || x<Integer.MIN_VALUE){//溢出处理
			x = 0;
		}
		if(!isPositive)
			x = -x;
		return x;
	}
	
	public static void main(String[] args) {
		ReverseInteger reverseInteger = new ReverseInteger();
		int x1 = 10;
		int x2 = 1000;
		int x3 = 1000000003;
		int x4 = -12345;
		System.out.println(reverseInteger.reverse(x1));
		System.out.println(reverseInteger.reverse(x2));
		System.out.println(reverseInteger.reverse(x3));
		System.out.println(reverseInteger.reverse(x4));
	}
}
