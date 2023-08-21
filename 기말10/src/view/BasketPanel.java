package view;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.EBasketPanel;
import global.Constants.ETooltip;
import valueObject.VCLecture;

public class BasketPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private CLecture cLecture;
	private Vector<VCLecture> vCLectures;
	
	private BasketList basketList;
	
	public BasketPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.vCLectures = new Vector<VCLecture>();
		this.basketList = new BasketList();
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(this.basketList);
		this.add(scrollpane);
	}
	public void initialize(String fileName) throws FileNotFoundException {
			Vector<VCLecture> storeLectures = new Vector<VCLecture>();
			this.cLecture = new CLecture();
			if(cLecture.getData(fileName) != null) {
			storeLectures = cLecture.getData(fileName);
			this.addRows(storeLectures);
			}
	}
	public void finish(String fileName) {
		try {
			this.cLecture = new CLecture();
			this.cLecture.setData(fileName, this.vCLectures);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addRows(Vector<VCLecture> vCRemovedLectures) {
		this.basketList.addRows(vCRemovedLectures);
		this.basketList.getSelectionModel().clearSelection();
		this.basketList.getSelectionModel().addSelectionInterval(0, 0);
	}
	public void removeSelectedLectures() {
		this.basketList.removeSelectedLectures();
	}
	public Vector<VCLecture> getSelectedLectures() {
		return this.basketList.getSelectedLectures();
	}

	public Vector<VCLecture> getStoreLectures() {
		// TODO Auto-generated method stub
		return this.vCLectures;
	}
	public void CheckLectures(Vector<VCLecture> resultLectures) {
		this.basketList.CheckNameLectures(resultLectures);
		this.basketList.CheckTimeLectures(resultLectures);
		this.basketList.CheckCreditLectures(resultLectures);
	}
		public int credit(Vector<VCLecture> resultLectures) {
			int sumCredit = this.basketList.credit(resultLectures);
			return sumCredit;
	}
	private class BasketList extends JTable{
		private static final long serialVersionUID = 1L;
		
		private DefaultTableModel tableModel;
		
		private BasketList() {
			Vector<String> header = new Vector<String>();
			for(int i =1; i<EBasketPanel.values().length;i++){
				header.add(EBasketPanel.values()[i].getString());
			}
			
			this.tableModel = new DefaultTableModel(header,0){
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int i, int c){return false;}
				};

			this.setModel(this.tableModel);
			this.getColumnModel().getColumn(0).setMaxWidth(60);//���¹�ȣ ĭ ���
			this.getColumnModel().getColumn(1).setMaxWidth(120);//���¹�ȣ ĭ ���
		
		}
	
		
		public int credit(Vector<VCLecture> resultLectures) {
			int sumCredit = 0;
			for(VCLecture vCLecture: resultLectures) {
				sumCredit = sumCredit + Integer.parseInt(vCLecture.getCredit());
			}
			
			return sumCredit;
		}


		public void CheckNameLectures(Vector<VCLecture> resultLectures) {
			for(int i = this.tableModel.getRowCount() -1; i>=0;i--) {
				if(this.isRowSelected(i)) {
					for(VCLecture vCLecture: resultLectures) {
						if(this.tableModel.getValueAt(i, 1).equals(vCLecture.getName())) {
							this.removeRowSelectionInterval(i, i);
						}
					}
					}
				}
		}
		public void CheckTimeLectures(Vector<VCLecture> resultLectures) {
			
		}
		public void CheckCreditLectures(Vector<VCLecture> resultLectures) {
			
		}
		public Vector<VCLecture> getSelectedLectures() {
			Vector<VCLecture> vCRemovedLectures = new Vector<VCLecture>();
			for(int i = this.tableModel.getRowCount() -1; i>=0;i--) {
				if(this.isRowSelected(i)) {
					this.tableModel.removeRow(i);
					vCRemovedLectures.add(vCLectures.get(i));
					vCLectures.remove(i);
				}
			}
			this.getSelectionModel().addSelectionInterval(0, 0);

			return vCRemovedLectures;
		}
		public void removeSelectedLectures() {
			for(int i = this.tableModel.getRowCount() -1; i>=0;i--) {
				if(this.isRowSelected(i)) {
					this.tableModel.removeRow(i);
					vCLectures.remove(i);
				}
			}
			this.getSelectionModel().addSelectionInterval(0, 0);
		}

		public void addRows(Vector<VCLecture> vCRemovedLectures) {
				Vector<String> rowData;
				boolean overlap = false;
				for(VCLecture vCLecture: vCRemovedLectures) {					
					rowData = new Vector<String>();
					if(!(this.getRowCount()==0)) { //contains: �ȿ� �ִ��� Ȯ��
						for(int i=0; i<this.getRowCount(); i++) {
							if(this.tableModel.getValueAt(i, 1).equals(vCLecture.getName())) {
								overlap =true;
							}
						}
					}if(overlap) {overlap = false;}
					else {
					rowData.add(vCLecture.getId());
					rowData.add(vCLecture.getName());
					this.tableModel.addRow(rowData);		
					vCLectures.add(vCLecture);
					this.setDefaultRenderer(Object.class, new TestCellRenderer(vCLectures));
					}
				}
					this.getSelectionModel().addSelectionInterval(0, 0);
					this.updateUI();
		} 
	}
    public class TestCellRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 1L;
		
			private Vector<VCLecture> getLecture2;
        public TestCellRenderer(Vector<VCLecture> vCLectures) {
        	this.getLecture2 = vCLectures;
		}

		@Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			setToolTipText(ETooltip.time.getString()+getLecture2.get(row).getTime());
			
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

    }





}
