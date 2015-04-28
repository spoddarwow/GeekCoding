package learning.graph.shortestPath;

public class DijkstraDAM {

	private int[][] graph = null;
	private int vCount = 0;
	private int[] weightTracker = null;
	private boolean[] vertexTraker = null;
	private int[] parent = null;

	public DijkstraDAM(int vCount) {
		this.vCount = vCount;
		graph = new int[this.vCount][this.vCount];
		vertexTraker = new boolean[this.vCount];
		weightTracker = new int[this.vCount];
		this.parent = new int[this.vCount];
		for (int i = 0; i < this.vCount; i++) {
			this.weightTracker[i] = 999;
			this.parent[i] = -1;
		}
	}

	private void addEdges(int src, int end, int weight) {
		if ((src < this.vCount) && (end < this.vCount)) {
			this.graph[src][end] = weight;
			this.graph[end][src] = weight;
		}
	}

	public void computePath() {
		weightTracker[0] = 0;
		// this.parent[0] = 0;
		for (int i = 0; i < this.vCount - 1; i++) {
			int u = getMinPathEdge();
			if (u > -1) {
				// this.parent[u] = (i > 0)?this.parent[i - 1]: 0;
				this.vertexTraker[u] = true;
				updateAdjacentWeight(u);
			}

		}
		System.out.println(this.parent); // weight - [0, 4, 3, 9, 7, 11, 12],
		printMST(); // parent - [-1, 0, 0, 1, 0, 3, 4]
	}

	public void printMST() {
		System.out.println("Edge   Weight\n");
		for (int i = 1; i < this.vCount; i++)
			System.out.println(parent[i] + " : " + i + " : "
					+ graph[i][parent[i]]);
	}

	private void updateAdjacentWeight(int u) {
		for (int v = 0; v < this.vCount; v++) {
			if (this.graph[u][v] > 0
					&& this.graph[u][v] + this.weightTracker[u] < this.weightTracker[v]) {
				this.parent[v] = u;
				this.weightTracker[v] = this.weightTracker[u]
						+ this.graph[u][v];
			}
		}

	}

	private int getMinPathEdge() {
		int min = 999, minIndex = -1;
		for (int b = 0; b < this.vCount; b++) {
			if (this.weightTracker[b] < min && !vertexTraker[b]) {
				min = this.weightTracker[b];
				minIndex = b;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		DijkstraDAM object = new DijkstraDAM(7);
		object.addEdges(0, 1, 4);
		object.addEdges(0, 2, 3);
		object.addEdges(0, 4, 7);
		object.addEdges(1, 3, 5);
		object.addEdges(1, 2, 6);
		object.addEdges(2, 3, 11);
		object.addEdges(2, 4, 8);
		object.addEdges(3, 4, 2);
		object.addEdges(3, 5, 2);
		object.addEdges(3, 6, 10);
		object.addEdges(4, 6, 5);
		object.addEdges(5, 6, 3);
		System.out.println(object.graph);
		object.computePath();

	}

}
