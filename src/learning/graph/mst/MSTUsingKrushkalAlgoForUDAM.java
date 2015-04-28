package learning.graph.mst;

import java.util.ArrayList;
import java.util.List;

import learning.graph.GraphNode;
import learning.graph.UndirectedWeightedMatrixGraph;

public class MSTUsingKrushkalAlgoForUDAM {
	private static int MAX = 999;
	private static List<Edge> edges = new ArrayList<Edge>();
	private static int[] parent;
	private static byte[] rank;
	private static List<Edge> result = new ArrayList<Edge>();

	public static void buildEdgeList(UndirectedWeightedMatrixGraph graph) {
		GraphNode[][] graphMatrix = graph.getGraph();
		int vCount = graph.getVertextCount();
		for (int i = 0; i < vCount; i++) {
			for (int j = 0; j < vCount; j++) {
				Edge edge = null;
				if ((null != graphMatrix[i][j])
						&& (graphMatrix[i][j].getWeight() > 0)) {
					edge = new Edge(i, j, graphMatrix[i][j].getWeight());
				} else {
					edge = new Edge(i, j, MAX);
				}
				graphMatrix[j][i] = null;
				edges.add(edge);
			}
		}
	}

	public static void qSortEdges(int low, int high) {
		int i = low, j = high, pivot = i + ((j - i) / 2);
		while (i < j) {
			while (edges.get(i).getWeight() < edges.get(pivot).getWeight()) {
				i++;
			}
			while (edges.get(pivot).getWeight() < edges.get(j).getWeight()) {
				j--;
			}

			if (i <= j) {
				Edge lowEdge = edges.get(i);
				edges.set(i, edges.get(j));
				edges.set(j, lowEdge);
				i++;
				j--;
			}
		}

		if (low < j) {
			qSortEdges(low, j);
		}
		if (i < high) {
			qSortEdges(i, high);
		}
	}

	public static void main(String[] args) {
		int vCount = 6;
		UndirectedWeightedMatrixGraph graph = new UndirectedWeightedMatrixGraph(
				vCount);
		graph.addEdge(0, 3, 6);
		graph.addEdge(0, 4, 2);
		graph.addEdge(0, 2, 4);
		graph.addEdge(0, 1, 1);
		graph.addEdge(1, 0, 1);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 4, 2);
		graph.addEdge(2, 1, 3);
		graph.addEdge(2, 0, 4);
		graph.addEdge(1, 4, 2);
		graph.addEdge(2, 1, 3);
		graph.addEdge(2, 0, 4);
		buildEdgeList(graph);
		qSortEdges(0, edges.size() - 1);
		parent = new int[vCount];
		rank = new byte[vCount];
		for (int i = 0; i < vCount; i++) {
			parent[i] = i;
		}
		int count = 0;
		while (result.size() < vCount - 1) {
			Edge e = edges.get(count);
			int x = findParent(e.getSrc());
			int y = findParent(e.getDest());
			if (x != y) {

				result.add(e);
				if (rank[x] < rank[y]) {
					parent[x] = y;
				} else if (rank[y] < rank[x]) {
					parent[y] = x;
				} else {
					parent[y] = x;
					rank[x]++;
				}
			}
			count++;
		}
		for (int io = 0; io < result.size(); io++) {
			System.out.println("-=-==--=");
			System.out.println(result.get(io).getSrc());
			System.out.println(result.get(io).getDest());
			System.out.println(result.get(io).getWeight());
		}
	}

	private static int findParent(int i) {
		if (parent[i] != i) {
			parent[i] = findParent(parent[i]);
		}
		return parent[i];
	}

}
