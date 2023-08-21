package view;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CDirectory;
import control.CLecture;
import valueObject.VCDirectory;
import valueObject.VCLecture;

class LecturePanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private LectureList lectureList;
	private DefaultTableModel tableSet;
	
	public LecturePanel() {
		
		String header[] = {"강좌번호","강좌명","담당교수","학점","시간"};
		
		JScrollPane scrollpane;
		scrollpane = new JScrollPane();
		
		this.tableSet = new DefaultTableModel(header,0);
		this.lectureList = new LectureList(this.tableSet);
		scrollpane.setViewportView(this.lectureList);
		this.add(scrollpane);
		
	}
	public void initialize(String id) {
		
	}
	
	public void refresh(String filename) {
		this.lectureList.refresh(filename);
	}

	private class LectureList extends JTable{
		private static final long serialVersionUID = 1L;
		
		private CLecture cLecture;
		private Vector<VCLecture> vCLectures;
		
		public LectureList(DefaultTableModel tableSet) {
			this.setModel(tableSet);
			this.cLecture = new CLecture();
		}

		public void refresh(String filename) {
			if(filename == null) return;
			
			this.vCLectures = cLecture.getData(filename); //이름 파일 이름
			tableSet.setRowCount(0);
			for(VCLecture vCLecture: this.vCLectures) {
				String tableColumns[] = new String[5];	
				tableColumns[0] = vCLecture.getId();
				tableColumns[1] = vCLecture.getClassName();
				tableColumns[2] = vCLecture.getProfessor();
				tableColumns[3] = vCLecture.getCredit();
				tableColumns[4] = vCLecture.getTime();
				tableSet.addRow(tableColumns);
			
			}	
			this.setRowSelectionInterval(0, 0);
			this.updateUI();
		}

		
		
	}
}