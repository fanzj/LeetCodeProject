package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * ���������ÿ�ε���һ��Ľڵ㣩
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if(root==null)
			return list;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode p;
		while(!queue.isEmpty()){//ÿ��while����һ��ڵ�
			ArrayList<Integer> subList = new ArrayList<>();
			int len = queue.size();
			p = queue.poll();//�ȵ���һ��
			subList.add(p.val);
			if(p.left!=null)
				queue.offer(p.left);
			if(p.right!=null)
				queue.offer(p.right);
			for(int i=1;i<len;i++){//���ò�ʣ�µĵ���
				p = queue.poll();
				subList.add(p.val);
				if(p.left!=null)
					queue.offer(p.left);
				if(p.right!=null)
					queue.offer(p.right);
			}
			list.add(subList);
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
		BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
		int[] A = {5,3,8,1,4,7,9};
	//	int[] A = {1,2};
		TreeNode node = null;
		for(int i=0;i<A.length;i++){
			node = solution.insert(A[i], node);
		}
		System.out.println(solution.levelOrder(node));
	}
}
