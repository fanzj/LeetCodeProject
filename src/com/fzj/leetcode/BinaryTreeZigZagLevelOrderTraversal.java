package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigZagLevelOrderTraversal {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 层序遍历（每次弹出一层的节点）
	 * 
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<>();
		int direction = 0;// 0表示正常的从左到右；1表示从右到左
		queue.offer(root);
		while (!queue.isEmpty()) {
			ArrayList<Integer> subList = new ArrayList<>();
			int len = queue.size();
			if (direction == 0) {
				TreeNode first = queue.poll();// 先弹出一个节点
				subList.add(first.val);
				if (first.left != null)
					queue.offer(first.left);
				if (first.right != null)
					queue.offer(first.right);

				for (int i = 1; i < len; i++) {// 弹出一层中后续的
					TreeNode next = queue.poll();
					subList.add(next.val);
					if (next.left != null)
						queue.offer(next.left);
					if (next.right != null)
						queue.offer(next.right);
				}
			} else {
				// 先存到一个栈中

				Stack<TreeNode> stack = new Stack<>();
				TreeNode first = queue.poll();
				if (first.left != null)
					queue.offer(first.left);
				if (first.right != null)
					queue.offer(first.right);
				stack.push(first);
				
				for (int i = 1; i < len; i++) {
					TreeNode next = queue.poll();
					if (next.left != null)
						queue.offer(next.left);
					if (next.right != null)
						queue.offer(next.right);
					stack.push(next);
				}
				
				while (!stack.isEmpty()) {
					TreeNode visited = stack.pop();
					subList.add(visited.val);
				}

			}

			list.add(subList);
			direction = (direction == 0 ? 1 : 0);
		}
		return list;
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

	public void inOrder(TreeNode head) {
		if (head != null) {
			inOrder(head.left);
			System.out.print(head.val + " ");
			inOrder(head.right);
		}
	}

	public static void main(String[] args) {
		BinaryTreeZigZagLevelOrderTraversal solution = new BinaryTreeZigZagLevelOrderTraversal();
		int[] A = { 5, 3, 8, 1, 4, 7, 9 };
		// int[] A = {1,2};
		TreeNode node = null;
		for (int i = 0; i < A.length; i++) {
			node = solution.insert(A[i], node);
		}
		solution.inOrder(node);
		System.out.println(solution.zigzagLevelOrder(node));
	}
}
