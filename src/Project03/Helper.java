package Project03;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Contains helper methods the ArrayList-based ADT list. 
 * @author Stephen Alvarez
 * @version 1.0
 */
public class Helper {
	public static void start() throws FileNotFoundException{
		
		ArrayList<String> list = new ArrayList<>();
		Expression ex = new Expression();
		Expression ex2 = new Expression("2+5*6");
		
		
		System.out.println("Create() \n");
		create(list);
		
		System.out.println("Display() \n");
		display(list);
		System.out.println("");
		
		System.out.println("testToString() \n");
		testToString(list);
		System.out.println("");

		
		System.out.println("testSetInfix() \n");
		testSetInfix(ex);
		System.out.println("");

		
		System.out.println("testGetInfix() \n");
		testGetInfix(ex);
		System.out.println("");

		
		System.out.println("testConvert() \n");
		testConvert(ex);
		System.out.println("");

		
		System.out.println("testEvaluate() \n");
		testEvaluate(ex);
		System.out.println("");

		System.out.println("Expression(\"2+5*6\") \n");
		System.out.println("ex2.getIfix(): " + ex2.getInfix());
		System.out.println("ex2.convert(): " + ex2.convert());
		System.out.println(ex2.getInfix() + " = " + ex2.evaluate());
		System.out.println("");
		
		System.out.println("ex is equal to ex2: " + ex.equals(ex2));
		System.out.println(ex.toString() + "\n" + ex2.toString());
		
	}
	
	/*
	 * creates a list with Strings of infix expressions
	 */
	public static void create(ArrayList<String> list)  throws FileNotFoundException{
		Scanner input = new Scanner(new File("datalist.txt"));

		while(input.hasNextLine()){
			String str = input.nextLine();
			list.add(str);
		}
	
		input.close();	
	}
	/*
	 * displays sum of expression
	 */
	public static void display(ArrayList<String> list) {
		Expression ex;
		
		for (int j = 0; j < list.size(); j++) {
			ex = new Expression(list.get(j));
			System.out.println(list.get(j) + " = " + ex.evaluate());
		}
	}
	
	/*
	 * Converts expression into a String 
	 */
	public static void testToString(ArrayList<String> list){
		Expression ex;
		
		for (int j = 0; j < list.size(); j++) {
			ex = new Expression(list.get(j));
			System.out.println(ex.toString());
		}	
	}
	
	/*
	 * tests setinfix
	 */
	private static void testSetInfix(Expression ex) {
		ex.setInfix("2 4 + 5 ( 2 / 6 ) * 1");
	}
	
	/*
	 * tests getinfix
	 */
	private static void testGetInfix(Expression ex) {
		System.out.println(ex.getInfix());
	}

	/*
	 * tests convert
	 */
	private static void testConvert(Expression ex) {
		System.out.println(ex.convert());
	}

	/*
	 * tests evaluate
	 */
	private static void testEvaluate(Expression ex) {
		System.out.println(ex.evaluate());
	}
}
