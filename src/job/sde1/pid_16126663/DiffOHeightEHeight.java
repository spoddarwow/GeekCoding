package job.sde1.pid_16126663;

import java.util.LinkedList;
import java.util.Queue;

import Util.BtTreeNode;

/*
 * http://www.careercup.com/question?id=16126663
 */
public class DiffOHeightEHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * iterative Pre Order
	 */
	private int getDiff(BtTreeNode node) {
		Queue<QueueObject> queue = new LinkedList<QueueObject>();
		int even = 0, odd = 0, height = 0;
		node.setChecked(true);
		queue.add(new QueueObject(node, height));
		while (!queue.isEmpty()) {
			QueueObject obj = queue.peek();

			if (obj.getNode().getLeft() != null && !obj.getNode().isChecked()) {
				obj.getNode().setChecked(true);
				queue.add(new QueueObject(obj.getNode().getLeft(), obj
						.getLevel() + 1));
			} else if (obj.getNode().getRight() != null
					&& !obj.getNode().isChecked()) {
				obj.getNode().setChecked(true);
				queue.add(new QueueObject(obj.getNode().getRight(), obj
						.getLevel() + 1));
			} else {
				if (obj.getLevel() % 2 == 0) {
					even += obj.getNode().getValue();
				} else {
					odd += obj.getNode().getValue();
				}
				queue.poll();
			}
		}
		return odd - even;
	}
}
