package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.CPersonalInfo;
import global.Constants;
import valueObject.VPersinalInfo;

public class PersonalInfo extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private JLabel insa;
	
	public void setID(String id) {this.id = id;}

	public PersonalInfo() {
		this.setLayout(new BorderLayout(10, 5));
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(0, Constants.MAIN_H*1/40));
		panel1.setBackground(Color.YELLOW);
		panel1.setLayout(new GridLayout(1, 0));
		this.add(panel1, BorderLayout.NORTH);
	
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(0, Constants.MAIN_H*3/20));
		panel2.setBackground(Color.BLACK);
		this.add(panel2, BorderLayout.CENTER);
		
		this.id = null;
		this.insa = new JLabel();
		panel1.add(this.insa);
	}
	
	public void getPersinalInfo(String id) throws FileNotFoundException {  
		CPersonalInfo cPersonalInfo = new CPersonalInfo();
		VPersinalInfo vPersonalInfo = cPersonalInfo.getPersonalInfo(id);
		this.insa.setText(vPersonalInfo.getName()+"님 어서오세요!");
	}
}
