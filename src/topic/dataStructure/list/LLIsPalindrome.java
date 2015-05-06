package topic.dataStructure.list;

/**
 * http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-
 * palindrome/
 *
 * @author xspro Version 1.0
 */
public class LLIsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node(new Node(new Node(new Node(new Node(new Node(null,
				"Q"), "R"), "A"), "D"), "A"), "R");
		System.out.println(isPalin(head));
	}

	public static boolean isPalin(Node head) {
		boolean isPalin = false;
		if (palinRecurseCheck(head, head) != null) {
			isPalin = true;
		}
		return isPalin;
	}

	/**
	 * @param head
	 * @param head2
	 * @return
	 */
	private static Node palinRecurseCheck(Node head, Node head2) {
		if (head2.getNext() != null) {
			head = palinRecurseCheck(head, head2.getNext());
		}
		if (head != null) {
			if (head.getN() == head2.getN()) {
				if (head.getNext() != null) {
					return head.getNext();
				} else {
					return head;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}

class Node {
	Node next;
	String n;

	/**
	 * @param next
	 * @param n
	 */
	public Node(Node next, String n) {
		super();
		this.next = next;
		this.n = n;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @return the n
	 */
	public String getN() {
		return n;
	}

	/**
	 * @param n
	 *            the n to set
	 */
	public void setN(String n) {
		this.n = n;
	}

}
