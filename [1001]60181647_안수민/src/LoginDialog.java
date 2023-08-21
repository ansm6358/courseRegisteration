import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	//components
	private JLabel nameLable;
	private JTextField nameText;
	private JLabel passwordLable;
	private JTextField passwordText;
	private JButton okButton;
	private JButton cancleButton;
	private JDialog nextScreen;
	//association
	private CLogin cLogin;
	
	public LoginDialog(MainFrame mainFrame) {
		super(mainFrame);
		
		//attributes
		int x = mainFrame.getX() + mainFrame.getWidth()/2;
		int y = mainFrame.getY() + mainFrame.getHeight()/2;
		
		this.setSize(400,200);
		this.setLocation(x- this.getWidth()/2, y - this.getHeight()/2);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// components
		ActionListener actionHandler = new ActionHandler();
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
	
	public void validateUser() throws FileNotFoundException {
		String textID = nameText.getText();
		String textPW = passwordText.getText();
		
		this.cLogin = new CLogin();
		boolean result = cLogin.valudateUser(textID,textPW);
		
		if(result) {
			System.out.print("성공");
			NextScreen();
			
		} else {
			System.out.print("실패");
			ShowDialog();
			
		}
		
	}
		
	private void ShowDialog() {
		JDialog failDialog = new JDialog(this);
		ActionListener actionHandler = new ActionHandler();
		JLabel failLabel;
		JButton retryButton;
		int x = this.getX() + this.getWidth()/2;
		int y = this.getY() + this.getHeight()/2;
		
		failDialog.setSize(300,150);
		failDialog.setLocation(x- failDialog.getWidth()/2, y - failDialog.getHeight()/2);
		failDialog.setLayout(new FlowLayout());
		failDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JPanel failPanel = new JPanel();
		failLabel = new JLabel("아이디 또는 비밀번호가 틀렸습니다.");
		failDialog.add(failLabel);
		
		retryButton = new JButton("retry");
		retryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				failDialog.dispose();
			}
		});
		retryButton.setActionCommand("retry");
		failPanel.add(retryButton);
		
		cancleButton = new JButton("cancle");
		cancleButton.addActionListener(actionHandler);
		cancleButton.setActionCommand("cancle");
		failPanel.add(cancleButton);
		failDialog.add(failPanel);
		failDialog.setVisible(true);
		
	}

	private void NextScreen() {
		JDialog nextScreen = new JDialog(this);
		int x = this.getX() + this.getWidth()/2;
		int y = this.getY() + this.getHeight()/2;
		
		nextScreen.setSize(300,150);
		nextScreen.setTitle("Next Screen");
		nextScreen.setLocation(x- nextScreen.getWidth()/2, y - nextScreen.getHeight()/2);
		nextScreen.setLayout(new FlowLayout());
		nextScreen.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		nextScreen.setVisible(true);
	}

	class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent actionEvent) {	
			if(actionEvent.getActionCommand().equals("OK")) {
				try {
					validateUser();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(actionEvent.getActionCommand().equals("cancle")) {
				System.out.println("cancle");
				disposeLoginDiallog();
				
			}
		}

		private void disposeLoginDiallog() {
			dispose();			
		}
		
	}


}
