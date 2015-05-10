package book.pie.linkedList;

import Util.SingleLLNode;

/*Page : 77*/
public class DeleteLLNode {
	// global head and tail as per the question.
	private static SingleLLNode head = null;
	private static SingleLLNode tail = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prepareInput();
		deleteNode(new SingleLLNode(14, null));
		print();
	}

	private static void print() {
		// TODO Auto-generated method stub
		SingleLLNode temp = head;
		while (temp != null) {
			System.out.println(temp.getValue());
			temp = temp.getNext();
		}
		System.out.println("----- Over -----");
		System.out.println(tail.getValue());
	}

	private static void deleteNode(SingleLLNode deleteNode) {
		if (deleteNode != null && head != null) {
			if (head.getNext() == null
					&& head.getValue() == deleteNode.getValue()) {
				head = null;
			}
			SingleLLNode temp = head;
			while (temp != null && temp.getNext() != null
					&& temp.getNext().getValue() != deleteNode.getValue()) {
				temp = temp.getNext();
			}
			if (temp != null) {
				if (deleteNode.getNext() == null) {
					temp.setNext(null);
					tail = temp;
				} else {
					temp.setNext(deleteNode.getNext());
				}
			}
		}
	}

	private static void prepareInput() {
		// TODO Auto-generated method stub
		SingleLLNode tailTemp = new SingleLLNode(14, null);
		tail = tailTemp;
		head = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(3,
				new SingleLLNode(4, tailTemp))));
	}

}
