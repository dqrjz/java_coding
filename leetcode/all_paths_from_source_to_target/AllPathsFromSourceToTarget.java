package com.leetcode.all_paths_from_source_to_target;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AllPathsFromSourceToTarget {
//	public static void main(String[] args) {
//		int a, b, res;
//		a = (int) (Math.random()*10);
//		b = 4;
//		res = ((a & 1) == 1) ? b : b+5;
//		System.out.println(res);
//	}
	
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		return helper(graph, 0);
	}
	
	private List<List<Integer>> helper(int[][] graph, int node) {
		List<List<Integer>> res = new ArrayList<>();
		if (node == graph.length - 1) {
			List<Integer> path = new ArrayList<>();
			path.add(node);
			res.add(path);
			return res;
		}
		
		for (int nextNode : graph[node]) {
			for (List<Integer> path : helper(graph, nextNode)) {
				path.add(0, node);
				res.add(path);
			}
		}
		return res;
	}
}

/**
 * dfs
 */
class Solution {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		
		path.add(0);
		dfsSearch(graph, 0, res, path);
		
		return res;
	}
	
	private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
		if (node == graph.length - 1) {
			res.add(new ArrayList<Integer>(path));
			return;
		}
		
		for (int nextNode : graph[node]) {
			path.add(nextNode);
			dfsSearch(graph, nextNode, res, path);
			path.remove(path.size() - 1);
		}
	}
}