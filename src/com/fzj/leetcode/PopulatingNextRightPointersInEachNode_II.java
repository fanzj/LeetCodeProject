package com.fzj.leetcode;

import java.util.LinkedList;
import java.util.Queue;


public class PopulatingNextRightPointersInEachNode_II {

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
     * ���������ÿ��whileҪ�ѵ�ǰ������нڵ�ȫ��������
     * @param root
     */
    public void connect(TreeLinkNode root) {
       if(root==null)
    	   return ;
       Queue<TreeLinkNode> queue = new LinkedList<>();
       queue.offer(root);
       TreeLinkNode cur;
       TreeLinkNode next;
       while(!queue.isEmpty()){
    	   int len = queue.size();
    	   //�ȵ���һ��
    	   cur = queue.poll();
    	   if(cur.left!=null)
    		   queue.offer(cur.left);
    	   if(cur.right!=null)
    		   queue.offer(cur.right);
    	   for(int i=1;i<len;i++){
    		   next = queue.poll();
    		   cur.next = next;
    		   cur = next;
    		   if(next.left!=null)
    			   queue.offer(next.left);
    		   if(next.right!=null)
    			   queue.offer(next.right);
    	   }
    	   cur.next = null;
       }
       
    }
    
    
    public static void main(String[] args) {
    	PopulatingNextRightPointersInEachNode_II solution = new PopulatingNextRightPointersInEachNode_II();
	//	int[] A = {5,3,8,1,4,7,9};
		int[] A = {};
		TreeLinkNode node = null;
		for (int i = 0; i < A.length; i++) {
			node = solution.insert(A[i], node);
		}
		solution.connect(node);
	}
}
