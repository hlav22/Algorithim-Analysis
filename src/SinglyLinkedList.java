import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * SinglyLinkedList
 * 
 * @author Hunter Lavender
 *
 * @param <E> = typed variable
 */
public class SinglyLinkedList<E> implements List<E> {
	public Node<E> head;
	private Node<E> tail;

	public SinglyLinkedList() {
		head = tail = null;
	}

	@Override
	/**
	 * Tells you the amount of elements in the linked list
	 */
	public int size() {
		var curr = head;

		int size = curr != null ? 1 : 0;
		while (curr != null && curr.hasNext()) {
			curr = curr.getNext();
			size++;

		}
		return size;
	}

	/**
	 * Returns true if the Linked list is empty
	 */
	@Override
	public boolean isEmpty() {
		if (head == null && tail == null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true or false based off if the Object is in the linked list
	 * 
	 * @param Object o
	 */
	@Override
	public boolean contains(Object o) {
		var curr = head;
		int index = 0;
		while (curr != null && curr.hasNext()) {
			if (get(index).equals(o)) {
				return true;
			}
			curr = curr.getNext();
			index++;
		}
		return false;
	}

	@Override
	/**
	 * Iterates over a sequence
	 */
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Itr();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Adds element to end of list and then returns true
	 * 
	 * @param Generic type e
	 */
	public boolean add(E e) {
		if (isEmpty()) {
			head = tail = new Node(e);
			return false;
		} else {
			Node newNode = new Node(e);
			tail.setNext(newNode);
			tail = newNode;

		}
		return true;
	}

	@Override
	/**
	 * Removes a specific object from the list
	 * 
	 * @param Object o
	 */
	public boolean remove(Object o) {
		var curr = head;
		int i = 0;
		while (curr.hasNext()) {
			if (get(i).equals(o)) {
				remove(i);
				return true;
			}
			curr = curr.getNext();
			i++;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * Adds all items from the collection to the end of the list
	 * 
	 * @param c
	 */
	public boolean addAll(Collection<? extends E> c) {
		if (c == null) {
			return false;
		}
		for (E item : c) {
			add(item);
		}
		return false;
	}

	@Override
	/**
	 * Adds all from a collection c at a specific index and shifts the stuff behind
	 * it to the right
	 * 
	 * @param index, c
	 */
	public boolean addAll(int index, Collection<? extends E> c) {
		if (c == null) {
			return false;
		}
		if (index < 0 || index >= this.size()) {
			return false;
		}
		if (this.isEmpty()) {
			addAll(c);
			return true;
		}
		var linkList = new LinkedList<E>();
		linkList.addAll(c);
		// Adding at the beginning
//		if (index == 0) {
//			linkList.tail.next = this.head;
//			this.head = linkList.head;
//			return true;
//		}
//		// Adding somewhere else
//		Node<E> curr = head;
//		int i = 0;
//		while (i < index - 1) {
//			curr = curr.next;
//			i++;
//		}
//		linkList.tail.next = curr.next;
//		curr.next = linkList.head;
		return false;
	}

	@Override
	/**
	 * Remove All from collection c
	 * 
	 * @param c
	 */
	public boolean removeAll(Collection<?> c) {
		for (Object item : c) {
			remove(item);
		}
		return true;

	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * Clears list
	 */
	public void clear() {
		head = null;
		tail = null;

	}

	@Override
	/**
	 * Gets value at a specific index
	 * 
	 * @param index
	 */
	public E get(int index) {
		int i = 0;
		var curr = head;
		while (i < index) {
			curr = curr.getNext();
			i++;
		}
		return curr.getItem();
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Add a element at a specific index
	 * 
	 * @param index, element
	 */
	public void add(int index, E element) {
		Node<E> addNode = new Node(element);
		var curr = head;
		int i = 0;
		if (this.isEmpty()) {
			head = new Node(element);
		}
		while (i < index) {
			addNode = curr;
			curr = curr.getNext();
			i++;
		}
		addNode.setNext(new Node(element));
		addNode.getNext().setNext(curr);
	}

	@Override
	/**
	 * Remove value at specific index
	 * 
	 * @param index
	 */
	public E remove(int index) {
		Node<E> prev = null;
		Node<E> curr = head;
		int i = 0;
		// Case 1 Supposed to be IndexOutOfBoundsException()
		if (index >= this.size() || index < 0) {
			return null;
		}

		// Case 2 Index to remove is 0, so remove head.
		if (index == 0) {
			E value = head.getItem();
			head = head.getNext();
			return value;
		}

		// Case 3: indexToRemoveAt > 0
		while (i < index) {
			prev = curr;
			curr = curr.getNext();
			i++;

		}

		// Remove item from list
		prev.setNext(curr.getNext());
		return curr.getItem();
	}

	@Override
	/**
	 * Returns index of specific object in link list
	 * 
	 * @param o
	 */
	public int indexOf(Object o) {
		int i = 0;
		Node<E> curr = head;
		while (curr != null) {
			if (curr.content.equals(o)) {
				return i;
			}
			curr = curr.next;
			i++;
		}
		return -1;
	}

	@Override
	/**
	 * Find the last occurence's index of the value of object
	 * 
	 * @param o
	 */
	public int lastIndexOf(Object o) {
		int i = 0;
		int lastI = -1;
		Node<E> curr = head;
		while (curr != null) {
			if (curr.content.equals(o)) {
				lastI = i;
			}
			curr = curr.next;
			i++;
		}
		return lastI;
	}

	@Override
	/**
	 * Iterates through list
	 */
	public ListIterator<E> listIterator() {
		return new Itr();
	}

	private class Itr implements ListIterator<E> {
		int size;
		int index;
		Node<E> curr;

		Itr() {
			size = size();
			index = 0;
			curr = head;
		}

		@Override
		public boolean hasNext() {
			return index != size;
		}

		@Override
		public E next() {
			E value = curr.content;
			curr = curr.next;
			index++;
			return value;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void add(E e) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	/**
	 * Iterates through but starting at specified index
	 * 
	 * @param index
	 */
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return new Itr();
	}

	@Override
	/**
	 * Creates Sublist from a specific index to another index of the linked list
	 * 
	 * @param fromIndex toIndex
	 */
	public List<E> subList(int fromIndex, int toIndex) {
		List<E> list = new ArrayList<E>();
		var curr = head;
		var index = 0;

		while (index < fromIndex) {
			curr = curr.getNext();
			index++;
		}

		while (index < toIndex && curr != null) {
			list.add(curr.getItem());
			curr = curr.getNext();
			index++;
		}

		return list;
	}

	@Override
	/**
	 * For debugging purposes
	 */
	public String toString() {
		String output = "";
		for (E e : this) {
			output += e + " ";
			output += "\n";
		}
		return output;
	}

}