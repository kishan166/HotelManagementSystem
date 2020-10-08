package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRoom extends JFrame implements ActionListener{

	JTextField t1,t2;
	Choice c1;
	JButton b1,b2,b3;
	public UpdateRoom() {

		this.setTitle("Update Room Info");
		
		JLabel l1 = new JLabel("Update Room Status");
		l1.setFont(new Font("Tahoma",Font.PLAIN,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(60,30,350,40);
		add(l1);
		
		JLabel number = new JLabel("ROOM NUMBER");                         //number
		number.setFont(new Font("Tahoma",Font.PLAIN,17));
		number.setBounds(60,80,120,30);
		add(number);
		c1=new Choice();
		try {
			
			conn c=new conn();
			ResultSet rs = c.s.executeQuery("select * from room where status='dirty' and available='available'");
			while (rs.next()) {
				c1.add(rs.getString("room_number"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		c1.setBackground(Color.WHITE);
		c1.setBounds(280, 80, 160, 30);
		add(c1);
			
		JLabel available = new JLabel("AVAILABILITY");                                  //availability
		available.setFont(new Font("Tahoma",Font.PLAIN,17));
		available.setBounds(60,130,120,30);
		add(available);
		t1 = new JTextField();
		t1.setBounds(280,130,160,30);
		add(t1);
		
		JLabel cleanstat = new JLabel("CLEAN STATUS");                             //clean stat
		cleanstat.setFont(new Font("Tahoma",Font.PLAIN,17));
		cleanstat.setBounds(60,180,120,30);
		add(cleanstat);
		t2 = new JTextField();
		t2.setBounds(280,180,160,30);
		add(t2);
		
		b1= new JButton("Check");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(180,230,120,30);
		add(b1);
		
		b2= new JButton("Update");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(80,280,120,30);
		add(b2);
		
		b3= new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		b3.setBounds(280,280,120,30);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
		Image i2 = i1.getImage().getScaledInstance(430, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l11 = new JLabel(i3);
		l11.setBounds(460, 60, 430, 250);
		add(l11);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(520,230,920,380);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new UpdateRoom().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			
			String room = null;
			String s1 = c1.getSelectedItem();	
			conn c = new conn();
			try {
				
				ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+s1+"'");
				while(rs2.next()) {
					t1.setText(rs2.getString("available"));
					t2.setText(rs2.getString("status"));
				}
				
			} catch (Exception e2) {
				System.out.println(e);
			}
			
		}
		else if(e.getSource() == b2) {
			
			try {
				
				conn c= new conn();
				String s1 = c1.getSelectedItem();
				
				String sql1 ="update room set available ='available',status ='cleaned' where room_number ='"+s1+"'"; 
				c.s.executeUpdate(sql1);
				JOptionPane.showMessageDialog(null, "Room Updated Succesfully");
				new Reception().setVisible(false);
				
			} catch (Exception e2) {
				System.out.println(e);
			}
			
		}
		else if(e.getSource() == b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}

}
