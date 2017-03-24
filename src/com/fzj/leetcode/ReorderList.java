package com.fzj.leetcode;

public class ReorderList {
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

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode mid = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			mid = mid.next;
			fast = fast.next.next;
		}
		mid.next = reverse(mid.next);
//		print(mid.next);
//		print(head);
		merge(head, mid, mid.next);
		print(head);
	}

	public ListNode reverse(ListNode head) {
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode temp;
		while (cur != null) {
			temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		head.next = null;
		//print(pre);
		return pre;
	}

	public void merge(ListNode head1,ListNode end1,ListNode head2){
		while(head1!=end1){
			end1.next = end1.next.next;
			head2.next = head1.next;
			head1.next = head2;
			head1 = head2.next;
			head2 = end1.next;
		}
	}

	
	
	public static void main(String[] args) {
		ReorderList solution = new ReorderList();
		int[] A = { 1, 2, 3, 4, 5 ,6};
		ListNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		//solution.reverse(root);
		solution.reorderList(root);
	}
}
