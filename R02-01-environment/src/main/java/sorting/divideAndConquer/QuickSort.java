package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (array == null
				|| array.length == 0
				|| leftIndex < 0
				|| rightIndex >= array.length
				|| leftIndex >= rightIndex) {

			return;
		}

		int pivotIndex = partition(array, leftIndex, rightIndex);

		sort(array, leftIndex, pivotIndex);

		sort(array, pivotIndex + 1, rightIndex);
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {

		T pivot = array[leftIndex];

		int i = leftIndex - 1;
		int j = rightIndex + 1;

		while (true) {

			do {
				i++;
			} while (array[i].compareTo(pivot) < 0);

			do {
				j--;
			} while (array[j].compareTo(pivot) > 0);

			if (i >= j) {
				return j;
			}

			Util.swap(array, i, j);
		}
	}
}
