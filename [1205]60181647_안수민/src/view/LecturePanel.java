package view;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.ELecturePanel;
import valueObject.VCLecture;

class LecturePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private CLecture cLecture;
	private Vector<VCLecture> vCLectures;
	
	private LectureList lectureList;
	
	public LecturePanel() {
		this.lectureList = new LectureList();
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(this.lectureList);
		this.add(scrollpane);
	}	
	public void initialize(String id) {
		// TODO Auto-generated method stub
		
	}
	
	public void refresh(String filename) {
		this.cLecture = new CLecture();
		this.vCLectures = cLecture.getData(filename);
		
		this.lectureList.addRows(this.vCLectures);
	}
	
	private class LectureList extends JTable{
		private static final long serialVersionUID = 1L;
		
		private DefaultTableModel tableModel;
		
		private LectureList() {
			
			this.setBackground(Color.YELLOW);

			Vector<String> header = new Vector<String>();
			for(int i =1; i<ELecturePanel.values().length;i++){
				header.add(ELecturePanel.values()[i].getString());
			}
			
			this.tableModel = new DefaultTableModel(header,0);
			this.setModel(this.tableModel);
			
		}

		public void addRows(Vector<VCLecture> vCLectures) {
				this.tableModel.setRowCount(0);
				Vector<String> rowData;
				for(VCLecture vCLecture: vCLectures) {
					rowData = new Vector<String>();
					rowData.add(vCLecture.getId());
					rowData.add(vCLecture.getName());
					rowData.add(vCLecture.getProfessorName());
					rowData.add(vCLecture.getCredit());
					rowData.add(vCLecture.getTime());
					this.tableModel.addRow(rowData);
				}
					this.getSelectionModel().addSelectionInterval(0, 0);
			
		}

		public Vector<VCLecture> getSelectedLectures() {
			Vector<VCLecture> selectedVCLecture = new Vector<VCLecture>();
			for(int i=0; i<this.getRowCount(); i++) {
				if(this.isRowSelected(i)) {
					selectedVCLecture.add(vCLectures.get(i));
				}
			}
			return selectedVCLecture;
		} 
	}

	public Vector<VCLecture> getSelectedLectures() {
		
		return this.lectureList.getSelectedLectures();
	}
}