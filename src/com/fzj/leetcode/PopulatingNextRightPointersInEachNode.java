package com.fzj.leetcode;

import java.util.LinkedList;
import java.util.Queue;


public class PopulatingNextRightPointersInEachNode {

    class TreeLinkNode{
    	int val;
    	TreeLinkNode left,right,next;
    	public TreeLinkNode(int x) {
			val = x;
		}
    }
    
    public TreeLinkNode insert(int x, TreeLinkNode t) {
		if (t == null)
			t = new TreeLinkNode(x);
		else if (x <= t.val) {
			t.left = insert(x, t.left);
		} else {
			t.right = insert(x, t.right);
		}
		return t;
	}
    
    /**
     * 层序遍历
     * @param root
     */
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if(root==null)
        	return ;
        queue.offer(root);
        TreeLinkNode p = null;
        TreeLinkNode next = null;
        int count = 0;
        int height = 1;//第几层
        while(!queue.isEmpty()){
        	p = queue.poll();//返回队列头部元素，并移除
        	if(p.left!=null)
        		queue.offer(p.left);
        	if(p.right!=null)
        		queue.offer(p.right);
        	count++;
        	//System.out.println("第"+count+"个："+p.val);
        	if(!queue.isEmpty()){
        		next = queue.peek();//返回队列头部元素
        	}else {
				next = null;
			}
        	if(count==(int)(Math.pow(2.0, height)-1)){//每层最后一个
        		height++;
        		p.next = null;
        	}else {
				p.next = next;
			}
        }
    }
    
    
    public static void main(String[] args) {
    	PopulatingNextRightPointersInEachNode solution = new PopulatingNextRightPointersInEachNode();
	//	int[] A = {5,3,8,1,4,7,9};
		int[] A = {};
		TreeLinkNode node = null;
		for (int i = 0; i < A.length; i++) {
			node = solution.insert(A[i], node);
		}
		solution.connect(node);
	}
}
