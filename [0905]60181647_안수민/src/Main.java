import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	
	private JFrame mainFrame;
	
	public Main() {
		this.mainFrame = new JFrame();
		this.mainFrame.setTitle("������û");
		this.mainFrame.setSize(700, 400);
		this.mainFrame.setLocationRelativeTo(null);
		this.mainFrame.setVisible(true);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		JFrame Login_gui = new JFrame();
		Login_gui.setTitle("�α���â");
		Login_gui.setSize(350, 200);
		Login_gui.setLayout(new GridLayout(2,1,30,30));
		Login_gui.setLocationRelativeTo(null);
		Login_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel PanelL = new JPanel();
		PanelL.setLayout(new GridLayout(2,0));
		Login_gui.add(PanelL);
		
		JPanel PanelT = new JPanel();
		PanelT.setLayout(new GridLayout(2,0));
		Login_gui.add(PanelT);
		
		JPanel PanelB = new JPanel();
		PanelB.setLayout(new GridLayout(2,1));
		Login_gui.add(PanelB);

		JPanel PanelB2 = new JPanel();
		PanelB2.setLayout(new GridLayout(2,1));
		Login_gui.add(PanelB2);
		
		JButton Login = new JButton("Login");
		PanelB.add(Login);
		JButton Cancle = new JButton("Cancle");
		PanelB2.add(Cancle);
		
		JLabel ID = new JLabel("                        ���̵�");
		JLabel Password = new JLabel("                        ��й�ȣ");
		PanelL.add(ID);
		PanelL.add(Password);
		
		JTextField IDBox = new JTextField("���̵�");
		JTextField passwordBox = new JTextField("��й�ȣ");
		PanelT.add(IDBox);
		PanelT.add(passwordBox);
		
		Login_gui.setVisible(true);
	}
	

	public static void main(String[] args) { //os�� ���⼭ ���� �����϶�� �� //�� Ŭ������ �������� �˷����� ���� ����
		Main main;
		main = new Main();
		main.run();
	}

}
