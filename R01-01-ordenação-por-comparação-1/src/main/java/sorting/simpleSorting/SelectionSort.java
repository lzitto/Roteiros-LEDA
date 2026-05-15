package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || array.length == 0
		|| leftIndex < 0
		|| rightIndex >= array.length
		|| leftIndex >= rightIndex) {
	return;
}
		for (int i = leftIndex; i < rightIndex; i++) {

		// Assume o menor elemento
		int minIndex = i;

		// Procura o verdadeiro menor
		for (int j = i + 1; j <= rightIndex; j++) {

			if (array[j].compareTo(array[minIndex]) < 0) {
				minIndex = j;
			}
		}

		// Swap
		T temp = array[minIndex];
		array[minIndex] = array[i];
		array[i] = temp;
		}
	}
}
