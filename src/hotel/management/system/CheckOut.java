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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckOut extends JFrame implements ActionListener{

	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
	
	public CheckOut() {
	
		this.setTitle("Checkout");
		
		JLabel l1 = new JLabel("Update Check-In Status");
		l1.setFont(new Font("Tahoma",Font.PLAIN,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(60,20,350,40);
		add(l1);
		
		JLabel id = new JLabel("GUEST ID");                               //ID
		id.setFont(new Font("Tahoma",Font.PLAIN,17));
		id.setBounds(60,80,120,30);
		add(id);
		c1=new Choice();
		try {
			
			conn c=new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while (rs.next()) {
				c1.add(rs.getString("number"));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		c1.setBackground(Color.WHITE);
		c1.setBounds(200, 80, 160, 30);
		add(c1);
		
		JLabel number = new JLabel("ROOM NUMBER");                         //number
		number.setFont(new Font("Tahoma",Font.PLAIN,17));
		number.setBounds(60,130,120,30);
		add(number);		
		t1 = new JTextField();
		t1.setBounds(200,130,160,30);
		add(t1);
		
		b1= new JButton("Check-Out");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(70,180,120,30);
		add(b1);
		
		b2= new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(220,180,120,30);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
		Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		b3 = new JButton(i3);
		b3.addActionListener(this);
		b3.setBounds(370, 80, 20, 20);
		add(b3);
		
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
		Image i12 = i11.getImage().getScaledInstance(480, 200, Image.SCALE_DEFAULT);
		ImageIcon i13 = new ImageIcon(i12);
		JLabel l11 = new JLabel(i13);
		l11.setBounds(400, 20, 480, 200);
		add(l11);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(520,230,920,280);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new CheckOut().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b3) {
			
			String s1 = c1.getSelectedItem();	
			conn c = new conn();
			try {
				
				ResultSet rs1 = c.s.executeQuery("select * from customer where number = '"+s1+"'");
				while(rs1.next()) {
					t1.setText(rs1.getString("room"));
				}
				
			} catch (Exception e2) {
				System.out.println(e);
			}
			
		}
		else if(e.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b1) {
			
			try {
				
				conn c= new conn();
				String s1 = c1.getSelectedItem();
				String room = t1.getText();
				String sql1 ="delete from customer where number ='"+s1+"'"; 
				String sql2 ="update room set available='available',status='dirty' where room_number='"+room+"'";
				c.s.executeUpdate(sql1);
				c.s.executeUpdate(sql2);
				JOptionPane.showMessageDialog(null, "Check-Out Done Succesfully");
				new Reception().setVisible(false);
				
			} catch (Exception e2) {
				System.out.println(e);
			}
			
		}
		
		
	}

}
