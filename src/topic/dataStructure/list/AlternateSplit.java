package topic.dataStructure.list;

import Util.SingleLLNode;

public class AlternateSplit {

	public static void main(String[] args) {
		SingleLLNode n1 = new SingleLLNode(1, null);
		SingleLLNode n2 = new SingleLLNode(2, null);
		SingleLLNode n3 = new SingleLLNode(3, null);
		SingleLLNode n4 = new SingleLLNode(4, null);
		SingleLLNode n5 = new SingleLLNode(6, null);
		//n5.setNext(new SingleLLNode(7, null));
		n4.setNext(n5);
		n3.setNext(n4);
		n2.setNext(n3);
		n1.setNext(n2);
		getAlternateSplitNode(n1);
	}

	public static void getAlternateSplitNode(SingleLLNode n1) {
		int i = 0;
		SingleLLNode a = null, aHead = null, b = null, bHead = null;
		while (n1 != null) {
			SingleLLNode temp = new SingleLLNode(n1.getValue(), null);
			if (i % 2 == 0) {
				if (a == null) {
					a = temp;
					aHead = a;
				} else {
					a.setNext(temp);
					a = a.getNext();
				}
			} else {
				if (b == null) {
					b = temp;
					bHead = b;
				} else {
					b.setNext(temp);
					b = b.getNext();
				}
			}
			i++;
			n1 = n1.getNext();
		}
		System.out.println("--- aHead ----");
		while (aHead != null) {
			System.out.println(aHead.getValue());
			aHead = aHead.getNext();
		}
		System.out.println("--- bHead ----");
		while (bHead != null) {
			System.out.println(bHead.getValue());
			bHead = bHead.getNext();
		}
	}
}
