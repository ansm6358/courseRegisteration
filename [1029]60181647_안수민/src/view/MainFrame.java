package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import global.Constants;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	

	private LoginDialog loginDialog;
	private PersonalInfo personalInfo;
	private ToolBar toolBar;

	private Registration registration;
	
	//constructor
	public MainFrame() {
		//attributes
		this.setTitle(Constants.MAIN_TITLE); 
		this.setSize(Constants.MAIN_W, Constants.MAIN_H);		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(
				dim.width/2 -this.getSize().width/2, 
				dim.height/2 -this.getSize().height/2);
		this.setLayout(new BorderLayout(10, 10));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//components
		this.personalInfo = new PersonalInfo();
		this.setPreferredSize(new Dimension(0, Constants.MAIN_H/10));
		this.add(this.personalInfo, BorderLayout.NORTH);
		
		this.toolBar = new ToolBar(this);
		this.add(this.toolBar);
		
		this.registration = new Registration();
		this.add(this.registration);
		
		//child window
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog = new LoginDialog(this, actionHandler);
		this.loginDialog.setVisible(true);
	}
	
	private void register(String ID) {
		
	}
	
	private void loginOK() throws FileNotFoundException {
		String ID =loginDialog.validateUser();
				if(ID != null) {
				loginDialog.dispose();
				this.personalInfo.getPersinalInfo(ID);
				
				}
			}
	private void loginCancle() {
			loginDialog.cancle();
				loginDialog.dispose();		
	}
	
	class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent actionEvent) {	
			if(actionEvent.getActionCommand().equals("OK")) {
				try {
					loginOK();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else if(actionEvent.getActionCommand().equals("cancle")) {
				loginCancle();
			}
		}	
	}
}
