package learning.graph.mst;

public class Edge {

	private int src;
	private int dest;
	private int weight;

	/**
	 * @param src
	 * @param dest
	 * @param weight
	 */
	public Edge(int src, int dest, int weight) {
		super();
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	/**
	 * @return the src
	 */
	public int getSrc() {
		return src;
	}

	/**
	 * @param src
	 *            the src to set
	 */
	public void setSrc(int src) {
		this.src = src;
	}

	/**
	 * @return the dest
	 */
	public int getDest() {
		return dest;
	}

	/**
	 * @param dest
	 *            the dest to set
	 */
	public void setDest(int dest) {
		this.dest = dest;
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

}
