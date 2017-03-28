package com.fzj.leetcode;

import java.util.ArrayList;

public class UniqueBinarySearchTrees_II {

	public ArrayList<TreeNode> generateTrees(int n) {
		return createTree(1, n);
	}
	
	public ArrayList<TreeNode> createTree(int low,int high){
		ArrayList<TreeNode> result = new ArrayList<>();
		if(low>high){
			result.add(null);
			return result;
		}
		for(int i=low;i<=high;i++){
			ArrayList<TreeNode> left = createTree(low, i-1);
			ArrayList<TreeNode> right = createTree(i+1, high);
			for(int j=0;j<left.size();j++){
				for(int k=0;k<right.size();k++){
					TreeNode newNode = new TreeNode(i);
					newNode.left = left.get(j);
					newNode.right = right.get(k);
					result.add(newNode);
				}
			}
		}
		return result;
	}
	
	public void print(TreeNode node){
		if(node!=null){
			print(node.left);
			System.out.print(node.val+" ");
			print(node.right);
		}
	}
	
	public void printAll(ArrayList<TreeNode> list){
		for(int i=0;i<list.size();i++){
			print(list.get(i));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees_II solution = new UniqueBinarySearchTrees_II();
		solution.printAll(solution.generateTrees(3));
		System.out.println();
	}
}
