package leets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HelperMethods {

	public void dfsConnected(int[][] connections) {

		List<Set<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < connections.length; i++)
			graph.add(new HashSet<>());
		for (int[] connection : connections) {
			int u = connection[0], v = connection[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

	}

	private int dfs(int node, List<Set<Integer>> graph, int[] visited) {
		if (visited[node] != 0)
			return 0;
		visited[node] = 1;
		for (int neighbor : graph.get(node))
			dfs(neighbor, graph, visited);
		return 1;
	}
}
