package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import control.CChangePw;
import global.Constants.EChangePw;
import global.Constants.EFindData;
import global.Constants.EFindResult;
import global.Constants.EImageName;
import global.Constants.ELoginDialog;

public class ChangePw extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JLabel passwordLable;
	private JTextField passwordText;
	private JLabel checkPWLable;
	private JTextField ckeckPWText;
	private JButton okButton;
	private JButton cancleButton;
	private CChangePw cChangePw;
	private String id;

	public ChangePw(String id) {
		this.id = id;
		this.setSize(EChangePw.width.getInt(),EChangePw.height.getInt());		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(
				dim.width/2 -this.getSize().width/2, 
				dim.height/2 -this.getSize().height/2);

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// components
		this.setLayout(new FlowLayout());		
		ActionHandler actionHandler = new ActionHandler();

		JPanel panel1 = new JPanel();
		passwordLable= new JLabel(EChangePw.passwordLable.getString());
		panel1.add(passwordLable);
		passwordText=new JTextField(EChangePw.passwordTextSize.getInt());
		passwordText.registerKeyboardAction(actionHandler, EChangePw.OkButton.getString(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED); 
		panel1.add(passwordText);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		checkPWLable= new JLabel(EChangePw.checkPWLable.getString());
		panel2.add(checkPWLable);
		ckeckPWText= new JTextField(EChangePw.ckeckPWTextSize.getInt());
		ckeckPWText.registerKeyboardAction(actionHandler, EChangePw.OkButton.getString(), KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED); 
		panel2.add(ckeckPWText);
		this.add(panel2);
		
		ImageIcon ok = new ImageIcon(EImageName.ok.getString());
		ImageIcon cancel = new ImageIcon(EImageName.cancel.getString());
		
		JPanel panel3 = new JPanel();
		okButton= new JButton(EChangePw.OkButton.getString(), ok);
		okButton.addActionListener(actionHandler);
		okButton.setActionCommand(EChangePw.OkButton.getString());	
		panel3.add(okButton);
		
		cancleButton= new JButton(EChangePw.CancleButton.getString(), cancel);
		cancleButton.addActionListener(actionHandler);
		cancleButton.setActionCommand(EChangePw.CancleButton.getString());
		panel3.add(cancleButton);
		this.add(panel3);
		
		this.setVisible(true);
	}
	private void Change() {
		String passWord = passwordText.getText();
		String checkPassWord = ckeckPWText.getText();
			if(passWord.equals(checkPassWord)) {
				try {
					this.cChangePw = new CChangePw();				
					this.cChangePw.Change(passWord, this.id);
					JOptionPane.showMessageDialog(this,EChangePw.successMessage.getString(), EChangePw.success.getString(),JOptionPane.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(this,EChangePw.errormessage.getString(), EFindResult.error.getString(),JOptionPane.INFORMATION_MESSAGE);
			}
		}

		private void Cancle() {
			this.dispose();			
		}
	private class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand().equals(EChangePw.OkButton.getString())) {
				Change();
			}else if(event.getActionCommand().equals(EChangePw.CancleButton.getString())) {
				Cancle();
			}
		}

		
	}
}
