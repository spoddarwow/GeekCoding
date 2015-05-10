package Util;

public class SingleLLNode {
	private int value;
	private SingleLLNode next;

	public SingleLLNode(int value, SingleLLNode next) {
		super();
		this.value = value;
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SingleLLNode getNext() {
		return next;
	}

	public void setNext(SingleLLNode next) {
		this.next = next;
	}

}
