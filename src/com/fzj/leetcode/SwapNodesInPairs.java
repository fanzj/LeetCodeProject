package com.fzj.leetcode;


public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode cur = start;
		while(cur.next!=null && cur.next.next!=null){
			cur.next = swap(cur.next, cur.next.next);
			cur = cur.next.next;
		}
		
		return start.next;
	}
	
	public ListNode swap(ListNode head1,ListNode head2){
		head1.next = head2.next;
		head2.next = head1;
		return head2;
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
		SwapNodesInPairs solution = new SwapNodesInPairs();
		int[] A = {1,2};
		ListNode root = null;
		for(int i=0;i<A.length;i++){
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		solution.print(solution.swapPairs(root));
	}
}
