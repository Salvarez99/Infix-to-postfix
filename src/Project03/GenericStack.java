package Project03;
import java.util.ArrayList;

/**
 * An implementation of a stack using an ArrayList. 
 * @author Stephen Alvarez
 * @version 1.0
 */
public class GenericStack<E> {
	
	private ArrayList<E> list = new ArrayList<E>();

	/*
	 * Puts an item on the top of the stack
	 * @param E item
	 */
	public void push(E item){
		list.add(item);
	}
	
	/*
	 * Removes an item from the top of the stack
	 * @return E item
	 * @throws StackException If the stack is empty
	 */
	public E pop() throws StackException {
		if (!isEmpty()) {
			E item = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return item;
		}else 
			throw new StackException("StackException on" + " pop: stack is empty");
		
	}
	
	/*
	 * Removes all items from the stack
	 * @throws StackException If the stack is empty
	 */
	public void popAll()  throws StackException{
		if (!isEmpty())
			list.removeAll(list);
		else
			throw new StackException("StackException on " + " popAll: stack is empty");
	}
	
	/*
	 * Returns item at the top of the stack
	 * @return E
	 * @throws StackException If the stack is empty
	 */
	public E peek() throws StackException{
		if (!isEmpty()) {
			E item = list.get(list.size() - 1);
			return item;
		}else 
			throw new StackException("StackException on" + " peek: stack is empty");
	}
	
	/*
	 * Checks to see if stack is empty
	 * @return Boolean
	 */
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	/*
	 * Checks how many items are in the stack
	 * @return int 
	 */
	public int size(){
		return list.size();
	}
}
