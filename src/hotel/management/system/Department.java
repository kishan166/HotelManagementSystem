package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener{

	JTable t1;
	JButton b1,b2;
	private JPanel mainPanel;
	private JScrollPane scroll_table;
	
	public Department() {
		
		this.setTitle("Department");
		
		JLabel l1 = new JLabel("Department");
		l1.setFont(new Font("Tahoma",Font.PLAIN,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(220,15,350,40);
		add(l1);
		
		mainPanel = new JPanel(null);
		mainPanel.setBackground(Color.WHITE);
		setSize(500, 250);
		t1 = new JTable();
		scroll_table = new JScrollPane(t1);
		scroll_table.setBounds(50,100,500,250);
		scroll_table.setVisible(true);
		scroll_table.setBackground(Color.WHITE);
		add(scroll_table);
		
		b1 = new JButton("Show");
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(150,380,120,30);
		add(b1);
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(300,380,120,30);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(640,230,620,480);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Department().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			
			try {
				
				conn c = new conn();
				String sql = "select * from department";				
				ResultSet rs= c.s.executeQuery(sql);
				t1.setModel(DbUtils.resultSetToTableModel(rs));

			} catch (Exception e2) {
				System.out.println(e2);
			}
			
		}
		else if (e.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}

}
