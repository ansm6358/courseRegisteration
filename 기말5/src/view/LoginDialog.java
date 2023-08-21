package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import control.CLogin;
import global.Constants.EErrorDialog;
import global.Constants.ELoginDialog;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	//components
	private JLabel nameLable;
	private JTextField nameText;
	private JLabel passwordLable;
	private JTextField passwordText;
	private JButton okButton;
	private JButton cancleButton;
	private JButton findId; // 추가기능
	private JButton findPw; //추가 기능
	//association
	private CLogin cLogin;
	private FindData findData;
	public LoginDialog(ActionListener actionHandler) {
		
		//attributes
		this.setSize(ELoginDialog.width.getInt(),ELoginDialog.height.getInt());		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(
				dim.width/2 -this.getSize().width/2, 
				dim.height/2 -this.getSize().height/2);

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// components
		this.setLayout(new FlowLayout());		
		
		JPanel panel1 = new JPanel();
		nameLable= new JLabel(ELoginDialog.NameLable.getString());
		panel1.add(nameLable);
		nameText=new JTextField(ELoginDialog.NameTextSize.getInt());
		nameText.registerKeyboardAction(actionHandler, ELoginDialog.OkButton.getString(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED); 
		panel1.add(nameText);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		passwordLable= new JLabel(ELoginDialog.PasswordLable.getString());
		panel2.add(passwordLable);
		passwordText= new JTextField(ELoginDialog.PasswordTextSize.getInt());
		passwordText.registerKeyboardAction(actionHandler, ELoginDialog.OkButton.getString(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED); 
		panel2.add(passwordText);
		this.add(panel2);
		
		JPanel panel3 = new JPanel();
		okButton= new JButton(ELoginDialog.OkButton.getString());
		okButton.addActionListener(actionHandler);
		okButton.setActionCommand(ELoginDialog.OkButton.getString());	
		panel3.add(okButton);
		
		cancleButton= new JButton(ELoginDialog.CancleButton.getString());
		cancleButton.addActionListener(actionHandler);
		cancleButton.setActionCommand(ELoginDialog.CancleButton.getString());
		panel3.add(cancleButton);
		this.add(panel3);
		
		
		JPanel panel4 = new JPanel();  // 추가기능
		findId = new JButton("아이디 찾기"); 
		findId.setBorderPainted(false); 
		findId.setContentAreaFilled(false);
		findId.addActionListener(actionHandler); 
		findId.setActionCommand("findId");
		panel4.add(findId); // 추가기능
		
		findPw = new JButton("비밀번호 찾기"); // 추가기능
		findPw.setBorderPainted(false);
		findPw.setContentAreaFilled(false);
		findPw.addActionListener(actionHandler);
		findPw.setActionCommand("findPw");
		panel4.add(findPw);
		this.add(panel4); // 추가기능
		
		this.setVisible(true);
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
			JOptionPane.showMessageDialog(this,EErrorDialog.message.getString(), EErrorDialog.title.getString(),JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
		
	}
	public void cancle() {

	}

	public void findData(String target) {
		this.findData = new FindData(target);
	}

}
