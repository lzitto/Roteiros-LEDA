package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	protected T[] array;
	protected int tail;
	protected int maxSize;
	protected int elements;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
<<<<<<< HEAD
		return array;
=======
		if (isEmpty()) {
			return null;
		}
		return array[0];
>>>>>>> 48d402b83881acdf5cc6e60d5028a5024971bb9b
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail == array.length - 1;
	}

	@SuppressWarnings("unused")
	private void shiftLeft() {
		for (int i = 0; i < tail; i++) {
			array[i] = array[i + 1];
		}
		array[tail] = null;
		tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element == null) {
			return; // ignora silenciosamente
		}
		if (isFull()) {
			throw new QueueOverflowException();
		}
		tail++;
		array[tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T element = array[0];
		shiftLeft();
		return element;
	}
}
