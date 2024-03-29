//UPDATE: HOW DO I ENTER NEGATIVE NUMBERS? SHOULD I MAKE A NEW BUTTON TO ACCOUNT FOR THAT?
//UPDATE: I'VE GOT TO MAKE SURE THAT WHEN PUSH IS CLICKED TWICE, OR IF DISPLAYCONTENT STRING IS EMPTY, NUMBERFORMAT IS HANDLED
//UPDATE: NEED TO HANDLE THE EXCEPTIONS FOR PI AND E FOR THE HOMEWORK; TREAT THEM AS PUSHED TO CLEAR THE SCREEN
//UPDATE: MAKE IT SO THAT WHATEVER IS DISPLAYED ON THE SCREEN IS ABLE TO BE PUSHED
//OPERATIONS FOR EXAMPLE: follow template for Add. addAction Button
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


//

//post fix calculator: its going to insert 2 numbers then operation then number, then operation
public class StackCalcMain extends JFrame  {
	private String displaycontent = new String("");
	private String stackcontent = new String("");
	
	
	private void setDisplayContent(String s) {
	this.displaycontent = s;	
	}
	
	private String getDisplayContent() {
		return this.displaycontent;
	}
	private void setStackContent(String s) {
		this.stackcontent = s;
	}
	private String getStackContent() {
		return this.stackcontent;
	}
	
	
	
	
	public StackCalcMain(Stack stack) throws StackFullException, EmptyStackException{
//		30 JButtons
		
		//BASE 10 && NUMBERS X 13
		JButton button0 = new JButton("0"); 
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		
		JButton buttonE = new JButton("e"); //about 2.7 ish
		JButton buttonPI = new JButton("π"); //about 3.14
		JButton buttonDECIMAL = new JButton(".");
		JButton buttonNegate = new JButton("(-)");
		
		//hover button option
		buttonNegate.setToolTipText("<HTML> <font face = \"Serif\" color = #000000 size = 20><span style = \"background-color:#ffff00\">  "
				+ "<b>This is the Negation Button.</b></span></font> </HTML>");
		
		
		
		//MATH OPERATIONS x 13
		JButton buttonAdd = new JButton("+");
		JButton buttonSub = new JButton("-");
		JButton buttonMul = new JButton("x");
		JButton buttonDiv = new JButton("÷");
		JButton buttonSin = new JButton("sin(x)");
		JButton buttonCos = new JButton("cos(x)");
		JButton buttonTan = new JButton("tan(x)");
		JButton buttonNaturalLog = new JButton("ln()");
		JButton buttonLogBase10 = new JButton("log10()");
		JButton buttonSqrt = new JButton("√");
		JButton buttonEtoPowerX = new JButton("e^x");
		JButton buttonExponentY = new JButton("x^y");
		JButton buttonSquare = new JButton("x^2");
		
		//hover button option
		buttonSub.setToolTipText("<HTML> <font face = \"Serif\" color = #000000 size = 6><span style = \"background-color:#ffff00\">  "
				+ "<b>If you are looking for the negation sign, <br> look no further! "
				+ "It is right next to the <br> Push Button! </b></span></font> </HTML>");
		buttonLogBase10.setToolTipText("<HTML> <font face = \"Serif\" color = #000000 size = 6><span style = \"background-color:#ffff00\">  "
				+ "<b>Do you mean these?</b><br><img src = \"https://irp-cdn.multiscreensite.com/3153f65a/import/base/dms3rep/multi/mobile/Satellite_261542398.png\" ></span></font> </HTML>");
		
		
		//CALC CONTROL BUTTONS x4	
		JButton buttonDelete = new JButton("<--");
		JButton buttonClearAll = new JButton("CE");
		JButton buttonPush = new JButton("PUSH");
		JButton buttonPop = new JButton("POP");
		
		//GUI OBJECTS
		//JTextField is used for single line displays, where as JTextArea, you can use newline escape keys
		
		JTextField display = new JTextField(); //displayed on top page centered, shows what user is putting in real-time and final result
		JTextArea stacklist = new JTextArea(); //going to be display the list of entered items in the center-left after push operation
		JScrollPane scroll = new JScrollPane(stacklist);
		Font mydisplayFont = new Font("Times New Roman", Font.PLAIN, 40);
		display.setFont(mydisplayFont);
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setEditable(false);
		
		scroll.setViewportView(stacklist);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		stacklist.setPreferredSize(new Dimension(150,700));
		//stacklist.setLineWrap(true);
		stacklist.setFont(new Font("Courier", Font.PLAIN, 20));
		String temp = "Stack Contents: \n";
		
		
		
		stacklist.setText(temp + " Stack is Empty");
		stacklist.setEditable(false);
		
		
		JPanel row1 = new JPanel();
		row1.setLayout(new GridLayout(1,5));
		JPanel row2 = new JPanel();
		row2.setLayout(new GridLayout(1,5));
		JPanel row3 = new JPanel();
		row3.setLayout(new GridLayout(1,5));
		JPanel row4 = new JPanel();
		row4.setLayout(new GridLayout(1,5));
		JPanel row5 = new JPanel();
		row5.setLayout(new GridLayout(1,5));
		JPanel row6 = new JPanel();
		row6.setLayout(new GridLayout(1,6));
		
		row1.add(buttonNaturalLog);
		row1.add(buttonLogBase10);
		row1.add(buttonClearAll);
		row1.add(buttonPop);
		row1.add(buttonDelete);
		
		row2.add(buttonSquare);
		row2.add(buttonExponentY);
		row2.add(buttonSin);
		row2.add(buttonCos);
		row2.add(buttonTan);
		
		row3.add(buttonSqrt);
		row3.add(button1);
		row3.add(button2);
		row3.add(button3);
		row3.add(buttonAdd);
		
		row4.add(buttonEtoPowerX);
		row4.add(button4);
		row4.add(button5);
		row4.add(button6);
		row4.add(buttonSub);
		
		row5.add(buttonE);
		row5.add(button7);
		row5.add(button8);
		row5.add(button9);
		row5.add(buttonMul);
		
		row6.add(buttonPI);
		row6.add(buttonDECIMAL);
		row6.add(button0);
		row6.add(buttonNegate);
		row6.add(buttonPush);
		row6.add(buttonDiv);
		
		
		JPanel allButtons = new JPanel();
		allButtons.setLayout(new GridLayout(6,1));
		allButtons.add(row1);
		allButtons.add(row2);
		allButtons.add(row3);
		allButtons.add(row4);
		allButtons.add(row5);
		allButtons.add(row6);
		
		
		
		
//		****JBUTTON ACTION*************************************************
//		********************************************************************
		
		
		
		button0.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("2.718281828459") || displaycontent.contains ("3.141592653589")) 
				setDisplayContent("");
			displaycontent += 0;
			display.setText(displaycontent);
		
		}});
		button1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("2.718281828459") || displaycontent.contains ("3.141592653589")) 
				setDisplayContent("");
			displaycontent += 1;
			display.setText(displaycontent);
			}});
		button2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("2.718281828459") || displaycontent.contains ("3.141592653589")) 
				setDisplayContent("");
			displaycontent += 2;
			display.setText(displaycontent);
			}});
		button3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("2.718281828459") || displaycontent.contains ("3.141592653589")) 
				setDisplayContent("");
			displaycontent += 3;
			display.setText(displaycontent);
			}});
		button4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("2.718281828459") || displaycontent.contains ("3.141592653589")) 
				setDisplayContent("");
			displaycontent += 4;
			display.setText(displaycontent);
			}});
		button5.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("2.718281828459") || displaycontent.contains ("3.141592653589")) 
				setDisplayContent("");
			displaycontent += 5;
			display.setText(displaycontent);
			}});
		button6.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("2.718281828459") || displaycontent.contains ("3.141592653589")) 
				setDisplayContent("");
			displaycontent += 6;
			display.setText(displaycontent);
			}});
		button7.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("2.718281828459") || displaycontent.contains ("3.141592653589")) 
				setDisplayContent("");
			displaycontent += 7;
			display.setText(displaycontent);	
			}});
		button8.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("2.718281828459") || displaycontent.contains ("3.141592653589")) 
				setDisplayContent("");
			displaycontent += 8;
			display.setText(displaycontent);
			}});
		button9.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("2.718281828459") || displaycontent.contains ("3.141592653589")) 
				setDisplayContent("");
			displaycontent += 9;
			display.setText(displaycontent);
			}});
		buttonE.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			setDisplayContent(""); //need to make a second variable to store values in pop
			displaycontent += 2.718281828459;
			display.setText(displaycontent);	
			
			}});
		buttonPI.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			displaycontent += 3.141592653589;
			display.setText(displaycontent);
			}});
		buttonDECIMAL.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("."))
					JOptionPane.showMessageDialog(null, "One Decimal per number please!");
			else {
				if(displaycontent.equals("")) {
					setDisplayContent("0.");
				}
				else {
				displaycontent += ".";
				}
				display.setText(displaycontent);
			}
			}});
		buttonNegate.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.contains("-"))
					JOptionPane.showMessageDialog(null, "One negation per number please! Sheesh.");
			else {
				if(displaycontent.equals("")) {
					setDisplayContent("-");
					display.setText(displaycontent);
				}
				else {
					JOptionPane.showMessageDialog(null, "The negation sign doesn't go there silly!");
				}
				
			}
			}});
		
		
		
//		********CONTROL BUTTONS******************
//		*****************************************
		
		
		buttonPush.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			if(displaycontent.equals(""))
					JOptionPane.showMessageDialog(null, "Please enter a value");
			else {
			try {
			stack.push(Double.parseDouble(getDisplayContent()));
			}
			catch (StackFullException x ){
				x.explainWhy();
			}
			stack.makeStackList();
			stacklist.setText("Stack Contents: \n " + stack.getStackList());
			setDisplayContent("");
			display.setText(displaycontent);
			}//else
			
			
			}});
		
		buttonPop.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			String topOfStack = "";
			try {
			topOfStack = Double.toString(stack.pop()); //converts top of stack to a string 
			}
			catch (EmptyStackException x) {
				JOptionPane.showMessageDialog(null, "Nothing in the stack");
			}
			stack.makeStackList();
			setDisplayContent(topOfStack);
			stacklist.setText("Stack Contents: \n " + stack.getStackList());
			display.setText(displaycontent);
			setDisplayContent("");
			
			
			
			}});
		
		buttonDelete.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			setDisplayContent(displaycontent.substring(0, displaycontent.length()-1));
			display.setText(displaycontent);
			
			
			}});
		buttonClearAll.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			stack.destroy();
			stack.makeStackList();
			stacklist.setText(stack.getStackList());
			setDisplayContent("");
			display.setText(displaycontent);
			
			}});
		
		
//		*******OPERATION BUTTONS************
//		************************************
//		these buttons will set an operation number to a certain value 		
		
		
		
		buttonAdd.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(1);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);
		}});
		
		buttonSub.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(2);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);
		}});
		buttonMul.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(3);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);
		}});
		buttonDiv.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(4);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);;
			stack.makeStackList(); //used to correct for division by 0
			stacklist.setText("Stack Contents: \n " + stack.getStackList());
		}});
		buttonSin.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(5);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);
		}});
		buttonCos.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(6);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);
		}});
		buttonTan.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(7);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);
		}});
		buttonNaturalLog.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(8);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);;
			
		}});
		buttonLogBase10.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(9);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);;
		}});
		buttonSqrt.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(10);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);;
		}});
		buttonEtoPowerX.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(11);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);
		}});
		buttonExponentY.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(12);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);;
		}});
		buttonSquare.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
			setDisplayContent("");
			stack.operation(13);
			setDisplayContent(stack.getOperationResult());
			display.setText(displaycontent);
		}});
		
		buttonDiv.setToolTipText("<html><b>Dividing by Zero will remove 0 from stack!</b></html>");
		
		
		//String input = stacklist.getText();
		
		
		add(allButtons, BorderLayout.CENTER);
		add(display, BorderLayout.PAGE_START);
		add(scroll, BorderLayout.LINE_START);//didnt need to add text area because its already added in by scrollpane
		
		setSize(600,600);
		setTitle("Stack Calculator");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	public static void main(String [] args) throws StackFullException, EmptyStackException {
		Stack stackobj = new Stack(20); //20 is the max size for the stack
		StackCalcMain theWindow = new StackCalcMain(stackobj);
	}

}
