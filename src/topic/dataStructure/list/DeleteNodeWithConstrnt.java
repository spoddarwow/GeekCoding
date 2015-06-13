package topic.dataStructure.list;

import Util.SingleLLNode;

public class DeleteNodeWithConstrnt {

	public static void main(String[] args) {
		SingleLLNode tailTemp = new SingleLLNode(2, new SingleLLNode(3,
				new SingleLLNode(4, null)));
		SingleLLNode head = new SingleLLNode(1, tailTemp);
		delete(head, head);
		while (head != null) {
			System.out.println(head.getValue());
			head = head.getNext();
		}

	}

	public static Object delete(SingleLLNode head, SingleLLNode deleteNode) {
		if (deleteNode != null && head != null) {
			if (head == deleteNode) {
				if (head.getNext() == null) {
					head.setNext(null);
				} else {
					head = null;
					head = deleteNode.getNext();
				}
				return null;
			} else {
				SingleLLNode temp = head;
				while (temp != null && temp.getNext() != deleteNode) {
					temp = temp.getNext();
				}
				temp.setNext(deleteNode.getNext());
				return null;
			}
		}
		return deleteNode;
	}
}
