import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JLabel nameLable;
	private JTextField nameText;
	private JLabel passwordLable;
	private JTextField passwordText;
	private JButton okButton;
	private JButton cancleButton;
	private JPanel mainPanel;
	
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
		nameLable= new JLabel(" ���̵�  ");
		panel1.add(nameLable);
		nameText=new JTextField(15);
		panel1.add(nameText);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		passwordLable= new JLabel("��й�ȣ");
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
	public void aggregation(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}	
	public void changeColor(String selectColor) {
		if(selectColor=="blue") {
			this.mainPanel.setBackground(Color.blue);
		}
		else if(selectColor=="red") {
			this.mainPanel.setBackground(Color.red);
		}
		else if(selectColor=="white") {
			this.mainPanel.setBackground(Color.white);
		}
		else if(selectColor=="black") {
			this.mainPanel.setBackground(Color.black);
		}
		else if(selectColor=="green") {
			this.mainPanel.setBackground(Color.green);
		}
		
	}
	
	class ActionHandler implements ActionListener{
		String selectColor;
		@Override
		public void actionPerformed(ActionEvent actionEvent) {	
			if(actionEvent.getActionCommand().equals("OK")) {
				try {
				selectColor = checkLogin();	
				dispose();
				changeColor(selectColor);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}
			else if(actionEvent.getActionCommand().equals("cancle")) {
				dispose();
				selectColor = "red";
				changeColor(selectColor);
			}
		}
		
		private String checkLogin() throws FileNotFoundException {
			
			String getID = nameText.getText();
			String getPW = passwordText.getText();
			System.out.println("���̵�:" +getID);
			System.out.println("��й�ȣ:" +getPW);
			String id;
			String pw;
			String check = null;
			
			File file = new File("information.txt");
			Scanner sc = new Scanner(file);
			String comId = sc.next();
			String comPw = sc.next();;
			
				id = sc.next();
				pw = sc.next();
		if(id.equals(getID)&&pw.equals(getPW)) {
			System.out.println("�α��� ����");
			check="blue";
		}
		
		else if(!(id.equals(getID))&&pw.equals(getPW)){
			System.out.println("���̵� Ʋ�Ƚ��ϴ�");
			check="white";
		}
		else if(id.equals(getID)&&!(pw.equals(getPW))) {
			System.out.println("�н����尡 Ʋ�Ƚ��ϴ�");
			check="black";
		}
		else if(!(id.equals(getID))&&!(pw.equals(getPW))) {
			System.out.println("���̵� Ʋ�Ƚ��ϴ�");
			System.out.println("�н����尡 Ʋ�Ƚ��ϴ�");
			check="green";
		}
		return check;
		}
		
	}

	

}
