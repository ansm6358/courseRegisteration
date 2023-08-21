package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		this.personalInfo = new PersonalInfo();
		this.personalInfo.setBackground(Color.CYAN);
		this.personalInfo.setPreferredSize(new Dimension(0, Constants.MAIN_H*1/20));
		this.add(this.personalInfo, BorderLayout.NORTH);
		
		this.toolBar = new ToolBar();
		this.toolBar.setBackground(Color.GREEN);
		this.add(this.toolBar, BorderLayout.CENTER);
		
		this.registration = new Registration();
		this.registration.setBackground(Color.CYAN);
		this.registration.setPreferredSize(new Dimension(0, Constants.MAIN_H*3/4));
		this.add(this.registration, BorderLayout.SOUTH);
		
		//child window
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog = new LoginDialog(this, actionHandler);
		this.loginDialog.setVisible(true);
	}
	
	private void register(String id) {
		this.personalInfo.showPersonalInfo(id);
	}
	
	private void loginOK() {
		String id =loginDialog.validateUser();
				if(id != null) {
				loginDialog.dispose();
				register(id);
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
				loginOK();
				
				
			}else if(actionEvent.getActionCommand().equals("cancle")) {
				loginCancle();
			}
		}	
	}
}
