package job.sde1.pid_16126663;

import Util.BtTreeNode;

public class QueueObject {
	private BtTreeNode node;
	private int level;

	public QueueObject(BtTreeNode node, int level) {
		super();
		this.node = node;
		this.level = level;
	}

	public BtTreeNode getNode() {
		return node;
	}

	public void setNode(BtTreeNode node) {
		this.node = node;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
