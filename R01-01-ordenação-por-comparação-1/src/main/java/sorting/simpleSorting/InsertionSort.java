package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// vamos pensar logo nos casos pro array ser nulo ou dar um bountException..
		// para isso vamos fazer se o meu array é igual a nulo, ou o meu IndexEsquerco é
		// menor que zero
		if (!(array == null || leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex)) {
			for (int i = leftIndex + 1; i <= rightIndex; i++) {
				T key = array[i];
				int j = i - 1;
				while (j >= leftIndex && array[j].compareTo(key) > 0) {
					array[j + 1] = array[j];
					j--;
				}
				array[j + 1] = key;
			}
		}
	}
}
