import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel mainPanel;
	private LoginDialog loginDialog;
	
	//constructor
	public MainFrame() {
		//attributes
		this.setTitle(Constants.MAIN_TITLE); //상수: 이름과 값이 변하지 않는 것, 변수: 이름과 값이 변할 수 있는 것
		this.setLocation(Constants.MAIN_X, Constants.MAIN_Y);
		this.setSize(Constants.MAIN_W, Constants.MAIN_H);

		//components
		this.mainPanel = new JPanel();	//오브젝트를 만들어내는 틀
		this.add(this.mainPanel);
		
		//child window
		this.loginDialog = new LoginDialog(this);
		this.loginDialog.setVisible(true);
	}
}
