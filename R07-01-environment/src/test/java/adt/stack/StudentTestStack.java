package adt.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTestStack {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@BeforeEach
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

		// pilha com tamaho 5 e 5 elementos

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
<<<<<<< HEAD
		stack1 = new StackImpl<>(4); // tamanho 4: 3 elementos, não cheia
		stack2 = new StackImpl<>(2); // tamanho 2: ficará cheia após setUp
		stack3 = new StackImpl<>(3); // vazia
=======
		stack1 = new StackImpl<>(4);
		stack2 = new StackImpl<>(2);
		stack3 = new StackImpl<>(4);
>>>>>>> c0fb543 (RoTBST - 11)
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(Integer.valueOf(3), stack1.top());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(stack1.isEmpty());
		assertTrue(stack3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}

	@Test
	public void testPush() {
		try {
			stack1.push(Integer.valueOf(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testPushComErro() throws StackOverflowException {
		assertThrows(StackOverflowException.class, () -> {
<<<<<<< HEAD
			stack2.push(Integer.valueOf(5));
=======
			stack2.push(Integer.valueOf(3));
>>>>>>> c0fb543 (RoTBST - 11)
		});
		// levanta excecao apenas se o tamanho nao permitir outra insercao
	}

	@Test
	public void testPop() {
		try {
			assertEquals(Integer.valueOf(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testPopComErro() throws StackUnderflowException {
		assertThrows(StackUnderflowException.class, () -> {
<<<<<<< HEAD
			assertEquals(Integer.valueOf(3), stack3.pop()); 
=======
			stack3.pop();
>>>>>>> c0fb543 (RoTBST - 11)
		});
		// levanta excecao apenas se stack3 for vazia
	}
}