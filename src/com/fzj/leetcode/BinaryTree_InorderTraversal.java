package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree_InorderTraversal {
	

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
	public ArrayList<Integer> inorderTraversal(TreeNode root,ArrayList<Integer> list) {
	
		if(root!=null){
			inorderTraversal(root.left,list);
			list.add(root.val);
			inorderTraversal(root.right,list);
		}
		return list;
	}
	
	/**
	 * ÖÐÐò±éÀú£¬·ÇµÝ¹é
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
        	return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p!=null || !stack.isEmpty()){
        	while(p!=null){
            	stack.push(p);
            	p = p.left;
            }
        	if(!stack.isEmpty()){
        		p = stack.pop();
        		list.add(p.val);
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
		BinaryTree_InorderTraversal solution = new BinaryTree_InorderTraversal();
		int[] A = {5,3,8,1,4,7,9};
	//	int[] A = {1,2};
		TreeNode node = null;
		for(int i=0;i<A.length;i++){
			node = solution.insert(A[i], node);
		}
		System.out.println(solution.inorderTraversal(node));
	}
}
