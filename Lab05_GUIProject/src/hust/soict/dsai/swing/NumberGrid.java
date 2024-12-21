package hust.soict.dsai.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NumberGrid extends JFrame{
	private JButton[] btnNumbers = new JButton[10];
	private JButton btnReset, btnDelete;
	private JTextField tfDisplay;
	
	public NumberGrid() {
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		tfDisplay.setPreferredSize(new Dimension(200, 50)); 
		 
		JPanel panelButtons = new JPanel(new GridLayout(4,3));
		addButtons(panelButtons);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelButtons, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Number Grid");
		setSize(300, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	void addButtons(JPanel panelButtons) {
		ButtonListener btnListener = new ButtonListener(tfDisplay);
		for(int i = 1; i <= 9; i++) {
			btnNumbers[i] = new JButton(""+i);
			panelButtons.add(btnNumbers[i]);
			btnNumbers[i].addActionListener(btnListener);
		}
		btnDelete = new JButton("DEL");
		panelButtons.add(btnDelete);
		btnDelete.addActionListener(btnListener);
		
		btnNumbers[0] = new JButton("0");
		panelButtons.add(btnNumbers[0]);
		btnNumbers[0].addActionListener(btnListener);
		
		btnReset = new JButton("C");
		panelButtons.add(btnReset);
		btnReset.addActionListener(btnListener);
	}
	public static void main(String[] args) {
		new NumberGrid();
	}
}
