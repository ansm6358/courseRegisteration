package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.CPersonalInfo;
import global.Constants.TPersonalInfo;
import valueObject.VCPersonalInfo;


public class PersonalInfo extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel lbInsa;
	private JLabel lbInsaPostfix;
	private JButton btnInfo;
	private JButton btnLogout;

	public PersonalInfo() {
		this.lbInsa = new JLabel();
		this.add(this.lbInsa);
		this.lbInsaPostfix = new JLabel(TPersonalInfo.tLbInsaPostfix.getString());
		this.add(this.lbInsaPostfix);
		this.btnInfo = new JButton(TPersonalInfo.tBtnInfo.getString());
		this.add(this.btnInfo);
		this.btnLogout = new JButton(TPersonalInfo.tBtnLogout.getString());
		this.add(this.btnLogout);
		
	}
	public void initialize(String id) {
		this.showPersonalInfo(id);
	}	 
	
	private void showPersonalInfo(String id) {
		CPersonalInfo cPersonalInfo = new CPersonalInfo();
		VCPersonalInfo vEPersonalInfo= cPersonalInfo.getPersonalInfo(id);
		this.lbInsa.setText(vEPersonalInfo.getName());
	}


}
