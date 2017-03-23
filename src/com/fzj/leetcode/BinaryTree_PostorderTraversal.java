package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree_PostorderTraversal {
	

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		boolean isFirst;
		public TreeNode(int x){val = x; }
	}

	/**
	 * �ݹ�
	 * @param root
	 * @param list
	 * @return
	 */
	public ArrayList<Integer> postorderTraversal(TreeNode root,ArrayList<Integer> list) {
	
		if(root!=null){
			postorderTraversal(root.left,list);
			postorderTraversal(root.right,list);
			list.add(root.val);
		}
		return list;
	}
	
	/**
	 * �ǵݹ�
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		TreeNode p = root;
		Integer i = new Integer(1);
		while(p!=null || !stack.isEmpty()){
			while(p!=null){//��������һֱ����������ֱ������û���������Ľ��
				stack.push(p);
				stack2.push(0);
				p = p.left;
			}
			while(!stack.isEmpty() && stack2.peek().equals(i)){
				stack2.pop();
				list.add(stack.pop().val);
			}
			if(!stack.isEmpty()){
				stack2.pop();
				stack2.push(new Integer(1));
				p = stack.peek();
				p = p.right;
				
			}
		}
		return list;
	}
	
	/**
	 * �ǵݹ�
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> postorderTraversal2(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root,r = null;
		while(p!=null || !stack.isEmpty()){
			if(p!=null){
				stack.push(p);
				p = p.left;
			}else {
				p = stack.peek();
				p = p.right;
				if(p!=null && p!=r){//����p���ڣ���δ�����ʹ�
					stack.push(p);
					p = p.left;
				}else {//��ջ������
					p = stack.pop();
					list.add(p.val);
					r = p;
					p = null;
				}
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
		BinaryTree_PostorderTraversal solution = new BinaryTree_PostorderTraversal();
		int[] A = {5,3,8,1,4,7,9};
	//	int[] A = {1,2,3};
		TreeNode node = null;
		for(int i=0;i<A.length;i++){
			node = solution.insert(A[i], node);
		}
		System.out.println(solution.postorderTraversal2(node));
	}
}
