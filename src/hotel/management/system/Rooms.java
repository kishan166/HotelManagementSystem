package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Rooms extends JFrame implements ActionListener{

	
	JTable t1;
	JButton b1,b2;
	private JPanel mainPanel;
	private JScrollPane scroll_table;
	public Rooms() {
		
		this.setTitle("Rooms");
		
		mainPanel = new JPanel(null);
		mainPanel.setBackground(Color.WHITE);
		setSize(460, 300);
		t1 = new JTable();
		scroll_table = new JScrollPane(t1);
		scroll_table.setBounds(10,50,460,300);
		scroll_table.setVisible(true);
		scroll_table.setBackground(Color.WHITE);
		add(scroll_table);
		
		b1 = new JButton("Load Data");
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(100,360,120,30);
		add(b1);
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(300,360,120,30);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(420, 350, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel il = new JLabel(i3);
		il.setBounds(480,25,420,350);
		add(il);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(520,230,920,460);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Rooms().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			
			try {
				
				conn c = new conn();
				String sql = "select * from room";
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
