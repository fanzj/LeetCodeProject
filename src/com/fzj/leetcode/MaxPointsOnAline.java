package com.fzj.leetcode;

import java.util.HashMap;

public class MaxPointsOnAline {

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int maxPoints(Point[] points) {
		int n = points.length;
		if(n<2)
			return n;
		int ret = 0;
		for(int i=0;i<n;i++){
			int ver = 0;//垂直
			int dup = 1;//与i重复的点个数
			HashMap<Double, Integer> map = new HashMap<>();
			Point p1 = points[i];
			for(int j=0;j<n;j++){
				if(i==j)
					continue;
				Point p2 = points[j];
				if(p1.x==p2.x){
					if(p1.y==p2.y){
						dup++;
					}else {
						ver++;
					}
				}else {
					double k = (p2.y - p1.y)*1.0/(p2.x-p1.x)*1.0;
					if(map.containsKey(k)){
						map.put(k, map.get(k)+1);
					}else {
						map.put(k, 1);
					}
				}
			}
			int max = ver;
			for(double k:map.keySet()){
				max = Math.max(max, map.get(k));
			}
			ret = Math.max(ret, max+dup);
		}
		return ret;
	}

	public static void main(String[] args) {
		MaxPointsOnAline solution = new MaxPointsOnAline();
		Point[] points = new Point[8];
		int[] x = {0,2,3,4,0,0,5,5};
		int[] y = {0,1,2,0,1,3,0,0};
	/*	Point[] points = new Point[2];
		int[] x = {0,0};
		int[] y = {0,0};*/
		for(int i=0;i<points.length;i++){
			Point point = solution.new Point(x[i], y[i]);
			points[i] = point;
		}
		System.out.println(solution.maxPoints(points));
	}
}
