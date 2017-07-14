package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size=0;
		head=new LLNode<E>(null,null,tail);
	    tail=new LLNode<E>(null,head,null);
	    
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element==null){
			throw new NullPointerException();			
		}else{
		LLNode<E> n= new LLNode<E>(element);
		n.prev=tail.prev;
		tail.prev=n;
		n.next=tail;
		n.prev.next=n;	
		this.size++;
		return true;
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		LLNode<E> curr = head;
		if((index>size-1)|| (index<0) || (size==0)){
			throw new IndexOutOfBoundsException();
		}else{
		for(int i=0;i<=index;i++){
			curr=curr.next;
		}
		return curr.data;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode<E> curr = head;
		if(element==null){
			throw new NullPointerException("There is null exception");			
		}
		if((size!=0) && ((index>size-1)|| (index<0))){
			throw new IndexOutOfBoundsException("Index Out of bounds");
		}
		if(size==0 && index!=0){
			throw new IndexOutOfBoundsException("Index Out of bounds");
		}
		if(size==0 && index==0){
			add(element);
		}else{
			LLNode<E> n= new LLNode<E>(element);
			for(int i=0;i<index;i++){
				curr=curr.next;
			}
			n.next=curr.next;
			curr.next.prev=n;
			n.prev=curr;
			curr.next=n;
			this.size++;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		LLNode<E> curr = head;
		if((size!=0) && ((index>size-1)|| (index<0))){
			throw new IndexOutOfBoundsException("Index Out of bounds");
		}
		if(size==0){
			throw new IndexOutOfBoundsException("Index Out of bounds");
		}
		for(int i=0;i<=index;i++){
			curr=curr.next;
		}
		curr.next.prev=curr.prev;
		curr.prev.next=curr.next;
		this.size--;
		return curr.data;
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
		// TODO: Implement this method
		LLNode<E> curr = head;
		if(element==null){
			throw new NullPointerException("There is null exception");			
		}
		if((size!=0) && ((index>size-1)|| (index<0))){
			throw new IndexOutOfBoundsException("Index Out of bounds");
		}
		if(size==0 && index>=0){
			throw new IndexOutOfBoundsException("Index Out of bounds");
		}
		for(int i=0;i<=index;i++){
			curr=curr.next;
		}
		E val = curr.data;
		curr.data=element;
		return val;
	}

	@Override
	public String toString() {
		return "MyLinkedList [head=" + head + ", tail=" + tail + ", size=" + size + "]";
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
	
	public LLNode(E e, LLNode<E> p,LLNode<E> n) 
	{
		this.data = e;
		this.prev = p;
		this.next = n;
	}

	@Override
	public String toString() {
		return "LLNode [prev=" + prev + ", next=" + next + ", data=" + data + "]";
	}

}
