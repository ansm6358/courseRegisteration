package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CLogin;
import global.Constants.GLoginDialog;
import global.Constants.TLoginDialog;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	//components
	private JLabel nameLable;
	private JTextField nameText;
	private JLabel passwordLable;
	private JTextField passwordText;
	private JButton okButton;
	private JButton cancleButton;
	//association
	private CLogin cLogin;
	
	public LoginDialog(ActionListener actionHandler) {
		
		//attributes
		this.setSize(GLoginDialog.gWidth.getInt(),GLoginDialog.gHeight.getInt());		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(
				dim.width/2 -this.getSize().width/2, 
				dim.height/2 -this.getSize().height/2);

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// components
		this.setLayout(new FlowLayout());		
		
		JPanel panel1 = new JPanel();
		nameLable= new JLabel(TLoginDialog.tNameLable.getString());
		panel1.add(nameLable);
		nameText=new JTextField(GLoginDialog.gNameTextSize.getInt());
		panel1.add(nameText);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		passwordLable= new JLabel(TLoginDialog.tPasswordLable.getString());
		panel2.add(passwordLable);
		passwordText= new JTextField(GLoginDialog.gPasswordTextSize.getInt());
		panel2.add(passwordText);
		this.add(panel2);
		
		JPanel panel3 = new JPanel();
		okButton= new JButton(TLoginDialog.tOkButton.getString());
		okButton.addActionListener(actionHandler);
		okButton.setActionCommand(TLoginDialog.tOkButton.getString());	
		panel3.add(okButton);
		
		cancleButton= new JButton(TLoginDialog.tCancleButton.getString());
		cancleButton.addActionListener(actionHandler);
		cancleButton.setActionCommand(TLoginDialog.tCancleButton.getString());
		panel3.add(cancleButton);
		this.add(panel3);
	}
	
	public void initialize() {
	}
	
	public String validateUser() {
		String ID = nameText.getText();
		String password = passwordText.getText();
		
		this.cLogin = new CLogin();
		boolean result = cLogin.valudateUser(ID,password);
		if(result) {
			return ID;
		} else {
			JOptionPane.showMessageDialog(this,TLoginDialog.tFailMessage.getString(),TLoginDialog.tFailTitle.getString() ,JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
		
	}
	public void cancle() {

	}

	
	

}
