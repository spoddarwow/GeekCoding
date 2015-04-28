package learning.graph;

public class UndirectedWeightedMatrixGraph {

	private GraphNode[][] graph;
	private int vertextCount;

	/**
	 * @return the graph
	 */
	public GraphNode[][] getGraph() {
		return graph;
	}

	/**
	 * @param graph
	 *            the graph to set
	 */
	public void setGraph(GraphNode[][] graph) {
		this.graph = graph;
	}

	/**
	 * @return the vertextCount
	 */
	public int getVertextCount() {
		return vertextCount;
	}

	/**
	 * @param vertextCount
	 *            the vertextCount to set
	 */
	public void setVertextCount(int vertextCount) {
		this.vertextCount = vertextCount;
	}

	/**
	 * @param vertextCount
	 */
	public UndirectedWeightedMatrixGraph(int vertextCount) {
		super();
		this.vertextCount = vertextCount;
		graph = new GraphNode[this.vertextCount][this.vertextCount];

	}

	public void addEdge(int src, int end, int weight) {
		graph[src][end] = new GraphNode(weight);
		graph[end][src] = new GraphNode(weight);
	}
}
