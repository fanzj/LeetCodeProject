package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inorder(root, list);
		for(int i=1;i<list.size();i++){
			int pre = list.get(i-1);
			int cur = list.get(i);
			if(cur<=pre)
				return false;
		}
		return true;
	}

	public TreeNode insert(TreeNode t, int x) {
		if (t == null)
			t = new TreeNode(x);
		else if (x <= t.val) {
			t.left = insert(t.left, x);
		} else {
			t.right = insert(t.right, x);
		}
		return t;
	}
	
	public void inorder(TreeNode root,List<Integer> list){
		if(root!=null){
			inorder(root.left,list);
			list.add(root.val);
			inorder(root.right,list);
		}
	}
	
	public boolean isValidBST2(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean helper(TreeNode root,int lower,int upper){
		if(root==null)
			return true;
		if(root.val <= lower || root.val>=upper)
			return false;
		return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
	}


	public static void main(String[] args) {
		ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
		int[] A = { 5, 3, 8, 1, 4, 7, 9 };
//		int[] A = {0};
//		int[] A = {1,1};
		TreeNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		System.out.println(solution.isValidBST2(root));
	}
}
