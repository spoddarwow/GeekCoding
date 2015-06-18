package topic.dataStructure.tree;

public class CountLeaf {

	public static void main(String[] args) {
		NodeTree tree = new NodeTree(1, new NodeTree(2, new NodeTree(4, null,
				null), new NodeTree(5, null, null)), new NodeTree(3,
				new NodeTree(6, null, null), new NodeTree(7,  new NodeTree(8,  new NodeTree(9, null, null), null),  new NodeTree(17, null, null))));
		System.out.println(countLeaf(tree, 0));

	}

	public static int countLeaf(NodeTree a, int count) {
		if (a == null) {
			return count;
		} else if (a.getLeft() == null && a.getRight() == null) {
			return  count + 1;
		}
		return countLeaf(a.getRight(), countLeaf(a.getLeft(), count));
	}
}
