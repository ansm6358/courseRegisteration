package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.JFrame;
import global.Constants;
import global.Constants.GMainFrame;
import global.Constants.TMainFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private PersonalInfo personalInfo;
	private Registration registration;
	
	//constructor
	public MainFrame() {
		//attributes
		this.setTitle(TMainFrame.tTitle.getString()); 
		this.setSize(GMainFrame.gWidth.getInt(), GMainFrame.gHeight.getInt());		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(
				dim.width/2 -this.getSize().width/2, 
				dim.height/2 -this.getSize().height/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		this.personalInfo = new PersonalInfo();
		this.add(this.personalInfo, BorderLayout.NORTH);
		
		this.registration = new Registration();
		this.add(this.registration, BorderLayout.CENTER);
		
		
	}

	public void initialize(String id) {
		
		this.personalInfo.initialize(id);
		this.registration.initialize(id);
	}

}
