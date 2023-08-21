package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import global.Constants.EMovePanel;

public class MovePanel extends JPanel {

	private JButton leftButton;
	private JButton rightButton;
	
	public JButton getLeftButton() {
		return leftButton;
	}

	public JButton getRightButton() {
		return rightButton;
	}

	public MovePanel(ActionListener actionListener) {
		this.leftButton = new JButton(EMovePanel.left.getString());
		this.leftButton.setActionCommand(EMovePanel.leftButton.getString());
		this.leftButton.addActionListener(actionListener);
		this.add(this.leftButton);
		
		this.rightButton = new JButton(EMovePanel.right.getString());
		this.rightButton.setActionCommand(EMovePanel.rightButton.getString());
		this.rightButton.addActionListener(actionListener);
		this.add(this.rightButton);
	}
	
	public void initialize() {
		
	}
}
