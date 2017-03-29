package com.fzj.leetcode;

public class PartitionList {

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

	public ListNode partition(ListNode head, int x) {
		if(head==null || head.next==null)
			return head;
		ListNode p = head;
		ListNode first = null,r = null;
		ListNode target = null,t= null;
		while(p!=null){
			if(p.val<x){
				if(first==null){
					first = new ListNode(p.val);
					r = first;
				}
				else{
					r.next = new ListNode(p.val);
					r = r.next;
				}
			}else {
				if(target==null){
					target = new ListNode(p.val);
					t = target;
				}
				else{
					t.next = new ListNode(p.val);
					t = t.next;
				}	
			}
			p = p.next;
		}
		
		if(first==null)
			return target;
		r.next = target;
		return first;
	}
	
	public ListNode partition2(ListNode head, int x) {
		if(head==null)
			return null;
		ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode cur1 = dummy1;
		ListNode cur2 = dummy2;
		while(head!=null){
			if(head.val<x){
				cur1.next = head;
				cur1 = cur1.next;
			}else {
				cur2.next = head;
				cur2 = cur2.next;
			}
			head = head.next;
		}
		cur2.next = null;
		cur1.next = dummy2.next;
		return dummy1.next;
	}

	public static void main(String[] args) {
		PartitionList solution = new PartitionList();
		int[] A = { 1, 4, 3, 2, 5, 2 };
		//int[] A = {1,1};
		ListNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		solution.print(solution.partition2(root, 3));
	}
}
