package view;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.CPersonalInfo;
import global.Constants.EImageName;
import global.Constants.EPersonalInfoPanel;
import valueObject.VCPersonalInfo;
import view.Main.ActionHandler;


public class PersonalInfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel lbInsa;
	private JLabel lbInsaPostfix;
	private JButton btnInfo;
	private JButton btnLogout;
	private JButton timeTable;
	private JButton credit;
	private JLabel creditLabel;
	
	private JLabel infoId;
	private JLabel infoName;
	
	private ChangePw changePw;

	public PersonalInfoPanel(ActionHandler actionHandler) {
		ImageIcon info = new ImageIcon(EImageName.info.getString());
		ImageIcon logout = new ImageIcon(EImageName.logout.getString());
		
		this.lbInsa = new JLabel();
		this.add(this.lbInsa);
		this.lbInsaPostfix = new JLabel(EPersonalInfoPanel.LbInsaPostfix.getString());
		this.add(this.lbInsaPostfix);
		
		this.btnInfo = new JButton(EPersonalInfoPanel.BtnInfo.getString(), info);
		this.btnInfo.addActionListener(actionHandler);
		this.btnInfo.setActionCommand(EPersonalInfoPanel.BtnInfo.getString());
		this.add(this.btnInfo);
		
		this.btnLogout = new JButton(EPersonalInfoPanel.BtnLogout.getString(), logout);
		this.btnLogout.addActionListener(actionHandler);
		this.btnLogout.setActionCommand(EPersonalInfoPanel.BtnLogout.getString());
		this.add(this.btnLogout);
		
//		ImageIcon timeTableImage = new ImageIcon(EImageName.timeTable.getString());
//		this.timeTable = new JButton(EPersonalInfoPanel.timetable.getString(), timeTableImage);
//		this.timeTable.addActionListener(actionHandler);
//		this.timeTable.setActionCommand(EPersonalInfoPanel.timetable.getString());
//		this.add(this.timeTable);
		
		this.credit = new JButton(EPersonalInfoPanel.credit.getString());
		this.credit.addActionListener(actionHandler);
		this.credit.setActionCommand(EPersonalInfoPanel.credit.getString());
		this.add(this.credit);
		
		this.creditLabel = new JLabel();
		this.add(this.creditLabel);
		
		this.infoId = new JLabel();
		this.infoName = new JLabel();
		
	}
	public void initialize(String id) {
		this.showPersonalInfo(id);
	}	 
	public void finish(String id) {
		
	}

	private void showPersonalInfo(String id) {
		CPersonalInfo cPersonalInfo = new CPersonalInfo();
		VCPersonalInfo vEPersonalInfo= cPersonalInfo.getPersonalInfo(id);
		this.setBackground(Color.CYAN);
		this.lbInsa.setText(vEPersonalInfo.getName());
		this.infoName.setText(vEPersonalInfo.getName());
		this.infoId.setText(vEPersonalInfo.getId());
		
	}
	public void info() {
		String name=this.infoName.getText();
		String id = this.infoId.getText();
		
		ImageIcon change = new ImageIcon(EImageName.change.getString());
		ImageIcon changePw = new ImageIcon(EImageName.changePw.getString());
		
		this.lbInsa.setText(EPersonalInfoPanel.name.getString()+name+EPersonalInfoPanel.gap.getString());
		this.lbInsaPostfix.setText(EPersonalInfoPanel.id.getString() +id);
		
		this.btnInfo.setIcon(change);
		this.btnInfo.setText(EPersonalInfoPanel.retext.getString());
		this.btnInfo.setActionCommand(EPersonalInfoPanel.retext.getString());
		
		this.btnLogout.setIcon(changePw);
		this.btnLogout.setText(EPersonalInfoPanel.changePW.getString());
		this.btnLogout.setActionCommand(EPersonalInfoPanel.changePW.getString());

	}
	public void retext() {
		ImageIcon info = new ImageIcon(EImageName.info.getString());
		ImageIcon logout = new ImageIcon(EImageName.logout.getString());
		
		String name=this.infoName.getText();
		this.lbInsa.setText(name);
		this.lbInsaPostfix.setText(EPersonalInfoPanel.LbInsaPostfix.getString());
		this.btnInfo.setIcon(info);
		this.btnInfo.setText(EPersonalInfoPanel.BtnInfo.getString());
		this.btnInfo.setActionCommand(EPersonalInfoPanel.BtnInfo.getString());
		
		this.btnLogout.setIcon(logout);
		this.btnLogout.setText(EPersonalInfoPanel.BtnLogout.getString());
		this.btnLogout.setActionCommand(EPersonalInfoPanel.BtnLogout.getString());
	}
	
	public void changePW() {
		String id = this.infoId.getText();
		this.changePw = new ChangePw(id);
	}
		public void credit(int sumCredit) {
			int count = 0;
			creditLabel.setText(EPersonalInfoPanel.creditText.getString()+sumCredit);
			Timer timer = new Timer();
			TimerTask time = new TimerTask() {
				@Override
				public void run() {
				if(count < 1 ) {
					creditLabel.setText(EPersonalInfoPanel.gap.getString());
					}else {
						
						timer.cancel();
					}
				}				
			};
			timer.schedule(time, 1000);				
			
	}
	

	
}
