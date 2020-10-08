package hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
	
	JTable t1;
	JButton b1,b2;
	public EmployeeInfo() {
		
		this.setTitle("Employee Info");
		
		JPanel mainPanel = new JPanel(null);
		setSize(860, 400);
		t1 = new JTable();
		JScrollPane scroll_table = new JScrollPane(t1);
		scroll_table.setBounds(20,50,860,250);
		scroll_table.setVisible(true);
		add(scroll_table);
		
		b1 = new JButton("Load Data");
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(250,315,120,30);
		add(b1);
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(500,315,120,30);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(520,230,920,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EmployeeInfo().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			
			try {
				
				conn c = new conn();
				String sql = "select * from employee";
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
