package problems;

import org.junit.jupiter.api.Test;

import adt.linkedList.SingleLinkedListNode;

public class OrderedSingleLinkedListTest {
    
    private void printVisual(SingleLinkedListNode<Integer> node) {
        System.out.println("Lista na memoria: ");
        SingleLinkedListNode<Integer> aux = node;
        while(!aux.isNIL()) {
            System.out.println(aux.getData() + " -> ");
            aux = aux.getNext();
        }
        System.err.println("NIL");
    }
    
    @Test
    public void testOrdemCrescente() {
        System.out.println("--TEST 1: Ordem Crescente --");

    }
}
