package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SortList_InsertionSort {
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

	public ListNode insertionSortList(ListNode head) {
		if (head == null)// 为空
			return null;
		if (head.next == null)// 一个节点
			return head;
		// ListNode h = head;
		List<Integer> list = new ArrayList<>();
		list.add(head.val);
		ListNode p = head.next;
		/*
		 * while(p!=null){ h = head; while(h!=p){ if(h.val>p.val){ int temp =
		 * h.val; h.val = p.val; p.val = temp;
		 * 
		 * 
		 * break; }else { h = h.next; } } p = p.next; }
		 */

		while (p != null) {
			list.add(p.val);
			p = p.next;
		}
		for (int i = 1; i < list.size(); i++) {
			for (int j = i; (j > 0) && list.get(j) < list.get(j - 1); j--) {
				int temp = list.get(j);
				list.set(j, list.get(j - 1));
				list.set(j - 1, temp);
			}
		}
		p = head;
		int count = 0;
		while (p != null) {
			p.val = list.get(count++);
			p = p.next;
		}
		print(head);
		return head;
	}

	public ListNode insertionSortList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode r = head.next;
		head.next = null;
		while(r!=null){
			ListNode q = head;
			ListNode p = null;
			while(q!=null && q.val<r.val){
				p = q;
				q = q.next;
			}
			ListNode t = r.next;
			if(q==head){
				r.next = head;
				head = r;
			}else {
				p.next = r;
				r.next = q;
			}
			r = t;
		}
		print(head);
		return head;
	}

	public static void main(String[] args) {
		SortList_InsertionSort solution = new SortList_InsertionSort();
		// int[] A = {5,3,1,2,4};
		int[] A = { 5, 4, 3, 2, 1 };
		// int[] A={1,2,3,4,5};
		ListNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		solution.insertionSortList(root);
	}
}
