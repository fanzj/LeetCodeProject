package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _4Sum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (num.length < 4)
			return result;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (map.containsKey(num[i] + num[j])) {
					ArrayList<Integer> list = map.get(num[i] + num[j]);
					//if (!list.contains(i)) {
						list.add(i);
						list.add(j);
					//}
				} else {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(j);
					map.put(num[i] + num[j], list);
				}
			}
		}
		//System.out.println(map);
		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			int x = entry.getKey();
			int y = target - x;
			if (map.containsKey(y)) {
				ArrayList<Integer> l1 = entry.getValue();
				ArrayList<Integer> l2 = map.get(y);
				for (int i = 0; i < l1.size(); i += 2) {
					int a = l1.get(i);
					int b = l1.get(i + 1);
					for (int j = 0; j < l2.size(); j += 2) {
						int c = l2.get(j);
						int d = l2.get(j + 1);
						if (a != c && a != d && b != c && b != d) {
							ArrayList<Integer> list = new ArrayList<>();
							list.add(num[a]);
							list.add(num[b]);
							list.add(num[c]);
							list.add(num[d]);
							Collections.sort(list);
							if(!result.contains(list))
								result.add(list);
						}
					}

				}

			}
		}
		Collections.sort(result, new Comparator<ArrayList<Integer>>() {

			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				for(int i=0;i<o1.size();i++){
					if(o1.get(i)<o2.get(i))
						return -1;
					else if(o1.get(i)>o2.get(i))
						return 1;
				}
				return 0;
			}
			
		});
		return result;
	}

	public static void main(String[] args) {
		_4Sum solution = new _4Sum();
		int[] A = { 1, 0, -1, 0, -2, 2 };
		System.out.println(solution.fourSum(A, 0));
		int[] B = {0,0,0,0};
		System.out.println(solution.fourSum(B, 0));
		int[] C = {-1,0,1,2,-1,-4};//-1
		System.out.println(solution.fourSum(C, -1));
		int[] D = {0,1,5,0,1,5,5,-4};//11
		System.out.println(solution.fourSum(D, 11));
		int[] E = {0,4,-5,2,-2,4,2,-1,4};//12
		System.out.println(solution.fourSum(E, 12));
	}
}
