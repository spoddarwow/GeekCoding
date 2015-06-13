package topic.dataStructure.list;

import Util.SingleLLNode;

/*
 * http://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/
 */
public class DeleteMAndNNode {

	public static void main(String[] args) {
		SingleLLNode head = new SingleLLNode(1, new SingleLLNode(2,
				new SingleLLNode(3, new SingleLLNode(4, new SingleLLNode(5,
						new SingleLLNode(6, new SingleLLNode(7,
								new SingleLLNode(8, null))))))));
		head = deleteMNNode(head, 2, 2);
		while (head != null) {
			System.out.println(head.getValue());
			head = head.getNext();
		}
	}

	public static SingleLLNode deleteMNNode(SingleLLNode node, int m, int n) {
		SingleLLNode temp = node;
		while (temp != null) {
			int count = 0;
			SingleLLNode first = null;
			while (count < m-1 && temp != null) {
				temp = temp.getNext();
				count++;
			}
			if (temp != null) {
				first = temp;
				count = 0;
				while (count < n && temp != null) {
					temp = temp.getNext();
					count++;
				}
				if (temp != null) {
					first.setNext(temp.getNext());
				}
			}
			temp = first.getNext();
		}
		return node;

	}
}
