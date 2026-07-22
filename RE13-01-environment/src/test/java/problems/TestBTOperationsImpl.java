package problems;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adt.bt.BTNode;


public class TestBTOperationsImpl {

	private BTOperations<String> implementation;
	
	@BeforeEach
	public void setUp() throws Exception {
		implementation = new BTOperationsImpl<String>();
	}

	/**
	 * Cria um BTNode vazio com os filhos todos setados corretamente
	 */
	private BTNode<String> criaBTNode(){
		BTNode<String> node = new BTNode<String>();
		node.setLeft(new BTNode<String>());
		node.getLeft().setParent(node);
		node.setRight(new BTNode<String>());
		node.getRight().setParent(node);

		return node;
	}

	/**
	 * Cria um BTNode com um dado com os filhos todos setados corretamente
	 */
	private BTNode<String> criaBTNode(String dado){
		BTNode<String> node = new BTNode<String>();
		node.setData(dado);
		node.setLeft(new BTNode<String>());
		node.getLeft().setParent(node);
		node.setRight(new BTNode<String>());
		node.getRight().setParent(node);

		return node;
	}

	@Test
	public void testIssymmetricTC01() {
		BTNode<String> root = criaBTNode();
		assertTrue(implementation.isSymmetric(root));
	}

	@Test
	public void testIssymmetricTC02() {
		BTNode<String> root = criaBTNode("A");
		assertTrue(implementation.isSymmetric(root));
	}

	@Test
	public void testIssymmetricTC03() {
		BTNode<String> root = criaBTNode("A");
		BTNode<String> filho1 = criaBTNode("B");
		BTNode<String> filho2 = criaBTNode("B");
		root.setLeft(filho1);
		filho1.setParent(root);
		root.setRight(filho2);
		filho2.setParent(root);
		assertTrue(implementation.isSymmetric(root));
	}

	@Test
	public void testIssymmetricTC04() {
		BTNode<String> root = criaBTNode("A");
		BTNode<String> filho1 = criaBTNode("B");
		BTNode<String> filho2 = criaBTNode("C");
		root.setLeft(filho1);
		filho1.setParent(root);
		root.setRight(filho2);
		filho2.setParent(root);
		assertFalse(implementation.isSymmetric(root));
	}

	@Test
	public void testIssymmetricTC05() {
		BTNode<String> root = criaBTNode("A");
		BTNode<String> filho1 = criaBTNode("B");
		BTNode<String> filho2 = criaBTNode("B");
		root.setLeft(filho1);
		filho1.setParent(root);
		root.setRight(filho2);
		filho2.setParent(root);

		BTNode<String> neto1 = criaBTNode("C");
		filho1.setRight(neto1);
		neto1.setParent(filho1);

		assertFalse(implementation.isSymmetric(root));
	}

	@Test
	public void testIssymmetricTC06() {
		BTNode<String> root = criaBTNode("A");
		BTNode<String> filho1 = criaBTNode("B");
		BTNode<String> filho2 = criaBTNode("B");
		root.setLeft(filho1);
		filho1.setParent(root);
		root.setRight(filho2);
		filho2.setParent(root);

		BTNode<String> neto1 = criaBTNode("C");
		filho1.setRight(neto1);
		neto1.setParent(filho1);

		BTNode<String> neto2 = criaBTNode("C");
		filho2.setLeft(neto2);
		neto2.setParent(filho2);
		
		assertTrue(implementation.isSymmetric(root));
	}

	@Test
	public void testIssymmetricTC07() {
		BTNode<String> root = criaBTNode("A");
		BTNode<String> filho1 = criaBTNode("B");
		BTNode<String> filho2 = criaBTNode("B");
		root.setLeft(filho1);
		filho1.setParent(root);
		root.setRight(filho2);
		filho2.setParent(root);

		BTNode<String> neto1 = criaBTNode("C");
		filho1.setRight(neto1);
		neto1.setParent(filho1);

		BTNode<String> neto2 = criaBTNode("C");
		filho2.setRight(neto2);
		neto2.setParent(filho2);
		
		assertFalse(implementation.isSymmetric(root));
	}

	@Test
	public void testIssymmetricTC08() {
		BTNode<String> root = criaBTNode("A");
		BTNode<String> filho1 = criaBTNode("C");
		BTNode<String> filho2 = criaBTNode("C");
		root.setLeft(filho1);
		filho1.setParent(root);
		root.setRight(filho2);
		filho2.setParent(root);

		BTNode<String> neto1 = criaBTNode("D");
		filho1.setLeft(neto1);
		neto1.setParent(filho1);

		BTNode<String> neto2 = criaBTNode("D");
		filho2.setRight(neto2);
		neto2.setParent(filho2);

		BTNode<String> neto3 = criaBTNode("E");
		filho2.setLeft(neto3);
		neto3.setParent(filho2);

		BTNode<String> neto4 = criaBTNode("E");
		filho1.setRight(neto4);
		neto4.setParent(filho1);

		BTNode<String> bisneto1 = criaBTNode("H");
		neto1.setRight(bisneto1);
		bisneto1.setParent(neto1);

		BTNode<String> bisneto2 = criaBTNode("H");
		neto2.setLeft(bisneto2);
		bisneto2.setParent(neto2);
		
		assertTrue(implementation.isSymmetric(root));
	}

	@Test
	public void testIsSimilarTC01() {
		BTNode<String> root1 = criaBTNode();
		BTNode<String> root2 = criaBTNode();
		assertTrue(implementation.isSimilar(root1,root2));
	}

	@Test
	public void testIsSimilarTC02() {
		BTNode<String> root1 = criaBTNode("A");
		BTNode<String> root2 = criaBTNode("A");
		assertTrue(implementation.isSimilar(root1,root2));
	}

	@Test
	public void testIsSimilarTC03() {
		BTNode<String> root1 = criaBTNode("A");
		BTNode<String> root2 = criaBTNode("B");
		assertTrue(implementation.isSimilar(root1,root2));
	}

	@Test
	public void testIsSimilarTC04() {
		BTNode<String> root1 = criaBTNode("A");
		BTNode<String> filho1 = criaBTNode("B");
		BTNode<String> filho2 = criaBTNode("C");
		root1.setLeft(filho1);
		filho1.setParent(root1);
		root1.setRight(filho2);
		filho2.setParent(root1);

		BTNode<String> root2 = criaBTNode("A");
		BTNode<String> filho3 = criaBTNode("B");
		BTNode<String> filho4 = criaBTNode("E");
		root2.setLeft(filho3);
		filho3.setParent(root2);
		root2.setRight(filho4);
		filho4.setParent(root2);

		assertTrue(implementation.isSimilar(root1,root2));
	}
	
	@Test
	public void testIsSimilarTC05() {
		BTNode<String> root1 = criaBTNode("A");
		BTNode<String> filho1 = criaBTNode("B");
		BTNode<String> filho2 = criaBTNode("C");
		root1.setLeft(filho1);
		filho1.setParent(root1);
		root1.setRight(filho2);
		filho2.setParent(root1);

		BTNode<String> root2 = criaBTNode("A");
		BTNode<String> filho3 = criaBTNode("E");
		root2.setLeft(filho3);
		filho3.setParent(root2);

		assertFalse(implementation.isSimilar(root1,root2));
	}

	@Test
	public void testIsSimilarTC06() {
		BTNode<String> root1 = criaBTNode("A");
		BTNode<String> filho1 = criaBTNode("B");
		BTNode<String> filho2 = criaBTNode("C");
		BTNode<String> neto1 = criaBTNode("D");
		root1.setLeft(filho1);
		filho1.setParent(root1);
		root1.setRight(filho2);
		filho2.setParent(root1);
		filho2.setLeft(neto1);
		neto1.setParent(filho2);

		BTNode<String> root2 = criaBTNode("A");
		BTNode<String> filho3 = criaBTNode("E");
		BTNode<String> filho4 = criaBTNode("C");
		root2.setLeft(filho3);
		filho3.setParent(root2);
		root2.setRight(filho4);
		filho4.setParent(root2);

		assertFalse(implementation.isSimilar(root1,root2));
	}
}
