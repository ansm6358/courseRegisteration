package view;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.CDirectory;
import valueObject.VCDirectory;

public class SelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private DirectoryPanel directoryPanel;
	private DirectoryPanel directoryPanel2;
	private DirectoryPanel directoryPanel3;



	private SubjectPanel subjectPanel;
	
	public SelectionPanel() {
		String Filename1 = null, Filename2 = null; 
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.directoryPanel = new DirectoryPanel(Filename1, Filename2);
		this.add(this.directoryPanel);
		
		this.subjectPanel = new SubjectPanel();
		this.add(this.subjectPanel);
	}
	
	private class DirectoryList extends JList<String>{
		
		private Vector<String> listData;
		private Vector<VCDirectory> vCVector;

		public DirectoryList(String filename) {
			String nonfile = null;
			String nonfile2 = "data/"+null;
			this.listData = new Vector<String>();
			this.setListData(this.listData);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			if(!(filename==null)&&!(filename.equals(nonfile2))) {
			CDirectory cDirectory = new CDirectory(); //e디렉토리
			this.vCVector = cDirectory.getData(filename); //이름 파일 이름
			for(VCDirectory vcDirectory: this.vCVector) {
				listData.add(vcDirectory.getSubjectName());
			}
			
			
			this.addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					String listname = getSelectedValue();
					
						directoryPanel.directoryList3.listData.removeAllElements();
						directoryPanel.directoryList3.setListData(directoryPanel.directoryList3.listData);
						String filename1 = "data/"+this.getname(vCVector, listname);
						String filename2 = null;
						
						directoryPanel2 = new DirectoryPanel(filename1, filename2);
						directoryPanel.directoryList2.setListData(directoryPanel2.directoryList2.listData);
						directoryPanel.directoryList2.addListSelectionListener(new ListSelectionListener() {
						
							@Override
							public void valueChanged(ListSelectionEvent arg0) {
								String listname = directoryPanel.directoryList2.getSelectedValue();
								String filename2 = "data/"+this.getname(directoryPanel2.directoryList2.vCVector, listname);
								directoryPanel3 = new DirectoryPanel(filename1, filename2);
								directoryPanel.directoryList3.setListData(directoryPanel3.directoryList3.listData);
							
							}

							private String getname(Vector<VCDirectory> vCVector, String listname) {
								for(VCDirectory vcDirectory: vCVector) {
									if(vcDirectory.getSubjectName().equals(listname)) {
										String filenames = vcDirectory.getFilename();
										
										return filenames;
									}
									
								}
								return null;
							}
						});
					
				}

				private String getname(Vector<VCDirectory> vCVector, String listname) {
					for(VCDirectory vcDirectory: vCVector) {
						if(vcDirectory.getSubjectName().equals(listname)) {
							String filenames = vcDirectory.getFilename();
							return filenames;
						}
						
					}
					return null;		
				}
			});
			}
		
			
		}
	}
	
	private class DirectoryPanel extends JPanel{
		private DirectoryList directoryList1;
		private DirectoryList directoryList2;
		private DirectoryList directoryList3;
		
		
		public DirectoryPanel(String filename1, String filename2) {
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			
			JScrollPane scrollpane;
			
			scrollpane = new JScrollPane();
			this.directoryList1 = new DirectoryList("data/root");
			scrollpane.setViewportView(this.directoryList1);
			
			this.add(scrollpane);
			
			scrollpane = new JScrollPane();
			directoryList2 = new DirectoryList(filename1);
			scrollpane.setViewportView(this.directoryList2);
			directoryList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.add(scrollpane);
			
			scrollpane = new JScrollPane();
			this.directoryList3 = new DirectoryList(filename2);
			scrollpane.setViewportView(this.directoryList3);
			this.add(scrollpane);
			
			
		}
	}
	
	private class SubjectPanel extends JPanel{
		public SubjectPanel() {
			
		}
	}
}
