package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team;
 * @author Elena Khasanova
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<E> (null);
		tail = new LLNode<E> (null);
		head.prev = null;
		tail.next = null;
		head.next = tail;
		tail.prev = head;
		// TODO: Implement this method
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) throws NullPointerException
	{
		if (element == null) {
			throw new NullPointerException ("Can't add null elements");
		}
		else {
		LLNode <E> node = new LLNode <E> (element);
		node.next = tail;
		node.prev = tail.prev;
		tail.prev.next = node;
		tail.prev = node;
		size +=1;
		return false;
		} //??
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 | index > size-1) {
			throw new IndexOutOfBoundsException ("Wrong index");
			}
		int n = 0;
		LLNode <E> current = null;
		if (head != null) {
			current = head;
		}
		while (n <= index) {
			n++;
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element )
	{
		if (index < 0 | index > size) {
			throw new IndexOutOfBoundsException ("Wrong index");
			}
		
		if (element == null) {
			throw new NullPointerException ("Can't add null elements");
			}
		LLNode <E> node = new LLNode <E> (element);
		
		if (index == 0) {
			node.next = head.next;
			head.next.prev = node;
			head.next = node;
			node.prev = head;
			size +=1;
		}
		else{
			
			int n = 0;
			LLNode <E> current = null;
			if (head != null) {
				current = head;
			}
			while (n <= index) {
				n++;
				current = current.next;
			}
		
		node.next = current.prev.next;
		node.prev = current.prev;
		current.prev.next = node;
		current.prev = node;
		
		size +=1;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		int s = 0;
		
		for (LLNode<E> node = head.next; node.next != null; node = node.next){
			s++;
			}
		return s;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		
		if (index < 0 | index > size-1) {
			throw new IndexOutOfBoundsException ("Wrong index");
			}
		
		int n = 0;
		LLNode <E> toRemove = head;
		
		if (head != null) {
			toRemove = head;
		}
		
		if (index == 0) {
			toRemove = head.next;
			head.next = toRemove.next;
			toRemove.next.prev = head;
			//size--;
			//head.prev = null;
		}
		else {
			while (n < index) {
				n++;
				toRemove = toRemove.next;
			}
			toRemove.prev.next = toRemove.next;
			toRemove.next.prev = toRemove.prev;
		}
		size--;
		return toRemove.data;
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (index < 0 | index > size-1) {
			throw new IndexOutOfBoundsException ("Wrong index");
			}
		if (element == null) {
			throw new NullPointerException ("Can't add null elements");
			}
		
		int n = 0;
		LLNode <E> toReplace = null;
		E rep = null;
		
		if (head != null) {
			toReplace = head;
		}
		
		while (n <= index) {
			n++;
			toReplace = toReplace.next;
		}
		rep = toReplace.data;
		toReplace.data = element;
		return rep;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	

}
