package book.pie.linkedList;

import Util.SingleLLNode;

/*Page : 92*/
final class IsCyclic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLLNode n1 = new SingleLLNode(3, null);
		SingleLLNode n2 = new SingleLLNode(2, null);
		SingleLLNode n3 = new SingleLLNode(4, null);
		SingleLLNode n4 = new SingleLLNode(6, null);
		SingleLLNode n5 = new SingleLLNode(2, null);

		n5.setNext(n3);
		n4.setNext(n5);
		n3.setNext(n4);
		n2.setNext(n3);
		n1.setNext(n2);

		System.out.println(isCyclic(n1));
	}

	public static boolean isCyclic(SingleLLNode head) {
		boolean isCyclic = false;
		if (head == null) {
			return isCyclic;
		}

		SingleLLNode h1 = head, h2 = head;
		if (head.getNext() != null && head.getNext().getNext() != null) {
			h1 = head.getNext().getNext();
		} else {
			return isCyclic;
		}
		while (!isCyclic && h1.getNext() != null
				&& h1.getNext().getNext() != null) {
			if (h1 == h2) {
				isCyclic = true;
			} else {
				h1 = h1.getNext().getNext();
				h2 = h2.getNext();
			}
		}
		return isCyclic;
	}
}
