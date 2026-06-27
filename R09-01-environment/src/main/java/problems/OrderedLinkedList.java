package problems;

import adt.linkedList.LinkedList;

/**
 * Lista encadeada simples que funciona de forma ordenada, onde a ordem é dada 
 * por um comparador.
 * 
 * Observe as restrições a serem respeitadas na classe que implementa essa interface
 */
public interface OrderedLinkedList<T extends Comparable<T>> extends LinkedList<T>{

    public T[] getMenores(T elem);
}
