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
		if (element != null) {
			SingleLinkedListNode<T> aux = this.head;

			// Caminha até encontrar um elemento maior ou igual, ou chegar no fim (NIL)
			while (!aux.isNIL() && this.comparator.compare(aux.getData(), element) < 0) {
				aux = aux.getNext();
			}

			// Criamos o novo nó que vai herdar o estado atual do aux (estratégia de clone)
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(aux.getData(), aux.getNext());
			
			// Atualizamos o aux para conter o novo elemento inserido
			aux.setData(element);
			aux.setNext(newNode);
		}
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
		if (elem != null) {
			SingleLinkedListNode<T> current = this.head;

			while(!current.isNIL()) {
				if(current.getData().compareTo(elem) < 0) {
					array.add(current.getData());
				}
				current = current.getNext();
			}
		}
		
		return (T[]) array.toArray(new Comparable[0]);
	}

	// NAO REMOVA NEM MODIFIQUE OS MÉTODOS ABAIXO. OS QUE SERÃO TESTADOS JÁ ESTÃO IMPLEMENTADOS
	public SingleLinkedListNode<T> getHead(){
		return this.head;
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
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
		ArrayList<T> array = new ArrayList<T>();
		SingleLinkedListNode<T> current = this.head;
		while (!current.isNIL()) {
			array.add(current.getData());
			current = current.getNext();
		}
		return (T[]) array.toArray(new Comparable[0]);
	}
	public static void main(String[] args) {
		// 1. Instancia o comparador e a lista
		Comparator<Integer> comp = (o1, o2) -> o1.compareTo(o2);
		OrderedSingleLinkedListImpl<Integer> lista = new OrderedSingleLinkedListImpl<>(comp);

		System.out.println("--- Testando Inserções ---");
		// Coloque o seu BREAKPOINT (bolinha azul) na linha abaixo!
		lista.insert(30);
		lista.insert(10);
		lista.insert(20);

		// Imprime o resultado do toArray visual
		System.out.println("Conteúdo da Lista: " + java.util.Arrays.toString(lista.toArray()));

		System.out.println("\n--- Testando getMenores(25) ---");
		Integer[] menores = lista.getMenores(25);
		System.out.println("Menores que 25: " + java.util.Arrays.toString(menores));

		// 3. VISUALIZANDO O INSERT: Imprime para ver se virou [1, 2, 3] na memória
		System.out.println("Lista após inserts: " + java.util.Arrays.toString(lista.toArray()));
		// 4. MANIPULANDO E TESTANDO O GETMENORES:
		// Vamos testar o getMenores passando o valor 3. Ele deve retornar apenas [1, 2]
		System.out.println("\n--- Testando getMenores(3) ---");
		Integer[] menoresQue3 = lista.getMenores(3);
		System.out.println("Resultado do getMenores(3): " + java.util.Arrays.toString(menoresQue3));
		
		// Mais um teste rápido: menores que 1 (deve vir vazio: [])
		Integer[] menoresQue1 = lista.getMenores(1);
		System.out.println("Resultado do getMenores(1): " + java.util.Arrays.toString(menoresQue1));
	}
}


