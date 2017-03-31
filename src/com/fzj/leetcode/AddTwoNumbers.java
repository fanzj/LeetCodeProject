package com.fzj.leetcode;



public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		int temp = 0;
		while(l1!=null || l2!=null || temp!=0){
			if(l1!=null){
				temp += l1.val;
				l1 = l1.next;
			}
			if(l2!=null){
				temp += l2.val;
				l2 = l2.next;
			}
			
			p.next = new ListNode(temp%10);
			p = p.next;
			temp/=10;
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
		AddTwoNumbers solution = new AddTwoNumbers();
//		int[] A = {2,4,3};
//		int[] B = {5,6,4};
//		int[] A = {1,8};
//		int[] B = {0};
//		int[] A = {9};
//		int[] B = {1,9,9,9,9,9,9,9,9,9};
		int[] A = {5};
		int[] B = {5};
		ListNode l1 = null,l2 = null;
		for(int i=0;i<A.length;i++){
			l1 = solution.insert(l1, A[i]);
		}
		solution.print(l1);
		for(int i=0;i<B.length;i++){
			l2 = solution.insert(l2, B[i]);
		}
		solution.print(l2);
		ListNode res = solution.addTwoNumbers(l1, l2);
		solution.print(res);
	}
}
