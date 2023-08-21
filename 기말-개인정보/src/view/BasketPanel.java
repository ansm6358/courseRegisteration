package view;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.EBasketPanel;
import global.Constants.ELecturePanel;
import valueObject.VCLecture;

public class BasketPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private CLecture cLecture;
	private Vector<VCLecture> vCLectures;
	
	private BasketList basketList;
	
	public BasketPanel() {
		this.basketList = new BasketList();
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(this.basketList);
		this.add(scrollpane);
	}
	public void initialize(String id) {
		
	}
	public void addLectures(Vector<VCLecture> vCLectures) {
		this.basketList.addRows(vCLectures);
	}
	public void deleteToBasket() {
		this.basketList.deleteToBasket();
	}
	private class BasketList extends JTable{
		private static final long serialVersionUID = 1L;
		
		private DefaultTableModel tableModel;
		
		private BasketList() {
			this.setBackground(Color.YELLOW);
			Vector<String> header = new Vector<String>();
			for(int i =1; i<EBasketPanel.values().length;i++){
				header.add(EBasketPanel.values()[i].getString());
			}
			
			this.tableModel = new DefaultTableModel(header,0);
			this.setModel(this.tableModel);
		}

		public void deleteToBasket() {
			for(int i=0; i<this.getRowCount(); i++) {
				if	(this.isRowSelected(i)) {
					
					this.tableModel.removeRow(i);
					i--;
					}
			}
		}

		public void addRows(Vector<VCLecture> vCLectures) {
				Vector<String> rowData;
				boolean overlap = false;
				for(VCLecture vCLecture: vCLectures) {
					rowData = new Vector<String>();
					if(!(this.getRowCount()==0)) { //contains: 안에 있는지 확인
					for(int i=0; i<this.getRowCount(); i++) {
						if(this.tableModel.getValueAt(i, 0).equals(vCLecture.getName())) {
							overlap =true;
						};
					}
				}if(overlap) {overlap = false;}
				else {rowData.add(vCLecture.getName());
					this.tableModel.addRow(rowData);}
					}
					this.getSelectionModel().addSelectionInterval(0, 0);
			
		} 
	}


}
