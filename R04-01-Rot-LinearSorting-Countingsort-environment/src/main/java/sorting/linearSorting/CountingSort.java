package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		// checagem de bordas
		if (array == null || array.length == 0) return;
		if (leftIndex < 0 || rightIndex >= array.length || leftIndex >= rightIndex) return;

		// encontrar maior valor
		int max = array[leftIndex];
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		// contador com menor tamanho possível
		int[] count = new int[max + 1];

		// frequências
		for (int i = leftIndex; i <= rightIndex; i++) {
			count[array[i]]++;
		}

		// acumulação
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// array auxiliar
		Integer[] aux = new Integer[rightIndex - leftIndex + 1];

		// preenchendo auxiliar (estável)
		for (int i = rightIndex; i >= leftIndex; i--) {
			int v = array[i];
			count[v]--;
			aux[count[v]] = v;
		}

		// copiar de volta
		for (int i = 0; i < aux.length; i++) {
			array[leftIndex + i] = aux[i];
		}
		
	}

}
