package calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/*
Given the User Interface provided, complete the functionality of the Calculator
to be able to perform these operations:
+ addition
- subtraction
x multiplication
/ division
% modulo (reminder)
+/- changing sign (from plus to minus and minus to plus)
C clear entry

The program will append to the first operand while entering numeric keys (0-9),
get the first operand when and operator key (+, -, x ,/ ) is pressed ,
get the second operand when the = key is pressed,
then compute the operation and display.

To get the value of a JTextField, use: textField.getText(),
to set its value, use: textField.setText()
 */

public class CalculatorActionListener implements ActionListener{
	String value1, value2;
	String operator;
	int v1, v2, result;

	private JTextField textField;

	public CalculatorActionListener(JTextField textField) {
		this.textField = textField;
	}
	
	public void evaluateValues() {
		switch(operator) {
		case "x":
			v1 = Integer.parseInt(value1);
			v2 = Integer.parseInt(value2);
			result = v1*v2;
			break;
		case "/":
			if (value2.equals("0")) {
				System.out.println("Result is UNDEFINED. Cannot divide by 0");
			} else {
				v1 = Integer.parseInt(value1);
				v2 = Integer.parseInt(value2);
				result = v1/v2;
			}
			break;
		case "+":
			v1 = Integer.parseInt(value1);
			v2 = Integer.parseInt(value2);
			result = v1+v2;
			break;
		case "-":
			v1 = Integer.parseInt(value1);
			v2 = Integer.parseInt(value2);
			result = v1-v2;
			break;
		case "%":
			v1 = Integer.parseInt(value1);
			v2 = Integer.parseInt(value2);
			result = v1%v2;
			break;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent: " + e.getActionCommand());
		//switch (e.getActionCommand()) {
		// ...
		
		switch(e.getActionCommand()) {
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9": 
				textField.setText(textField.getText()+e.getActionCommand());
				break;
			case "x":
			case "/":
			case "+":
			case "-":
			case "%":
				if (textField.getText().isEmpty()==true) {
					System.out.println("Please enter a number.");
				} else {
					value1 = textField.getText();
					textField.setText(null);
					operator = e.getActionCommand();
				}
				break;
			case "U":
				if (textField.getText().charAt(0)=='-') {
					textField.setText(textField.getText().substring(1));
				} else {
					textField.setText("-" + textField.getText());
				}
				break;			
			case "=":
				if (textField.getText().isEmpty()==true) {
					System.out.println("Please enter a number.");
				} else {
					value2 = textField.getText();
					evaluateValues();
					textField.setText(Integer.toString(result));
				}
				break;
			case "C":
				value1 = null;
				value2 = null;
				textField.setText(null);
				break;		
			default: 
				System.out.println("Try again.");
				break;
		}
	}
}