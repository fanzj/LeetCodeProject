package com.fzj.leetcode;

import java.util.Stack;

public class SameTree {

	//利用非递归的先序遍历访问来验证
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null)
			return true;
		if((p!=null && q==null) || (p==null && q!=null))
			return false;
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		TreeNode p1 = p;
		TreeNode p2 = q;
		while(p1!=null || !stack1.isEmpty()){
			while(p1!=null && p2!=null){
				if(p1.val!=p2.val)
					return false;
				else{
					stack1.push(p1);
					p1 = p1.left;
					stack2.push(p2);
					p2 = p2.left;
				}
			}
			while(p1!=null || p2!=null){
				return false;
			}
			if(!stack1.isEmpty()){
				p1 = stack1.pop();
				p1 = p1.right;
			}
			if(!stack2.isEmpty()){
				p2 = stack2.pop();
				p2 = p2.right;
			}
		}
		return true;
	}
	
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		if(p==null && q==null)
			return true;
		if(p==null || q==null)
			return false;
		if(p.val!=q.val)
			return false;
		return isSameTree2(p.left, q.left) && isSameTree(p.right, q.right);
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
	
	public static void main(String[] args) {
		SameTree solution = new SameTree();
//		int[] A = { 5, 3, 8, 1, 4, 7, 9 };
//		int[] B = { 5, 3, 8, 2, 4, 7, 9 };
		int[] A = {};
		int[] B = {0};
//		int[] B = {1,2};
		TreeNode p = null;
		for (int i = 0; i < A.length; i++) {
			p = solution.insert(p, A[i]);
		}
		TreeNode q = null;
		for (int i = 0; i < B.length; i++) {
			q = solution.insert(q, B[i]);
		}
		System.out.println(solution.isSameTree(p, q));
	}
}
