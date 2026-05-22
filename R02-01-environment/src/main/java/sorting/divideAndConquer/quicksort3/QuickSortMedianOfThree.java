package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array == null
				|| array.length == 0
				|| leftIndex < 0
				|| rightIndex >= array.length
				|| leftIndex >= rightIndex) {

			return;
		}

		/*
		 * Caso base para arrays de tamanho 2.
		 */
		if (rightIndex - leftIndex == 1) {

			if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
				Util.swap(array, leftIndex, rightIndex);
			}

			return;
		}

		medianOfThree(array, leftIndex, rightIndex);

		int pivotFinalPosition = partition(array, leftIndex, rightIndex);

		sort(array, leftIndex, pivotFinalPosition - 1);

		sort(array, pivotFinalPosition + 1, rightIndex);
	}

	private void medianOfThree(T[] array, int left, int right) {

		int center = (left + right) / 2;

		if (array[left].compareTo(array[center]) > 0) {
			Util.swap(array, left, center);
		}

		if (array[left].compareTo(array[right]) > 0) {
			Util.swap(array, left, right);
		}

		if (array[center].compareTo(array[right]) > 0) {
			Util.swap(array, center, right);
		}

		/*
		 * Coloca o pivô na penúltima posição.
		 */
		Util.swap(array, center, right - 1);
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {

		T pivot = array[rightIndex - 1];

		int i = leftIndex;

		for (int j = leftIndex; j < rightIndex - 1; j++) {

			if (array[j].compareTo(pivot) < 0) {

				Util.swap(array, i, j);

				i++;
			}
		}

		/*
		 * Coloca o pivô em sua posição final.
		 */
		Util.swap(array, i, rightIndex - 1);

		return i;
	
	}
}
