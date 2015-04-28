package learning.graph;

public class GraphNodeAL {

	int weight;
	int destEdge;

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
	 * @return the destEdge
	 */
	public int getDestEdge() {
		return destEdge;
	}

	/**
	 * @param destEdge
	 *            the destEdge to set
	 */
	public void setDestEdge(int destEdge) {
		this.destEdge = destEdge;
	}

	/**
	 * @param weight
	 * @param destEdge
	 */
	public GraphNodeAL(int weight, int destEdge) {
		super();
		this.weight = weight;
		this.destEdge = destEdge;
	}

	/**
	 * 
	 */
	public GraphNodeAL() {
		// TODO Auto-generated constructor stub
	}

}
