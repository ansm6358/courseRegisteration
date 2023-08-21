package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectionPanel extends JPanel implements ListSelectionListener{
	private static final long serialVersionUID = 1L;
	
	private DirectoryPanel directoryPanel;
	private LecturePanel lecturePanel;
	
	public SelectionPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.directoryPanel = new DirectoryPanel(this);
		this.add(this.directoryPanel);
		
		this.lecturePanel = new LecturePanel();
		this.add(this.lecturePanel);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		String fileName =  this.directoryPanel.refresh(e.getSource());
		this.lecturePanel.refresh(fileName);
		
	}

	public void start() {
		this.directoryPanel.start();
	}

	
}
