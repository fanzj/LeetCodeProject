package com.fzj.leetcode;


public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int count = 0;
		ListNode p = dummy;
		while(p.next!=null){
			ListNode q = p;
			count = 0;
			while(q.next!=null && count<n){
				q = q.next;
				count ++;
			}
			if(q.next==null){//进行删除操作
				//System.out.println("p.val = "+p.val);
				p.next = p.next.next;
				break;
			}
			p = p.next;
		}
		return dummy.next;
	}
	
	/**
	 * 快慢指针
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		if (head==null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;//快指针先走n步
		ListNode slow = dummy;//慢指针
		for(int i=0;i<n;i++){
			fast = fast.next;
		}
		while(fast.next!=null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
	
	public ListNode insert(ListNode node,int x){
		if(node==null)
			node = new ListNode(x);
		else
			node.next = insert(node.next, x);
		return node;
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
		RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
		int[] A = {1,2,3,4,5};
		//int[] A = {1};
		ListNode root = null;
		for(int i=0;i<A.length;i++){
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		solution.print(solution.removeNthFromEnd2(root, 2));
	}
}
