import javax.swing.JOptionPane;

public class StackFullException extends Exception {
	public StackFullException() {
		
	}
	public void explainWhy() {
		JOptionPane.showMessageDialog(null, "Stack is full!");
	}
}
