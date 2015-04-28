package learning.graph.cyclic;

import learning.graph.travesal.dfs.UnDirectedAdjacentMatrix;

/**
 * @author xspro Uses : Union - Find Algorithm.
 */
public class IsCyclicAMGraph {
	public static boolean isGraphCyclic(int[][] graph, int vCount) {
		int[] parent = new int[vCount];
		byte[] rank = new byte[vCount];
		for (int in = 0; in < vCount; in++) {
			parent[in] = in;
		}
		boolean isCyclicGraph = false;
		int i = 0, j = 0;
		while (!isCyclicGraph && i < vCount) {
			j = 0;
			while (!isCyclicGraph && j < vCount) {
				if (graph[i][j] == 1) {
					if (computeIsCyclic(i, j, parent, rank)) {
						isCyclicGraph = true;
					}
				}
				j++;
			}
			i++;
		}
		return isCyclicGraph;
	}

	public static int findParentIndex(int i, int[] parent) {
		if (parent[i] != i) {
			parent[i] = findParentIndex(parent[i], parent);
		}
		return parent[i];
	}

	private static boolean computeIsCyclic(int i, int j, int[] parent,
			byte[] rank) {
		boolean isCyclic = false;
		int x = findParentIndex(i, parent);
		int y = findParentIndex(j, parent);
		if (x == y) {
			isCyclic = true;
		} else {
			unionParentArray(i, j, parent, rank);
		}
		return isCyclic;
	}

	private static void unionParentArray(int i, int j, int[] parent, byte[] rank) {
		if (rank[i] < rank[j]) {
			parent[i] = j;
		} else if (rank[j] < rank[i]) {
			parent[j] = i;
		} else {
			parent[j] = i;
			rank[i]++;
		}
	}

	public static void main(String[] args) {
		UnDirectedAdjacentMatrix graph = new UnDirectedAdjacentMatrix(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 2);
		System.out.println(isGraphCyclic(graph.getGraphMatrix(),
				graph.getVertexCount()));
	}

}
