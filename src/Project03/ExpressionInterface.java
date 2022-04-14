package Project03;

/**
 * Specifications of common operations of an expression. 
 * @author Stephen Alvarez
 * @version 1.0
 */

public interface ExpressionInterface {

	/*
	 * Sets the infix equal to inputed string
	 * @param String input
	 */
	public void setInfix(String input);
	
	/*
	 * Gets infix
	 * @return String
	 */
	public String getInfix();
	
	/*
	 * Converts this infix to postfix and returns the postfix as a list of tokens
	 * @param String input
	 * @return StringTokenizer 
	 */
	public String convert();
	
	/*
	 * Evaluates this infix and returns the result
	 * @param String input
	 * @return int 
	 */
	public int evaluate();
	
	/*
	 * 
	 */
	public boolean equals();
	
	/**
	 * Returns a string representation of this infix.
	 * @return A string representation of this infix.
	 */
	public String toString();
}
