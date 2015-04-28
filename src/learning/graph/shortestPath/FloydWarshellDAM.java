package learning.graph.shortestPath;

public class FloydWarshellDAM {

	private int[][] graph = null;
	private int vCount = 0;

	public FloydWarshellDAM(int vCount) {
		this.vCount = vCount;
		this.graph = new int[this.vCount][this.vCount];
		for (int i = 0; i < this.vCount; i++) {
			for (int j = 0; j < this.vCount; j++) {
				this.graph[i][j] = (i == j) ? 0 : 999;
			}
		}
	}

	private void addEdge(int src, int end, int weight) {
		if ((src < this.vCount) && (end < this.vCount)) {
			this.graph[src][end] = weight;
		}
	}

	public static void main(String[] args) {
		FloydWarshellDAM object = new FloydWarshellDAM(4);
		object.addEdge(1, 3, 1);
		object.addEdge(1, 2, 1);
		object.addEdge(2, 1, 1);
		object.addEdge(3, 0, 1);
		object.addEdge(3, 2, 1);
		object.applyAlgo();
	}

	private void applyAlgo() {
		// [[0, 5, 999, 10], [999, 0, 3, 999], [999, 999, 0, 1], [999, 999, 999,
		// 0]]
		int[][] duplGraph = new int[this.vCount][this.vCount];
		int[][] parentPathGraph = new int[this.vCount][this.vCount];
		for (int i = 0; i < this.vCount; i++) {
			for (int j = 0; j < this.vCount; j++) {
				duplGraph[i][j] = this.graph[i][j];
				parentPathGraph[i][j] = (this.graph[i][j] == 0) ? -1
						: this.graph[i][j];
				if (i == (j - 1)) {
					parentPathGraph[i][j] = i;
				}
			}
		}
		for (int k = 0; k < this.vCount; k++) {
			System.out.println("------------------------");
			System.out.println("k : " + k);
			for (int i = 0; i < this.vCount; i++) {
				System.out.println("======================");
				System.out.println("i : " + i);
				for (int j = 0; j < this.vCount; j++) {
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=");
					System.out.println("j : " + j);
					System.out
							.println("this.graph[i][k] : " + this.graph[i][k]);
					System.out
							.println("this.graph[k][j] : " + this.graph[k][j]);
					System.out.println("duplGraph[i][j] : " + duplGraph[i][j]);
					if (duplGraph[i][k] + duplGraph[k][j] < duplGraph[i][j]) {
						System.out.println("<><><><><><><><><><><><>");
						duplGraph[i][j] = duplGraph[i][k] + duplGraph[k][j];
						System.out.println("Finally updated. "
								+ duplGraph[i][j]);
						parentPathGraph[i][j] = k;
					}
				}
			}
		}
		System.out.println(duplGraph);
		System.out.println(parentPathGraph);// [[0, 5, 8, 9], [999, 0, 3, 4],
											// [999,
		// 999, 0, 1], [999, 999, 999, 0]]
	}
}
