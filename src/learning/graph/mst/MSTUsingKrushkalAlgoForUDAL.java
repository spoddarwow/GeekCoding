package learning.graph.mst;

import java.util.ArrayList;

import learning.graph.GraphNodeAL;

public class MSTUsingKrushkalAlgoForUDAL {

	private ArrayList<ArrayList<GraphNodeAL>> graph = new ArrayList<ArrayList<GraphNodeAL>>();
	private int vCount;
	private int MAX = 999;
	private ArrayList<Edge> result = new ArrayList<Edge>();
	private ArrayList<Edge> allEdgeList = new ArrayList<Edge>();
	private int[] parent;
	private int[] rank;

	public MSTUsingKrushkalAlgoForUDAL(int vCount) {
		this.vCount = vCount;
		parent = new int[this.vCount];
		for (int i = 0; i < vCount; i++) {
			graph.add(i, new ArrayList<GraphNodeAL>());
			parent[i] = i;
		}
		rank = new int[this.vCount];

	}

	public void buildAllEdgeList() {
		for (int i = 0; i < vCount; i++) {
			ArrayList<GraphNodeAL> edge = graph.get(i);
			for (int j = 0; j < edge.size(); j++) {
				allEdgeList.add(new Edge(i, edge.get(j).getDestEdge(), edge
						.get(j).getWeight()));
			}
		}
	}

	public void qSortEdges(int low, int high) {
		int i = low, j = high, pivot = i + ((j - i) / 2);
		while (i < j) {
			while (allEdgeList.get(i).getWeight() < allEdgeList.get(pivot)
					.getWeight()) {
				i++;
			}
			while (allEdgeList.get(pivot).getWeight() < allEdgeList.get(j)
					.getWeight()) {
				j--;
			}

			if (i <= j) {
				Edge lowEdge = allEdgeList.get(i);
				allEdgeList.set(i, allEdgeList.get(j));
				allEdgeList.set(j, lowEdge);
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

	public void addEdge(int src, GraphNodeAL edge) {
		if (src < vCount) {
			ArrayList<GraphNodeAL> existingEdge = graph.get(src);
			if (null == existingEdge) {
				existingEdge = new ArrayList<GraphNodeAL>();
			}
			existingEdge.add(edge);
			graph.remove(src);
			graph.add(src, existingEdge);
		}
	}

	public static void main(String[] args) {
		MSTUsingKrushkalAlgoForUDAL object = new MSTUsingKrushkalAlgoForUDAL(4);
		object.addEdge(0, new GraphNodeAL(10, 1));
		object.addEdge(0, new GraphNodeAL(6, 2));
		object.addEdge(0, new GraphNodeAL(5, 3));
		object.addEdge(1, new GraphNodeAL(15, 3));
		object.addEdge(2, new GraphNodeAL(4, 3));
		object.buildAllEdgeList();
		object.qSortEdges(0, object.allEdgeList.size() - 1);
		int currentIndex = 0;
		while (object.result.size() <= 2) {
			Edge edge = object.allEdgeList.get(currentIndex);
			int x = findParentPath(edge.getSrc(), object);
			int y = findParentPath(edge.getDest(), object);
			if (x != y) {
				object.result.add(edge);
				if (object.rank[x] < object.rank[y]) {
					object.parent[x] = y;
				} else if (object.rank[y] < object.rank[x]) {
					object.parent[y] = x;
				} else {
					object.parent[y] = x;
					object.rank[x]++;
				}
			}
			currentIndex++;
		}
		for (int i = 0; i < object.result.size(); i++) {
			System.out.println("-=-=-=-=-=");
			System.out.println(object.result.get(i).getSrc());
			System.out.println(object.result.get(i).getDest());
			System.out.println(object.result.get(i).getWeight());
		}
	}

	private static int findParentPath(int index,
			MSTUsingKrushkalAlgoForUDAL object) {
		if (object.parent[index] != index) {
			object.parent[index] = findParentPath(object.parent[index], object);
		}
		return object.parent[index];
	}
}
