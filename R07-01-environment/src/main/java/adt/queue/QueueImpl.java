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
<<<<<<< HEAD
		return array;
=======
		if (isEmpty()) {
			return null;
		}
		return array[0];
>>>>>>> 48d402b83881acdf5cc6e60d5028a5024971bb9b
=======
		return isEmpty() ? null : array[0];
>>>>>>> c0fb543 (RoTBST - 11)
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
<<<<<<< HEAD
		for (int i = 0; i < tail; i++) {
			array[i] = array[i + 1];
		}
		array[tail] = null;
		tail--;
=======
		if (!isEmpty()) {
			for (int i = 0; i < tail; i++) {
				array[i] = array[i + 1];
			}
			array[tail] = null;
			tail--;
		}
>>>>>>> c0fb543 (RoTBST - 11)
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (element == null) {
<<<<<<< HEAD
			return; // ignora silenciosamente
=======
			return;
>>>>>>> c0fb543 (RoTBST - 11)
		}
		if (isFull()) {
			throw new QueueOverflowException();
		}
<<<<<<< HEAD
		tail++;
		array[tail] = element;
=======
		array[++tail] = element;
>>>>>>> c0fb543 (RoTBST - 11)
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
