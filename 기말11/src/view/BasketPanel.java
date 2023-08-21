package view;

import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.EBasketPanel;
import global.Constants.ECredit;
import global.Constants.EErrorDialog;
import global.Constants.EOverlapTime;
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
	public void CheckLectures(Vector<VCLecture> resultLectures, int sumCredit) {
		this.basketList.CheckNameLectures(resultLectures);		
		this.basketList.CheckTimeLectures(resultLectures);
		this.basketList.CheckSelectedTimeLectures();
		this.basketList.CheckCreditLectures(sumCredit);
		
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
			this.getColumnModel().getColumn(0).setMaxWidth(60);//강좌번호 칸 축소
			this.getColumnModel().getColumn(1).setMaxWidth(120);//강좌번호 칸 축소
		
		}
	
		
		public void CheckSelectedTimeLectures() {
			boolean overlap = false;
			for(int i=0; i<this.getRowCount(); i++) {
				if(this.isRowSelected(i)) {
					for(int c=i+1; c<this.getRowCount(); c++) {
						if(this.isRowSelected(c)) {
							String selectedDate = vCLectures.get(i).getTime();
							String basketDate = vCLectures.get(c).getTime();;
							overlap = CheckDate(selectedDate, basketDate);
							if(overlap) {
								this.removeRowSelectionInterval(c, c);
								JOptionPane.showMessageDialog(this,EOverlapTime.message.getString()+EOverlapTime.jump.getString()
								+EOverlapTime.message2.getString()+this.tableModel.getValueAt(c, 1)+EOverlapTime.jump.getString()
								+EOverlapTime.message3.getString()+basketDate+EOverlapTime.jump.getString()
								+EOverlapTime.message4.getString()+this.tableModel.getValueAt(i, 1)+EOverlapTime.jump.getString()
								+EOverlapTime.message3.getString()+selectedDate,
								EErrorDialog.title.getString(),JOptionPane.INFORMATION_MESSAGE);
								overlap = false;
								
							}
							
						}	}
				}
		}}


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
			
			boolean overlap = false;
			
			for(int i = this.tableModel.getRowCount() -1; i>=0;i--) {
				if(this.isRowSelected(i)) {
					for(VCLecture vCLecture: resultLectures) {
							String basketDate = vCLectures.get(i).getTime();
							String resultDate = vCLecture.getTime();
							overlap = CheckDate(basketDate, resultDate);
						
						if(overlap) {
							this.removeRowSelectionInterval(i, i);
							JOptionPane.showMessageDialog(this,EOverlapTime.message.getString()+EOverlapTime.jump.getString()
							+EOverlapTime.message2.getString()+this.tableModel.getValueAt(i, 1)+EOverlapTime.jump.getString()
							+EOverlapTime.message3.getString()+basketDate+EOverlapTime.jump.getString()
							+EOverlapTime.message4.getString()+vCLecture.getName()+EOverlapTime.jump.getString()
							+EOverlapTime.message3.getString()+vCLecture.getTime(),
							EErrorDialog.title.getString(),JOptionPane.INFORMATION_MESSAGE);
							overlap = false;
							
						}
						}
					}
				}
		}
		private boolean CheckDate(String basketDate, String resultDate) {
			char first =0x30;
			char last = 0x39;
			boolean overlap = false;
			
			if(basketDate.charAt(1)>=first && basketDate.charAt(1)<=last) {
							if(resultDate.charAt(1)>=first && resultDate.charAt(1)<=last) { //둘 다 하루 수업
										if(basketDate.charAt(0)==resultDate.charAt(0)) {
											String basketTime = basketDate.substring(1, basketDate.length()-1);
											String resultTime =	resultDate.substring(1, resultDate.length()-1);	
											overlap = checkTime(basketTime, resultTime);
									}
								}else { //result가 이틀 수업
										if(basketDate.charAt(0)==resultDate.charAt(0)) {
											String basketTime = basketDate.substring(1, basketDate.length()-1);
											String resultTime =	resultDate.substring(2, resultDate.length()-1);	
											overlap = checkTime(basketTime, resultTime);
										
										}else if(basketDate.charAt(0)==resultDate.charAt(1)) {
											String basketTime = basketDate.substring(1, basketDate.length()-1);
											String resultTime =	resultDate.substring(2, resultDate.length()-1);	
											overlap = checkTime(basketTime, resultTime);
									}
								}
							}else {
								if(resultDate.charAt(1)>=first && resultDate.charAt(1)<=last) {//basket만 이틀 수업
										if(basketDate.charAt(0)==resultDate.charAt(0)) { 
											String basketTime = basketDate.substring(2, basketDate.length()-1);
											String resultTime =	resultDate.substring(1, resultDate.length()-1);	
											overlap = checkTime(basketTime, resultTime);
										}else if(basketDate.charAt(1)==resultDate.charAt(0)) {
											String basketTime = basketDate.substring(2, basketDate.length()-1);
											String resultTime =	resultDate.substring(1, resultDate.length()-1);	
											overlap = checkTime(basketTime, resultTime);
										}
								}else {//둘 다 이틀 수업
									if(basketDate.charAt(0)==resultDate.charAt(0)) { 
										String basketTime = basketDate.substring(2, basketDate.length()-1);
										String resultTime =	resultDate.substring(2, resultDate.length()-1);	
										overlap = checkTime(basketTime, resultTime);
									}else if(basketDate.charAt(1)==resultDate.charAt(0)) {
										String basketTime = basketDate.substring(2, basketDate.length()-1);
										String resultTime =	resultDate.substring(2, resultDate.length()-1);	
										overlap = checkTime(basketTime, resultTime);
									}else if(basketDate.charAt(0)==resultDate.charAt(1)) {
										String basketTime = basketDate.substring(2, basketDate.length()-1);
										String resultTime =	resultDate.substring(2, resultDate.length()-1);	
										overlap = checkTime(basketTime, resultTime);
									}else if(basketDate.charAt(1)==resultDate.charAt(1)) {
										String basketTime = basketDate.substring(2, basketDate.length()-1);
										String resultTime =	resultDate.substring(2, resultDate.length()-1);	
										overlap = checkTime(basketTime, resultTime);
								}
							}
							}
								return overlap;
					}
		

		private boolean checkTime(String basketTime, String resultTime) {
			boolean overlap = false;
			int startBasket = Integer.parseInt(basketTime.substring(0, 3));
			int endBasket= Integer.parseInt(basketTime.substring(5, 8));
			int startResult = Integer.parseInt(resultTime.substring(0, 3));
			int endResult = Integer.parseInt(resultTime.substring(5, 8));
			if(startBasket > startResult) {
				if(startBasket < endResult) {
					overlap = true;
				}
			}else if(startBasket == startResult){
				overlap = true;
			}else if(startBasket < startResult){
				if(endBasket > startResult) {
					overlap = true;
				}
			}
			
			return overlap;
			
			
			
			
		}


		public void CheckCreditLectures(int sumCredit) {
			int sum = sumCredit;
			int overCredit = 0;
			String error=ECredit.gap.getString();
			for(int i=0; i<this.getRowCount(); i++) {
				if(this.isRowSelected(i)) {
					sum = sum + Integer.parseInt(vCLectures.get(i).getCredit());
					if(sum > ECredit.MaxCredit.getInt()) {
						sum = sum - Integer.parseInt(vCLectures.get(i).getCredit());
						error = error + ECredit.gap.getString() + vCLectures.get(i).getName();
						overCredit = overCredit +Integer.parseInt(vCLectures.get(i).getCredit());
						this.removeRowSelectionInterval(i, i);
					}
				}
			}	
			if(overCredit>0) {
				JOptionPane.showMessageDialog(this,ECredit.message.getString()+ECredit.jump.getString()+ECredit.message2.getString()+error+ECredit.jump.getString()+ECredit.message3.getString()+overCredit, EErrorDialog.title.getString(),JOptionPane.INFORMATION_MESSAGE);
			}
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
					if(!(this.getRowCount()==0)) { //contains: 안에 있는지 확인
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
