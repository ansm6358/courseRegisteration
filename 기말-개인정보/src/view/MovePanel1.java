package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MovePanel1 extends JPanel {

	private JButton leftButton;
	private JButton rightButton;
	
	public MovePanel1(ActionListener actionListener) {
		this.leftButton = new JButton("<");
		this.leftButton.setActionCommand("leftButton");
		this.leftButton.addActionListener(actionListener);
		this.add(this.leftButton);
		
		this.rightButton = new JButton(">");
		this.rightButton.setActionCommand("rightButton");
		this.rightButton.addActionListener(actionListener);
		this.add(this.rightButton);
	}
	
	public void initialize() {
		
	}
}
