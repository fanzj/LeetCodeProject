package com.fzj.leetcode;

public class RemoveDuplicatesFromSortedList_II {

	public ListNode insert(ListNode head, int x) {
		if (head == null)
			head = new ListNode(x);
		else
			head.next = insert(head.next, x);
		return head;
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = head;
		ListNode last = dummy;
		while(cur!=null && cur.next!=null){
			if(cur.val!=cur.next.val){
				last = cur;
			}else{
				while(cur.next!=null && cur.val==cur.next.val){
					cur = cur.next;
				}
				last.next = cur.next;
			}
			cur = cur.next;
		}
		
		return dummy.next;
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
		RemoveDuplicatesFromSortedList_II solution = new RemoveDuplicatesFromSortedList_II();
		int[] A = { 1, 1, 2, 3, 3, 4, 4, 4, 5 };
		//int[] A = {1,1};
		ListNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		solution.print(solution.deleteDuplicates(root));
	}
}
