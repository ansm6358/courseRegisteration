package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import valueObject.VCLecture;

public class RegistrationPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ActionListener actionHandler;
	
	private SelectionPanel selectionPanel;
	private MovePanel1 movePanel1;
	private BasketPanel basketPanel;
	private JPanel movePanel2;
	private JPanel resultPanel1;
	
	public RegistrationPanel() {
		this.setBackground(Color.GREEN);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.selectionPanel = new SelectionPanel();
		this.selectionPanel.setBackground(Color.GREEN);
		this.add(this.selectionPanel);
		
		this.actionHandler = new ActionHandler();
		this.movePanel1 = new MovePanel1(this.actionHandler);
		this.movePanel1.setBackground(Color.GREEN);
		this.add(this.movePanel1);
		
		this.basketPanel = new BasketPanel();
		this.basketPanel.setBackground(Color.GREEN);
		this.add(this.basketPanel);
		
		this.movePanel2 = new JPanel();
		this.movePanel2.setBackground(Color.GREEN);
		this.add(this.movePanel2);
		
		this.resultPanel1 = new JPanel();
		this.resultPanel1.setBackground(Color.GREEN);
		this.add(this.resultPanel1);
		
	}

	public void initialize(String id) {
		this.selectionPanel.initialize(id);
		this.basketPanel.initialize(id);
//		this.resultPanel1.initialize(id);
	}
	private void moveLecturesToBasket() {
		Vector<VCLecture> selectedLectures = this.selectionPanel.getSelectedLectures();
		this.basketPanel.addLectures(selectedLectures);
	}
	private void deleteToBasket() {
			this.basketPanel.deleteToBasket();			
		}
	private class ActionHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getActionCommand().equals("leftButton")) {
				deleteToBasket();
			} else if(event.getActionCommand().equals("rightButton")) {
			moveLecturesToBasket();				
			}

		}


		}
}
