/**
 * Represents a node in a linked list
 * 
 * 
 * @author Hunter Lavender
 *
 * @param <E> Type variable
 */
public class Node<E> {
	E content;
	Node<E> next;
	Node<E> prev;

	public Node(E content) {
		this.content = content;
		next = prev = null;
	}

	public Node<E> getNext() {
		return this.next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public Boolean hasNext() {
		return this.getNext() != null;
	}

	public E getItem() {
		return content;
	}

}
