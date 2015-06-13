package topic.dataStructure.list;

import Util.SingleLLNode;

/*
 * 
 * http://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
 */

public class OddEvenSegregate {

	public static void main(String[] args) {
		SingleLLNode n1 = new SingleLLNode(8, new SingleLLNode(12,
				new SingleLLNode(10, new SingleLLNode(5, new SingleLLNode(4,
						new SingleLLNode(1, new SingleLLNode(6, null)))))));

		/*
		 * SingleLLNode n1 = new SingleLLNode(8, new SingleLLNode(12, new
		 * SingleLLNode(10, null)));
		 */
		n1 = segregate(n1);
		while (n1 != null) {
			System.out.print(n1.getValue() + "->");
			n1 = n1.getNext();
		}
	}

	private static SingleLLNode findLastEvenNode(SingleLLNode n1) {
		SingleLLNode lastEvenNode = null;
		while (n1 != null) {
			if (n1.getValue() % 2 == 0) {
				lastEvenNode = n1;
			}
			n1 = n1.getNext();
		}
		return lastEvenNode;
	}

	public static SingleLLNode segregate(SingleLLNode head) {
		SingleLLNode end = null, tempHead = head, prev = null;
		while (tempHead!= null) {
			end = tempHead;
			tempHead = tempHead.getNext();
		}
		tempHead = head;
		while (tempHead != null && tempHead != end) {
			if (tempHead.getValue() % 2 != 0) {
				prev.setNext(tempHead.getNext());
				end.setNext(new SingleLLNode(tempHead.getValue(), null));
				end = end.getNext();
				
			}
			prev = tempHead;
			tempHead = tempHead.getNext();
		}
		return head;
	}
}
