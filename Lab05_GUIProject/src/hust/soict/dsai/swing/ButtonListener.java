package hust.soict.dsai.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
public class ButtonListener implements ActionListener {
	private JTextField tfDisplay;
	
	public ButtonListener(JTextField tfDisplay) {
        this.tfDisplay = tfDisplay;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		
		if(button.charAt(0) >= '0' && button.charAt(0) <= '9') {
			tfDisplay.setText(tfDisplay.getText() + button);
		}
		else if (button.equals("DEL")) {
			String text = tfDisplay.getText();
			if(text.length() > 0) {
				tfDisplay.setText(text.substring(0, text.length() - 1));
			}
		} else {
			tfDisplay.setText(""); //Reset	
		}
	}
}
