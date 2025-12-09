package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		// checagem de bordas
		if (array == null || array.length == 0) return;
		if (leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex) return;

		// achar min e max
		int min = array[leftIndex];
		int max = array[leftIndex];
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] < min) min = array[i];
			if (array[i] > max) max = array[i];
		}

		// deslocamento para suportar negativos
		int shift = -min;
		int size = max - min + 1;

		int[] count = new int[size];

		// frequências
		for (int i = leftIndex; i <= rightIndex; i++) {
			count[array[i] + shift]++;
		}

		// acumulação
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// auxiliar
		Integer[] aux = new Integer[rightIndex - leftIndex + 1];

		// montagem (estável)
		for (int i = rightIndex; i >= leftIndex; i--) {
			int v = array[i] + shift;
			count[v]--;
			aux[count[v]] = array[i];
		}

		// copiar de volta
		for (int i = 0; i < aux.length; i++) {
			array[leftIndex + i] = aux[i];
		}
	}

}
