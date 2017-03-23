package com.fzj.leetcode;


public class PathSum {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode insert(int x, TreeNode t) {
		if (t == null)
			t = new TreeNode(x);
		else if (x <= t.val) {
			t.left = insert(x, t.left);
		} else {
			t.right = insert(x, t.right);
		}
		return t;
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)
			return false;
		sum -= root.val;
		//结束条件，当到叶子节点时候sum=0
		if(root.left==null && root.right==null){
			if(sum==0)
				return true;
		}
		if(hasPathSum(root.left, sum))
			return true;
		if(hasPathSum(root.right, sum))
			return true;
		return false;
	}
	
	
	

	public static void main(String[] args) {
		PathSum solution = new PathSum();
		 int[] A = {5,3,8,1,4,7,9};
		// int[] A = {2,1,3};
		//int[] A = { 3, 2 };
		// int[] A = {};
		TreeNode node = null;
		for (int i = 0; i < A.length; i++) {
			node = solution.insert(A[i], node);
		}
		System.out.println(solution.hasPathSum(node, 12));
	}
}
