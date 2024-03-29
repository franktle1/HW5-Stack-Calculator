import java.util.EmptyStackException;

import javax.swing.JOptionPane;

public class Stack {
	private class Node{
		private double data;
		private Node next;
		private Node(double data) { //constructor
			this.data = data;
			this.next = null;
		}
		
		private void setNext(Node next) {
			this.next = next;
		}
		private Node getNext() {
			return this.next;
		}
		private void setData(double data) {
			this.data = data;
		}
		private double getData() {
			return this.data;
		}
		
	}//END OF NODE CLASS

//	*******************STACK METHODS********
//	*****************************************
	
//	STACK DATA FIELDS
	private Node top; 						//Top of Stack pointer. Always pointing at the top of the stack
	private int stackSize; 					//this will be a dynamic variable
	private int maxStackSize; 				//benchmark for Stack Overflow

//	STACK CONSTRUCTOR
	public Stack(int maxStackSize) {
		this.top = null;
		this.stackSize = 0;
		this.maxStackSize = maxStackSize;
		
	}
	
//	STACK METHODS
	private void incrementStackSize() {
		stackSize++;
	}
	private void decrementStackSize() {
		stackSize--;
	}
	
	private void setTop(Node top) {
		this.top = top;
	}
	
	private Node getTop() {
		return this.top;
	}
	
	private boolean isEmpty() {
		return (getTop() == null);
	}
	
	private boolean isFull() { //when you encounter an emminent stack overflow
		return (stackSize == maxStackSize);
	}
	
	private int size() { //stackSize goes up or down when things are popped or pushed
		return this.stackSize;
	}
	
	public void push(double data) throws StackFullException {
		if(isFull()) { //prevents overflow
			throw new StackFullException();
		}
		Node newNode = new Node(data);
		if(!isEmpty()) {
			newNode.setNext(getTop());
		}
		setTop(newNode);
		incrementStackSize();
	}
	
	public double pop() throws EmptyStackException{
		if(isEmpty()) {
			throw new EmptyStackException();
			}
		double temp = peek();
		setTop(top.getNext());
		decrementStackSize();
		return temp;
	}
	
	public double peek() throws EmptyStackException { //peeks at the top of the stack
		if(isEmpty()) {
			throw new EmptyStackException();
		} 
		return (getTop().getData());
	}
	
	
	private String stacklistString;
	private void setStackList(String s) {
		this.stacklistString = s;
	}
	public String getStackList() {
		return this.stacklistString;
	}
	
	public void makeStackList() { //similarly the print method
		setStackList("");
		String temp = "";
		if(isEmpty())
			setStackList("Stack is Empty");
		else {
			Node curr = getTop();
			temp = "-->" + curr.getData() + "\n" ;
			curr = curr.getNext();
			
			while(curr!= null) {
				temp+= "      "+ curr.getData() +"\n";
				curr = curr.getNext();
			}
			setStackList(temp);
			//System.out.println("- - - - - - - - - - - - -");	
		}
		
	}
	
	public double [] popAll() throws EmptyStackException{
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			int currentSize = size();
			double [] temp = new double [currentSize];
			for(int i = 0; i < currentSize; i++) {
				temp[i] = pop();
			}
			return temp;
		}//else
	}//popAll
	
	public void destroy() {
		setTop(null);
		this.stackSize = 0;
		
	}
	
	
	private String operationResult = new String("");
	public void operation(int choice) throws EmptyStackException { //this will perform all the mathematical operations from StackCalcMain
		
		switch(choice) {
		case 1: //add
			if(!isEmpty() && top.getNext() != null) {
				setOperationResult(Double.toString(peek() + top.getNext().getData()));
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
			}
			 
			break;
		case 2: //subtract
			if(!isEmpty() && top.getNext() != null) {
				setOperationResult(Double.toString(peek() - top.getNext().getData()));
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
			}
			break;
		case 3: //multiply
			if(!isEmpty() && top.getNext() != null) {
				setOperationResult(Double.toString(peek() * top.getNext().getData()));
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
			}
			break;
		case 4: //divide
			if(!isEmpty() && top.getNext() != null) {
				if(top.getNext().getData() != 0)
					setOperationResult(Double.toString(peek() / top.getNext().getData()));
				else {
					JOptionPane.showMessageDialog(null, "Can't Divide by Zero! Only when pigs fly!");
					top.setNext(top.next.getNext());
					setOperationResult("");}
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
			};
			break;
		case 5: //sine
			if(!isEmpty()) {
				setOperationResult(Double.toString(Math.sin(peek()))); //gets top of stack, gets the sine, turns it into a string
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
				}
			break;
		case 6: //cosine
			if(!isEmpty()) {
				setOperationResult(Double.toString(Math.cos(peek()))); //gets top of stack, gets the sine, turns it into a string
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
				}
			break;
		case 7: //tangent
			if(!isEmpty()) {
				setOperationResult(Double.toString(Math.tan(peek()))); //gets top of stack, gets the sine, turns it into a string
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
				}
			break;
		case 8://natural log 
			if(!isEmpty()) {
				setOperationResult(Double.toString(Math.log(peek()))); //gets top of stack, gets the sine, turns it into a string
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
				}
			break;
		case 9: //common log base10
			if(!isEmpty()) {
				setOperationResult(Double.toString(Math.log10(peek()))); //gets top of stack, gets the sine, turns it into a string
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
				}
			break;
		case 10: //square root
			if(!isEmpty()) {
				setOperationResult(Double.toString(Math.sqrt(peek()))); //gets top of stack, gets the sine, turns it into a string
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
				}
			break;
		case 11: //e^x
			if(!isEmpty()) {
				setOperationResult(Double.toString(Math.pow(Math.E, peek()))); //gets top of stack, gets the sine, turns it into a string
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
				}
			break;
		case 12: //x^y
			if(!isEmpty() && top.getNext() != null) {
				setOperationResult(Double.toString(Math.pow(top.getNext().getData(), peek())));
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
			}
			break;
		case 13: //x^2
			if(!isEmpty()) {
				setOperationResult(Double.toString(Math.pow(peek(), 2))); //gets top of stack, gets the sine, turns it into a string
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need more inputs.");
				setOperationResult("");
				}
			break;
		
		}
	}
//	Operation chart
//	1.buttonAdd
//	2.buttonSub
//	3.buttonMul
//	4.buttonDiv
//	5.buttonSin
//	6.buttonCos
//	7.buttonTan
//	8.buttonNaturalLog
//	9.buttonLogBase10
//	10.buttonSqrt
//	11.buttonEtoPowerX
//	12.buttonExponentY
//	13.buttonSquare
	
	private void setOperationResult(String s) {
		this.operationResult = s;
	}
	public String getOperationResult() {
		return this.operationResult;
	}
	

	
	
	
	
} //END OF STACK CLASS
