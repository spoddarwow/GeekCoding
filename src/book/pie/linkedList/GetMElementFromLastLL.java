package book.pie.linkedList;

import Util.SingleLLNode;

public class GetMElementFromLastLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLLNode head = new SingleLLNode(1, new SingleLLNode(2,
				new SingleLLNode(3, new SingleLLNode(4, new SingleLLNode(6,
						null)))));
		SingleLLNode bhnd = getMElementFromLast(head, 5);
		System.out.println((bhnd != null)? bhnd.getValue():"M out of range");
	}

	private static SingleLLNode getMElementFromLast(SingleLLNode head, int m) {
		SingleLLNode current = head, behind = head;
		if (head == null) {
			return null;
		}
		int i = 0;
		while (current != null && i < m) {
			if (current.getNext() != null) {
				current = current.getNext();
			} else {
				current = null;
				behind = null;
			}
			i++;
		}
		if (current != null) {
			while (current.getNext() != null) {
				current = current.getNext();
				behind = behind.getNext();
			}
		}
		return behind;
	}
}
