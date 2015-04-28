package learning.graph.mst;

public class MSTUsingPrimAlgoForUAM {

	private int[][] graph = null;
	private int vCount = 0;
	private int[] parent = null;
	private int[] key = null;
	private boolean[] isUsed = null;
	private static int MAX = 999;

	public MSTUsingPrimAlgoForUAM(int vCount) {
		this.vCount = vCount;
		this.graph = new int[this.vCount][this.vCount];
		this.parent = new int[this.vCount];
		this.key = new int[this.vCount];
		this.isUsed = new boolean[this.vCount];
		for (int i = 0; i < this.vCount; i++) {
			this.key[i] = MAX;
			this.parent[i] = -1;
		}
	}

	public void addGraph(int start, int end, int weight) {
		if (start < vCount && end < vCount) {
			this.graph[start][end] = weight;
			this.graph[end][start] = weight;
		}
	}

	public static void main(String[] args) {
		MSTUsingPrimAlgoForUAM graphObject = new MSTUsingPrimAlgoForUAM(5);
		graphObject.addGraph(0, 1, 2);
		graphObject.addGraph(0, 3, 6);
		graphObject.addGraph(1, 2, 3);
		graphObject.addGraph(1, 3, 8);
		graphObject.addGraph(1, 4, 5);
		graphObject.addGraph(2, 4, 7);
		graphObject.addGraph(3, 4, 9);
		System.out.println(graphObject.graph);
		graphObject.doPrimsAlgo();
		System.out.println(graphObject.parent);
		graphObject.printMST();
	}

	public void printMST() {
		System.out.println("Edge   Weight\n");
		for (int i = 1; i < this.vCount; i++)
			System.out.println(parent[i] + " : " + i + " : "
					+ graph[i][parent[i]]);
	}

	private void doPrimsAlgo() {
		this.key[0] = 0;
		// this.parent[0] = -1;
		for (int i = 0; i < this.vCount - 1; i++) {
			int minVertex = getVertixWithMinWeight();
			isUsed[minVertex] = true;
			for (int j = 0; j < this.vCount; j++) {
				if ((this.graph[minVertex][j] != 0) && (!this.isUsed[j])
						&& (this.graph[minVertex][j] < this.key[j])) {
					this.parent[j] = minVertex;
					this.key[j] = this.graph[minVertex][j];
				}
			}
		}

	}

	private int getVertixWithMinWeight() {
		int minWeightVertex = -1;
		int minWeight = 999;
		for (int j = 0; j < this.vCount; j++) {
			if ((!isUsed[j]) && (key[j] < minWeight)) {
				minWeight = key[j];
				minWeightVertex = j;
			}
		}
		return minWeightVertex;
	}
}
