package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import global.Constants.EDataFileName;
import global.Constants.EFinal;
import valueObject.VCLecture;

public class RegistrationPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ActionListener actionHandler;
	
	private SelectionPanel selectionPanel;
	private MovePanel movePanel1;
	private BasketPanel basketPanel;
	private MovePanel movePanel2;
	private BasketPanel resultPanel1;
	
	public RegistrationPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.selectionPanel = new SelectionPanel();
		this.add(this.selectionPanel);
		
		this.actionHandler = new ActionHandler();
		this.movePanel1 = new MovePanel(this.actionHandler);
		this.add(this.movePanel1);
		
		this.basketPanel = new BasketPanel();
		this.add(this.basketPanel);
		this.basketPanel.setPreferredSize(new Dimension(175, this.getHeight()));
		
		this.movePanel2 = new MovePanel(this.actionHandler);
		this.add(this.movePanel2);
		
		this.resultPanel1 = new BasketPanel();
		this.resultPanel1.setPreferredSize(new Dimension(175, this.getHeight()));
		this.add(this.resultPanel1);
		
	}

	public void initialize(String id) throws FileNotFoundException {
		this.selectionPanel.initialize(id);
		
			this.basketPanel.initialize(id+EDataFileName.basket.getString());
			this.resultPanel1.initialize(id+EDataFileName.result.getString());
		
	}
	public void finish(String id) {
		this.selectionPanel.finish(id);
		this.basketPanel.finish(id+EDataFileName.basket.getString());
		this.resultPanel1.finish(id+EDataFileName.result.getString());
		Vector<VCLecture> resultLectures = this.resultPanel1.getStoreLectures();
		int sumCredit = this.resultPanel1.credit(resultLectures);
		JOptionPane.showMessageDialog(this,EFinal.message.getString()+sumCredit, EFinal.title.getString(),JOptionPane.INFORMATION_MESSAGE);
	}
	private void moveLecturesToBasket() {
		Vector<VCLecture> selectedLectures = this.selectionPanel.getSelectedLectures();
		this.basketPanel.addRows(selectedLectures);
	}
	private void removeSelectedLectures() {
		this.basketPanel.removeSelectedLectures();
		}

	private void moveBasketToResult() {
			Vector<VCLecture> resultLectures = this.resultPanel1.getStoreLectures();
			int sumCredit = this.resultPanel1.credit(resultLectures);
			this.basketPanel.CheckLectures(resultLectures, sumCredit);
			Vector<VCLecture> selectedLectures = this.basketPanel.getSelectedLectures();
			this.resultPanel1.addRows(selectedLectures);
		}
	private void moveResultToBasket() {
			Vector<VCLecture> selectedLectures = this.resultPanel1.getSelectedLectures();
			this.basketPanel.addRows(selectedLectures);
		}
	public int credit() {
		Vector<VCLecture> resultLectures = this.resultPanel1.getStoreLectures();
		int sumCredit = this.resultPanel1.credit(resultLectures);
		return sumCredit;
	}
	private class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource().equals(movePanel1.getLeftButton())) {			
				removeSelectedLectures();
			} else if(event.getSource().equals(movePanel1.getRightButton())) {
				moveLecturesToBasket();			
			}else if(event.getSource().equals(movePanel2.getLeftButton())) {
				moveResultToBasket();
			} else if(event.getSource().equals(movePanel2.getRightButton())) {
				moveBasketToResult();}
				
			}
		}




}
