package topic.dataStructure.list;

public class TreeListNode {

	private int index;
	private TreeListNode next1;
	private TreeListNode next2;
	private TreeListNode parent;

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the next1
	 */
	public TreeListNode getNext1() {
		return next1;
	}

	/**
	 * @param next1
	 *            the next1 to set
	 */
	public void setNext1(TreeListNode next1) {
		this.next1 = next1;
	}

	/**
	 * @return the next2
	 */
	public TreeListNode getNext2() {
		return next2;
	}

	/**
	 * @param next2
	 *            the next2 to set
	 */
	public void setNext2(TreeListNode next2) {
		this.next2 = next2;
	}

	/**
	 * @return the parent
	 */
	public TreeListNode getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(TreeListNode parent) {
		this.parent = parent;
	}

	/**
	 * @param index
	 * @param next1
	 * @param next2
	 * @param parent
	 */
	public TreeListNode(int index, TreeListNode next1, TreeListNode next2,
			TreeListNode parent) {
		super();
		this.index = index;
		this.next1 = next1;
		this.next2 = next2;
		this.parent = parent;
	}

	/**
	 * @param index
	 */
	public TreeListNode(int index) {
		super();
		this.index = index;
	}

	/**
	 * 
	 */
	public TreeListNode() {
		super();
		// TODO Auto-generated constructor stub
	}

}
