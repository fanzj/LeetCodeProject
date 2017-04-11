package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class _3Sum {
	/**
	 * 超时
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (num.length < 3)
			return result;
		HashMap<Integer, Integer> map = new HashMap<>();// <某个值,存在的个数>
		for (int i = 0; i < num.length; i++) {
			if (map.containsKey(num[i])) {
				int count = map.get(num[i]);
				count++;
				map.put(num[i], count);
			} else {
				map.put(num[i], 1);
			}
		}
		System.out.println("map: " + map);
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int x = num[i] + num[j];
				int y = -x;
				if (map.containsKey(y)) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(num[i]);
					list.add(num[j]);
					int count = map.get(y);
					if (y != num[i] && y != num[j]) {
						list.add(y);
					} else if (y == num[i] && y == num[j]) {
						if (count >= 3) {
							list.add(y);
						}
					} else {
						if (count >= 2) {
							list.add(y);
						}
					}
					Collections.sort(list);
					if (!result.contains(list) && list.size()==3)
						result.add(list);

				}
			}
		}

		return result;
	}
	
	public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (num.length < 3)
			return result;	
		Arrays.sort(num);//O(NlogN)
		for(int i=0;i<num.length;i++){
			if(num[i]>0)//i之后的全是正数了
				break;
			if(i>0 && num[i]==num[i-1])//去重
				continue;
			int l = i+1;
			int r = num.length-1;
			while(l<r){
				if(num[l]+num[r]+num[i]==0){
					ArrayList<Integer> list = new ArrayList<>();
					list.add(num[l]);
					list.add(num[r]);
					list.add(num[i]);
					Collections.sort(list);
					if(!result.contains(list))
						result.add(list);
					if(l<r && num[l]==num[l+1])
						l++;
					else if(l<r && num[r]==num[r-1])
						r--;
					else{
						l++;
						r--;
					}
				}else if(num[l]+num[r]+num[i]<0){
					l++;
				}else {
					r--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		_3Sum solution = new _3Sum();
		int[] A = { -1, 0, 1, 2, -1, -4 };
		System.out.println(solution.threeSum2(A));
		int[] B = {0,0,0};
		System.out.println(solution.threeSum2(B));
	}
}
