package view;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
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
import global.Constants.EFindData;
import global.Constants.EImageName;
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
	private JButton clock;
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

		ImageIcon ok = new ImageIcon(EImageName.ok.getString());
		ImageIcon cancel = new ImageIcon(EImageName.cancel.getString());
		ImageIcon clockImage = new ImageIcon(EImageName.clock.getString());
		
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
		okButton= new JButton(ELoginDialog.OkButton.getString(), ok);
		okButton.addActionListener(actionHandler);
		okButton.setActionCommand(ELoginDialog.OkButton.getString());	
		panel3.add(okButton);
		
		cancleButton= new JButton(ELoginDialog.CancleButton.getString(), cancel);
		cancleButton.addActionListener(actionHandler);
		cancleButton.setActionCommand(ELoginDialog.CancleButton.getString());
		panel3.add(cancleButton);
		
		MouseHandler mouseHandler = new MouseHandler();		
		clock = new JButton();
		clock.setIcon(clockImage);	
		clock.setBorderPainted(false); 
		clock.setContentAreaFilled(false);
		clock.addMouseListener(mouseHandler);
		panel3.add(clock);
		this.add(panel3);
		
		
		JPanel panel4 = new JPanel();  // 추가기능
		findId = new JButton(EFindData.findId.getString()); 
		findId.setBorderPainted(false); 
		findId.setContentAreaFilled(false);
		findId.addActionListener(actionHandler); 
		findId.setActionCommand(EFindData.CheckId.getString());
		panel4.add(findId); // 추가기능
		
		findPw = new JButton(EFindData.findPw.getString()); // 추가기능
		findPw.setBorderPainted(false);
		findPw.setContentAreaFilled(false);
		findPw.addActionListener(actionHandler);
		findPw.setActionCommand(EFindData.CheckPw.getString());
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

	private class MouseHandler implements MouseListener{	
		@Override
		public void mouseClicked(MouseEvent arg0) {}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			
			Date today = new Date();	        
		    SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		    SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");	        	    
			clock.setToolTipText("날짜: "+date.format(today)+" "+"시간: "+time.format(today));
		}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
}
