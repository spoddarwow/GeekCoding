package topic.dataStructure.tree;

public class Travesal {

	public static void inOrderTravesal(NodeTree root) {
		if (root != null) {
			inOrderTravesal(root.getLeft());
			System.out.print(root.getValue() + ",");
			inOrderTravesal(root.getRight());
		}
	}

	public static void preOrdertravesal(NodeTree root) {
		if (root != null) {
			System.out.print(root.getValue() + ",");
			preOrdertravesal(root.getLeft());
			preOrdertravesal(root.getRight());
		}
	}

	public static void postOrdertravesal(NodeTree root) {
		if (root != null) {
			postOrdertravesal(root.getLeft());
			postOrdertravesal(root.getRight());
			System.out.print(root.getValue() + ",");
		}
	}

	public static void main(String[] args) {
		NodeTree x = new NodeTree(4, null, null);
		NodeTree x1 = new NodeTree(5, null, null);
		NodeTree x2 = new NodeTree(2, x, x1);
		x = new NodeTree(6, null, null);
		NodeTree x3 = new NodeTree(3, x, null);
		NodeTree root = new NodeTree(1, x2, x3);
		System.out.println("-=-=-= Inorder -=-=-=-=");
		inOrderTravesal(root);
		System.out.println("-=-=-= Preorder -=-=-=-=");
		preOrdertravesal(root);
		System.out.println("-=-=-= Postorder -=-=-=-=");
		postOrdertravesal(root);
	}
}
