package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import global.Constants.EFindData;
import global.Constants.ELoginDialog;
import global.Constants.EPersonalInfoPanel;


public class Main {
	
	//component
	private LoginDialog loginDialog;
	private MainFrame mainFrame;

	//associate
	
	public Main() {
		//child window
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog = new LoginDialog(actionHandler);

	}
	private void initialize() {
		this.loginDialog.initialize();	
	}
	private void loginOK() {
		String id =loginDialog.validateUser();
				if(id != null) {
				loginDialog.dispose();	
				ActionHandler actionHandler = new ActionHandler();
				this.mainFrame = new MainFrame(actionHandler);
				this.mainFrame.initialize(id);
				}
			}
	private void loginCancle() {
			loginDialog.cancle();
				loginDialog.dispose();		
	}
	private void find(String target) {
			this.loginDialog.findData(target);
				
		}
	private void info() {
		this.mainFrame.info();
		}

	private void logout() {
		this.mainFrame.finish();
		this.mainFrame.dispose();
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog = new LoginDialog(actionHandler);
		}
	private void retext() {
		this.mainFrame.retext();
		}
	private void changePW() {
		this.mainFrame.changePW();
		}	
	private void credit() {
		this.mainFrame.credit();
		}
	class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent actionEvent) {	
			if(actionEvent.getActionCommand().equals(ELoginDialog.OkButton.getString())) {
				loginOK();
					
			}else if(actionEvent.getActionCommand().equals(ELoginDialog.CancleButton.getString())) {
				loginCancle();
			}// 추가 기능
			else if(actionEvent.getActionCommand().equals(EFindData.CheckId.getString())) {
				find(EFindData.CheckId.getString());
			}
			else if(actionEvent.getActionCommand().equals(EFindData.CheckPw.getString())) {
				find(EFindData.CheckPw.getString());
			}else if(actionEvent.getActionCommand().equals(EPersonalInfoPanel.BtnLogout.getString())) {
				logout();
			}else if(actionEvent.getActionCommand().equals(EPersonalInfoPanel.BtnInfo.getString())) {
				info();
			}else if(actionEvent.getActionCommand().equals(EPersonalInfoPanel.retext.getString())) {
				retext();
			}else if(actionEvent.getActionCommand().equals(EPersonalInfoPanel.changePW.getString())) {
				changePW();
			}else if(actionEvent.getActionCommand().equals(EPersonalInfoPanel.credit.getString())) {
				credit();
			}
			//추가 기능
		}

		




	}
	
	public static void main(String[] args) { 
		Main main;
		main = new Main();
		main.initialize();
	}
	

}
