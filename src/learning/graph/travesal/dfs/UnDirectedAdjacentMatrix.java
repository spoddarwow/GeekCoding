package learning.graph.travesal.dfs;

import java.util.Stack;

import learning.graph.travesal.bfs.DirectedAdjacentMatrix;

public class UnDirectedAdjacentMatrix {

	private int vertexCount = 0;
	private int[][] graphMatrix = null;
	private boolean[] vertexVisitTrack = null;
	private Stack<Integer> dfsTrack = new Stack<Integer>();

	public UnDirectedAdjacentMatrix(int vertexCount) {
		this.vertexCount = vertexCount;
		this.vertexVisitTrack = new boolean[this.vertexCount];
		this.graphMatrix = new int[this.vertexCount][this.vertexCount];

	}

	public void addEdge(int vertexStart, int vertexEnd) {
		if (((-1 < vertexStart) && (-1 < vertexEnd))
				&& ((vertexStart < this.vertexCount) && (vertexEnd < this.vertexCount))) {
			this.graphMatrix[vertexStart][vertexEnd] = 1;
		} else {
			System.err.println("Vertex passed is not in the limit."
					+ vertexStart + " : " + vertexEnd);
		}

	}

	public void dfsTravesal(int i) {
		System.out.println("Vertex : " + i);
		this.dfsTrack.push(i);
		this.vertexVisitTrack[i] = true;
		while (!this.dfsTrack.isEmpty()) {
			int nextVertex = getAdjacentVertex(this.dfsTrack.peek());
			if (nextVertex == -1) {
				this.dfsTrack.pop();
			} else {
				this.vertexVisitTrack[nextVertex] = true;
				this.dfsTrack.push(nextVertex);
				System.out.println("Vertex : " + nextVertex);
			}
		}
	}

	private int getAdjacentVertex(Integer peek) {
		int nextVertex = -1;
		for (int i = 0; i < this.vertexCount; i++) {
			if (this.graphMatrix[peek][i] == 1 && !this.vertexVisitTrack[i]) {
				nextVertex = i;
				break;
			}
		}
		return nextVertex;
	}

	public static void main(String[] args) {
		UnDirectedAdjacentMatrix graph = new UnDirectedAdjacentMatrix(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 0);
		graph.addEdge(1, 2);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 3);
		System.out.println("----- DFS ------");
		graph.dfsTravesal(2);
		graph = new UnDirectedAdjacentMatrix(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 0);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 3);
		graph.addEdge(3, 1);
		graph.addEdge(3, 0);
		System.out.println("----- BFS ------");
		DirectedAdjacentMatrix.bfs(1, graph.graphMatrix, graph.vertexCount);
	}

	/**
	 * @return the vertexCount
	 */
	public int getVertexCount() {
		return vertexCount;
	}

	/**
	 * @param vertexCount
	 *            the vertexCount to set
	 */
	public void setVertexCount(int vertexCount) {
		this.vertexCount = vertexCount;
	}

	/**
	 * @return the graphMatrix
	 */
	public int[][] getGraphMatrix() {
		return graphMatrix;
	}

	/**
	 * @param graphMatrix
	 *            the graphMatrix to set
	 */
	public void setGraphMatrix(int[][] graphMatrix) {
		this.graphMatrix = graphMatrix;
	}

	/**
	 * @return the vertexVisitTrack
	 */
	public boolean[] getVertexVisitTrack() {
		return vertexVisitTrack;
	}

	/**
	 * @param vertexVisitTrack
	 *            the vertexVisitTrack to set
	 */
	public void setVertexVisitTrack(boolean[] vertexVisitTrack) {
		this.vertexVisitTrack = vertexVisitTrack;
	}

	/**
	 * @return the dfsTrack
	 */
	public Stack<Integer> getDfsTrack() {
		return dfsTrack;
	}

	/**
	 * @param dfsTrack
	 *            the dfsTrack to set
	 */
	public void setDfsTrack(Stack<Integer> dfsTrack) {
		this.dfsTrack = dfsTrack;
	}

}
