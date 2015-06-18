package topic.dataStructure.list;

public class LLIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node a1 = new Node(new Node(null, "30"), "15");

		Node a = new Node(new Node(new Node(a1, "9"), "6"), "3");
		Node b = new Node(a1, "10");
		System.out.println(getIntersectedList(a, b).getN());
	}

	public static Node getIntersectedList(Node ab, Node bb) {
		ab = reverseNode(ab, null);
		ab = reverseAndVerify(ab, bb);
		return ab;
	}

	private static Node reverseAndVerify(Node a, Node b) {
		if (b.getNext() != null) {
			a = reverseAndVerify(a, b.getNext());
		}
		if (!a.getN().equals("null")) {
			if (a.getN().equals(b.getN())) {
				return a.getNext();
			} else {
				a.setN("null");
				a.setNext(null);
				return a;
			}
		}
		return a;
	}

	private static Node reverseNode(Node ab, Node cb) {
		while (ab.getNext() != null) {
			Node temp = new Node(cb, ab.getN());
			cb = temp;
			ab = ab.getNext();
		}
		Node temp = new Node(cb, ab.getN());
		cb = temp;
		return cb;
	}
}
