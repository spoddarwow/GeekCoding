package learning.sorting;

public class MaxHeapSort {

	private int[] inputArray = null;
	private int maxLength = 0;

	public MaxHeapSort(int maxLength) {
		this.maxLength = maxLength;
		this.inputArray = new int[this.maxLength];
	}

	private void addInputArrayValue(int index, int value) {
		this.inputArray[index] = value;
	}

	private void performHeapSort() {
		buildHeap();
		int total = this.inputArray.length - 1;
		for (int i = total; i > 0; i--) {
			int temp = this.inputArray[0];
			this.inputArray[0] = this.inputArray[i];
			this.inputArray[i] = temp;
			maxHeap(0, total);
			total--;
		}
	}

	private void buildHeap() {
		for (int i = this.inputArray.length / 2; i >= 0; i--) {
			maxHeap(i, this.inputArray.length);
		}

	}

	private void maxHeap(int i, int total) {
		int left = 2 * i;
		int right = left + 1;
		int largest = i;
		if ((left < total) && (this.inputArray[left] > this.inputArray[i])) {
			largest = left;
		}
		if ((right < total)
				&& (this.inputArray[right] > this.inputArray[largest])) {
			largest = right;
		}
		if (largest != i) {
			int temp = this.inputArray[i];
			this.inputArray[i] = this.inputArray[largest];
			this.inputArray[largest] = temp;
			maxHeap(largest, total);
		}
	}

	public static void main(String[] args) {
		MaxHeapSort object = new MaxHeapSort(6);
		object.addInputArrayValue(0, 13);
		object.addInputArrayValue(1, 2);
		object.addInputArrayValue(2, 10);
		object.addInputArrayValue(3, 6);
		object.addInputArrayValue(4, 5);
		object.addInputArrayValue(5, 15);
		for (int i = 0; i < object.inputArray.length; i++) {
			System.out.print(object.inputArray[i] + ",");
		}
		System.out.println("After Sorting------------------");
		object.performHeapSort();
		for (int i = object.inputArray.length - 1; i >= 0; i--) {
			System.out.print(object.inputArray[i] + ",");
		}

	}

}
