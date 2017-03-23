package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList_MergeSort {
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}
	

	public ListNode insert(ListNode t, int x) {
		if (t == null) {
			t = new ListNode(x);
		} else {
			t.next = insert(t.next, x);
		}
		return t;
	}

	public void print(ListNode root) {
		while (root != null) {
			System.out.print(root.val);
			if (root.next != null)
				System.out.print("->");
			else
				System.out.println();
			root = root.next;
		}
	}
	
	public ListNode sortList(ListNode head) {
        if(head==null)
            return head;
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while(p!=null){
            list.add(p.val);
            p = p.next;
        }
        Collections.sort(list);
        p = head;
        int count = 0;
        while(p!=null){
            p.val = list.get(count++);
            p = p.next;
        }
        print(head);
        return head;
    }
	
	public ListNode merge(ListNode left,ListNode right){
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while(left!=null && right!=null){
			if(left.val < right.val){
				p.next = left;
				left = left.next;
			}else {
				p.next = right;
				right = right.next;
			}
			p = p.next;
		}
		if(left!=null)
			p.next = left;
		if(right!=null)
			p.next = right;
		return dummy.next;
	}
	
	public ListNode sortList2(ListNode head) {
        if(head==null || head.next==null)
        	return head;
        ListNode p = head,q = head.next;
        while(q!=null && q.next!=null){
        	p = p.next;//ÂýÖ¸Õë
        	q = q.next.next;//¿ìÖ¸Õë
        }
        ListNode left = sortList2(p.next);
        p.next = null;
        ListNode right = sortList2(head);
        return merge(left, right);
    }
	


	public static void main(String[] args) {
		SortList_MergeSort solution = new SortList_MergeSort();
		// int[] A = {5,3,1,2,4};
		int[] A = { 5, 4, 3, 2, 1 };
		// int[] A={1,2,3,4,5};
		ListNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		solution.print(solution.sortList2(root));
	}
}
