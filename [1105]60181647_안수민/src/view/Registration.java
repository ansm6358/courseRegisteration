package view;
import javax.swing.JPanel;

public class Registration extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private SelectionPanel selectionPanel;
	
	public Registration() {
		this.selectionPanel = new SelectionPanel();
		this.add(this.selectionPanel);
		
	}
	

}
