package com.fzj.leetcode;


public class BalancedBinaryTree {
	/*public boolean isBalanced(TreeNode root) {
		return isBalanced_helper(root, 0);
	}
	
	public boolean isBalanced_helper(TreeNode root,int depth){
		if(root==null){
			depth = 0;
			return true;
		}
		int left = 0,right = 0;
		if(isBalanced_helper(root.left, left) && isBalanced_helper(root.right, right)){
			if(Math.abs(left-right)<=1){
				depth = 1 + Math.max(left, right);
				return true;
			}
		}
		return false;
	}*/
	
	public boolean isBalanced(TreeNode root) {
		if(root==null)
			return true;
		int left = treeHeight(root.left);
		int right = treeHeight(root.right);
		if(Math.abs(left-right)<=1){
			if(isBalanced(root.left) && isBalanced(root.right)){
				return true;
			}
		}
		return false;
	}
	
	public int treeHeight(TreeNode root){
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		return Math.max(treeHeight(root.left), treeHeight(root.right))+1;
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
	
	public static void main(String[] args) {
		BalancedBinaryTree solution = new BalancedBinaryTree();
	//	int[] A = {5,3,8,1,4,7,9};//true
		int[] A = {5,3,8,1,4,7,9,10,11};//false
	//	int[] A = {1,2,3};
	//	int[] A = {};
	//	int[] A = {1,2};
		TreeNode node = null;
		for(int i=0;i<A.length;i++){
			node = solution.insert(A[i], node);
		}
		System.out.println(solution.isBalanced(node));
	}
}
