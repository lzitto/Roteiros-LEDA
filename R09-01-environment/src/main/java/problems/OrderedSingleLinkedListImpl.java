package problems;

import java.util.ArrayList;
import java.util.Comparator;

import adt.linkedList.SingleLinkedListNode;

/**
 * Para testar essa classe voce deve implementar seu comparador. Primeiro
 * implemente todos os métodos requeridos. Depois implemente dois comparadores
 * (com idéias opostas) e teste sua classe com eles. Dependendo do comparador
 * que você utilizar a lista funcionar como ascendente ou descendente, mas a
 * implemntação dos métodos é independnete disso.
 * 
 * IMPORTANTE: ASSUMA QUE ESTA LISTA NÃO IRÁ TER ELEMENTOS DUPLICADOS. OU SEJA, 
 * NENHUM TESTE TENTARÁ INSERIR ELEMENTOS DUPLICADOS NA ESTRUTURA
 */

@SuppressWarnings({"unchecked"})
public class OrderedSingleLinkedListImpl<T extends Comparable<T>> implements
		OrderedLinkedList<T> {

	protected SingleLinkedListNode<T> head;
	protected Comparator<T> comparator;

	public OrderedSingleLinkedListImpl(Comparator<T> comparator) {
		this.head = new SingleLinkedListNode<T>();
		this.comparator = comparator;
	}


	/*
	 * Restrições:
	 * - A não observação de qualquer restrição abaixo anulará a nota de testes.
	 * - O uso de memória extra de seu algoritmo deve ser O(1)
     * - O tempo de seu algoritmo deve ser O(k.N), onde k = 1.
     * - Voce NÃO pode usar recursão
     * - Você NÃO pode declarar atributos na classe
     * - Você NÃO pode usar return em métodos void
     * - Você NÃO pode usar mais de um return em métodos que retornam algum valor
     * - Você NÃO pode usar comandos break ou continue
	 * - Você NÃO pode usar o comando ternário: cond?exp1:exp2
     * - Você NÃO pode implementar método auxiliar para usar neste método.
	 * - Qualquer comparação entre objetos to tipo T DEVE ser feita pelo comparator.
	 * - Você NÃO pode olhar para o próximo elemento (node.getNext()) em condições de comandos de decisão
	 *   nem em condições de laços.
     **/
	@Override
	public void insert(T element) {
		// TODO IMPLEMENTE ESTE MÉTODO
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/*
	 * Restrições:
	 * - A não observação de qualquer restrição abaixo anulará a nota de testes.
     * - O tempo de seu algoritmo deve ser O(k.N), onde k = 1.
     * - Voce NÃO pode usar recursão
     * - Você NÃO pode declarar atributos na classe
     * - Você NÃO pode usar return em métodos void
     * - Você NÃO pode usar mais de um return em métodos que retornam algum valor
     * - Você NÃO pode usar comandos break ou continue
     * - Você NÃO pode implementar método auxiliar para usar neste método.
	 * - Qualquer comparação entre objetos do tipo T DEVE ser feita pelo 
	 *   método compareTo() do tipo T e NÃO pelo comparator.
	 * - Você NÃO pode olhar para o próximo elemento (node.getNext()) em condições de comandos de decisão
	 *   nem em condições de laços.
     **/
	@Override
	public T[] getMenores(T elem) {
		ArrayList<T> array = new ArrayList<T>();

		// TODO IMPLEMENTE ESTE MÉTODO

		return (T[]) array.toArray(new Comparable[0]);
	}

	// NAO REMOVA NEM MODIFIQUE OS MÉTODOS ABAIXO. OS QUE SERÃO TESTADOS JÁ ESTÃO IMPLEMENTADOS
	public SingleLinkedListNode<T> getHead(){
		return this.head;
	}

	@Override
	public boolean isEmpty() {
		return this.isEmpty();
	}

	@Override
	public int size() {
		// TODO NAO PRECISA IMPLEMENTAR ESTE MÉTODO, POIS ELE NÃO SERÁ TESTADO
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T search(T element) {
		// TODO NAO PRECISA IMPLEMENTAR ESTE MÉTODO, POIS ELE NÃO SERÁ TESTADO
		throw new UnsupportedOperationException("Not implemented yet!");
	}
	
		@Override
	public void remove(T element) {
		// TODO NAO PRECISA IMPLEMENTAR ESTE MÉTODO, POIS ELE NÃO SERÁ TESTADO
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] toArray() {
		// TODO NAO PRECISA IMPLEMENTAR ESTE MÉTODO, POIS ELE NÃO SERÁ TESTADO
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
