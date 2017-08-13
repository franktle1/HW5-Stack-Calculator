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
	
	public void setTop(Node top) {
		this.top = top;
	}
	
	public Node getTop() {
		return this.top;
	}
	
	public boolean isEmpty() {
		return (getTop() == null);
	}
	
	public boolean isFull() { //when you encounter an emminent stack overflow
		return (stackSize == maxStackSize);
	}
	
	public int size() { //stackSize goes up or down when things are popped or pushed
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
	
	public void print() { 
		if(isEmpty())
			System.out.println("Stack is Empty");
		else {
			Node curr = getTop();
			System.out.print("--> " + curr.getData());
			curr = curr.getNext();
			
			while(curr!= null) {
				System.out.println("    "+ curr.getData());
				curr.getNext();
			}
			
			System.out.println("- - - - - - - - - - - - -");	
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
		case 1:
			if(!isEmpty() && top.getNext() != null) {
				setOperationResult(Double.toString(peek() + top.getNext().getData()));
			}
			else {
				JOptionPane.showMessageDialog(null, "Operation failed. Need inputs.");
				setOperationResult("");
			}
			 //gets the first two lines of the stack
			break;
		case 2:
			setOperationResult(Double.toString(peek() - top.getNext().getData()));
			break;
		case 3:
			setOperationResult(Double.toString(peek() * top.getNext().getData())); //gets the first two lines of the stack
			break;
		case 4:
			setOperationResult(Double.toString(peek() / top.getNext().getData()));
			break;
		case 5:
			//setOperationResult(); //gets the first two lines of the stack
			break;
		case 6:
			//setOperationResult();
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
	
	public void setOperationResult(String s) {
		this.operationResult = s;
	}
	public String getOperationResult() {
		return this.operationResult;
	}
	

	
	
	
	
} //END OF STACK CLASS
