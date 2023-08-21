package view;

import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import control.CDirectory;
import valueObject.VCDirectory;

class DirectoryPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private DirectoryList directoryList1;
	private DirectoryList directoryList2;
	private DirectoryList directoryList3;
	
	public DirectoryPanel(ListSelectionListener listSelectionListener) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane scrollpane;
		
		scrollpane = new JScrollPane();
		this.directoryList1 = new DirectoryList();
		this.directoryList1.addListSelectionListener(listSelectionListener);
		scrollpane.setViewportView(this.directoryList1);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.directoryList2 = new DirectoryList();
		this.directoryList2.addListSelectionListener(listSelectionListener);
		scrollpane.setViewportView(this.directoryList2);
		this.add(scrollpane);
		
		scrollpane = new JScrollPane();
		this.directoryList3 = new DirectoryList();
		this.directoryList3.addListSelectionListener(listSelectionListener);
		scrollpane.setViewportView(this.directoryList3);
		this.add(scrollpane);
		
	}
	public String refresh(Object source) {
		String fileName = null;
		if(source==null) {
			this.directoryList1.refresh("root");
			fileName = this.directoryList1.getSelectedFile();
			this.directoryList2.refresh(fileName);
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
		}
		else if(source.equals(this.directoryList1)) {
			this.directoryList2.listData.removeAllElements();
			this.directoryList3.listData.removeAllElements();
			
			fileName = this.directoryList1.getSelectedFile();
			this.directoryList2.refresh(fileName);
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
			
			this.directoryList2.setSelectedIndex(0);
			this.directoryList3.setSelectedIndex(0);
		}else if(source.equals(this.directoryList2)) {
			
			this.directoryList3.listData.removeAllElements();
			fileName = this.directoryList2.getSelectedFile();
			this.directoryList3.refresh(fileName);
			fileName = this.directoryList3.getSelectedFile();
			
			this.directoryList3.setSelectedIndex(0);
		}else if(source.equals(this.directoryList3)) {
			fileName = this.directoryList3.getSelectedFile();

		}
		return fileName;
	}	
	
	private class DirectoryList extends JList<String>{
		private static final long serialVersionUID = 1L;
		
		private CDirectory cDirectory;
		private Vector<VCDirectory> vCDirectories;
		private Vector<String> listData;
		
		public DirectoryList() {
			this.listData = new Vector<String>();
			this.setListData(this.listData);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			this.cDirectory = new CDirectory(); //e디렉토리
			
		}

		public String getSelectedFile() {
			if((getSelectedIndex() != -1) && (getSelectedIndex() < this.listData.size()) ) {

			String fileName = this.vCDirectories.get(this.getSelectedIndex()).getFilename();
			return fileName;
			}
			return null;
		}
		public void refresh(String fileName) {
			if(fileName == null) return;
			
			this.vCDirectories = cDirectory.getData(fileName); //이름 파일 이름
			this.listData.clear();
			for(VCDirectory vCDirectory: this.vCDirectories) {
				this.listData.add(vCDirectory.getText());
			}	
			//this.setSelectedIndex(0);
			this.updateUI();			
		}


	}

	public void initialize() {
		this.refresh(null);
		this.directoryList1.setSelectedIndex(0);
		this.directoryList2.setSelectedIndex(0);
		this.directoryList3.setSelectedIndex(0);
	}

}

