package com.fzj.leetcode;


public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		ListNode p = l1,q = l2;
		while(p!=null && q!=null){
			if(p.val<=q.val){
				cur.next = p;
				p = p.next;
			}else {
				cur.next = q;
				q = q.next;
			}
			cur = cur.next;
		}
		while(p!=null){
			cur.next = p;
			p = p.next;
			cur = cur.next;
		}
		while(q!=null){
			cur.next = q;
			q = q.next;
			cur = cur.next;
		}
		return dummy.next;
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
	
	public static void main(String[] args) {
		MergeTwoSortedLists solution = new MergeTwoSortedLists();
//		int[] A = {1,3,5,7};
//		int[] B = {2,4,6,8};
		int[] A = {1};
		int[] B = {};
		ListNode l1 = null,l2 = null;
		for(int i=0;i<A.length;i++){
			l1 = solution.insert(l1, A[i]);
		}
		solution.print(l1);
		for(int i=0;i<B.length;i++){
			l2 = solution.insert(l2, B[i]);
		}
		solution.print(l2);
		ListNode res = solution.mergeTwoLists(l1, l2);
		solution.print(res);
	}
}
