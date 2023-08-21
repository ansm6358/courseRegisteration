import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
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
	
	public LoginDialog(MainFrame mainFrame) {
		super(mainFrame);
			
		String id= "13579";
		String pw= "02468";	
		int x = mainFrame.getX() + mainFrame.getWidth()/2;
		int y = mainFrame.getY() + mainFrame.getHeight()/2;
		
		ImageIcon ok = new ImageIcon("puppy_ok.png");
		ImageIcon cancel = new ImageIcon("puppy_no.png");
		
		
		this.setSize(400,200);
		this.setLocation(x- this.getWidth()/2, y - this.getHeight()/2);
		this.setLayout(new GridLayout(5,2));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		JPanel panel0 = new JPanel();
		panel0.setLayout(new GridLayout(0,2));
		JLabel start = new JLabel();
		panel0.add(start);
		this.add(panel0);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0,2));
		nameLable= new JLabel(" 아이디  ");
		panel1.add(nameLable);
		nameText=new JTextField(15);
		panel1.add(nameText);
		this.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0,2));
		passwordLable= new JLabel("비밀번호");
		panel2.add(passwordLable);
		passwordText= new JTextField(15);
		panel2.add(passwordText);
		this.add(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(0,2));
		okButton= new JButton("OK",ok);
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String getID = nameText.getText();
				String getPW = passwordText.getText();
				System.out.println("아이디:" +getID);
				System.out.println("비밀번호:" +getPW);
			if(id.equals(getID)&&pw.equals(getPW)) {
				System.out.println("로그인 성공");
			}
			
			else if(!(id.equals(getID))&&pw.equals(getPW)){
				System.out.println("아이디가 틀렸습니다");
			}
			else if(id.equals(getID)&&!(pw.equals(getPW))) {
				System.out.println("패스워드가 틀렸습니다");
			}
			else if(!(id.equals(getID))&&!(pw.equals(getPW))) {
				System.out.println("아이디가 틀렸습니다");
				System.out.println("패스워드가 틀렸습니다");
			}
			}
		});
		
		panel3.add(okButton);
		cancleButton= new JButton("cancle",cancel);
		cancleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancleButton.addActionListener(null);
		panel3.add(cancleButton);
		this.add(panel3);
	}

}
