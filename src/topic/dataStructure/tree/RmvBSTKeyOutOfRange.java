package topic.dataStructure.tree;

/*
 * http://www.geeksforgeeks.org/remove-bst-keys-outside-the-given-range/
 */
public class RmvBSTKeyOutOfRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeTree tree = new NodeTree(6, new NodeTree(-13, null, new NodeTree(
				-8, null, null)), new NodeTree(14, new NodeTree(13,
				new NodeTree(7, null, null), null),
				new NodeTree(15, null, null)));
		int[] intArray = new int[2];
		intArray[0] = -10;
		intArray[1] = 13;
		tree = process(tree, intArray);
		System.out.println(tree);
	}

	private static NodeTree process(NodeTree tree, int[] intArray) {
		if (intArray != null && intArray.length == 2) {
			if (intArray[0] < intArray[1]) {
				return deleteNode(tree, intArray[0], intArray[1]);
			}
		}
		return null;
	}

	public static NodeTree deleteNode(NodeTree node, int min, int max) {
		if (node == null) {
			return null;
		}

		if (node.getLeft() != null) {
			node.setLeft(deleteNode(node.getLeft(), min, max));
		}
		if (node.getRight() != null) {
			node.setRight(deleteNode(node.getRight(), min, max));
		}
		if (node.getValue() < min || node.getValue() > max) {
			node = deleteNodeWdSuccsr(node);
		}

		return node;
	}

	private static NodeTree deleteNodeWdSuccsr(NodeTree node) {
		if (node.getRight() == null && node.getLeft() != null) {
			node.setValue(node.getLeft().getValue());
			node.setLeft(node.getLeft().getLeft());
			node.setRight(node.getLeft().getRight());
		} else if (node.getLeft() == null && node.getRight() != null) {
			node.setValue(node.getRight().getValue());
			node.setLeft(node.getRight().getLeft());
			node.setRight(node.getRight().getRight());
		} else {
			NodeTree temp = getMinValNode(node.getRight());
			node.setValue((temp != null)?temp.getValue():0);
		}
		return node;
	}

	private static NodeTree getMinValNode(NodeTree node) {
		NodeTree temp = node;
		if (node != null) {
			while (node.getLeft() != null && node.getLeft().getLeft() != null) {
				node = node.getLeft();
			}
			temp = node.getLeft();
			node.setLeft(null);
		}
		return temp;
	}
}
