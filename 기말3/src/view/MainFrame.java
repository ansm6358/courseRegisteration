package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import global.Constants.EMainFrame;
import view.Main.ActionHandler;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = EMainFrame.serialVersionUID.getInt();
	
	private PersonalInfoPanel personalInfo;
	private RegistrationPanel registration;
	private String id;
	//constructor
	public MainFrame(ActionHandler actionHandler) {
		//attributes
		this.setTitle(EMainFrame.Title.getString()); 
		this.setSize(EMainFrame.Width.getInt(), EMainFrame.Height.getInt());		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(
				dim.width/2 -this.getSize().width/2, 
				dim.height/2 -this.getSize().height/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//components
		WindowListener windowListener = new WindowHandler();
		this.addWindowListener(windowListener);
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		
		this.personalInfo = new PersonalInfoPanel(actionHandler);
		this.add(this.personalInfo, BorderLayout.NORTH);
		
		this.registration = new RegistrationPanel();
		this.add(this.registration, BorderLayout.CENTER);
		
		this.setVisible(true);

	}

	public void initialize(String id) {
		this.id = id;
		this.personalInfo.initialize(id);
		this.registration.initialize(id);
	}
	public void finish() {
		
		this.personalInfo.finish(this.id);
		this.registration.finish(this.id);
	}
	public void info() {
		this.personalInfo.info();
	}

	public void retext() {
		this.personalInfo.retext();
	}
	private class WindowHandler implements WindowListener{
		@Override
		public void windowActivated(WindowEvent arg0) {
		}
		@Override
		public void windowClosed(WindowEvent arg0) {			
		}
		@Override
		public void windowClosing(WindowEvent arg0) {
			finish();
		}
		@Override
		public void windowDeactivated(WindowEvent arg0) {
		}
		@Override
		public void windowDeiconified(WindowEvent arg0) {
		}
		@Override
		public void windowIconified(WindowEvent arg0) {
		}
		@Override
		public void windowOpened(WindowEvent arg0) {
		}
		
	}
}
