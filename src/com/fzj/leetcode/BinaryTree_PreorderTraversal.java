package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree_PreorderTraversal {
	

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){val = x; }
	}

	/**
	 * µÝ¹é
	 * @param root
	 * @param list
	 * @return
	 */
	public ArrayList<Integer> preorderTraversal(TreeNode root,ArrayList<Integer> list) {
	
		if(root!=null){
			list.add(root.val);
			preorderTraversal(root.left,list);
			preorderTraversal(root.right,list);
		}
		return list;
	}
	
	/**
	 * ·ÇµÝ¹é
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(p!=null || !stack.isEmpty()){
			while(p!=null){
				list.add(p.val);
				stack.push(p);
				p = p.left;
			}
			if(!stack.isEmpty()){
				p = stack.pop();
				p = p.right;
			}
		}
		return list;
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
		BinaryTree_PreorderTraversal solution = new BinaryTree_PreorderTraversal();
		int[] A = {5,3,8,1,4,7,9};
	//	int[] A = {1,2};
		TreeNode node = null;
		for(int i=0;i<A.length;i++){
			node = solution.insert(A[i], node);
		}
		System.out.println(solution.preorderTraversal(node, new ArrayList<Integer>()));
	}
}
