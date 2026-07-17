package adt.bst;

import adt.bt.BT;

/**
 * Interface de uma árvore binaria de busca (BST).
 */
public interface BST<T extends Comparable<T>> extends BT<T> {

	/**
	 * Retorna o nó contendo o maior elemento da BST ou null se a BST é vazia.
	 */
	public BSTNode<T> maximum();

	/**
	 * Retorna o nó contendo o menor elemento da BST ou null se a BST é vazia.
	 */
	public BSTNode<T> minimum();

	/**
	 * Retorna o nó contendo o sucessor de um elemento da BST ou null se o sucessor não existe.
	 */
	public BSTNode<T> sucessor(T element);

	/**
	 * Retorna o nó contendo o predecessor de um elemento da BST ou null se o predecessor não existe.
	 */
	public BSTNode<T> predecessor(T element);

}
