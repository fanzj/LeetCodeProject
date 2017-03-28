package com.fzj.leetcode;

public class RemoveDuplicatesFromSortedList {

	public ListNode insert(ListNode head, int x) {
		if (head == null)
			head = new ListNode(x);
		else
			head.next = insert(head.next, x);
		return head;
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

	public ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode pre = head;
		ListNode cur = head.next;
		while(cur!=null){
			if(pre.val!=cur.val){
				pre.next = cur;	
				pre = cur;
				cur = cur.next;
			}else {
				cur = cur.next;
			}
			if(cur==null){
				pre.next = cur;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
		int[] A = { 1,1, 2, 2, 2, 4, 5, 5 };
		ListNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		solution.print(solution.deleteDuplicates(root));
	}
}
