package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
	
	//component
	private LoginDialog loginDialog;
	private MainFrame mainFrame;
	private FindData findData;
	//associate
	
	public Main() {
		//child window
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog = new LoginDialog(actionHandler);
		this.loginDialog.setVisible(true);
		

	}
	private void loginOK() {
		String id =loginDialog.validateUser();
				if(id != null) {
				loginDialog.dispose();	
				this.mainFrame = new MainFrame(id);
				this.mainFrame.setVisible(true);

				}
			}
	private void loginCancle() {
			loginDialog.cancle();
				loginDialog.dispose();		
	}
	
	private void find(String target) {
			this.findData = new FindData();
		}
	
	class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent actionEvent) {	
			if(actionEvent.getActionCommand().equals("OK")) {
				loginOK();
				
				
			}else if(actionEvent.getActionCommand().equals("cancle")) {
				loginCancle();
			}
			// �߰� ���
			else if(actionEvent.getActionCommand().equals("findId")) {
				find("id");
			}
			else if(actionEvent.getActionCommand().equals("findPw")) {
				find("password");
			}
			//�߰� ���
		}

			
	}
	
	public static void main(String[] args) { //os�� ���⼭ ���� �����϶�� �� //�� Ŭ������ �������� �˷����� ���� ����
		Main main;
		main = new Main();

	}

}
