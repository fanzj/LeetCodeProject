package com.fzj.leetcode;

import java.util.ArrayList;

public class PathSum_II {

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

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> subList = new ArrayList<>();
		pathSum_Aux(root, sum, subList, list);
		return list;
	}

	public void pathSum_Aux(TreeNode root, int sum, ArrayList<Integer> subList,
			ArrayList<ArrayList<Integer>> list) {
		if(root==null)
			return;
		sum -= root.val;
		subList.add(root.val);
		if(root.left==null && root.right==null && sum==0){
			list.add(new ArrayList<>(subList));
		}
		pathSum_Aux(root.left, sum, subList, list);
		pathSum_Aux(root.right, sum, subList, list);
		subList.remove(subList.size()-1);
	}
	
	public void inorder(TreeNode root){
		if(root!=null){
			inorder(root.left);
			System.out.print(root.val+" ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		PathSum_II solution = new PathSum_II();
		int[] A = { 5, 3, 8, 1, 4, 7, 9 };
		// int[] A = {2,1,3};
		// int[] A = { 3, 2 };
		// int[] A = {};
		TreeNode node = null;
		for (int i = 0; i < A.length; i++) {
			node = solution.insert(A[i], node);
		}
		//solution.inorder(node);
		System.out.println(solution.pathSum(node, 12));
	}
}
