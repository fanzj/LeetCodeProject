package com.fzj.leetcode;



public class CopyListWithRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;

		public RandomListNode(int x) {
			this.label = x;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null || (head.next==null && head.random==null))
			return head;
		RandomListNode node = head;
		while(node!=null){
			RandomListNode cpNode = copyOf(node);
			node.next = cpNode;
			node = node.next.next;
		}
		node = head.next;
		while(node!=null){
			if(node.next!=null)
				node.next = node.next.next;
			if(node.random!=null)
				node.random = node.random.next;
			node = node.next;
		}
		return head.next;
	}
	
	public RandomListNode copyOf(RandomListNode node){
		RandomListNode res = new RandomListNode(node.label);
		res.next = node.next;
		res.random = node.random;
		return res;
	}
	
	public RandomListNode insert(RandomListNode t, int x) {
		if (t == null) {
			t = new RandomListNode(x);
		} else {
			t.next = insert(t.next, x);
		}
		return t;
	}

	public void print(RandomListNode root) {
		while (root != null) {
			System.out.print(root.label);
			if (root.next != null)
				System.out.print("->");
			else
				System.out.println();
			root = root.next;
		}
	}


	public static void main(String[] args) {
		CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
		//int[] A = {2,5,7,3,1};
		int[] A={1,2,2,2};
		RandomListNode root = null;
		for(int i=0;i<A.length;i++){
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		solution.print(solution.copyRandomList(root));
	}
}
