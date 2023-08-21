package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.CPersonalInfo;
import global.Constants.EPersonalInfoPanel;
import valueObject.VCPersonalInfo;
import view.Main.ActionHandler;


public class PersonalInfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel lbInsa;
	private JLabel lbInsaPostfix;
	private JButton btnInfo;
	private JButton btnLogout;
	
	private JLabel infoId;
	private JLabel infoName;
	
	private ChangePw changePw;

	public PersonalInfoPanel(ActionHandler actionHandler) {
		this.lbInsa = new JLabel();
		this.add(this.lbInsa);
		this.lbInsaPostfix = new JLabel(EPersonalInfoPanel.LbInsaPostfix.getString());
		this.add(this.lbInsaPostfix);
		this.btnInfo = new JButton(EPersonalInfoPanel.BtnInfo.getString());
		this.btnInfo.addActionListener(actionHandler);
		this.btnInfo.setActionCommand(EPersonalInfoPanel.BtnInfo.getString());
		this.add(this.btnInfo);
		this.btnLogout = new JButton(EPersonalInfoPanel.BtnLogout.getString());
		this.btnLogout.addActionListener(actionHandler);
		this.btnLogout.setActionCommand(EPersonalInfoPanel.BtnLogout.getString());
		this.add(this.btnLogout);
		
		this.infoId = new JLabel();
		this.infoName = new JLabel();
		
	}
	public void initialize(String id) {
		this.showPersonalInfo(id);
	}	 
	
	private void showPersonalInfo(String id) {
		CPersonalInfo cPersonalInfo = new CPersonalInfo();
		VCPersonalInfo vEPersonalInfo= cPersonalInfo.getPersonalInfo(id);
		this.lbInsa.setText(vEPersonalInfo.getName());
		this.infoName.setText(vEPersonalInfo.getName());
		this.infoId.setText(vEPersonalInfo.getId());
		
	}
	public void info() {
		String name=this.infoName.getText();
		String id = this.infoId.getText();
		this.lbInsa.setText(EPersonalInfoPanel.name.getString()+name+EPersonalInfoPanel.gap.getString());
		this.lbInsaPostfix.setText(EPersonalInfoPanel.id.getString() +id);
		this.btnInfo.setText(EPersonalInfoPanel.retext.getString());
		this.btnInfo.setActionCommand(EPersonalInfoPanel.retext.getString());
		this.btnLogout.setText(EPersonalInfoPanel.changePW.getString());
		this.btnLogout.setActionCommand(EPersonalInfoPanel.changePW.getString());

	}
	public void retext() {
		String name=this.infoName.getText();
		this.lbInsa.setText(name);
		this.lbInsaPostfix.setText(EPersonalInfoPanel.LbInsaPostfix.getString());
		this.btnInfo.setText(EPersonalInfoPanel.BtnInfo.getString());
		this.btnInfo.setActionCommand(EPersonalInfoPanel.BtnInfo.getString());
		this.btnLogout.setText(EPersonalInfoPanel.BtnLogout.getString());
		this.btnLogout.setActionCommand(EPersonalInfoPanel.BtnLogout.getString());
	}
	public void changePW() {
		String id = this.infoId.getText();
		this.changePw = new ChangePw(id);
	}
	public void finish(String id) {
		// TODO Auto-generated method stub
		
	}
	


}
