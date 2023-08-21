package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.CPersonalInfo;
import valueObject.VCPersonalInfo;


public class PersonalInfo extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel insa;
	private JLabel text1;
	private JButton info;
	private JButton logout;

	public PersonalInfo() {
		this.insa = new JLabel();
		this.add(this.insa);
		this.text1 = new JLabel("님 어서오세요");
		this.add(this.text1);
		this.info = new JButton("개인정보");
		this.add(this.info);
		this.logout = new JButton("logout");
		this.add(this.logout);
		
	}
	 
	public void showPersonalInfo(String id) {
		CPersonalInfo cPersonalInfo = new CPersonalInfo();
		VCPersonalInfo vEPersonalInfo= cPersonalInfo.getPersonalInfo(id);
		this.insa.setText(vEPersonalInfo.getName());
	}
}
