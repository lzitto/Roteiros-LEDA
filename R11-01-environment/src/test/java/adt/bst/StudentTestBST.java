package adt.bst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import adt.bt.BTNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class StudentTestBST {

	private BSTImpl<Integer> tree;
	private BTNode<Integer> NIL = new BTNode<Integer>();

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	@BeforeEach
	public void setUp() {
		tree = new BSTImpl<Integer>();
	}

	@Test
	public void testInit() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(-1, tree.height());

		assertEquals(NIL, tree.getRoot());

		assertTrue(tree.order().isEmpty());
		assertTrue(tree.preOrder().isEmpty());
		assertTrue(tree.postOrder().isEmpty());

		assertEquals(NIL, tree.search(12));
		assertEquals(NIL, tree.search(-23));
		assertEquals(NIL, tree.search(0));

		assertEquals(null, tree.minimum());
		assertEquals(null, tree.maximum());

		assertEquals(null, tree.sucessor(12));
		assertEquals(null, tree.sucessor(-23));
		assertEquals(null, tree.sucessor(0));

		assertEquals(null, tree.predecessor(12));
		assertEquals(null, tree.predecessor(-23));
		assertEquals(null, tree.predecessor(0));
	}

	@Test
	public void testMinMax() {
		tree.insert(6);
		assertEquals(Integer.valueOf(6), tree.minimum().getData());
		assertEquals(Integer.valueOf(6), tree.maximum().getData());

		tree.insert(23);
		assertEquals(Integer.valueOf(6), tree.minimum().getData());
		assertEquals(Integer.valueOf(23), tree.maximum().getData());

		tree.insert(-34);
		assertEquals(Integer.valueOf(-34), tree.minimum().getData());
		assertEquals(Integer.valueOf(23), tree.maximum().getData());

		tree.insert(5);
		assertEquals(Integer.valueOf(-34), tree.minimum().getData());
		assertEquals(Integer.valueOf(23), tree.maximum().getData());

		tree.insert(9);
		assertEquals(Integer.valueOf(-34), tree.minimum().getData());
		assertEquals(Integer.valueOf(23), tree.maximum().getData());
	}

	@Test
	public void testSucessorPredecessor() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(null, tree.predecessor(-40));
		assertEquals(Integer.valueOf(-34), tree.sucessor(-40).getData());

		assertEquals(Integer.valueOf(-40), tree.predecessor(-34).getData());
		assertEquals(Integer.valueOf(0), tree.sucessor(-34).getData());

		assertEquals(Integer.valueOf(-34), tree.predecessor(0).getData());
		assertEquals(Integer.valueOf(2), tree.sucessor(0).getData());

		assertEquals(Integer.valueOf(0), tree.predecessor(2).getData());
		assertEquals(Integer.valueOf(5), tree.sucessor(2).getData());
	}

	@Test
	public void testSize() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, tree.size());

		while (!tree.isEmpty()) {
			tree.remove(tree.getRoot().getData());
			assertEquals(--size, tree.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		List<Integer> preOrder = Arrays.asList(6, -34, -40, 5, 2, 0, 23, 9, 12,
				76, 67, 232 );
		assertTrue(preOrder.equals(tree.preOrder()));
		assertEquals(4, tree.height());

		//mano????
		List<Integer> seuPreOrder = tree.preOrder();
		System.out.println("PreOrder (Raiz -> Esq -> Dir):  " + seuPreOrder);

		tree.remove(0);
		assertEquals(3, tree.height());

		tree.remove(2);
		assertEquals(3, tree.height());
	
		
	}

	@Test
	public void testRemove() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		List<Integer> order = Arrays.asList( -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 );
		assertTrue(order.equals(tree.order()));

		tree.remove(6);
		order = Arrays.asList( -40, -34, 0, 2, 5, 9, 12, 23, 67, 76, 232 );
		assertTrue(order.equals(tree.order()));

		tree.remove(9);
		order = Arrays.asList( -40, -34, 0, 2, 5, 12, 23, 67, 76, 232 );
		assertTrue(order.equals(tree.order()));

		assertEquals(NIL, tree.search(6));
		assertEquals(NIL, tree.search(9));

	}

	@Test
	public void testSearch() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(Integer.valueOf(-40), tree.search(-40).getData());
		assertEquals(Integer.valueOf(-34), tree.search(-34).getData());
		assertEquals(NIL, tree.search(2534));
	}
	@Test
    public void testInsertESearchUnicos() {
        // Árvore vazia
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());

        // Testando o insert
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);

        // Se o insert funcionou, o size mudou e o search acha!
        assertEquals(3, tree.size());
        assertEquals(Integer.valueOf(50), tree.getRoot().getData());
        assertEquals(Integer.valueOf(30), tree.search(30).getData());
        assertEquals(Integer.valueOf(70), tree.search(70).getData());
    }
}
