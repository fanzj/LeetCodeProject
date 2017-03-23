package com.fzj.leetcode;


public class MinimumDepthOfBinaryTree {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			this.val = x;
		}
	}
	
	public int run(TreeNode root){
		if(root==null)
			return 0;
		int left = run(root.left)+1;
		int right = run(root.right)+1;
		if(left==1 || right==1)
			return Math.max(left, right);
		else
			return Math.min(left, right);
	}
	
	public TreeNode insert(int x,TreeNode t){
		if(t==null)
			t = new TreeNode(x);
		else if(x<=t.val){
			t.left = insert(x, t.left);
		}else{
			t.right = insert(x, t.right);
		}
		return t;
	}
	
	/**
	 * Ç°Ðò
	 * @param node
	 */
	public void printPreOrder(TreeNode node){
		if(node==null)
			return;
		System.out.print(node.val+" ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	/**
	 * ÖÐÐò
	 * @param node
	 */
	public void printMidOrder(TreeNode node){
		if(node==null)
			return;
		printMidOrder(node.left);
		System.out.print(node.val+" ");
		printMidOrder(node.right);
	}
	
	/**
	 * ºóÐò
	 * @param node
	 */
	public void printPostOrder(TreeNode node){
		if(node==null)
			return;
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.val+" ");
	}
	
	public static void main(String[] args) {
		MinimumDepthOfBinaryTree solution = new MinimumDepthOfBinaryTree();
		int[] A = {5,3,8,1,4,7,9};
	//	int[] A = {1,2};
		TreeNode node = null;
		for(int i=0;i<A.length;i++){
			node = solution.insert(A[i], node);
		}
		System.out.println(solution.run(node));
	//	solution.printPostOrder(node);
	}
}
