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

public class UpdateCheck extends JFrame implements ActionListener {

	Choice c1;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3;
	
	public UpdateCheck() {
		
		this.setTitle("Check-In Status");
		
		JLabel l1 = new JLabel("Check-In Status");
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
		c1.setBounds(280, 80, 160, 30);
		add(c1);
		
		JLabel number = new JLabel("ROOM NUMBER");                         //number
		number.setFont(new Font("Tahoma",Font.PLAIN,17));
		number.setBounds(60,130,120,30);
		add(number);		
		t1 = new JTextField();
		t1.setBounds(280,130,160,30);
		add(t1);
		
		JLabel name = new JLabel("NAME");                      //availability
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		name.setBounds(60,180,120,30);
		add(name);
		t2 = new JTextField();
		t2.setBounds(280,180,160,30);
		add(t2);
		
		JLabel checkin = new JLabel("CHECK-IN");                       //checkin
		checkin.setFont(new Font("Tahoma",Font.PLAIN,17));
		checkin.setBounds(60,230,120,30);
		add(checkin);
		t3 = new JTextField();
		t3.setBounds(280,230,160,30);
		add(t3);
		
		JLabel ap = new JLabel("AMOUNT PAID");                       //amount paid
		ap.setFont(new Font("Tahoma",Font.PLAIN,17));
		ap.setBounds(60,280,120,30);
		add(ap);
		t4 = new JTextField();
		t4.setBounds(280,280,160,30);
		add(t4);
		
		JLabel pa = new JLabel("PENDING AMOUNT");                       //pending amount
		pa.setFont(new Font("Tahoma",Font.PLAIN,17));
		pa.setBounds(60,330,200,30);
		add(pa);
		t5 = new JTextField();
		t5.setBounds(280,330,160,30);
		add(t5);
		
		b1= new JButton("Check");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(80,400,120,30);
		add(b1);
		
//		b2= new JButton("Update");
//		b2.setBackground(Color.BLACK);
//		b2.setForeground(Color.WHITE);
//		b2.addActionListener(this);
//		b2.setBounds(80,430,120,30);
//		add(b2);
		
		b3= new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		b3.setBounds(280,400,120,30);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.png"));
		Image i2 = i1.getImage().getScaledInstance(430, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l11 = new JLabel(i3);
		l11.setBounds(460, 100, 430, 250);
		add(l11);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(520,230,920,500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new UpdateCheck().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			
			String room = null;
			String deposit = null;
			String price = null;
			int amountremain=0 ;
			String s1 = c1.getSelectedItem();	
			conn c = new conn();
			try {
				
				ResultSet rs1 = c.s.executeQuery("select * from customer where number = '"+s1+"'");
				while(rs1.next()) {
					t1.setText(rs1.getString("room"));
					t2.setText(rs1.getString("name"));
					t3.setText(rs1.getString("checkin"));
					t4.setText(rs1.getString("deposit"));
					room = rs1.getString("room");
					deposit = rs1.getString("deposit");
				}
				
				ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+room+"'");
				while(rs2.next()) {
					price = rs2.getString("price");
					amountremain = Integer.parseInt(price)- Integer.parseInt(deposit);
					t5.setText(Integer.toString(amountremain));
				}
				
			} catch (Exception e2) {
				System.out.println(e);
			}
			
		}
//		else if(e.getSource() == b2) {
//			
//			try {
//				
//				conn c= new conn();
//				String  checkin = t3.getText();
//				String s1 = c1.getSelectedItem();
//				
//				String sql1 ="update customer set checkin ='"+checkin+"' where number ='"+s1+"'"; 
//				c.s.executeUpdate(sql1);
//				JOptionPane.showMessageDialog(null, "Updated Succesfully");
//				new Reception().setVisible(false);
//				
//			} catch (Exception e2) {
//				System.out.println(e);
//			}
//			
//		}
		else if(e.getSource() == b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}

}
