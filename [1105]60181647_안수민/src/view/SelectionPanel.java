package view;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class SelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private DirectoryPanel directoryPanel;
	private SubjectPanel subjectPanel;
	
	public SelectionPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.directoryPanel = new DirectoryPanel();
		this.add(this.directoryPanel);
		this.subjectPanel = new SubjectPanel();
		this.add(this.subjectPanel);
	}
	
	private class DirectoryList extends JList<String>{
		
		private Vector<String> listData;
		
		public DirectoryList() {
			this.listData = new Vector<String>();
			this.setListData(this.listData);
			
			this.listData.add("test1");
			this.listData.add("test2");
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
	}
	
	private class DirectoryPanel extends JPanel{
		private DirectoryList directoryList;
		public DirectoryPanel() {
			this.directoryList = new DirectoryList();
			this.add(this.directoryList);
		}
	}
	
	private class SubjectPanel extends JPanel{
		public SubjectPanel() {
			
		}
	}
}
