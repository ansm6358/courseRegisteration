package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import global.Constants;

public class Registration extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton RButton1;
	private JButton RButton2;
	private JButton LButton1;
	private JButton LButton2;
	
	public Registration() {
		this.setLayout(new BorderLayout(10, 10));
		this.setBorder(new EmptyBorder(10, 10, 50, 10));
		
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(Constants.MAIN_W*2/5, 0));
		panel3.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel3.setLayout(new GridLayout(0,3,10,10));
		panel3.setBackground(Color.PINK);
		this.add(panel3, BorderLayout.WEST);
		
		JPanel BSpanel = new JPanel();
		BSpanel.setPreferredSize(new Dimension(Constants.MAIN_W*2/5/3, 0));
		BSpanel.setLayout(new BorderLayout(10, 10));
		BSpanel.setBackground(Color.PINK);
		panel3.add(BSpanel);
		
		JPanel Spanel1 = new JPanel();
		Spanel1.setPreferredSize(new Dimension(0, Constants.MAIN_H*3/20));
		Spanel1.setBackground(Color.red);
		BSpanel.add(Spanel1,BorderLayout.NORTH);
		
		JPanel Spanel2 = new JPanel();
		Spanel2.setBackground(Color.ORANGE);
		BSpanel.add(Spanel2,BorderLayout.CENTER);
		
		JPanel Spanel3 = new JPanel();
		Spanel3.setPreferredSize(new Dimension(Constants.MAIN_W*2/5/3, 0));
		Spanel3.setBackground(Color.MAGENTA);
		panel3.add(Spanel3);
		
		JPanel Spanel4 = new JPanel();
		Spanel4.setPreferredSize(new Dimension(Constants.MAIN_W*2/5/3, 0));
		Spanel4.setBackground(Color.DARK_GRAY);
		panel3.add(Spanel4);
		
		JPanel Cpanel1 = new JPanel();
		Cpanel1.setPreferredSize(new Dimension(Constants.MAIN_W*9/20, 0));
		Cpanel1.setBackground(Color.CYAN);
		Cpanel1.setLayout(new BorderLayout(10,10));
		this.add(Cpanel1, BorderLayout.EAST);
		
		JPanel Apanel1 = new JPanel();
		Apanel1.setPreferredSize(new Dimension(Constants.MAIN_W*3/20, 0));
		Apanel1.setBackground(Color.PINK);
		Cpanel1.add(Apanel1, BorderLayout.EAST);
		
		JPanel Apanel2 = new JPanel();
		Apanel2.setPreferredSize(new Dimension(Constants.MAIN_W*7/40, 0));
		Apanel2.setBackground(Color.YELLOW);
		Cpanel1.add(Apanel2, BorderLayout.WEST);
		
		JPanel Bpanel1 = new JPanel();
		Bpanel1.setPreferredSize(new Dimension(Constants.MAIN_W*3/10/4, 0));
		Bpanel1.setLayout(new GridLayout(2, 0, 0, Constants.MAIN_H/2));
		Bpanel1.setBackground(Color.CYAN);
		Cpanel1.add(Bpanel1,BorderLayout.CENTER);
		RButton1 = new JButton(">>");
		LButton1 = new JButton("<<");
		Bpanel1.add(RButton1);
		Bpanel1.add(LButton1);
		
		JPanel BPanel = new JPanel();
		BPanel.setPreferredSize(new Dimension(Constants.MAIN_W*3/10, 0));
		BPanel.setLayout(new GridLayout(2, 0, 10, Constants.MAIN_H/2));
		BPanel.setBackground(Color.CYAN);
		this.add(BPanel, BorderLayout.CENTER);
		RButton2 = new JButton(">>");
		LButton2 = new JButton("<<");
		BPanel.add(RButton2);
		BPanel.add(LButton2);
	}
}
