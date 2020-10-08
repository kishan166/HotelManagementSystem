package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {

	JTable t1;
	JComboBox c1;
	JCheckBox cb1;
	JButton b1,b2;
	
	
	public SearchRoom() {
		
		this.setTitle("Search Room");
		
		JLabel l1 = new JLabel("Search Rooms");
		l1.setFont(new Font("Tahoma",Font.PLAIN,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(350,20,350,30);
		add(l1);
		
		JLabel id = new JLabel("ROOM BED TYPE");                               //ID
		id.setFont(new Font("Tahoma",Font.PLAIN,17));
		id.setBounds(60,80,220,30);
		add(id);
		String str[]= {"Single Bed","Double Bed"};
		c1 = new JComboBox(str);
		c1.setBackground(Color.WHITE);
		c1.setBounds(250, 80, 160, 30);
		add(c1);
		
		cb1 = new JCheckBox("Only Display Available");
		cb1.setBackground(Color.WHITE);
		cb1.setBounds(600,80,160,30);
		add(cb1);
		
		
		JPanel mainPanel = new JPanel(null);
		setSize(860, 250);
		t1 = new JTable();
		JScrollPane scroll_table = new JScrollPane(t1);
		scroll_table.setBounds(20,160,860,250);
		scroll_table.setVisible(true);
		add(scroll_table);

		b1 = new JButton("Load Data");
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(250,430,120,30);
		add(b1);
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(500,430,120,30);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(520,230,920,520);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SearchRoom().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			
			try {
				
				conn c = new conn();
				String sql1 = "select * from room where bed_type='"+c1.getSelectedItem()+"'";
				String sql2 = "select * from room where available='available' AND bed_type='"+c1.getSelectedItem()+"'";
				
				ResultSet rs;
				
				if(cb1.isSelected()) {
					rs= c.s.executeQuery(sql2);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				}else {
					rs= c.s.executeQuery(sql1);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				}
				
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
