package topic.dataStructure;

import topic.dataStructure.ArrayAsQueue.ArrayObject;

public class ArrayAsQueueMain {

	public static void main(String[] args) {
		ArrayAsQueue queue = new ArrayAsQueue(5);
		pull(queue);
		System.out.println(queue.peek());
		queue.push("s");
		pull(queue);
		pull(queue);
		queue.push("s1");
		queue.push("s2");
		queue.push("s3");
		queue.push("s4");
		pull(queue);
		pull(queue);
		pull(queue);
		pull(queue);
		pull(queue);
		queue.push("s5");
		System.out.println(queue.peek());
		pull(queue);

	}

	private static void pull(ArrayAsQueue queue) {
		System.out.println(queue.pull());
	}
}
