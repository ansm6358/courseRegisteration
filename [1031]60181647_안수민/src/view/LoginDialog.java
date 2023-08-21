package view;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.CLogin;

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
	
	public LoginDialog(MainFrame mainFrame, ActionListener actionHandler) {
		super(mainFrame);
		
		//attributes
		int x = mainFrame.getX() + mainFrame.getWidth()/2;
		int y = mainFrame.getY() + mainFrame.getHeight()/2;
		
		this.setSize(400,200);
		this.setLocation(x- this.getWidth()/2, y - this.getHeight()/2);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// components
		JPanel panel1 = new JPanel();
		nameLable= new JLabel(" 아이디  ");
		panel1.add(nameLable);
		nameText=new JTextField(15);
		panel1.add(nameText);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		passwordLable= new JLabel("비밀번호");
		panel2.add(passwordLable);
		passwordText= new JTextField(15);
		panel2.add(passwordText);
		this.add(panel2);
		
		JPanel panel3 = new JPanel();
		okButton= new JButton("OK");
		okButton.addActionListener(actionHandler);
		okButton.setActionCommand("OK");	
		panel3.add(okButton);
		
		cancleButton= new JButton("cancle");
		cancleButton.addActionListener(actionHandler);
		cancleButton.setActionCommand("cancle");
		panel3.add(cancleButton);
		this.add(panel3);
	}
	
	public String validateUser() {
		String ID = nameText.getText();
		String password = passwordText.getText();
		
		this.cLogin = new CLogin();
		boolean result = cLogin.valudateUser(ID,password);
		if(result) {
			return ID;
		} else {
			JOptionPane.showMessageDialog(this,"틀렸습니다.", "로그인실패",JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
		
	}
	public void cancle() {

	}
	

}
