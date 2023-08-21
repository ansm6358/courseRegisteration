package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import control.CFindData;
import global.Constants.EFindData;
import global.Constants.EFindResult;
import global.Constants.EImageName;
import global.Constants.ELoginDialog;

public class FindData extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel nameLable;
	private JTextField nameText;
	private JLabel IdLable;
	private JTextField IdText;
	private JLabel passwordLable;
	private JTextField passwordText;
	private JButton okButton;
	private JButton cancleButton;
	
	private CFindData cFindData;
	private ChangePw changePw;
	
	
	public FindData(String target) {
		this.setSize(EFindData.width.getInt(),EFindData.height.getInt());		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(
				dim.width/2 -this.getSize().width/2, 
				dim.height/2 -this.getSize().height/2);

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		ActionHandler actionHandler = new ActionHandler();

		if(target.equals(EFindData.CheckId.getString())) {
			JPanel panel1 = new JPanel();
			passwordLable= new JLabel(EFindData.PasswordLable.getString());
			panel1.add(passwordLable);
			passwordText=new JTextField(EFindData.PasswordTextSize.getInt());
			passwordText.registerKeyboardAction(actionHandler, target, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED); 
			panel1.add(passwordText);
			this.add(panel1);
		}else if(target.equals(EFindData.CheckPw.getString())) {
			JPanel panel1 = new JPanel();
			IdLable= new JLabel(EFindData.IdLable.getString());
			panel1.add(IdLable);
			IdText=new JTextField(EFindData.IdTextSize.getInt());
			IdText.registerKeyboardAction(actionHandler, target, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED); 
			panel1.add(IdText);
			this.add(panel1);
		}

		JPanel panel2 = new JPanel();
		nameLable= new JLabel(EFindData.NameLable.getString());
		panel2.add(nameLable);
		nameText= new JTextField(EFindData.NameTextSize.getInt());
		nameText.registerKeyboardAction(actionHandler, target, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED); 
		panel2.add(nameText);
		this.add(panel2);
		
		ImageIcon ok = new ImageIcon(EImageName.ok.getString());
		ImageIcon cancel = new ImageIcon(EImageName.cancel.getString());
		
		JPanel panel3 = new JPanel();
		okButton= new JButton(EFindData.OkButton.getString(), ok);
		okButton.addActionListener(actionHandler);
		okButton.setActionCommand(target);	
		panel3.add(okButton);
		
		cancleButton= new JButton(EFindData.CancleButton.getString(), cancel);
		cancleButton.addActionListener(actionHandler);
		cancleButton.setActionCommand(EFindData.CancleButton.getString());
		panel3.add(cancleButton);
		this.add(panel3);
		this.setVisible(true);
	}

	public void findId() {		
		String password = passwordText.getText();
		String name = nameText.getText();
		
		this.cFindData = new CFindData();
		String result = cFindData.findId(password,name);
		if(result != null) {
			JOptionPane.showMessageDialog(this,EFindResult.findMessage.getString()+result, EFindResult.find.getString(),JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this,EFindResult.errormessage.getString(), EFindResult.error.getString(),JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void findPw() {
		String ID = IdText.getText();
		String name = nameText.getText();
		
		this.cFindData = new CFindData();
		String result = cFindData.findPw(ID,name);
		if(result != null) {
			this.dispose();
			this.changePw = new ChangePw(ID);
		} else {
			JOptionPane.showMessageDialog(this,EFindResult.errormessage.getString(), EFindResult.error.getString(),JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	private void findCancle() {
		this.dispose();
		
	}
	private class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent target) {
			if(target.getActionCommand().equals(EFindData.CheckId.getString())) {
				findId();
			}
			else if(target.getActionCommand().equals(EFindData.CheckPw.getString())) {
				findPw();			
			}else if(target.getActionCommand().equals(EFindData.CancleButton.getString())) {
				findCancle();
			}
		}

		
	}
}
