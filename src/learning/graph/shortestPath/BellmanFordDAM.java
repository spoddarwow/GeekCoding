package learning.graph.shortestPath;


public class BellmanFordDAM {

	private int[][] graph = null;
	private int vCount = 0;
	private int[] parent = null;
	private int[] nodeWeight = null;
	private int MAX = 999;

	/**
	 * 
	 */
	public BellmanFordDAM(int vCount) {
		this.vCount = vCount;
		this.graph = new int[this.vCount][this.vCount];
		this.parent = new int[this.vCount];
		this.nodeWeight = new int[this.vCount];
		for (int i = 0; i < this.vCount; i++) {
			this.parent[i] = -1;
			this.nodeWeight[i] = MAX;
		}
	}

	private void addEdge(int src, int end, int weigth) {
		if (src < this.vCount && end < this.vCount) {
			this.graph[src][end] = weigth;
		}
	}

	public static void main(String[] args) {
		BellmanFordDAM object = new BellmanFordDAM(5);
		object.addEdge(0, 1, 6);
		object.addEdge(0, 4, 7);
		object.addEdge(1, 2, 5);
		object.addEdge(1, 4,8);
		object.addEdge(1,3,-4);
		object.addEdge(2,1,-2);
		object.addEdge(3, 2,7);
		object.addEdge(3,0,2);
		object.addEdge(4, 2, -4);
		object.addEdge(4, 3, 5);
		System.out.println(object.graph);
		System.out.println(object.performBellmanFordAlgo());

	}

	private boolean performBellmanFordAlgo() {
		boolean isNegativeCycle = false;
		this.nodeWeight[0] = 0;
		for (int i = 0; i < this.vCount - 1; i++) {
			for (int x = 0; x < this.vCount; x++) {
				for (int y = 0; y < this.vCount; y++) {
					if (this.graph[x][y] != 0) {
						relaxation(x, y);
					}
				}
			}
		}
		printCycle();
		for (int x = 0; x < this.vCount; x++) {
			for (int y = 0; y < this.vCount; y++) {
				if (this.graph[x][y] != 0) {
					if (this.nodeWeight[x] + this.graph[x][y] < this.nodeWeight[y]) {
						isNegativeCycle = true;
						break;
					} else {
						isNegativeCycle = false;
					}
				}
			}
		}
		return isNegativeCycle;
	}

	private void printCycle() {
		int shortestPathWeight = 0;
		for (int i = 0; i < this.parent.length; i++) {
			System.out.println("-==-=-=-=-");
			System.out.println("Path src : " + this.parent[i]);
			System.out.println("Path dest : " + i);
			System.out
					.println("Path weigth : " + this.graph[this.parent[i]][i]);
			shortestPathWeight += this.graph[this.parent[i]][i];
		}
		System.out.println("shortestPathWeight : " + shortestPathWeight);
	}

	private void relaxation(int x, int y) {
		if (this.nodeWeight[x] + this.graph[x][y] < this.nodeWeight[y]) {
			this.nodeWeight[y] = this.nodeWeight[x] + this.graph[x][y];
			this.parent[y] = x;
		}

	}
}
