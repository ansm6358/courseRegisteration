import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	

	private LoginDialog loginDialog;
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
		this.registration = new Registration(this);
		this.add(this.registration);
		
		//child window
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog = new LoginDialog(this, actionHandler);
		this.loginDialog.setVisible(true);
	}
	
	private void register(String ID) {

	}
	
	private void loginOK() {
		String ID =loginDialog.validateUser();
				if(ID != null) {
				loginDialog.dispose();
				register(ID);
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
