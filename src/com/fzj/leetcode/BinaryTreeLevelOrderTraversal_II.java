package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal_II {

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(root==null)
			return result;
		Stack<Integer> stack_num = new Stack<>();//每层的节点数
		Stack<Integer> stack_val = new Stack<>();//存放节点值
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){//从右至左的层序遍历,一次弹出一层
			int len = queue.size();
			stack_num.push(len);
			TreeNode first = queue.poll();//先弹出一个
			stack_val.push(first.val);
			if(first.right!=null)
				queue.offer(first.right);
			if(first.left!=null)
				queue.offer(first.left);
			for(int i=1;i<len;i++){
				TreeNode next = queue.poll();//弹出剩下的
				stack_val.push(next.val);
				if(next.right!=null)
					queue.offer(next.right);
				if(next.left!=null)
					queue.offer(next.left);
			}
		}
		while(!stack_num.isEmpty()){
			int num = stack_num.pop();
			ArrayList<Integer> subList = new ArrayList<>();
			for(int i=0;i<num;i++){
				subList.add(stack_val.pop());
			}
			result.add(subList);
		}
		return result;
	}

	public TreeNode insert(TreeNode t, int x) {
		if (t == null)
			t = new TreeNode(x);
		else if (x <= t.val)
			t.left = insert(t.left, x);
		else
			t.right = insert(t.right, x);
		return t;
	}

	public void print(TreeNode node) {
		if (node != null) {
			print(node.left);
			System.out.print(node.val + " ");
			print(node.right);
		}
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal_II solution = new BinaryTreeLevelOrderTraversal_II();
		int[] A = { 5, 3, 8, 1, 4, 7, 9 };
		TreeNode root = null;
		for (int i = 0; i < A.length; i++) {
			root = solution.insert(root, A[i]);
		}
		solution.print(root);
		System.out.println(solution.levelOrderBottom(root));
	}
}
