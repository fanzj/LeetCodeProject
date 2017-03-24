package com.fzj.leetcode;

public class MaximumDepthOfBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode insert(int x, TreeNode t) {
		if (t == null){
			t = new TreeNode(x);
		}
		else if (x <= t.val) {
			t.left = insert(x, t.left);
		} else {
			t.right = insert(x, t.right);
		}
		return t;
	}
	
	public int maxDepth(TreeNode root) {
        int max = 0;
		if(root==null)
        	return 0;
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right) + 1;
        max = Math.max(left, right);
        return max;
    }	

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
		//int[] A = { 5, 3, 8, 1, 4, 7, 9 };
		int[] A = {};
		TreeNode node = null;
		for (int i = 0; i < A.length; i++) {
			node = solution.insert(A[i], node);
		}
		System.out.println("maximum depth = "+solution.maxDepth(node));
	}
}
