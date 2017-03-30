package com.fzj.leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int[] temp = new int[digits.length+1];
		int k = 0;
		int jw = 1;//进位,初始位0,相当于加1
		for(int i=digits.length-1;i>=0;i--){
			int cur = digits[i];//当前位
			if(cur+jw>9){
				temp[k++] = (cur+jw)%10;
				jw = 1;
			}else{
				temp[k++] = cur+jw;
				jw = 0;
			}
		}
		if(jw==1){
			temp[k++] = jw;
		}
		int[] res = new int[k];
		for(int i=k-1;i>=0;i--){
			res[i] = temp[k-1-i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		PlusOne one = new PlusOne();
		int[] A = {1,5,6,8,9};
		//int[] A = {9,9,9};
		int[] res = one.plusOne(A);
		for(int i=0;i<res.length;i++){
			System.out.print(res[i]);
			if(i<res.length-1)
				System.out.print(" ");
			else
				System.out.println();
		}
	}
}
