import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
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

		
		this.setSize(Constants.MAIN_W-100, Constants.MAIN_H-400);
		this.setLocation(Constants.MAIN_X, Constants.MAIN_Y);		
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel pannel1 = new JPanel();
		pannel1.setLayout(new BoxLayout(pannel1, BoxLayout.X_AXIS));
		pannel1.setPreferredSize(new Dimension(0, 10));
		
		nameLable= new JLabel("이름");
		pannel1.add(nameLable);
		nameText=new JTextField(20);
		pannel1.add(nameText);
		this.add(pannel1);
		
		JPanel pannel2 = new JPanel();
		pannel2.setPreferredSize(new Dimension(0, 10));
		pannel2.setLayout(new BoxLayout(pannel2, BoxLayout.X_AXIS));
		passwordLable= new JLabel("비밀번호");
		pannel2.add(passwordLable);
		passwordText= new JTextField(20);
		pannel2.add(passwordText);
		this.add(pannel2);
		
		JPanel pannel3 = new JPanel();
		pannel3.setPreferredSize(new Dimension(0, 70));
		pannel3.setLayout(new BoxLayout(pannel3, BoxLayout.X_AXIS));
		okButton= new JButton("OK");
		pannel3.add(okButton);
		cancleButton= new JButton("cancle");
		pannel3.add(cancleButton);
		this.add(pannel3);
	}

}
