import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	private LoginDialog loginDialog;
	
	//constructor
	private Cregister cregister;
	
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
		this.mainPanel = new JPanel();
		this.add(this.mainPanel);
		
		//child window
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog = new LoginDialog(this, actionHandler);
		this.loginDialog.setVisible(true);
	}
	
	private String register(String ID) throws FileNotFoundException {
		this.cregister = new Cregister();
		String name = cregister.getData(ID);
		
		return name;
	}
	
	class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent actionEvent) {	
			if(actionEvent.getActionCommand().equals("OK")) {
				String ID =loginDialog.validateUser();
				if(ID != null) {
				loginDialog.dispose();
				String name = null;
				try {
					name = register(ID);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, name+"님 어서오세요", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}else if(actionEvent.getActionCommand().equals("cancle")) {
				loginDialog.cancle();
				dispose();
			}
		}	
	}
}
