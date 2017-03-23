package com.fzj.leetcode;


public class LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		//如果无环，则fast先走到终点
		//当链表长度为奇数，fast->next为空
		//当链表长度为偶数，fast为空
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			
			//如果有环，则fast会超过slow一圈
			if(fast==slow){
				break;
			}
		}
		
		if(fast==null || fast.next==null)
			return false;
		else
			return true;
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
		LinkedListCycle solution = new LinkedListCycle();
		int[] A = {1,2,3,4,5};
		ListNode root = null;
		for(int i=0;i<A.length;i++){
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		System.out.println(solution.hasCycle(root));
	}
}
