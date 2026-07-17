package problems;

import adt.bst.BSTImpl;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeil {

	/**
	 * Esse calculo deve ser feito usando a BST. 
	 * Restricoes
	 * - O unico metodo da BST que voce pode usar eh o insert. Ou seja, dentro
	 * do metodo floor pode-se apenas invocar this.insert(elem) da BST
	 * - Voce DEVE implementar seu metodo usando recursao
	 * - Voce NAO pode usar nenhum algoritmo de ordenacao
	 * - Voce NAO pode usar memoria/estrutura auxiliar
	 * - Seu algoritmo DEVE ter complexidade O(n), onde n eh o tamanho do array
	 * ENTRETANTO, o processo de buscar o ceil DEVE ser O(log n)
	 */
	@Override
	public Integer floor(Integer[] array, Integer numero) {
		//TODO Implemente seu codigo aqui
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
   * Esse calculo deve ser feito usando a BST. 
	 * 
	 * Restricoes
	 * - O unico metodo da BST que voce pode usar eh o insert. Ou seja, dentro
	 * do metodo floor pode-se apenas invocar this.insert(elem) da BST
	 * - Voce DEVE implementar seu metodo usando recursao
	 * - Voce NAO pode usar nenhum algoritmo de ordenacao
	 * - Voce NAO pode usar memoria/estrutura auxiliar
	 * - Seu algoritmo DEVE ter complexidade O(n), onde n eh o tamanho do array
	 * ENTRETANTO, o processo de buscar o ceil DEVE ser O(log n)
	 */
	@Override
	public Integer ceil(Integer[] array, Integer numero) {
		//TODO Implemente seu codigo aqui
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
