import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	private LoginDialog loginDialog;
	
	//constructor
	public MainFrame() {
		//attributes
		this.setTitle(Constants.MAIN_TITLE); //���: �̸��� ���� ������ �ʴ� ��, ����: �̸��� ���� ���� �� �ִ� ��
		this.setLocation(Constants.MAIN_X, Constants.MAIN_Y);
		this.setSize(Constants.MAIN_W, Constants.MAIN_H);

		//components
		this.mainPanel = new JPanel();	//������Ʈ�� ������ Ʋ
		this.add(this.mainPanel);
		
		//child window
		this.loginDialog = new LoginDialog(this);
		this.loginDialog.setVisible(true);
	}
}
