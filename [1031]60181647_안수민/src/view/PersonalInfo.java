package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.CPersonalInfo;
import valueObject.VCPersonalInfo;


public class PersonalInfo extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private JLabel insa;
	
	public void setID(String id) {
		this.id = id;
	}

	public PersonalInfo() {
		this.id = null;
		this.insa = new JLabel();
		this.add(this.insa);
	}
	 
	public void showPersonalInfo(String id) {
		CPersonalInfo cPersonalInfo = new CPersonalInfo();
		VCPersonalInfo vEPersonalInfo= cPersonalInfo.getPersonalInfo(id);
		this.insa.setText(vEPersonalInfo.getName());
	}
}
