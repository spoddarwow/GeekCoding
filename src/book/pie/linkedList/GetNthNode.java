package book.pie.linkedList;

import Util.SingleLLNode;

/*http://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/
 */
public class GetNthNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLLNode head = new SingleLLNode(1, new SingleLLNode(2,
				new SingleLLNode(3, new SingleLLNode(4, new SingleLLNode(10,
						new SingleLLNode(14, null))))));
		SingleLLNode current = getNthNode(head, 5);
		if (current != null) {
			System.out.println(current.getValue());
		} else {
			System.out.println("Invalid 'n'");
		}
	}

	public static SingleLLNode getNthNode(SingleLLNode head, int n) {
		if (head == null) {
			return null;
		}
		SingleLLNode current = head;
		int a = 0;
		while (current != null && a < n) {
			current = current.getNext();
			a++;
		}
		return current;
	}
}
