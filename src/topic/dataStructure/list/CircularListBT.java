package topic.dataStructure.list;

import topic.dataStructure.tree.NodeTree;

public class CircularListBT {

	public static TreeListNode convTreeToCircularList(NodeTree tree) {
		if (tree == null) {
			return null;
		}
		TreeListNode list = new TreeListNode(tree.getValue());
		list.setNext1(convTreeToCircularList(tree.getLeft()));
		if (list.getNext1() != null) {
			list.getNext1().setParent(list);
		}
		list.setNext2(convTreeToCircularList(tree.getRight()));
		if (list.getNext2() != null) {
			list.getNext2().setParent(list);
		}

		return list;
	}

	public static void main(String[] args) {
		NodeTree n1 = new NodeTree(8, null, null);
		NodeTree n2 = new NodeTree(4, n1, null);
		NodeTree n3 = new NodeTree(5, null, null);
		NodeTree n4 = new NodeTree(2, n2, n3);
		NodeTree n5 = new NodeTree(6, null, null);
		NodeTree n6 = new NodeTree(7, null, null);
		NodeTree n7 = new NodeTree(3, n5, n6);
		NodeTree tree = new NodeTree(1, n4, n7);
		TreeListNode list = convTreeToCircularList(tree);
		System.out.println(list);
	}
}
