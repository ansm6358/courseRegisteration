package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import valueObject.VCLecture;

public class SelectionPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private DirectoryPanel directoryPanel;
	private LecturePanel lecturePanel;
	
	public SelectionPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.GREEN);

		ListSelectionListener listSelectionHandler = new ListSelectionHandler();
		
		this.directoryPanel = new DirectoryPanel(listSelectionHandler);
		this.directoryPanel.setBackground(Color.GREEN);

		this.add(this.directoryPanel,BorderLayout.CENTER);
		
		this.lecturePanel = new LecturePanel();
		this.lecturePanel.setBackground(Color.GREEN);
		this.add(this.lecturePanel,BorderLayout.SOUTH);
	}
	public void initialize(String id) {
		this.directoryPanel.initialize(id);
		this.lecturePanel.initialize(id);
		
	}
	private class ListSelectionHandler implements ListSelectionListener{
	@Override
	public void valueChanged(ListSelectionEvent e) {
		String fileName =  directoryPanel.refresh(e.getSource());
		lecturePanel.refresh(fileName);		
		}
	}
	public Vector<VCLecture> getSelectedLectures() {
		
		return this.lecturePanel.getSelectedLectures();
	}
}
