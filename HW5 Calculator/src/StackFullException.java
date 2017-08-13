
public class StackFullException extends Exception {
	public StackFullException() {
		
	}
	public void explainWhy() {
		System.out.println("Stack is full!");
	}
}
