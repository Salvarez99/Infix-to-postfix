package Project03;
import java.util.StringTokenizer;

/**
 * An implementation of an expression. 
 * @author Stephen Alvarez
 * @version 1.0
 */

public class Expression {
	
	 private String infix; 
	 
	 
	 Expression(){
		 this.infix = "";
	 }
	 
	 Expression(String input){
		 this.infix = input;
	 }
	 
	public void setInfix(String input){
		this.infix = input;
	}
	
	public String getInfix(){
		return infix;
	}
	
	public String convert(){
		
		
		GenericStack<String> stack = new GenericStack<>();
		StringBuilder postfix = new StringBuilder();
		
	//Code to make Strings into tokens
		StringBuilder infixSB = new StringBuilder();
		
		for (int i = 0; i < infix.length(); i++) {
			
			if(infix.charAt(i) == '+' || infix.charAt(i) == '-' ||
			   infix.charAt(i) == '*' || infix.charAt(i) == '/' ||
			   infix.charAt(i) == '(' || infix.charAt(i) == ')' )
			{
				infixSB.append(" ");
				infixSB.append(infix.charAt(i));
				infixSB.append(" ");
				
				
			}else if(infix.charAt(i) != '+' || infix.charAt(i) != '-' ||
					 infix.charAt(i) != '*' || infix.charAt(i) != '/' ||
					 infix.charAt(i) != '(' || infix.charAt(i) != ')' )
			
			infixSB.append(infix.charAt(i));
		}
		
		StringTokenizer infixST = new StringTokenizer(infixSB.toString());
		String currentToken;
		
	//Code to convert from infix to postfix
		while(infixST.hasMoreTokens())
		{
			currentToken = infixST.nextToken();
			/* Case 1: can be integers
			 * 	if token is equal to an integer 
			 * 		is not equal to (+*-/)
			 * 	place in postfix String
			 */
			if(currentToken.equals("(") == false && currentToken.equals("+") == false
			&& currentToken.equals("-") == false && currentToken.equals("*") == false 
			&& currentToken.equals("/") == false && currentToken.equals(")") == false)
			{
				postfix.append(currentToken);
				postfix.append(" ");
			}else{
				
			/*Case 2: can be operators  (+/-*
			 * place onto stack 
			 * 1. if token is "(" push onto stack
			 * 2. if stack is empty, push operator onto stack
			 * 3. if stack is not empty, pop operators of greater precedence 
			 * and append to StringBuilder
			 * 
			 */
			switch(currentToken)
			{
				case "(":
					stack.push(currentToken);
					break;
				case "+":
					stack.push(currentToken);	
					
					if (stack.peek() == "+" || stack.peek() == "-") {
						while(stack.peek() != "*" || stack.peek() != "/"){
							
							postfix.append(" ");
							postfix.append(stack.pop());
							postfix.append(" ");
						}
					}else
					break;
				case "-":
					stack.push(currentToken);	
					
					if (stack.peek() == "+" || stack.peek() == "-") {
						while(stack.peek() != "*" || stack.peek() != "/"){
							
							postfix.append(" ");
							postfix.append(stack.pop());
							postfix.append(" ");
						}
					}else
					break;
				case "*":
					stack.push(currentToken);	
					
					if (stack.peek() == "*" || stack.peek() == "/") {
						while(stack.peek() != "*" || stack.peek() != "/"){
							
							postfix.append(" ");
							postfix.append(stack.pop());
							postfix.append(" ");
						}
					}else
						break;
				case "/":
					stack.push(currentToken);	
					
					if (stack.peek() == "*" || stack.peek() == "/") {
						while(stack.peek() != "*" || stack.peek() != "/"){
							
							postfix.append(" ");
							postfix.append(stack.pop());
							postfix.append(" ");
						}
					}else
					break;
					
					/*Case 3: is closing parenthesis )	
					 * pop elements off the stack until you see a matching "("
					 * and append popped elements to StringBuilder
					 * pop "(" when done
					 */
					//pop all elements off the stack
				case ")":
					while(stack.peek().equals("(") == false ){
						if (stack.isEmpty() == false) {

							postfix.append(" ");
							postfix.append(stack.pop());
							postfix.append(" ");
						}
					}
					
					stack.pop();
					break;
					
				default: 
					stack.pop();
					break;
			}	

		}
	}
		while(stack.isEmpty() == false){
			postfix.append(stack.pop());
			postfix.append(" ");
		}
	
		return postfix.toString();	
	}
	
	public int evaluate(){
		
		int sum = 0;
		String postfix = this.convert();
		String currentToken;
		StringTokenizer postfixST = new StringTokenizer(postfix);
		GenericStack<String> stack = new GenericStack<>();
		
		while(postfixST.hasMoreTokens())
		{
			currentToken = postfixST.nextToken();
			
			if( currentToken.equals("+") == false && currentToken.equals("-") == false && 
				currentToken.equals("*") == false && currentToken.equals("/") == false  ){
				
				stack.push(currentToken);
			}else if( currentToken.equals("+") == true || currentToken.equals("-") == true || 
					  currentToken.equals("*") == true || currentToken.equals("/") == true ){

				switch(currentToken){
					  case "+":
						  sum = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
						  stack.push(String.valueOf(sum));
						  break;
					  case "-":
						  sum = Integer.parseInt(stack.pop()) - Integer.parseInt(stack.pop());
						  stack.push(String.valueOf(sum));
						  break;
					  case "*":
						  sum = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
						  stack.push(String.valueOf(sum));
						  break;
					  case "/":
						  sum = Integer.parseInt(stack.pop()) / Integer.parseInt(stack.pop());
						  stack.push(String.valueOf(sum));
						  break;
				}
			}		
		}
		return sum = Integer.parseInt(stack.pop());
	}
	
	public boolean equals(Expression input){
		return this.infix == input.infix;
	}
	
	public String toString(){
		return getClass().getSimpleName() + ": " + this.infix;
	}
}