package adt.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTestQueue {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@BeforeEach
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		queue1.head();

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		/*Comentario feito por dlzitto do presente
		no passado fiz isso e vou usar isso pra aprender. sobre testes!
		1ª vou isntanciar minha implementação
		*/

		queue1 = new QueueImpl<>(4);
		queue2 = new QueueImpl<>(2);
		queue3 = new QueueImpl<>(1);
		queue1 = new CircularQueueImpl<>(4);
		queue2 = new CircularQueueImpl<>(2);
		queue3 = new CircularQueueImpl<>(4);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(Integer.valueOf(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
		assertTrue(queue2.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(Integer.valueOf(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testEnqueueComErro() throws QueueOverflowException {
		assertThrows(QueueOverflowException.class, () -> {
			queue2.enqueue(Integer.valueOf(5));
		});
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(Integer.valueOf(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDequeueComErro() throws QueueUnderflowException {
		assertThrows(QueueUnderflowException.class, () -> {
			queue3.dequeue();
		});
	}

	@Test
    public void testCircularReuse() throws QueueOverflowException, QueueUnderflowException {
        // queue2 está cheia: [1, 2]  head=0, tail=1
        queue2.dequeue();           // remove 1 — head avança para idx 1
        queue2.enqueue(9);          // deve ocupar o idx 0 via (tail+1) % 2

        assertEquals(Integer.valueOf(2), queue2.head()); // 2 é o novo primeiro
        assertFalse(queue2.isEmpty());
        assertTrue(queue2.isFull()); // voltou a ficar cheia
    }
}