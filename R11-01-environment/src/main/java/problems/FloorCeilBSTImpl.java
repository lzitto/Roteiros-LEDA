package problems;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

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
		Integer ans = null;
        if (array != null && numero != null && array.length > 0) {
            this.root = new BSTNode<>();
            for (Integer elem : array) {
                if (elem != null) {
                    this.insert(elem);
                }
            }
            ans = findFloor(this.root, numero, null);
        }
        return ans;
	}

	private Integer findFloor(BSTNode<Integer> node, Integer x, Integer currentFloor) {
       Integer ans = currentFloor;
        if (node != null && !node.isEmpty()) {
            if (node.getData().equals(x)) {
                ans = node.getData();
            } else if (node.getData() > x) {
                ans = findFloor((BSTNode<Integer>) node.getLeft(), x, currentFloor);
            } else {
                ans = findFloor((BSTNode<Integer>) node.getRight(), x, node.getData());
            }
        }
        return ans;
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
		Integer ans = null;
        if (array != null && numero != null && array.length > 0) {
            this.root = new BSTNode<>();
            for (Integer elem : array) {
                if (elem != null) {
                    this.insert(elem);
                }
            }
            ans = findCeil(this.root, numero, null);
        }
        return ans;
	}

	
	private Integer findCeil(BSTNode<Integer> node, Integer x, Integer currentCeil) {
      Integer ans = currentCeil;
        if (node != null && !node.isEmpty()) {
            if (node.getData().equals(x)) {
                ans = node.getData();
            } else if (node.getData() < x) {
                ans = findCeil((BSTNode<Integer>) node.getRight(), x, currentCeil);
            } else {
                ans = findCeil((BSTNode<Integer>) node.getLeft(), x, node.getData());
            }
        }
        return ans;
	}
}
