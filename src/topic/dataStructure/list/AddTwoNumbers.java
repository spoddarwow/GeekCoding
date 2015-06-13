package topic.dataStructure.list;

import Util.SingleLLNode;

/*http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/ */
public class AddTwoNumbers {

	public static void main(String[] args) {
		SingleLLNode n1 = new SingleLLNode(7, new SingleLLNode(5,
				new SingleLLNode(9, new SingleLLNode(3, new SingleLLNode(1,
						null)))));
		SingleLLNode n2 = new SingleLLNode(8, new SingleLLNode(4,
				new SingleLLNode(2, null)));
		SingleLLNode n3 = addTwoNumberItr(n1, n2);
		while (n3 != null) {
			System.out.print(n3.getValue());
			System.out.print("->");
			n3 = n3.getNext();
		}
		System.out.println("-=-=-=-=");
		n3 = addTwoNumberItr2(n1, n2);
		while (n3 != null) {
			System.out.print(n3.getValue());
			System.out.print("->");
			n3 = n3.getNext();
		}
		System.out.println("-=-=-=-=");
		n3 = addTwoNumberRecur(n1, n2, 0, null);
		while (n3 != null) {
			System.out.print(n3.getValue());
			System.out.print("->");
			n3 = n3.getNext();
		}
	}

	public static SingleLLNode addTwoNumberItr(SingleLLNode nodeA,
			SingleLLNode nodeB) {
		SingleLLNode result = null, resultHead = null;
		int res = 0;
		while (nodeA != null || nodeB != null) {
			int teamp = res + ((nodeA != null) ? nodeA.getValue() : 0)
					+ ((nodeB != null) ? nodeB.getValue() : 0);
			SingleLLNode tempNode = new SingleLLNode(teamp % 10, null);
			res = teamp / 10;
			if (resultHead == null) {
				result = tempNode;
				resultHead = result;
			} else {
				result.setNext(tempNode);
				result = result.getNext();
			}
			nodeA = (nodeA != null) ? nodeA.getNext() : null;
			nodeB = (nodeB != null) ? nodeB.getNext() : null;
		}
		return resultHead;
	}

	public static SingleLLNode addTwoNumberItr2(SingleLLNode nodeA,
			SingleLLNode nodeB) {
		SingleLLNode result = null;
		int res = 0;
		while (nodeA != null || nodeB != null) {
			int teamp = res + ((nodeA != null) ? nodeA.getValue() : 0)
					+ ((nodeB != null) ? nodeB.getValue() : 0);
			SingleLLNode tempNode = new SingleLLNode(teamp % 10, null);
			res = teamp / 10;
			if (result == null) {
				result = tempNode;
			} else {
				updateResult(result, tempNode);
			}
			nodeA = (nodeA != null) ? nodeA.getNext() : null;
			nodeB = (nodeB != null) ? nodeB.getNext() : null;
		}
		return result;
	}

	private static void updateResult(SingleLLNode result, SingleLLNode tempNode) {

		while (result.getNext() != null) {
			result = result.getNext();
		}
		result.setNext(tempNode);

	}

	public static SingleLLNode addTwoNumberRecur(SingleLLNode nodeA,
			SingleLLNode nodeB, int res, SingleLLNode result) {
		if (nodeA == null && nodeB == null) {
			return null;
		}
		int temp = res;
		temp += (nodeA != null) ? nodeA.getValue() : 0;
		temp += (nodeB != null) ? nodeB.getValue() : 0;
		result = addTwoNumberRecur((nodeA != null) ? nodeA.getNext() : null,
				(nodeB != null) ? nodeB.getNext() : null, temp / 10, result);
		SingleLLNode tempRes = new SingleLLNode(temp % 10, null);
		if (result == null) {
			result = tempRes;
		} else {

			tempRes.setNext(result);

			result = tempRes;
		}
		return result;
	}
}
