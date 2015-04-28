package learning.sorting;

public class MinHeapSort {

	private int[] inputArray = null;
	private int length;

	/**
	 * @param length
	 */
	public MinHeapSort(int length) {
		this.length = length;
		this.inputArray = new int[this.length];
	}

	private void addInputArrayValue(int index, int value) {
		this.inputArray[index] = value;
	}

	public static void main(String[] args) {
		MinHeapSort object = new MinHeapSort(6);
		object.addInputArrayValue(0, 13);
		object.addInputArrayValue(1, 2);
		object.addInputArrayValue(2, 10);
		object.addInputArrayValue(3, 6);
		object.addInputArrayValue(4, 5);
		object.addInputArrayValue(5, 15);
		for (int i = 0; i < object.inputArray.length; i++) {
			System.out.print(object.inputArray[i] + ",");
		}
		System.out
				.println("------------------  After Sorting ------------------");
		object.performHeapSort();
		for (int i = object.inputArray.length - 1; i >= 0; i--) {
			System.out.print(object.inputArray[i] + ",");
		}
	}

	private void performHeapSort() {
		buildHeap();
		int total = this.inputArray.length - 1;
		for (int i = total; i > 0; i--) {
			int temp = this.inputArray[i];
			this.inputArray[i] = this.inputArray[0];
			this.inputArray[0] = temp;
			minHeap(0, total);
			total--;
		}
	}

	private void buildHeap() {
		for (int i = this.inputArray.length / 2; i >= 0; i--) {
			minHeap(i, this.inputArray.length);
		}
	}

	private void minHeap(int i, int length) {
		int left = 2 * i;
		int right = left + 1;
		int smallestIndex = i;
		if ((left < length) && (this.inputArray[left] < this.inputArray[i])) {
			smallestIndex = left;
		}
		if ((right < length)
				&& (this.inputArray[right] < this.inputArray[smallestIndex])) {
			smallestIndex = right;
		}
		if (smallestIndex != i) {
			int temp = this.inputArray[i];
			this.inputArray[i] = this.inputArray[smallestIndex];
			this.inputArray[smallestIndex] = temp;
			minHeap(smallestIndex, length);
		}
	}
}
