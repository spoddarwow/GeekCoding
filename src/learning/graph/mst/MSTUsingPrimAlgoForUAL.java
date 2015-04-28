package learning.graph.mst;

import java.util.ArrayList;

import learning.graph.GraphNodeAL;

public class MSTUsingPrimAlgoForUAL {

	private ArrayList<ArrayList<GraphNodeAL>> graph = new ArrayList<ArrayList<GraphNodeAL>>();
	private static int MAX = 999;
	private int[] key = null;
	private int[] parent = null;
	private boolean[] isUsed = null;
	private int vCount = 0;

	public MSTUsingPrimAlgoForUAL(int vCount) {
		this.vCount = vCount;
		this.key = new int[this.vCount];
		this.isUsed = new boolean[this.vCount];
		this.parent = new int[this.vCount];
		for (int i = 0; i < this.vCount; i++) {
			this.key[i] = MAX;
			this.parent[i] = -1;
			graph.add(i, new ArrayList<GraphNodeAL>());
		}
	}

	public void addEdge(int src, GraphNodeAL edge) {
		if (src < vCount) {
			ArrayList<GraphNodeAL> existingEdge = graph.get(src);
			if (null == existingEdge) {
				existingEdge = new ArrayList<GraphNodeAL>();
			}
			existingEdge.add(edge);
			graph.set(src, existingEdge);
		}
	}

	public static void main(String[] args) {
		MSTUsingPrimAlgoForUAL object = new MSTUsingPrimAlgoForUAL(5);

		object.addEdge(0, new GraphNodeAL(2, 1));
		object.addEdge(1, new GraphNodeAL(2, 0));

		object.addEdge(0, new GraphNodeAL(6, 3));
		object.addEdge(3, new GraphNodeAL(6, 0));

		object.addEdge(1, new GraphNodeAL(3, 2));
		object.addEdge(2, new GraphNodeAL(3, 1));

		object.addEdge(1, new GraphNodeAL(8, 3));
		object.addEdge(3, new GraphNodeAL(8, 1));

		object.addEdge(1, new GraphNodeAL(5, 4));
		object.addEdge(4, new GraphNodeAL(5, 1));

		object.addEdge(2, new GraphNodeAL(7, 4));
		object.addEdge(4, new GraphNodeAL(7, 2));

		object.addEdge(3, new GraphNodeAL(9, 4));
		object.addEdge(4, new GraphNodeAL(9, 3));
		System.out.println(object.graph);
		object.doPrims();
		System.out.println(object.parent);
		object.printMST();
	}

	private void doPrims() {

		this.key[0] = 0;
		for (int i = 0; i < this.vCount - 1; i++) {
			int minVertex = getMinVertex();
			isUsed[minVertex] = true;
			for (int j = 0; j < this.vCount; j++) {
				if ((!isUsed[j])
						&& (minVertex > -1 && j < this.graph.get(minVertex)
								.size())
						&& (this.graph.get(minVertex).get(j) != null)
						&& (this.graph.get(minVertex).get(j).getWeight() < this.key[j])) {
					this.key[j] = this.graph.get(minVertex).get(j).getWeight();
					this.parent[j] = minVertex;
				}
			}
		}

	}

	public void printMST() {
		System.out.println("Edge   Weight\n");
		for (int i = 1; i < this.vCount; i++)
			System.out.println(parent[i]
					+ " : "
					+ i
					+ " : "
					+ ((parent[i] > -1) ? this.graph.get(i).get(parent[i])
							.getWeight() : ""));
	}

	private int getMinVertex() {
		int minWeightVertex = -1, min = 999;
		for (int j = 0; j < this.vCount; j++) {
			if ((!this.isUsed[j]) && (this.key[j] < min)) {
				min = this.key[j];
				minWeightVertex = j;
			}

		}
		return minWeightVertex;
	}
}
