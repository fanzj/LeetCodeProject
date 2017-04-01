package com.fzj.leetcode;

import java.util.ArrayList;

public class GrayCode {
	public ArrayList<Integer> grayCode(int n){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		for(int i=0;i<n;i++){
			int len = list.size();
			for(int k=len-1;k>=0;k--){
				list.add(list.get(k)+(1<<i));
			}
		}
		
		return list;
	}

	public static void main(String[] args) {
		GrayCode grayCode = new GrayCode();
		System.out.println(grayCode.grayCode(3));
	}
}
