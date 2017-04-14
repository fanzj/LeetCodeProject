package com.fzj.leetcode;


public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if(head==null || head.next ==null)
			return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode fast = dummy;//快指针，先走n步
		ListNode slow = dummy;//慢指针
		//先计算个长度
		int len = 0;
		ListNode p = dummy.next;
		while(p!=null){
			len ++;
			p = p.next;
		}
		n %= len;
		for(int i=0;i<n;i++){
			fast = fast.next;
		}
		while(fast.next!=null){
			fast = fast.next;
			slow = slow.next;
		}
		fast.next = dummy.next;
		dummy.next = slow.next;
		slow.next = null;
		return dummy.next;
	}
	
	public ListNode insert(ListNode t,int x){
		if(t==null){
			t = new ListNode(x);
		}else {
			t.next = insert(t.next, x);
		}
		return t;
	}
	
	public void print(ListNode root){
		while(root!=null){
			System.out.print(root.val);
			if(root.next!=null)
				System.out.print("->");
			else
				System.out.println();
			root = root.next;
		}
	}
	
	public static void main(String[] args) {
		RotateList rotateList = new RotateList();
//		int A[] = {1,2,3,4,5};
//		int n = 2;
		int A[] = {1,2};
		int n = 2;
		ListNode head = null;
		for(int i=0;i<A.length;i++){
			head = rotateList.insert(head, A[i]);
		}
		rotateList.print(head);
		rotateList.print(rotateList.rotateRight(head, n));
	}
}
