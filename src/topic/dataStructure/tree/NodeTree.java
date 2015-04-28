package topic.dataStructure.tree;

public class NodeTree {

	private int value;
	private NodeTree left;
	private NodeTree right;

	/**
	 * @param value
	 * @param left
	 * @param right
	 */
	public NodeTree(int value, NodeTree left, NodeTree right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the left
	 */
	public NodeTree getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(NodeTree left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public NodeTree getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(NodeTree right) {
		this.right = right;
	}

}
