package com.fzj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		public UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<>();
		}
	}

	private Map<Integer,UndirectedGraphNode> map = new HashMap<>();
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return clone(node);
	}
	
	private UndirectedGraphNode clone(UndirectedGraphNode node){
		if(node==null)
			return node;
		if(map.containsKey(node.label))
			return map.get(node.label);
		
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(clone.label, clone);
		for(UndirectedGraphNode neighbor:node.neighbors){
			clone.neighbors.add(clone(neighbor));
		}
		return clone;
	}
	
	public void print(UndirectedGraphNode node){
		ArrayList<UndirectedGraphNode> list = node.neighbors;
		System.out.print(node.label+":");
		for(int j=0;j<list.size();j++){
			System.out.print(list.get(j).label);
			if(j<list.size()-1)
				System.out.print("->");
			else
				System.out.println();
		}
		
		for(int i=0;i<list.size();i++){
			UndirectedGraphNode temp = list.get(i);
			System.out.print(temp.label+":");
			ArrayList<UndirectedGraphNode> subList = temp.neighbors;
			for(int j=0;j<subList.size();j++){
				System.out.print(subList.get(j).label);
				if(j<subList.size()-1)
					System.out.print("->");
				else
					System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		CloneGraph solution = new CloneGraph();
		UndirectedGraphNode first = solution.new UndirectedGraphNode(0);
		UndirectedGraphNode second = solution.new UndirectedGraphNode(1);
		UndirectedGraphNode third = solution.new UndirectedGraphNode(2);
		ArrayList<UndirectedGraphNode> firstList = new ArrayList<>();
		firstList.add(second);
		firstList.add(third);
		first.neighbors = firstList;
		ArrayList<UndirectedGraphNode> secondList = new ArrayList<>();
		secondList.add(third);
		second.neighbors = secondList;
		ArrayList<UndirectedGraphNode> thirdList = new ArrayList<>();
		thirdList.add(third);
		third.neighbors = thirdList;
		
		solution.print(first);
		System.out.println("----------------");
		solution.print(solution.clone(first));
		
	}
}
