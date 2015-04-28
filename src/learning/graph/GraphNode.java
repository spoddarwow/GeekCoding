package learning.graph;

public class GraphNode {
	int weight;

	/**
	 * 
	 */
	public GraphNode() {
		super();
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @param weight
	 */
	public GraphNode(int weight) {
		super();
		this.weight = weight;
	}

}
