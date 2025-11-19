package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null || leftIndex >= rightIndex ||
            leftIndex < 0 || rightIndex >= array.length) {
            return;
        }

        boolean swapped = true;

        while (swapped) {
            swapped = false;

            // Pass left -> right (empurrando maiores para o fim)
            for (int i = leftIndex; i < rightIndex; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    Util.swap(array, i, i + 1);
                    swapped = true;
                }
            }

            // Se não houve swap, já está ordenado
            if (!swapped) break;

            // zona ordenada no final, reduz a janela
            rightIndex--;
            swapped = false;

            // Pass right -> left (empurrando menores para o começo)
            for (int i = rightIndex; i > leftIndex; i--) {
                if (array[i].compareTo(array[i - 1]) < 0) {
                    Util.swap(array, i, i - 1);
                    swapped = true;
                }
            }

            // zona ordenada no início
            leftIndex++;
        }
	}
}
