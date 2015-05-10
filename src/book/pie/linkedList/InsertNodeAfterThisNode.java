package book.pie.linkedList;

import Util.SingleLLNode;

/*Page: 77*/
public class InsertNodeAfterThisNode {
	// global head and tail as per the question.
	private static SingleLLNode head = null, tail = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prepareHead();
		insert(new SingleLLNode(2, null), 4);
		print();

	}

	private static void prepareHead() {
		SingleLLNode tailTemp = new SingleLLNode(6, null);
		tail = tailTemp;
		head = new SingleLLNode(1, new SingleLLNode(2, new SingleLLNode(3,
				tailTemp)));

	}

	private static void print() {
		SingleLLNode temp = head;
		while (temp != null) {
			System.out.println(temp.getValue());
			temp = temp.getNext();
		}
		System.out.println("----- Over -----");
		System.out.println(tail.getValue());
	}

	public static void insert(SingleLLNode insertAfterNode, int value) {
		if (head == null) {
			head = new SingleLLNode(value, null);
		} else {
			SingleLLNode temp = head;
			while (temp != null
					&& temp.getValue() != insertAfterNode.getValue()) {
				temp = temp.getNext();
			}

			if (temp != null) {
				SingleLLNode t = new SingleLLNode(value, temp.getNext());
				if (temp.getNext() == null) {
					tail = t;
				}
				temp.setNext(t);
			}
		}
	}
}
