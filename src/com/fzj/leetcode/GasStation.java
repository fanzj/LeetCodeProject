package com.fzj.leetcode;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		int[] diff = new int[len];
		for (int i = 0; i < len; i++) {
			diff[i] = gas[i] - cost[i];
		}

		int pos = -1;
		for (int i = 0; i < len; i++) {
			int j = i;
			int count = 0;
			int sum = 0;
			while (count != len) {

				if (sum + diff[j] < 0) {
					break;
				} else {
					sum += diff[j];
					count++;
				}
				j = (j + 1) % len;
			}
			if (count == len) {
				pos = i;
				break;
			}
		}
		return pos;
	}

	/**
	 * 从start出发， 如果油量足够， 可以一直向后走 end++； 油量不够的时候， start向后退 最终 start ==
	 * end的时候，如果有解一定是当前 start所在位置
	 * 
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int start = gas.length - 1;
		int end = 0;
		int sum = gas[start] - cost[start];
		while (start > end) {
			if (sum >= 0) {
				sum += gas[end] - cost[end];
				end++;
			} else {
				start--;
				sum += gas[start] - cost[start];
			}
		}
		return sum >= 0 ? start : -1;
	}

	public static void main(String[] args) {
		GasStation gasStation = new GasStation();
		 int[] gas = {10,8,12,4,6};
		 int[] cost = {8,12,10,5,4};
		/*int[] gas = { 10, 8, 12, 4, 6 };
		int[] cost = { 9, 12, 17, 5, 8 };*/
		System.out.println(gasStation.canCompleteCircuit2(gas, cost));
	}
}
