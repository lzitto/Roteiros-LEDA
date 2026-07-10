package adt.stack;

public class StackImpl<T> implements Stack<T> {

	protected T[] array;
	protected int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
<<<<<<< HEAD
		if(isEmpty()) {
			return null;
		}
		return array[top];
=======
		return isEmpty() ? null : array[top];
>>>>>>> c0fb543 (RoTBST - 11)
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
<<<<<<< HEAD
		return top == array.length -1;
=======
		return top == array.length - 1;
>>>>>>> c0fb543 (RoTBST - 11)
	}

	@Override
	public void push(T element) throws StackOverflowException {
<<<<<<< HEAD
		if (isFull()) {
            throw new StackOverflowException();
        }
        
        if (element != null) {
            top++;
            array[top] = element;
        }
=======
		if (element == null) {
			return;
		}
		if (isFull()) {
			throw new StackOverflowException();
		}
		array[++top] = element;
>>>>>>> c0fb543 (RoTBST - 11)
	}

	@Override
	public T pop() throws StackUnderflowException {
<<<<<<< HEAD
		if(isEmpty()){
			throw new StackUnderflowException();
		}
		T element = array[top];
		array[top] = null;
		top--;
=======
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		T element = array[top];
		array[top--] = null;
>>>>>>> c0fb543 (RoTBST - 11)
		return element;
	}
}
