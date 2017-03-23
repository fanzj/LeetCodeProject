package com.fzj.leetcode;

public class LinkedListCycle_II {
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

	public ListNode detectCycle(ListNode head) {
		if(head==null)
			return head;
		ListNode slow = head;
		ListNode quick = head;
		ListNode meet = null;
		while(quick!=null && quick.next!=null){
			slow = slow.next;
			quick = quick.next.next;
			if(slow==quick){
				meet = slow;
				break;
			}
		}
		if(meet==null)
			return null;
		slow = head;
		while(slow!=meet){
			slow = slow.next;
			meet = meet.next;
		}
		return meet;
		
	}

	public static void main(String[] args) {
		LinkedListCycle_II solution = new LinkedListCycle_II();
		int[] A = { 1, 2, 3, 4, 5 };
		ListNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		System.out.println(solution.detectCycle(root));
	}
}
