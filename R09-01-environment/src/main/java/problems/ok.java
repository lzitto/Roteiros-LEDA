public void reverse() {
		// Validamos se a lista não está vazia. Não usamos return!
		if (!this.isEmpty()) {
			SingleLinkedListNode<T> previous = new SingleLinkedListNode<T>(); // Começa como um nó NIL
			SingleLinkedListNode<T> current = this.head;
			SingleLinkedListNode<T> nextNode;

			// O laço caminha invertendo as setas para trás
			while (!current.isNIL()) {
				nextNode = current.getNext(); // Guarda quem era o próximo original
				
				current.setNext(previous);    // Inverte a seta! O atual passa a apontar para o anterior
				
				previous = current;           // Avança o anterior para o nó atual
				current = nextNode;           // Avança o atual para o próximo original
			}

			// No final do laço, 'previous' estará em cima do antigo último nó.
			// Mudamos o head da lista para ele!
			this.head = previous;
		}
	}