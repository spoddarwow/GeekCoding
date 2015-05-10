package learning.sorting;

import company.HelloWorld;

public class MergeSort {

	private static int[] numbers;
	private static int[] helper;
	private static int size;

	public MergeSort(int size) {
		super();
		this.size = size;
		this.numbers = new int[size];
		this.helper = new int[size];
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public static void main(String[] args) {
		numbers = new int[8];
		helper = new int[8];
		int i = 0;
		numbers[i] = 1;
		i++;
		numbers[i] = 6;
		i++;
		numbers[i] = 11;
		i++;
		numbers[i] = 3;
		i++;
		numbers[i] = 8;
		i++;
		numbers[i] = 9;
		i++;
		numbers[i] = 5;
		i++;
		numbers[i] = 7;
		i++;
		doMerge(0, numbers.length - 1);
		for (int j = 0; j < numbers.length; j++) {
			System.out.println(numbers[j]);
		}
	}

	public static void doMerge(int low, int high) {
		if (low < high) {
			int middle = low + ((high - low) / 2);
			doMerge(low, middle);
			doMerge(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private static void merge(int low, int middle, int high) {
		for (int o = low; o <= high; o++) {
			helper[o] = numbers[o];
		}
		int a = low, e = middle + 1;
		while (low <= middle && e <= high) {
			if (helper[low] < helper[e]) {
				numbers[a] = helper[low];
				low++;
			} else {
				numbers[a] = helper[e];
				e++;
			}
			a++;
		}
		while (low <= middle) {
			numbers[a] = helper[low];
			low++;
			a++;
		}
	}
}
