package com.fzj.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {

	/**
	 * ≤„–Ú£¨error
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.offer(root);
		queue2.offer(root);
		TreeNode left,right;
		while(!queue1.isEmpty() && !queue2.isEmpty()){
			left = queue1.poll();
			right = queue2.poll();
			if(left.val!=right.val)
				return false;
			if(left.left!=null && right.right!=null){
				queue1.offer(left.left);
				queue2.offer(right.right);
			}else if(left.left==null && right.right==null){
				return true;
			}else{
				return false;
			}
			
			if(left.right!=null && right.left!=null){
				queue1.offer(left.right);
				queue2.offer(right.left);
			}else if(left.right==null && right.left==null){
				return true;
			}else{
				return false;
			}
		}
		while(!queue1.isEmpty() || !queue2.isEmpty()){
			return false;
		}
		return true;
	}
	
	/**
	 * ÷––Ú∑«µ›πÈ±È¿˙£¨accepted
	 * @param root
	 * @return
	 */
	public boolean isSymmetric2(TreeNode root) {
		if(root==null)
			return true;
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		TreeNode left = root;
		TreeNode right = root;
		while(left!=null || !stack1.isEmpty()){
			while(left!=null && right!=null){
				stack1.push(left);
				stack2.push(right);
				left = left.left;
				right = right.right;
			}
			while(left!=null || right!=null){
				return false;
			}
			if(!stack1.isEmpty() && !stack2.isEmpty()){
				left = stack1.pop();
				right = stack2.pop();
				if(left.val!=right.val)
					return false;
				left = left.right;
				right = right.left;
			}
			
		}
		return true;
			
	}
	
	public boolean isSymmetric3(TreeNode root) {
		if(root==null)
			return true;
		return check(root.left, root.right);
	}
	
	public boolean check(TreeNode x,TreeNode y){
		if(x==null && y==null)
			return 	true;
		if(x==null || y==null)
			return false;
		if(x.val!=y.val)
			return false;
		return check(x.left, y.right) && check(x.right, y.left);
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
		SymmetricTree solution = new SymmetricTree();
//		int[] A = { 5, 3, 8, 1, 4, 7, 9 };
		int[] A = {0};
//		int[] A = {1,2};
		TreeNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		System.out.println(solution.isSymmetric3(root));
	}
	
	
}
