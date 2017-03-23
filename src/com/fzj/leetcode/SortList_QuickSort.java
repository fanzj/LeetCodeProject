package com.fzj.leetcode;


public class SortList_QuickSort {
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
		return quickSort(head, null);
	}
	
	public ListNode quickSort(ListNode head,ListNode end){
		if(head!=end){
			ListNode cur = partion(head, end);
			quickSort(head, cur);
			quickSort(cur.next, end);
		}
		return head;
	}

	public ListNode partion(ListNode head,ListNode end){
		int key = head.val;
	    ListNode p = head;
	    ListNode q = head.next;
	    while(q!=end){
	    	if(q.val<key){
	    		p = p.next;
	    		swap(p, q);
	    	}
	    	q = q.next;
	    }
	    swap(p, head);
	    return p;
	}

	public void swap(ListNode p, ListNode q) {
		int temp = p.val;
		p.val = q.val;
		q.val = temp;
	}

	public static void main(String[] args) {
		SortList_QuickSort solution = new SortList_QuickSort();
		// int[] A = {5,3,1,2,4};
		int[] A = { 5, 4, 3, 2, 1 };
		// int[] A={1,2,3,4,5};
		ListNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		solution.print(solution.sortList(root));
	}
}
