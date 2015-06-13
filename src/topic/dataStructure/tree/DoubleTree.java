package topic.dataStructure.tree;

/*
 *  	http://www.geeksforgeeks.org/double-tree/
 */
public class DoubleTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeTree tree = new NodeTree(1, new NodeTree(2, new NodeTree(4, null, null), new NodeTree(5, null, null)),
				new NodeTree(3, null, null));
		doubleTree(tree);
		printTree(tree);
	}

	public static void printTree(NodeTree tree) {
		if (tree != null) {
			printTree(tree.getLeft());
			System.out.println(tree.getValue());
			printTree(tree.getRight());
		}

	}

	public static NodeTree doubleTree(NodeTree tree) {
		if (tree == null) {
			return null;
		}
		doubleTree(tree.getLeft());
		NodeTree temp = new NodeTree(tree.getValue(), tree.getLeft(), null);
		tree.setLeft(temp);
		doubleTree(tree.getRight());
		return null;
	}

}
