package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Voce NÃO pode modificar o array original
	 * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e utilizado.
	 *   Ou seja, seu uso de memori aextra deve ser O(1)
	 * - Você NÃO pode usar métodos já prontos de manipulação de arrays
	 * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   usando a ideia do selection sort).
	 * - Considere que k varia de 1 a N 
	 * - Você pode implementar no máximo 4 métodos auxiliares, desde que seja apenas nesta classe.
	 * - Você DEVE usar recursão. Seu código não pode conter nenhum tipo de laço (for, while, do-while).
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		//TODO implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
