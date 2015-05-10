package Util;

public class BtTreeNode {
	private int value;
	private boolean isChecked;
	private BtTreeNode left;
	private BtTreeNode right;

	public BtTreeNode(int value, boolean isChecked, BtTreeNode left,
			BtTreeNode right) {
		super();
		this.value = value;
		this.isChecked = isChecked;
		this.left = left;
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public BtTreeNode getLeft() {
		return left;
	}

	public void setLeft(BtTreeNode left) {
		this.left = left;
	}

	public BtTreeNode getRight() {
		return right;
	}

	public void setRight(BtTreeNode right) {
		this.right = right;
	}

}
