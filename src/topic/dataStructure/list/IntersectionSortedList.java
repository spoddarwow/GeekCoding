package topic.dataStructure.list;

import Util.SingleLLNode;

/*http://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
 */
public class IntersectionSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLLNode n1 = new SingleLLNode(1, null);
		SingleLLNode n2 = new SingleLLNode(2, null);
		SingleLLNode n3 = new SingleLLNode(3, null);
		SingleLLNode n4 = new SingleLLNode(4, null);
		SingleLLNode n5 = new SingleLLNode(6, null);

		// n5.setNext(n3);
		n4.setNext(n5);
		n3.setNext(n4);
		n2.setNext(n3);
		n1.setNext(n2);

		SingleLLNode n12 = new SingleLLNode(8, null);
		SingleLLNode n22 = n2;
		SingleLLNode n44 = n4;
		SingleLLNode n55 = n5;
		n55.setNext(n12);
		n44.setNext(n55);
		n22.setNext(n44);

		SingleLLNode node = getIntersection(n1, n22);
		while (node.getNext() != null) {
			System.out.println(node.getValue());
			node = node.getNext();
		}

	}

	public static SingleLLNode getIntersection(SingleLLNode head,
			SingleLLNode head2) {
		SingleLLNode finalHead = null, headTemp = null;
		while (head.getNext() != null) {
			if (head.getValue() != head2.getValue()) {
				head = head.getNext();
			} else {
				SingleLLNode temp = new SingleLLNode(head.getValue(), null) ;
				if (headTemp == null) {
					headTemp = temp;
					finalHead = headTemp;
				} else {
					headTemp.setNext(temp);
					headTemp = headTemp.getNext();
				}
				head = head.getNext();
				head2 = head2.getNext();
			}
		}
		return finalHead;
	}
}
