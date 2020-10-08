package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener{

	JTable t1;
	Choice c1;
	JButton b1,b2;
	
	public Pickup() {
		this.setTitle("Pickup");
		
		JLabel l1 = new JLabel("Pickup");
		l1.setFont(new Font("Tahoma",Font.PLAIN,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(420,15,350,40);
		add(l1);
		
		JLabel id = new JLabel("TYPE OF CAR");                               //ID
		id.setFont(new Font("Tahoma",Font.PLAIN,17));
		id.setBounds(60,80,120,30);
		add(id);
		c1=new Choice();
//		Set se = new LinkedHashSet();
		try {
			
			conn c=new conn();
			ResultSet rs = c.s.executeQuery("select distinct car_model from driver;");
			
			while (rs.next()) {
				c1.add(rs.getString("car_model"));
//				se.add(rs.getString("car_model"));
			}			
//			String[] stockArr = new String[se.size()];
//			stockArr = (String[]) se.toArray(stockArr);
//			for(String s : stockArr)
//			    c1.add(s);
		} catch (Exception e) {
			System.out.println(e);
		}
		c1.setBackground(Color.WHITE);
		c1.setBounds(280, 80, 160, 30);
		add(c1);
		
		
		JPanel mainPanel = new JPanel(null);
		setSize(860, 100);
		t1 = new JTable();
		JScrollPane scroll_table = new JScrollPane(t1);
		scroll_table.setBounds(20,160,860,100);
		scroll_table.setVisible(true);
		add(scroll_table);
		
		b1 = new JButton("Load Data");
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(250,290,120,30);
		add(b1);
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(500,290,120,30);
		add(b2);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(520,230,920,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Pickup().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			
			try {
				
				conn c = new conn();
				String sql = "select * from driver where car_model='"+c1.getSelectedItem()+"'";				
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
