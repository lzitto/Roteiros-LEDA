package adt.bt;

import java.util.List;

/**
 * Interface de uma árvore binária genárica (BT) que guarda elementos de um tipo T.
 */
public interface BT<T> {
	/**
	 * Retorna a raiz da árvore
	 */
	public BTNode<T> getRoot();

	/**
	 * Diz se a BT é vazia
	 */
	public boolean isEmpty();

	/**
	 * Retorna a altura de uma BT. Uma BT vazia tem altura -1. 
	 * Uma BT não-vazia tem como altura a maior distancia entre a raiz e uma folha. 
	 */
	public int height();

	/**
	 * Busca um elemento na BT começando pela raiz. Se o elemento nao existe, retorna um nó NIL.
	 */
	public BTNode<T> search(T elem);

	/**
	 * Insere um elemento em uma BT.
	 */
	public void insert(T value);

	/**
	 * Remove um elemento de uma BT.
	 */
	public void remove(T key);

	/**
	 * Retorna um array de elementos preenchido de acordo com o percurso em 
	 * pre-ordem.
	 */
	public List<T> preOrder();

	/**
	 * Retorna um array de elementos preenchido de acordo com o percurso em 
	 * ordem.
	 */
	public List<T> order();

	/**
	 * Retorna um array de elementos preenchido de acordo com o percurso em 
	 * pós-ordem.
	 */
	public List<T> postOrder();

	/**
	 * Retorna o número de nós (não NIL) de uma BT.
	 */
	public int size();
}
