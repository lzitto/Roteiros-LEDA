package adt.bst;

import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}

	private int height(BSTNode<T> node) {
		int ans;

		if(node.isEmpty()) {
			ans = -1;
		} else {
			
			ans = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
		}

		return ans;
	}

	@Override
	public BSTNode<T> search(T element) {
		if (element == null) return new BSTNode<>();
		return search(root, element);
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> ansNode = null;
		if (node.isEmpty() || element.equals(node.getData())) {
			ansNode = node;	
		} else if (element.compareTo(node.getData()) < 0) {
			ansNode = search((BSTNode<T>) node.getLeft(), element);
		} else {
			ansNode = search((BSTNode<T>) node.getRight(), element);
		}
		return ansNode;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			insert(root,element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if(node.isEmpty()) {
			node.setData(element);
			BSTNode<T> left = new BSTNode<>();
			left.setParent(node);
			node.setLeft(left);

			BSTNode<T> right = new BSTNode<>();
			right.setParent(node);
			node.setRight(right);
		} else if (element.compareTo(node.getData()) < 0){
			insert((BSTNode<T>) node.getLeft(), element);	
		} else if (element.compareTo(node.getData()) > 0){
			insert((BSTNode<T>) node.getRight(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}


	// um metodo pequeno pra visualização do visit node
	private void visit(BSTNode<T> node, List<T> array) {
		System.out.println("-> visit(node) executado para o valor: " + node.getData());
		array.add(node.getData());
	}
	@Override
	public List<T> preOrder() {
		List<T> array = new java.util.ArrayList<>();
		preOrder(this.root, array);
		return array;
	}

	private void preOrder(BSTNode<T> node, List<T> array) {
		
		if(!node.isEmpty()){
			visit(node, array);
			preOrder((BSTNode<T>) node.getLeft(), array);
			preOrder((BSTNode<T>) node.getRight(), array);
		}
	}

	@Override
	public List<T> order() {
		List<T> array = new java.util.ArrayList<>();
		order(this.root, array);
		return array;
	}

	private void order(BSTNode<T> node, List<T> array) {
		if(!node.isEmpty()) {
			order((BSTNode<T>) node.getLeft(), array);
			visit(node, array);
			order((BSTNode<T>) node.getRight(), array);
		}
	}

	@Override
	public List<T> postOrder() {
		List<T> array = new java.util.ArrayList<>();
		preOrder(this.root, array);
		return array;
	}

	private void postOrder(BSTNode<T> node, List<T> array) {
		postOrder((BSTNode<T>) node.getRight(), array);
		postOrder((BSTNode<T>) node.getLeft(), array);
		visit(node, array);
	}

	/**
	 * Método já implementado com recursão. Entenda como funciona e use uma idéia
	 * similar para implementar os outros.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// caso base significa fazer nada (return 0)
		if (!node.isEmpty()) { // caso indutivo
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
