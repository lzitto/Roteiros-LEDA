package adt.queue;

@SuppressWarnings("unused")
public class CircularQueueImpl<T> implements Queue<T> {

	protected T[] array;
	protected int tail;
	protected int head;
	protected int elements;

	@SuppressWarnings("unchecked")
	public CircularQueueImpl(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element == null) {
			return;
		}
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if (isEmpty()) {
			head = 0; // primeira inserção: inicializa head
		}
		tail = (tail + 1) % array.length;
		array[tail] = element;
		elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T element = array[head];
		array[head] = null;
		head = (head + 1) % array.length;
		elements--;
		return element;
	}

	@Override
	public T head() {
		if (isEmpty()) {
			return null;
		}
		return array[head];
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
