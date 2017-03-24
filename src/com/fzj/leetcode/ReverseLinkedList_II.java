package com.fzj.leetcode;

public class ReverseLinkedList_II {
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

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		int cur_num = 1;
		if(m==n)
			return head;
		ListNode pre = dummy;
		dummy.next = head;
		ListNode cur = head;
	
		ListNode p1 = null;
		ListNode p2 = null;
		while(cur!=null){
			
			if(cur_num==m){
				p1 = pre;
				
			}else if(cur_num==n){
				p2 = cur.next;
				cur.next = null;
			}else {
				
			}
			pre = cur;
			cur = cur.next;
			cur_num++;
		}
		p1.next = reverse(p1.next);
		ListNode t = head;
		while(t.next!=null){
			t = t.next;
		}
		t.next = p2;
		return dummy.next;
		
	}
	
	public ListNode reverse(ListNode head){
		if(head==null || head.next==null)
			return head;
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode temp ;
		while(cur!=null){
			temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		head.next = null;
		return pre;
	}
	
	public ListNode reverseBetween2(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode preStart = dummy;
		ListNode start = head;
		for(int i=1;i<m;i++){
			preStart = start;
			start = start.next;
		}
		//reverse
		for(int i=0;i<n-m;i++){
			ListNode temp = start.next;
			start.next = temp.next;
			temp.next = preStart.next;
			preStart.next = temp;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ReverseLinkedList_II solution = new ReverseLinkedList_II();
		int[] A = { 1, 2, 3, 4, 5, 6 };
		//int[] A = {1,2};
		ListNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		solution.print(solution.reverseBetween2(root, 1, 5));
	}
}
