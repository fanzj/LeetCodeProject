package com.fzj.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
        int maxLen = 1;
        int len = 1;
        Arrays.sort(num);
       
        for(int i=1;i<num.length;i++){
        	if(num[i]==num[i-1]){
        	
        	}else if(num[i]-num[i-1]==1){
        		len++;
        	}
        	else {
				if(maxLen<len)
					maxLen = len;
				len = 1;
			}
        	if(i==num.length-1){
    			if(maxLen<len)
					maxLen = len;
    		}
        }
        return maxLen;
    }

	public int longestConsecutive2(int[] num) {
        Set<Integer> set = new HashSet<>();
        for(int i:num)
        	set.add(i);
        int len = 0;
        for(int i=0;i<num.length;i++){
        	if(set.contains(num[i])){
        		int next = num[i]-1;//找比num[i]小一个的值
        		int cnt = 1;
        		set.remove(num[i]);//及时的移除，减少之后的查找时间
        		while(set.contains(next)){
        			set.remove(next);
        			next --;
        			cnt++;
        		}
        		next = num[i]+1;//找比num[i]大一个的值
        		while(set.contains(next)){
        			set.remove(next);
        			next++;
        			cnt++;
        		}
        		len = Math.max(len,cnt);
        	}
        }
        return len;
    }
	
	public static void main(String[] args) {
		//int[] A={1,2,3,6,12,9,10,11,13};
		//int[] A={100, 4, 200, 1, 3, 2};
		int[] A={0};//1
		//int[] A={1,2,0,1,1,2,2,2};//3
		System.out.println(new LongestConsecutiveSequence().longestConsecutive2(A));
	}
}
