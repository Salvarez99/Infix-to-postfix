package Project03;
/**
 * Specifications of common operations of a stack. 
 * @author Stephen Alvarez
 * @version 1.0
 */
public interface GenericStackInterface<E> {

	/*
	 * Puts an item on the top of the stack
	 * @param E item
	 */
	public void push(E item);
	
	/*
	 * Removes an item from the top of the stack
	 * @return E item
	 */
	public E pop();
	
	/*
	 * Removes all items from the stack
	 */
	public void popAll();
	
	/*
	 * Returns item at the top of the stack
	 * @return E
	 */
	public E peek();
	
	/*
	 * Checks to see if stack is empty
	 * @return Boolean
	 */
	public boolean isEmpty();
	
	/*
	 * Checks how many items are in the stack
	 * @return int 
	 */
	public int size();
}
