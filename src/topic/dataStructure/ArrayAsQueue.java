package topic.dataStructure;

@SuppressWarnings("static-access")
public class ArrayAsQueue {

	private static ArrayObject[] queue;
	private static int initialCount = 0;
	private static int nextIncCount = 0;
	private static int currentIndexToInsert = 0;
	private static int currentIndexToPull = 0;

	/**
	 * @return the queue
	 */
	public static ArrayObject[] getQueue() {
		return queue;
	}

	public ArrayAsQueue(int initialCount) {
		this.initialCount = initialCount;
		this.queue = new ArrayObject[initialCount];
		this.nextIncCount = initialCount;

	}

	public ArrayAsQueue(int initialCount, int nextIncCount) {
		this.initialCount = initialCount;
		this.queue = new ArrayObject[initialCount];
		this.nextIncCount = nextIncCount;

	}

	public void push(String value) {
		if (this.queue != null && this.queue.length > 0) {
			if (value == null) {
				System.err.println("Value to insert cannot be null.");
			} else {
				if (this.queue[this.queue.length - 1] != null) {
					rehashArray();
				}
				this.queue[this.currentIndexToInsert] = new ArrayObject(value);
				this.currentIndexToInsert += 1;
			}
		} else {
			System.err
					.println("Queue object is not initialized before using this method.");
		}
	}

	private void rehashArray() {
		ArrayObject[] tempQueue = new ArrayObject[this.initialCount
				+ this.nextIncCount];
		int index = 0;
		int i = currentIndexToPull;
		while (i <= this.queue.length - 1 && this.queue[i] != null) {
			tempQueue[index] = this.queue[i];
			index++;
			i++;
		}
		this.queue = tempQueue;
		this.currentIndexToInsert = 0;
		this.currentIndexToPull = 0;
	}

	public String pull() {
		if (this.currentIndexToPull > this.queue.length - 1) {
			return null;
		}
		if (this.queue[this.currentIndexToPull] == null) {
			return null;
		}
		String value = this.queue[this.currentIndexToPull].value;
		if (null != value) {
			this.currentIndexToPull += 1;
		}
		return value;
	}

	public ArrayObject pullArrayObject() {
		if (this.currentIndexToPull > this.queue.length - 1) {
			return null;
		}
		if (this.queue[this.currentIndexToPull] == null) {
			return null;
		}
		ArrayObject value = this.queue[this.currentIndexToPull];
		if (null != value) {
			this.currentIndexToPull += 1;
		}
		return value;
	}

	public String peek() {
		if (this.queue[this.currentIndexToPull] == null) {
			return null;
		}
		this.queue[this.currentIndexToPull].isVisited = true;
		return this.queue[this.currentIndexToPull].value;
	}

	public ArrayObject peekArrayObject() {
		if (this.queue[this.currentIndexToPull] == null) {
			return null;
		}
		this.queue[this.currentIndexToPull].isVisited = true;
		return this.queue[this.currentIndexToPull];
	}

	public class ArrayObject {
		private String value;
		private boolean isVisited = false;

		/**
		 * @param value
		 */
		public ArrayObject(String value) {
			super();
			this.value = value;
		}

	}
}
